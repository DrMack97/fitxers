package FileExam;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyGame {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //ask file name
        System.out.print("Input data file name: ");
        String Filename = scan.next();
        List<Game> originalData = loadData();
        //write data to 2 file
        int elementsSave = writeTo2File(Filename, originalData);
        //TODO show number of elements saved
        
        System.out.println("elements saved = "+ elementsSave);

        System.out.println("Read from file: (enter a file name)");
        String fileRead = scan.next();
        List<Game> readData = readFromFile(fileRead);
        
        displayList(readData);
        
    }
    
    /**
     * displays a list of contacts
     * @param data the list of contacts to display
     */
    public static void displayList(List<Game> data) {
        for (Game t : data) {
            System.out.println(t);
        }
    }
    
    /**
     * writes data into the fileSource 
     * @param fileSource 
     * @param data
     */
    public static int writeTo2File(String fileSource,List<Game> data) {
    
        int games = 0;
        //TODO write the list to file

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileSource))){

            for (Game game : data) {
                if (game.getHh() > 1 ) {
                    games++;
                }
            }

            oos.writeInt(games);
            
            for (Game game : data) {
                if (game.getHh() > 1) {
                    oos.writeObject(game); // juego por juego 
                    
                }
            }

            
            
        } catch (IOException e) {
            System.out.println("error"+ e.getMessage());
        }

        //END TODO
        
        return games;
    }

    /**
     * reads the file and return a list of games;
     * @param filename the file name to read from
     */

    private static List<Game> readFromFile(String filename) {
        
            List<Game> data = new ArrayList<>();

            try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream(filename))){
                int size = ios.readInt();

                for (int i = 0; i < size; i++) {
                    Game g = (Game) ios.readObject();
                    data.add(g);
                }

                
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error " + e.getMessage());
            }
            
            return data;
        }

    private static List<Game> loadData(){
        List<Game> data = new ArrayList<>();
        data.add(new Game("Held",2,33,55));
        data.add(new Game("Bold",0,45,51));
        data.add(new Game("May",4,12,5));
        data.add(new Game("Flop",1,23,34));
        return data;
    }
    
}