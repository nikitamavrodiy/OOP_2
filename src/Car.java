
public class Car {
    String brand;
    String model;
    String color;
    String productionCountry;
    double engineVolume;
    int productionYear;

    Car (String brand, String model, int productionYear, String productionCountry, String color, double engineVolume) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.productionCountry = productionCountry;
        this.engineVolume = engineVolume;
        this.productionYear = productionYear;
        printCar();
    }

    void printCar() {
        System.out.println(brand + model + ", год выпуска " + productionYear + ", сборка " +
                productionCountry + ", цвет " + color + ", объем двигателя " + engineVolume + " л.");
    }

}
