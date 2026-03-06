package ru.tequila.lab.Pleasework;

import ru.tequila.lab.service.DragonCollectionManager;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            DragonCollectionManager manager = new DragonCollectionManager();
            Scanner scanner = new Scanner(System.in);

            System.out.println(" Dragon Collection Manager");
            CommandProcessor processor = new CommandProcessor(manager, scanner);
            processor.run();
        }
    }
