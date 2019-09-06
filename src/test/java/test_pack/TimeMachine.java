package test_pack;

/**
 * Created by ShykulaD on 16/08/2019.
 */
class TimeMachine {


    public static void main(String[] args) {

        TimeMachine timeMachine = new TimeMachine();

        Cat barsik = new Cat(5);

        System.out.println("Сколько лет Барсику в самом начале работы программы?");
        System.out.println(barsik.age);

        barsik.setFutureAge(barsik);
        System.out.println("А теперь?");
        System.out.println(barsik.age);

        System.out.println("Елки-палки! Барсик постарел на 10 лет! Живо гони назад!");
        barsik.setPastAge(barsik);
        System.out.println("Получилось? Мы вернули коту его изначальный возраст?");
        System.out.println(barsik.age);
    }

}