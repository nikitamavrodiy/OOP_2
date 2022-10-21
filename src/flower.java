import java.util.Arrays;

public class flower {
    private final String name;
    private String flowerColor;
    private String country;
    private double cost;
    private int lifeSpan;
    private static flower[] bouquet = new flower[0];

    public flower(String name, String flowerColor, String country, double cost) {
        this(name, flowerColor, country, cost, 3);
    }

    public flower(String name, String flowerColor, String country, double cost, int lifeSpan) {
        setFlowerColor(flowerColor);
        setCountry(country);
        setCost(cost);
        setLifeSpan(lifeSpan);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFlowerColor() {
        return flowerColor;
    }

    public void setFlowerColor(String flowerColor) {
        this.flowerColor = flowerColor != null && !flowerColor.isEmpty() && !flowerColor.isBlank() ? flowerColor : "Белый";
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country != null && !country.isEmpty() && !country.isBlank() ? country : "Россия";
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost > 0 ? cost : 1;
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(int lifeSpan) {
        if (lifeSpan < 0) {
            this.lifeSpan = Math.abs(lifeSpan);
        } else if (lifeSpan == 0) {
            this.lifeSpan = 3;
        } else {
            this.lifeSpan = lifeSpan;
        }
    }

    public static flower[] getBouquet() {
        return bouquet;
    }

    public String toString() {
        return "Название: " + getName() +
                "  Страна происхождения: " + getCountry() +
                "  Цвет: " + getFlowerColor() +
                "  Стоимость: " + getCost() + " руб." +
                "  Срок стояния цветка: " + getLifeSpan() + " дн.";
    }
    public static void addToBouquet(flower flower) {
        addToBouquet(flower, 1);
    }

    public static void addToBouquet(flower flower, int count) {
        for (int i = 0; i < count ; i++) {
            bouquet = Arrays.copyOf(getBouquet(), getBouquet().length + 1);
            bouquet[getBouquet().length - 1] = flower;
        }
    }

    public static void calculateBouquet() {
        double bouquetCost = 0;
        int bouquetLifeSpan = bouquet[0].getLifeSpan();
        for (int i = 0; i < bouquet.length; i++) {
            bouquetCost += bouquet[i].getCost();
            if (bouquet[i].getLifeSpan() < bouquetLifeSpan) {
                bouquetLifeSpan = bouquet[i].getLifeSpan();
            }
        }

        System.out.print("Букет, в котором есть:");
        composition();
        System.out.println(" -- будет стоить " + Math.floor((bouquetCost * 1.1) * 100) / 100 + " руб. и простоит " + bouquetLifeSpan + " суток.");
    }

    public static void composition() {
        int counter = 1;
        for (int i = 1; i < bouquet.length; i++) {
            if (bouquet[i] == bouquet[i - 1]) {
                counter++;
            } else {
                System.out.print("  " + bouquet[i-1].getName() + "(" + counter + "), ");
                counter = 1;
            }
        }
        System.out.print("  " + bouquet[bouquet.length - 1].getName() + "(" + counter + ")");

    }


}
