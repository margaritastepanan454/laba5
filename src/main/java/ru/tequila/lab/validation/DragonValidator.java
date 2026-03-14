package validation;

import domain.*;

public class DragonValidator {
    public static void validateDragon(Dragon dragon) {
        if (dragon.getId() == null || dragon.getId() <= 0) {
            throw new IllegalArgumentException("Ошибка: id не может быть null и должен быть больше 0");
        }
        validateName(dragon.getName());
        validateCoordinates(dragon.getCoordinates());
        if (dragon.getCreationDate() == null) {
            throw new IllegalArgumentException("Ошибка: creationDate не может быть 0");
        }
        if (dragon.getAge() <= 0) {
            throw new IllegalArgumentException("Ошибка: age должно быть больше 0");
        }
        if (dragon.getWeight() <= 0) {
            throw new IllegalArgumentException("Ошибка: weight должно быть больше 0");
        }
        if (dragon.getType() == null) {
            throw new IllegalArgumentException("Ошибка: type не может быть 0");
        }
        if (dragon.getCharacter() == null) {
            throw new IllegalArgumentException("Ошибка: character не может быть 0");
        }
        validateDragonHead(dragon.getHead());
    }

    public static void validateNewDragon(String name, Coordinates coords,
                                         long age, double weight, DragonType type,
                                         DragonCharacter character, DragonHead head) {
        validateName(name);
        validateCoordinates(coords);
        if (age <= 0) {
            throw new IllegalArgumentException("Ошибка: age должно быть больше 0");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Ошибка: weight должно быть больше 0");
        }
        if (type == null) {
            throw new IllegalArgumentException("Ошибка: type не может быть 0");
        }
        if (character == null) {
            throw new IllegalArgumentException("Ошибка: character не может быть 0");
        }
        validateDragonHead(head);
    }

    private static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ошибка: name не может быть 0 или пустой строкой");
        }
    }

    private static void validateCoordinates(Coordinates coords) {
        if (coords == null) {
            throw new IllegalArgumentException("Ошибка: coordinates не может быть 0");
        }
        if (coords.getX() > 523) {
            throw new IllegalArgumentException("Ошибка: x не должно превышать 523");
        }
        if (coords.getY() == null) {
            throw new IllegalArgumentException("Ошибка: y не может быть 0");
        }
    }

    private static void validateDragonHead(DragonHead head) {
        if (head == null) {
            throw new IllegalArgumentException("Ошибка: head не может быть 0");
        }
        if (head.getToothCount() == null) {
            throw new IllegalArgumentException("Ошибка: toothCount не может быть 0");
        }
    }
}
