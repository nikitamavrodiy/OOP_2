
public class Car {
    String brand;
    String model;
    String color;
    String productionCountry;
    double engineVolume;
    int productionYear;

    Car (String brand, String model, int productionYear, String productionCountry, String color, double engineVolume) {
        this.brand = checkInputField(brand);
        this.model = checkInputField(model);
        this.color = color.length() < 2 ? "white" : color;
        this.productionCountry = checkInputField(productionCountry);
        this.engineVolume = engineVolume < 0 ? Math.abs(engineVolume) : engineVolume;
        this.productionYear = productionYear < 0 ? Math.abs(productionYear) : productionYear;
        printCar();
    }

    Car (String brand, String model, int productionYear, String productionCountry, String color) {
        this(brand, model, productionYear, productionCountry, color, 1.5);
    }

    Car (int productionYear, String color, double engineVolume) {
        this("default", "default", productionYear, "default", color, engineVolume);
    }

    Car (String brand, String model, int productionYear, String productionCountry, double engineVolume) {
        this(brand, model, productionYear, productionCountry, "white", engineVolume);
    }

    Car (String brand, String model, String productionCountry, String color, double engineVolume) {
        this(brand, model, 2000, productionCountry, color, engineVolume);
    }

    Car (String brand, String model, String productionCountry, String color) {
        this(brand, model, 2000, productionCountry, color, 1.5);
    }

    void printCar() {
        System.out.println(brand + " " + model + ", год выпуска " + productionYear + ", сборка " +
                productionCountry + ", цвет " + color + ", объем двигателя " + engineVolume + " л.");
    }

    String checkInputField(String check) {
        return check = (check.length() > 0) ? check : "default";
    }


}
