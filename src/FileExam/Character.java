package FileExam;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.Serializable;

/**
 *
 * @author eblazquez
 */
public class Character implements Serializable {
    
    private String weapon, defense;
    private String name;
    private double life;
    private String origin;

    public Character(String weapon, String defense, String name, double life, String origin) {
        this.weapon = weapon;
        this.defense = defense;
        this.name = name;
        this.life = life;
        this.origin = origin;
    }

    public String getWeapon() {
        return weapon;
    }

    public String getDefense() {
        return defense;
    }

    public String getName() {
        return name;
    }

    public double getLife() {
        return life;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        sb.append("Character{");
        sb.append("name=").append(name);
        sb.append(", life=").append(life);
        sb.append(", Origin=").append(origin);
        sb.append(", weapon=").append(weapon);
        sb.append(", defense=").append(defense);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
