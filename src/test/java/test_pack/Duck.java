package test_pack;

/**
 * Created by ShykulaD on 05/09/2019.
 */
public class Duck implements Swimmable {

    public void swim() {
        System.out.println("Уточка, плыви!");
    }

    public static void main(String[] args) {

        Duck duck = new Duck();
        duck.swim();
    }
}
