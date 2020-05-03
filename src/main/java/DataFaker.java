import com.github.javafaker.Faker;

import java.util.Random;

public class DataFaker {

    Random rand;
    public DataFaker() {
        this.rand = new Random();
    }

    enum Companies{
        TELEKOMAS, ORLEAN, KLASCO, GRUDAI, AZOTAS, NAFTA, GELEZINKELIAI, TRANSPORTAS, MAXIMA, TRAFFIC;
    }
    public String[] GenerateName()
    {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String[] fullName = {firstName, lastName};
        return fullName;
    }

    public int GenerateIncome(){
        int income = rand.nextInt(1000);
        return income;
    }

    public String GenerateCompany(){
        int index = rand.nextInt(10);
        return Companies.values()[index].toString();
    }



}
