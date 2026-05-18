package FileExam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author eblazquez
 */
public class CopyDialogs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        //ask file name
        
        CopyDialogs cd = new CopyDialogs();
        
        List<String> dialog = new ArrayList<>();
        dialog.add("Journey starts...");
        dialog.add("Old man Hololo wants war...");
        dialog.add("OK I'll defense you're vilage..");
        
        System.out.print("Input data file name: ");
        String filename = scan.next(); 

        cd.saveLinesToFile(dialog, filename);
        
        List<String> savedDialog = cd.readLinesFromFile(filename);
        
        cd.showDialogCharacter("Murag", dialog);
        
    }
    
    public int saveLinesToFile(List<String> data, String filename) {
        int counter = 0;
        //TO DO

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){

            for (String s : data) {
                bw.write(s);
                bw.newLine();
                counter++;
            }
            
        } catch (IOException e) {
            System.out.println("error "+ e.getMessage());
        }

        return counter;
    }
    
    /**
     * reads array of String from a file, each element from a line
     * @param filename the name of the file
     * @return the list of String
     */
    public List<String> readLinesFromFile(String filename) {
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            
            String line;

            while ((line = br.readLine()) != null) {
                data.add(line);
            }

        } catch (IOException e) {
            System.out.println("error "+ e.getMessage());
        }
        return data;
    }
    
    public void showDialogCharacter(String name, List<String> dialog){
        for(String d : dialog){
            System.out.println(name);
            System.out.println(d);
        }
    }
    
}
