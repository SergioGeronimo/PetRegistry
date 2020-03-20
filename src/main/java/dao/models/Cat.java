package dao.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cat extends Animal implements Serializable {
    @Id @GeneratedValue @Column(name = "id")
    int id;

    @Column(name = "personality", nullable = false)
    String personality;

    @OneToOne
    Animal mate;

    public Cat(String name, int age, boolean alive, String personality, Animal mate) {
        super(name, age, alive);
        this.personality = personality;
        this.mate = mate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public Animal getMate() {
        return mate;
    }

    public void setMate(Animal mate) {
        this.mate = mate;
    }
}
