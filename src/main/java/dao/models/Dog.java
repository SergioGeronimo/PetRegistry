package dao.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Dog extends Animal {
    @Id @GeneratedValue @Column(name = "id")
    int id;

    @Column(name = "isTrained", nullable = false)
    boolean trained;

    @Column(name = "exerciseNeededPerDay", nullable = false)
    float exerciseNeededPerDay;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    ArrayList<Human> owners;

    public Dog(String name, int age, boolean alive, boolean trained, float exerciseNeededPerDay, ArrayList<Human> owners) {
        super(name, age, alive);
        this.trained = trained;
        this.exerciseNeededPerDay = exerciseNeededPerDay;
        this.owners = owners;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTrained() {
        return trained;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }

    public float getExerciseNeededPerDay() {
        return exerciseNeededPerDay;
    }

    public void setExerciseNeededPerDay(float exerciseNeededPerDay) {
        this.exerciseNeededPerDay = exerciseNeededPerDay;
    }

    public ArrayList<Human> getOwners() {
        return owners;
    }

    public void setOwners(ArrayList<Human> owners) {
        this.owners = owners;
    }
}
