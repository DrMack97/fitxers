package FileExam;

import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author eblazquez
 */
public class Game implements Serializable {
    private String name;
    private int hh, mm, ss;
    
    public Game(String name, int hh, int mm, int ss){
        this.name = name; 
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
    }
    
    public int getHh() {
        return hh;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Game of user: ").append(name);
        sb.append(hh).append(":");
        sb.append(mm).append(":");
        sb.append(ss);
        
        return sb.toString();
    }
    
}
