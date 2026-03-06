package ru.tequila.lab.service;

import ru.tequila.lab.domain.Dragon;
import ru.tequila.lab.validation.DragonValidator;
import ru.tequila.lab.validation.ValidationException;

import java.time.LocalDateTime;
import java.util.*;


public class DragonCollectionManager {
    private final Hashtable<Integer, Dragon> dragons = new Hashtable<>();
    private final LocalDateTime initTime = LocalDateTime.now();
    private int nextId = 1;

    public synchronized int generateId() {
        while (dragons.containsKey(nextId)) nextId++;
        return nextId++;
    }

    public synchronized void add(Integer key, Dragon dragon) {
        if (key == null) throw new ValidationException("Ключ не может быть null");
        if (dragons.containsKey(key)) throw new ValidationException("Ключ " + key + " уже существует");
        if (dragon.getId() == null) dragon.setId(generateId());
        if (dragon.getCreationDate() == null) dragon.setCreationDate(LocalDateTime.now());
        DragonValidator.validateDragon(dragon);
        dragons.put(key, dragon);
    }

    public synchronized String getInfo() {
        return String.format("Тип: Hashtable<Integer, Dragon>\nДата инициализации: %s\nКоличество элементов: %d",
                initTime, dragons.size());
    }


    public synchronized List<Dragon> getAll() {
        return new ArrayList<>(dragons.values());
    }

    public synchronized void updateById(int id, Dragon newDragon) {
        boolean found = false;
        for (Map.Entry<Integer, Dragon> entry : dragons.entrySet()) {
            if (entry.getValue().getId() == id) {
                found = true;
                newDragon.setId(id);
                if (newDragon.getCreationDate() == null) {
                    newDragon.setCreationDate(entry.getValue().getCreationDate());
                }
                DragonValidator.validateDragon(newDragon);
                dragons.put(entry.getKey(), newDragon);
                break;
            }
        }
        if (!found) throw new ValidationException("Дракон с id=" + id + " не найден");
    }


    public synchronized void removeByKey(Integer key) {
        if (dragons.remove(key) == null) {
            throw new ValidationException("Элемент с ключом " + key + " не найден");
        }
    }


    public synchronized void clear() {
        dragons.clear();
    }


    public synchronized void removeGreater(Dragon element) {
        List<Integer> toRemove = new ArrayList<>();
        for (Map.Entry<Integer, Dragon> entry : dragons.entrySet()) {
            if (entry.getValue().compareTo(element) > 0) {
                toRemove.add(entry.getKey());
            }
        }
        for (Integer key : toRemove) {
            dragons.remove(key);
        }
    }

    public synchronized void replaceIfGreater(Integer key, Dragon newDragon) {
        Dragon oldDragon = dragons.get(key);
        if (oldDragon == null) {
            throw new ValidationException("Элемент с ключом " + key + " не найден");
        }
        if (newDragon.compareTo(oldDragon) > 0) {
            newDragon.setId(oldDragon.getId());
            newDragon.setCreationDate(oldDragon.getCreationDate());
            DragonValidator.validateDragon(newDragon);
            dragons.put(key, newDragon);
        }
    }


    public synchronized void removeGreaterKey(Integer key) {
        List<Integer> toRemove = new ArrayList<>();
        for (Integer k : dragons.keySet()) {
            if (k > key) {
                toRemove.add(k);
            }
        }
        for (Integer k : toRemove) {
            dragons.remove(k);
        }
    }

    public synchronized Map<Integer, Long> groupCountingById() {
        Map<Integer, Long> counts = new HashMap<>();
        for (Dragon dragon : dragons.values()) {
            counts.merge(dragon.getId(), 1L, Long::sum);
        }
        return counts;
    }

    public synchronized List<Dragon> filterStartsWithName(String prefix) {
        List<Dragon> result = new ArrayList<>();
        for (Dragon dragon : dragons.values()) {
            if (dragon.getName().startsWith(prefix)) {
                result.add(dragon);
            }
        }
        return result;
    }

    public synchronized List<Dragon> printAscending() {
        List<Dragon> sorted = new ArrayList<>(dragons.values());
        Collections.sort(sorted);
        return sorted;
    }

    public synchronized void show() {
        if (dragons.isEmpty()) {
            System.out.println("Коллекция пуста");
            return;
        }
        dragons.values().forEach(System.out::println);
    }
}
