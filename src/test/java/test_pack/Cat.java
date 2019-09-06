package test_pack;

/**
 * Created by ShykulaD on 15/08/2019.
 */

public class Cat {

    int age;

    public Cat(int age) {
        this.age = age;
    }

    public void setFutureAge(Cat cat) {

        cat.age += 10;
    }

    public void setPastAge(Cat cat) {

        cat.age -= 10;
    }
}