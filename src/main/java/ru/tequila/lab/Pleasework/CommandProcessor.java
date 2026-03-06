package ru.tequila.lab.Pleasework;

import ru.tequila.lab.domain.Dragon;
import ru.tequila.lab.service.DragonCollectionManager;
import java.util.List;
import java.util.Scanner;

public class CommandProcessor {
    private final DragonCollectionManager manager;
    private final Scanner scanner;
    private final DragonInputReader inputReader;

    public CommandProcessor(DragonCollectionManager manager, Scanner scanner) {
        this.manager = manager;
        this.scanner = scanner;
        this.inputReader = new DragonInputReader(scanner);
    }

    public void run() {
        System.out.println("Dragon Lab  введите 'help'");
        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            if (line.equals("exit")) break;

            try {
                processCommand(line);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        System.out.println("Пока!");
    }

    private void processCommand(String line) {
        String[] parts = line.split("\\s+", 2);
        String cmd = parts[0];

        switch (cmd) {
            case "help" -> printHelp();
            case "info" -> System.out.println(manager.getInfo());
            case "show" -> {
                List<Dragon> dragons = manager.getAll();
                if (dragons.isEmpty()) {
                    System.out.println("Коллекция пуста");
                } else {
                    dragons.forEach(System.out::println);
                }
            }
            case "insert" -> {
                if (parts.length < 2) {
                    System.out.println("insert <key>");
                    return;
                }
                int key = Integer.parseInt(parts[1]);
                Dragon dragon = inputReader.readDragon();
                manager.add(key, dragon);
                System.out.println("Добавлен id=" + dragon.getId());
            }
            case "clear" -> {
                manager.clear();
                System.out.println("Коллекция очищена");
            }
            default -> System.out.println(" Неизвестная команда. 'help'");
        }
    }

    private void printHelp() {
        System.out.println("\nhelp      справка");
        System.out.println("  info      информация о коллекции");
        System.out.println("  show      показать драконов");
        System.out.println("  insert K  добавить дракона (K=ключ)");
        System.out.println("  clear     очистить коллекцию");
        System.out.println("  exit      выход\n");
    }
}
