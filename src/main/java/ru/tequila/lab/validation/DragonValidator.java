package ru.tequila.lab.validation;

import ru.tequila.lab.domain.*;

public class DragonValidator {
    public static void validateDragon(Dragon dragon) {
        if (dragon.getId() == null || dragon.getId() <= 0) {
            throw new ValidationException("id должен быть > 0");
        }
        if (dragon.getName() == null || dragon.getName().isBlank()) {
            throw new ValidationException("name не может быть пустым");
        }
        if (dragon.getCoordinates() == null || dragon.getCoordinates().getY() == null) {
            throw new ValidationException("coordinates не может быть null");
        }
        if (dragon.getCreationDate() == null) {
            throw new ValidationException("creationDate не может быть null");
        }
        if (dragon.getAge() <= 0) {
            throw new ValidationException("age должен быть > 0");
        }
        if (dragon.getWeight() <= 0) {
            throw new ValidationException("weight должен быть > 0");
        }
        if (dragon.getType() == null) {
            throw new ValidationException("type не может быть null");
        }
        if (dragon.getCharacter() == null) {
            throw new ValidationException("character не может быть null");
        }
    }
}

