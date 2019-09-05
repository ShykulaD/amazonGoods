package test_pack;

/**
 * Created by ShykulaD on 05/09/2019.
 */

public class Test {
    public static void main(String[] args) {
        Seasons arg = Seasons.FALL;

        switch (arg) {
            case WINTER:
                System.out.println("It's winter! Christmas time!");
                break;
            case SUMMER:
                System.out.println("It's summer! Let's go to the beach!");
                break;
            case SPRING:
                System.out.println("It's spring! Easter is coming!");
                break;
            case FALL:
                System.out.println("It's fall! Helloween is coming!");
                break;
        }
    }
}