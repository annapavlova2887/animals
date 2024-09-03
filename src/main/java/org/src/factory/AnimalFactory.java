package org.src.factory;

import org.src.animals.Animals;
import org.src.animals.birds.Duck;
import org.src.animals.pets.Cat;
import org.src.animals.pets.Dog;
import org.src.data.Comands2;

public class AnimalFactory {

    private String name;
    private int age;
    private int weight;
    private String color;

    public AnimalFactory(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;

    }

    public Animals create(Comands2 animalData) {
        switch (animalData) {
            case CAT: {
                return new Cat(name, age, weight, color);
            }
            case DOG: {
                return new Dog(name, age, weight, color);
            }
            case DUCK: {
                return new Duck(name, age, weight, color);
            }
        }

        return null;
    }
}
