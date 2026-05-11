package FileExam;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Game2 implements Serializable {
    String nombre;
    double horas;

    public Game2(String nombre, double horas) {
        this.nombre = nombre;
        this.horas = horas;
    }


    public double getHoras() {
        return horas;
    }


    public String toString() {
        return nombre + " (" + horas + "h)";
    }
}

public class GameFileExercise {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);

        // FASE 1: Definir datos originales
        // TODO: crea una List<Game> con 5-6 juegos, algunos con <1h y otros con >1h

        ArrayList<Game2> gamesList = new ArrayList<>(gameList());

        // Mostrar originales
        System.out.println("=== Original Data ===");

        for (Game2 g : gamesList) {
            System.out.println(g.toString());
        }

        // FASE 2: Pedir nombres de ficheros
        
        System.out.print("Input file name: ");
        String filename = scan.next();

        // FASE 3: Escribir SOLO los Game con >1 hora
        // TODO: usa ObjectOutputStream

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            

            
            int size = gamesList.size();
            int written = 0;
            // TODO: escribe el tamaño primero
            oos.writeInt(written);

            // TODO: loop con if(horas > 1)

            for (int i = 0; i < size; i++) {
                if (gamesList.get(i).getHoras() > 1) {
                    oos.writeObject(gamesList.get(i));    //bien hecho 


                    // TODO: cuenta cuántos escribiste
                    written++;
                }
            }
            // FASE 4: Mostrar cuáles 
        // TODO: muestra el contador


        System.out.println("se guardaron total: " + written);
        } catch (IOException e) {
            
        }
        
        // FASE 5: Leer desde el fichero
        // TODO: usa ObjectInputStream
        try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream(filename))){
            
            // TODO: lee el tamaño
            int size = ios.readInt();   

            // TODO: lee cada Game

            Game2[] newGameList = new Game2[size];

            for (int i = 0; i < size; i++) {
                newGameList[i] = (Game2)ios.readObject();
            }

            // FASE 6: Mostrar lo leído
        System.out.println("=== Data Read ===");
        
        for (Game2 game2 : newGameList) {           //pusiste mal la lista 
            System.out.println(game2.toString());
        }

        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
        
        
    }

    public static ArrayList<Game2> gameList() {
        ArrayList<Game2> games = new ArrayList<>();

        games.add(new Game2("batman", 0));
        games.add(new Game2("invencible", 50));
        games.add(new Game2("RE9", 0));
        games.add(new Game2("Zomboid", 100));
        games.add(new Game2("Skyrim", 250));
        games.add(new Game2("spec ops the line", 40));

        return games;
    }

}
