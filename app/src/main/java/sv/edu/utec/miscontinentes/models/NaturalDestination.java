package sv.edu.utec.miscontinentes.models;

import java.io.Serializable;

public class NaturalDestination implements Serializable {
    private String name;
    private String image;

    public NaturalDestination(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
