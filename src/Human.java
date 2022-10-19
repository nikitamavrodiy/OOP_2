import java.util.Calendar;

public class Human {
    private String name;
    private String town;
    private int yearOfBirth;
    private String job;

    Human(String name, String town, int age, String job) {
        setYearOfBirth(Calendar.getInstance().get(Calendar.YEAR) - age);
        setTown(town);
        setName(name);
        setJob(job);
        System.out.println(this.toString());
    }

    String checkInputField(String check) {
        return check = check == null || check.isEmpty() || check.isBlank() ? "(Информация не указана)" : check;
    }

    public String toString() {
        return "Привет! Меня зовут " + name + ". Я из города " + town +
                ". Я родился в " + yearOfBirth + " году. Я работаю на должности " + job + ". Будем знакомы!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = checkInputField(name);
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = checkInputField(town);
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth <= 0 ? 0 : yearOfBirth;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = checkInputField(job);
    }
}
