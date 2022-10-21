package transport;


import java.time.LocalDate;
import java.util.Calendar;

public class Car {
    private final String brand;
    private final String model;
    private final int productionYear;
    private final String productionCountry;
    private final String bodyType;
    private final int seatsNumber;
    private double engineVolume;
    private String transmission;
    private String registrationNumber;
    private String color;
    private String tyresType;

    public final Key key;
    public final Insurance insurance;

    public Car(String brand, String model, int productionYear, String productionCountry, String color, double engineVolume, String transmission, String registrationNumber, String bodyType, String tyresType, int seatsNumber, Key key, Insurance insurance) {
        this.brand = checkCondition(brand);
        this.model = checkCondition(model);
        this.productionCountry = checkCondition(productionCountry);
        this.bodyType = checkCondition(bodyType);
        this.tyresType = checkCondition(tyresType);
        this.key = key;
        this.insurance = insurance;
        if (seatsNumber == 0) {
            this.seatsNumber = 40;
        } else {
            this.seatsNumber = seatsNumber < 0 ? Math.abs(seatsNumber) : seatsNumber;
        }
        if (productionYear == 0) {
            this.productionYear = 2000;
        } else {
            this.productionYear = productionYear < 0 ? Math.abs(productionYear) : productionYear;
        }
        setRegistrationNumber(registrationNumber);
        setTyresType(tyresType);
        setTransmission(transmission);
        setEngineVolume(engineVolume);
        setColor(color);
        printCar();
    }

    public boolean isRegNumberValid() {
        if (this.registrationNumber.length() != 9) {
            return false;
        }
        char[] regNumberChars = this.registrationNumber.toCharArray();
        return isNumberLetter(regNumberChars[0])
                && isNumber(regNumberChars[1])
                && isNumber(regNumberChars[2])
                && isNumber(regNumberChars[3])
                && isNumberLetter(regNumberChars[4])
                && isNumberLetter(regNumberChars[5])
                && isNumber(regNumberChars[6])
                && isNumber(regNumberChars[7])
                && isNumber(regNumberChars[8]);
    }

    private boolean isNumber(char symbol) {
        return Character.isDigit(symbol);
    }

    private boolean isNumberLetter(char symbol) {
        String allowedSymbols = "АВЕКМНОРСТУХ";
        return allowedSymbols.contains("" + symbol);
    }

    public void changeTires() {
        if (Calendar.getInstance().get(Calendar.MONTH) > 1 && Calendar.getInstance().get(Calendar.MONTH) < 11) {
            setTyresType("Летняя");
        } else {
            setTyresType("Зимняя");
        }
    }

    public void setTyresType(String tyresType) {
        this.tyresType = checkCondition(tyresType);
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = checkCondition(registrationNumber);

    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume < 0) {
            this.engineVolume = Math.abs(engineVolume);
        } else {
            this.engineVolume = engineVolume > 0 ? engineVolume : 1.5;
        }
    }

    public void setTransmission(String transmission) {
        this.transmission = checkCondition(transmission);
    }

    public String getTransmission() {
        return transmission;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getTyresType() {
        return tyresType;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void printCar() {
        System.out.println(brand + " " + model + ", год выпуска " + productionYear + ", сборка " +
                productionCountry + ", цвет" + color + ", объем двигателя " + engineVolume + " л." + ", коробка передач "
                + transmission + ", тип кузова " + bodyType + ",\n регистр.номер " + registrationNumber + ", количество мест "+seatsNumber
                + ", резина - " + tyresType);
    }

    private static String checkCondition(String check) {
        return check = check != null && !check.isEmpty() && !check.isBlank() ? check : "default";
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color != null && !color.isEmpty() && !color.isBlank() ? color : "white";
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public static class Key {
        private final boolean remoteEngineStart;
        private final boolean keyLessAcces;

        public Key(boolean remoteEngineStart, boolean keyLessAcces) {
            this.remoteEngineStart = remoteEngineStart;
            this.keyLessAcces = keyLessAcces;
        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeyLessAcces() {
            return keyLessAcces;
        }
    }

    public static class Insurance {
        private final LocalDate validUntil;
        private final float cost;
        private final String number;

        public Insurance(LocalDate validUntil, float cost, String number) {
            this.validUntil = validUntil != null ? validUntil : LocalDate.now().plusDays(10);
            this.cost = Math.max(cost, 1f);
            this.number = checkCondition(number);
        }

        public void isNumberValid() {
            if (number.length() != 9) {
                System.out.println("Номер страховки некорректный!");
            }
        }

        public void isInsuranceValid() {
            if (!LocalDate.now().isBefore(this.validUntil)) {
                System.out.println("Страховка просрочена - нужно срочно оформлять новую");
            }
        }
    }
}
