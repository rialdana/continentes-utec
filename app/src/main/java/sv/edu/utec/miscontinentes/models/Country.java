package sv.edu.utec.miscontinentes.models;

import java.io.Serializable;

public class Country implements Serializable {
    private String name;
    private String capital;

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }
}
