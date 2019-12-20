package com.github.mohamed9555.Model;

public class Countries {

    private String name;
    private String capital;
    private String region;
    private int population;
    private String flag;

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

    public String getFlag() {
        return flag;
    }
}
