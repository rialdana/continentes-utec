package sv.edu.utec.miscontinentes.models;

import java.io.Serializable;
import java.util.List;

public class Continent implements Serializable {
    private String image;
    private String name;
    private List<NaturalDestination> rivers;
    private List<NaturalDestination> lakes;
    private List<NaturalDestination> volcanoes;
    private List<Country> countries;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NaturalDestination> getRivers() {
        return rivers;
    }

    public void setRivers(List<NaturalDestination> rivers) {
        this.rivers = rivers;
    }

    public List<NaturalDestination> getLakes() {
        return lakes;
    }

    public void setLakes(List<NaturalDestination> lakes) {
        this.lakes = lakes;
    }

    public List<NaturalDestination> getVolcanoes() {
        return volcanoes;
    }

    public void setVolcanoes(List<NaturalDestination> volcanoes) {
        this.volcanoes = volcanoes;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
