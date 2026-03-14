package service;

import domain.*;
import validation.DragonValidator;

import java.util.*;

public class DragonCollectionManager {
    private final Hashtable<Integer, Dragon> dragons = new Hashtable<>();
    private int nextId = 1;
    private final long initializationTime = System.currentTimeMillis();
    public Dragon addDragon(String name, Coordinates coordinates,
                            long age, double weight, DragonType type,
                            DragonCharacter character, DragonHead head) {
        DragonValidator.validateNewDragon(name, coordinates, age, weight, type, character, head);

        Dragon dragon = new Dragon(name, coordinates, age, weight, type, character, head);
        dragon.setId(nextId++);

        DragonValidator.validateDragon(dragon);
        dragons.put(dragon.getId(), dragon);
        return dragon;
    }

    public Dragon getById(int id) {
        Dragon dragon = dragons.get(id);
        if (dragon == null) {
            throw new IllegalArgumentException("Ошибка: дракон с id=" + id + " не найден");
        }
        return dragon;
    }

    public Collection<Dragon> getAll() {
        return new ArrayList<>(dragons.values());
    }


    public boolean update(int id, Dragon newDragon) {
        if (!dragons.containsKey(id)) {
            throw new IllegalArgumentException("Ошибка: дракон с id=" + id + " не найден");
        }
        newDragon.setId(id);
        newDragon.setCreationDate(getById(id).getCreationDate()); // сохраняем дату создания
        DragonValidator.validateDragon(newDragon);
        dragons.put(id, newDragon);
        return true;
    }

    public boolean remove(int id) {
        if (!dragons.containsKey(id)) {
            throw new IllegalArgumentException("Ошибка: дракон с id=" + id + " не найден");
        }
        dragons.remove(id);
        return true;
    }

    public void clear() {
        dragons.clear();
        nextId = 1;
    }

    public String getInfo() {
        return String.format("Тип: java.util.Hashtable<Integer,Dragon>, дата инициализации: %tc, количество элементов: %d",
                new Date(initializationTime), dragons.size());
    }

    public boolean containsKey(int id) {
        return dragons.containsKey(id);
    }

    public int size() {
        return dragons.size();
    }

    public Set<Integer> getKeys() {
        return dragons.keySet();
    }
}
