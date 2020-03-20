package dao.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Human extends Animal{
    @Id @GeneratedValue
    @Column (name = "curp")
    String curp;

    @Column (name = "nationality", nullable = false)
    String nationality;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    ArrayList<Animal> pets;

    public Human(String name, int age, boolean alive, String nationality, ArrayList<Animal> pets) {
        super(name, age, alive);
        this.nationality = nationality;
        this.pets = pets;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public ArrayList<Animal> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Animal> pets) {
        this.pets = pets;
    }
}
