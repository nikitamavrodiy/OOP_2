public class Main {

    public static void main(String[] args) {
        Human maksim = new Human("Максим", "Минск", 35, "бренд-менеджер");
        Human anya = new Human("Аня", "Москва", 29, "методист образовательных программ");
        Human katya = new Human("Катя", "Калининград", 28, "продакт-менеджер");
        Human artem = new Human("Артем", "Москва", 27, "директор по развитию бизнеса");

        System.out.println();
        Human Karlos = new Human(27);
        Human unnamed = new Human("","",0,"");

        System.out.println();
        Car car1 = new Car("Lada", "Granta", 2015, "Россия", "желтый", 1.7);
        Car car2 = new Car("Audi", "A8 50 L TDI quattro", 2020, "Германия", "черный", 3.0);
        Car car3 = new Car("BMW", "Z8", 2021, "Германия", "черный", 3.0);
        Car car4 = new Car("Kia", "Sportage 4-го поколения", 2018, "Южная Корея", "красный", 2.4);
        Car car5 = new Car("Hyundai", "Avante", 2016, "Южная Корея", "оранжевый", 1.6);

        System.out.println();
        Car carDefault = new Car("", "Avante", "Южная Корея", "оранжевый");

    }

}
