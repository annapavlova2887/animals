package org.src;
import org.src.animals.Animals;
import org.src.animals.pets.Cat;
import org.src.animals.pets.Dog;
import org.src.animals.birds.Duck;
import org.src.data.Comands;
import org.src.data.Comands2;
import org.src.factory.AnimalFactory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Animals {

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
                    if (command2 == null) {
                        System.out.println("У нас нет такого животного");
                        continue;
                    }
                    System.out.println("Введите имя");
                    String nameconsole = console.next();

                    int ageconsole = 0;
                    boolean checkAge = false;
                    while (!checkAge) {
                        System.out.println("Введите возраст целым числом");
                        try {
                            ageconsole = console.nextInt();
                            if (ageconsole > 0) {
                                checkAge = true;
                            } else {
                                System.out.println("Возраст не может быть равен 0");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Возраст можно ввести только целым числом");
                            console.nextLine();
                        }
                    }

                    int waconsole = 0;
                    boolean checkWe = false;
                    while (!checkWe) {
                        System.out.println("Введите вес цифрами");
                        try {
                            waconsole = console.nextInt();
                            if (waconsole > 0) {
                                checkWe = true;
                            } else {
                                System.out.println("Вес не может быть равен 0");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Вес можно ввести только целым числом");
                            console.nextLine();
                        }
                    }

                    System.out.println("Введите цвет");
                    String colconsole = console.next();

                    //AnimalFactory animalFactory = new AnimalFactory(nameconsole, ageconsole, waconsole, colconsole);
                    //newAnimals.add(animalFactory.create(Comands2.valueOf(input2)));
                    //break;

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
                            Duck duck = new Duck(nameconsole, ageconsole, waconsole, colconsole);
                            newAnimals.add(duck);
                            duck.say();
                            break;
                    }
                    break;

                case LIST:
                    for (Animals item : newAnimals) {
                        System.out.println(item.toString());
                    }
                    break;
                case EXIT:
                    System.out.println("Вы ввели Exit, сейчас программа завершит работу");
                    System.exit(0);
                }
            }
        console.close();
    }
}


