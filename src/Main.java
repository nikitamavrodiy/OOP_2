import transport.Car;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Human maksim = new Human("Максим", "Минск", 35, "бренд-менеджер");
        Human anya = new Human("Аня", "Москва", 29, "методист образовательных программ");
        Human katya = new Human("Катя", "Калининград", 28, "продакт-менеджер");
        Human artem = new Human("Артем", "Москва", 27, "директор по развитию бизнеса");
        Human vladimir = new Human("Vladimir","Казань",21,null);
        System.out.println();

        flower rosue = new flower("Роза обыкновенная",null,"Голландия", 35.59);
        System.out.println(rosue.toString());
        flower chrysanthemum = new flower("Хризантема", null,"", 15, 5);
        System.out.println(chrysanthemum.toString());
        flower pion = new flower("Пион", null,"Англия", 69.9, 1);
        System.out.println(pion.toString());
        flower gypsophila = new flower("Гипсофила", null,"Турция", 19.5, 10);
        System.out.println(gypsophila.toString());

        flower.addToBouquet(rosue, 3);
        flower.addToBouquet(chrysanthemum, 5);
        flower.addToBouquet(gypsophila);
        flower.calculateBouquet();
        System.out.println();

        Car.Key key = new Car.Key(true,true);
        Car.Insurance insurance = new Car.Insurance(LocalDate.of(2021,04,04), 250.50f, "3423343039");
        transport.Car carDefault = new transport.Car("", "Avante", 0 , null, "оранжевый", 0, "automat", "У343ХА053", " ","Winter", 4, key, insurance);
        carDefault.changeTires();
        carDefault.printCar();
        System.out.println("the regNumber is " + carDefault.isRegNumberValid());
        System.out.println("isKeyLessAcces = " + carDefault.key.isKeyLessAcces());
        System.out.println("isRemoteEngineStart = " + carDefault.key.isRemoteEngineStart());
        carDefault.insurance.isInsuranceValid();
        carDefault.insurance.isNumberValid();

    }

}
