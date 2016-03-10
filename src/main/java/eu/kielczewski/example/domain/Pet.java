package eu.kielczewski.example.domain;

import javax.persistence.*;

/**
 * Created by andreibadoi on 09/03/16.
 */

@Entity
@Table(name = "pet")
public class Pet {

    public Pet() {}
    public Pet(String name, String type, User owner) {
        this.name = name;
        this.type = type;
        this.owner = owner;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    private User owner;

    @Enumerated(EnumType.STRING)

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +

                ", name='" + name +
                ", type='" + type +
                ", owner=" + owner +
                '}';

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
