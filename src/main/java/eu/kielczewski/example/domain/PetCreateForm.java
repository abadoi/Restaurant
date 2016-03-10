package eu.kielczewski.example.domain;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Danut on 3/10/2016.
 */
public class PetCreateForm {

    @NotEmpty
    private String name;

    @NotEmpty
    private String type;


    private User owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
    @Override
    public String toString() {
        return "PetCreateForm{" +
                "name=" + name +
                ", type=" + type +
                ", owner=" + owner +
                '}';
    }
}
