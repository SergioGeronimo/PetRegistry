package dao.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Animal")
public class Animal implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "age", nullable = false)
    int age;

    @Column(name = "isAlive", nullable = false)
    boolean alive;

    public Animal(String name, int age, boolean alive) {
        this.name = name;
        this.age = age;
        this.alive = alive;
    }

    public Animal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
