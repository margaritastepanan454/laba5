package ru.tequila.lab.Pleasework;

import ru.tequila.lab.domain.*;
import java.util.Scanner;

public class DragonInputReader {
    private final Scanner scanner;

    public DragonInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Dragon readDragon() {
        System.out.println("Ввод дракона:");

        String name;
        do {
            System.out.print("Имя: ");
            name = scanner.nextLine().trim();
        } while (name.isEmpty());

        float x = readFloat("x координата (≤523): ");
        while (x > 523) x = readFloat("x ≤ 523: ");
        long y = readLong("y координата: ");


        long age = readPositiveLong("Возраст (>0): ");
        double weight = readPositiveDouble("Вес (>0): ");

        DragonType type = readEnum("Тип (WATER/AIR/FIRE/UNDERGROUND): ", DragonType.values());

        DragonCharacter character = readEnum("Характер (WISE/GOOD/): ", DragonCharacter.values());
        return new Dragon(null, name, new Coordinates(x, y), null, age, weight, type, character, null);
    }

    private float readFloat(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Float.parseFloat(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Число");
            }
        }
    }

    private long readLong(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Long.parseLong(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Целое число");
            }
        }
    }

    private long readPositiveLong(String prompt) {
        long value;
        do {
            value = readLong(prompt);
        } while (value <= 0);
        return value;
    }

    private double readPositiveDouble(String prompt) {
        double value;
        do {
            value = readDouble(prompt);
        } while (value <= 0);
        return value;
    }

    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Число");
            }
        }
    }

    @SuppressWarnings("unchecked")
    private <T extends Enum<T>> T readEnum(String prompt, T[] values) {
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        System.out.println("Выберите: " + String.join(", ", names));

        while (true) {
            System.out.print(prompt);
            try {
                return (T) Enum.valueOf((Class<Enum>) values[0].getClass(), scanner.nextLine().trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Выберите из того, что я вам предложила");
            }
        }
    }
}
