import java.util.Calendar;

public class Human {
    private String name;
    private String town;
    private int yearOfBirth;
    private String job;

    Human(int age) {
        this("(Информация не указана)", "(Информация не указана)", age, "(Информация не указана)");
    }

    Human(String name, String town, int age, String job) {
        if (age < 0) {
            throw new IllegalArgumentException("Значение возраста не может быть отрицательным!");
        }
        this.yearOfBirth = Calendar.getInstance().get(Calendar.YEAR) - age;
        this.name = checkInputField(name);
        this.town = checkInputField(town);
        this.job = checkInputField(job);
        System.out.println(this.toString());
    }

    String checkInputField(String check) {
        return check = (check.length() > 0) ? check : "(Информация не указана)";
    }

    public String toString() {
        return "Привет! Меня зовут " + name + ". Я из города " + town +
                ". Я родился в " + yearOfBirth + " году. Я работаю на должности " + job + ". Будем знакомы!";
    }





}
