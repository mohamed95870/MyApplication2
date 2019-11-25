package retrofitgerrit;

public class Countries {

    private String name;
    private String capital;
    private String region;
    private int population;

    public Countries(String name, String capital, String region, int population) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }

    public int getPopulation() {
        return population;
    }
}
