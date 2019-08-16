package test_pack;

/**
 * Created by ShykulaD on 15/08/2019.
 */
public class Car {

    String model;//модель
    private int maxSpeed;//максимальная скорость
    int wheels;//ширина дисков
    private double engineVolume;//объем двигателя
    private String color;//цвет
    private int yearOfIssue;//год выпуска
    private String ownerFirstName;//имя владельца
    String ownerLastName;//фамилия владельца
    private long price;//цена
    private boolean isNew;//новая или нет
    private int placesInTheSalon;//число мест в салоне
    String salonMaterial;//материал салона
    private boolean insurance;//застрахована ли
    private String manufacturerCountry;//страна-производитель
    int trunkVolume;//объем багажника
    private int accelerationTo100km;//разгон до 100 км/час в секундах


    public static void main(String[] args) {

        Car bugatti = new Car();

        bugatti.color = "blue";
        bugatti.accelerationTo100km = 3;
        bugatti.engineVolume = 6.3;
        bugatti.manufacturerCountry = "Italy";
        bugatti.ownerFirstName = "Amigo";
        bugatti.yearOfIssue = 2016;
        bugatti.insurance = true;
        bugatti.price = 2000000;
        bugatti.isNew = false;
        bugatti.placesInTheSalon = 2;
        bugatti.maxSpeed = 407;
        bugatti.model = "Bugatti Veyron";

        System.out.println("Модель Bugatti Veyron. Объем двигателя - " + bugatti.engineVolume + ", багажника - " + bugatti.trunkVolume + ", салон сделан из " + bugatti.salonMaterial +
                ", ширина дисков - " + bugatti.wheels + ". Была приоберетена в 2018 году господином " + bugatti.ownerLastName);


    }
}
