package FileExam;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author eblazquez
 */
public class CopyCharacter {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        //instantiate main class
        CopyCharacter ap = new CopyCharacter();
        //create test data
        List<Character> originalData = ap.loadData();
        //display original data
        System.out.println("Original data");
        ap.displayList(originalData);
        //ask file name
        System.out.print("Input public data file name: ");
        String publicFilename = scan.next();
        System.out.print("Input private data file name: ");
        String privateFilename = scan.next();
        //write data to file
        int elemsWritten = ap.writeToFile(publicFilename, privateFilename, originalData);
        //TO DO show the numbers of items save

        System.out.println("items save = " + elemsWritten);
        //END TO DO
        
        //read data from file
        System.out.println("Read data");
        List<Character> readData = ap.readFromFile(publicFilename, privateFilename);
        //display read data
        ap.displayList(readData);
    }

    /**
     * displays a list of employee
     * @param data the list of employee to display
     */
    public void displayList(List<Character> data) {
        for (Character t : data) {
            System.out.println(t);
        }
    }
    
    /**
     * writes employee data to two files (public and private data)
     * @param pubFilename the file name to write public data
     * @param privFilename the file name to write private data
     * @param data the list to be written to file
     * @return the number of elements actually written to file
     */
    public int writeToFile(String pubFilename, String privFilename, List<Character> data) {
        int counter = 0;
            // open ObjectOutputStream
        try (ObjectOutputStream oosPub = new ObjectOutputStream(new FileOutputStream(pubFilename));
            ObjectOutputStream oosPriv = new ObjectOutputStream(new FileOutputStream(privFilename))){

            //show size
            oosPub.writeInt(data.size());
            oosPriv.writeInt(data.size());

            //shower loop (for each)
            for (Character c : data) {
                oosPub.writeObject(c.getWeapon());
                oosPub.writeObject(c.getDefense());

                // show other file

                oosPriv.writeObject(c.getName());
                oosPriv.writeDouble(c.getLife());
                oosPriv.writeObject(c.getOrigin());

                counter++;
            }
            
        } catch (IOException e) {
            System.out.println("Error "+ e.getMessage());
        }
        return counter;
    }

    /**
     * reads a list of double from file
     * @param filename the file name to read from
     * @return the list of double read from file
     */
    private List<Character> readFromFile(String pubFilename, String privFilename) {
        List<Character> data = null;
        File file1 = new File(pubFilename);
        File file2 = new File(privFilename);
        if (file1.exists() && file1.canRead() && file2.exists() && file2.canRead()) {
            data = new ArrayList<>();

        try (ObjectInputStream iosPub = new ObjectInputStream(new FileInputStream(pubFilename));
            ObjectInputStream iosPriv = new ObjectInputStream(new FileInputStream(privFilename))){

            // Read Size 
            int pubSize = iosPub.readInt();
            int privSize = iosPriv.readInt();

            // Arras or list (1 for each attribute)
            String [] weapons = new String [pubSize];
            String [] defense = new String [pubSize];
            String [] names = new String [pubSize];
            String [] origins = new String [pubSize];
            double [] life = new double[privSize];

            // Read data

                for (int i = 0; i < privSize; i++) {
            // public
                    weapons[i] = (String) iosPub.readObject();
                    defense[i] = (String) iosPub.readObject();
            // private
                    names[i]    =  (String) iosPriv.readObject();
                    origins[i]  = (String) iosPriv.readObject(); 
                    life[i]     = iosPriv.readDouble();
                }
                
            // Rebuild
                for (int i = 0; i < privSize; i++) {
                    data.add(new Character(weapons[i], defense[i], names[i], life[i], origins[i]));
                }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("error "+ e.getMessage());
        }
        }
        return data;
    }
    /**
     * loads test data
     * @return list of double with some data
     */

    public List<Character> loadData() {
        List<Character> data = new ArrayList<>();
        data.add(new Character( "Sword","Shield" ,"Tink", 100, "Morer"));
        data.add(new Character( "Axe", "VikingDefense", "Ranuro", 2000, "Flirtur"));
        data.add(new Character( "Hammer", "WeakDefense","Rock", 40, "Morer"));
        data.add(new Character( "Arch", "Helmet", "Sharee", 50, "Hanukak"));
        data.add(new Character( "GoldHammer", "NaturalShield", "Sferia", 250, "Flirtur"));
        data.add(new Character( "RoyalSword", "RoyalArmor", "Ronana", 500, "Morer"));
        return data;
    }
}
