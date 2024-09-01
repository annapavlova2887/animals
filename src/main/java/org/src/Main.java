package org.src;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Animals{

    public Main(String name, int age, int weight, String color) {
        super(name, age, weight, color);
    }

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        Boolean exit = false;
        ArrayList<Animals> newAnimals = new ArrayList<Animals>();

        while (!exit) {
            System.out.println("Введите команду: add/list/exit");
            String input = console.next();
            Comands command = Comands.fromString(input);

            if (command==null) {
                System.out.println("Введена неверная команда");
                continue;
            }

            switch (command) {
                case ADD:
                    System.out.println("Какое вы животное? (Cat/Dog/Duck)");
                    String input2 = console.next();
                    Comands2 command2 = Comands2.fromString(input2);
                    if (command2==null) {
                        System.out.println("У нас нет такого животного");
                        continue;
                    }
                    System.out.println("Введите имя");
                    String nameconsole = console.next();
                    System.out.println("Введите возраст");
                    int ageconsole=console.nextInt();
                    System.out.println("Введите вес");
                    int waconsole = console.nextInt();
                    System.out.println("Введите цвет");
                    String colconsole = console.next();

                    switch (command2) {
                        case CAT:
                            Cat cat = new Cat(nameconsole, ageconsole, waconsole, colconsole);
                            newAnimals.add(cat);
                            cat.say();
                            break;
                        case DOG:
                            Dog dog = new Dog(nameconsole, ageconsole, waconsole, colconsole);
                            newAnimals.add(dog);
                            dog.say();
                            break;
                        case DUCK:
                            Duck duck = new Duck (nameconsole, ageconsole, waconsole, colconsole);
                            newAnimals.add(duck);
                            duck.say();
                            break;
                    }
                    break;
                case LIST:
                    for (Animals item: newAnimals) {
                        System.out.println(item.toString());
                    }
                    break;
                case EXIT:
                    exit=true;
                    System.out.println("Вы ввели Exit");
                    // System.exit(0);
                    break;
            }
        }
        console.close();
    }
}


