package circus;

import circus.animal.*;
import circus.stuff.Equipment;
import circus.stuff.Cannon;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;


public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {

        System.out.println("Number of animals in our circus: " + animals.length);
//        animals[3] = new Duck("Louie");
//        System.out.println("Number of animals in our circus: " + animals.length);
//        makeAnimalsTalk();
//        System.out.println("Total value of animals " + calculateAssetValue(animals));
//        System.out.println("Total value of equipments " + calculateAssetValue(equipments));

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));

//        printAllAnimals(animalArrayList);
//        printCircusSize(animalArrayList);
        animalArrayList.add(new Duck("Scrooge"));

//        printAllAnimals(animalArrayList);
//        printCircusSize(animalArrayList);

        Elephant dumbo = new Elephant("Jumbo");
        animalArrayList.add(dumbo);

        printCircusSize(animalArrayList);

        System.out.println("Jumbo is in position: "+ animalArrayList.indexOf(dumbo));
        Animal candidateAnimal = findAnimal(animalArrayList,"Scrooge");
        System.out.println("Scrooge is in position: "
                + animalArrayList.indexOf(candidateAnimal));

        System.out.println("Before Sorting");
        printAllAnimals(animalArrayList);
        animalArrayList.sort(Animal.AnimalNameComparator);
        System.out.println("After Sorting");
        printAllAnimals(animalArrayList);
    }

    private static void printCircusSize(ArrayList<Animal> animalArrayList) {
        System.out.println("Number of animals in our circus(AL): " + animalArrayList.size());
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }

    private static Animal findAnimal(ArrayList<Animal> animalArrayList, String candidate) {
        for (Animal a : animalArrayList) {
            if (a.name == candidate) {
                return(a);
            }
        }
        return null;
    }
}
