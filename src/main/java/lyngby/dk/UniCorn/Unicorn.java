package lyngby.dk.UniCorn;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.boot.model.process.internal.UserTypeResolution;
@Entity
public class Unicorn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private int powerStrength;

    public Unicorn() {
    }

    public Unicorn(String name, int age, int powerStrength) {
        this.name = name;
        this.age = age;
        this.powerStrength = powerStrength;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPowerStrength(int powerStrength) {
        this.powerStrength = powerStrength;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPowerStrength() {
        return powerStrength;
    }
}

