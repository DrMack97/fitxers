import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class WeaponShop {

    public static class weapons1 implements Serializable {

        String name; 
        String rareza;
        int ammo;
        
        public weapons1(String name, String rareza, int ammo) {
            this.name = name;
            this.rareza = rareza;
            this.ammo = ammo;
        }

        @Override
        public String toString() {
            return "weapons1 [name=" + name + ", rareza=" + rareza + ", ammo=" + ammo + "]";
        }

        public String getName() {
            return name;
        }

        public String getRareza() {
            return rareza;
        }

        public int getAmmo() {
            return ammo;
        }
        
    }
    public static void main(String[] args) {

        ArrayList<weapons1> weaps = wList();

        //mostrar todas 
        System.out.println("ALL Weapons");

        for (weapons1 w : weaps) {
            System.out.println(w.toString());
        }

        //guardar por rareza
        saveWeapons("Weapons.dat", weaps);

        //leer y mostrar 
        readWeapons("Weapons.dat", weaps);
        
    }

    public static int saveWeapons(String file, ArrayList<weapons1> DATA){
        int counter = 0;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            
            //guardar tamaño
            oos.writeInt(DATA.size()); // muestra el tamaño
            //guardar por rareza 

            for (weapons1 w : DATA) {
                if (w.getRareza().equalsIgnoreCase("legend") || w.getRareza().equalsIgnoreCase("epic")) {
                    oos.writeObject(w);
                    counter++;
                }
                
            }

            //show saved
            System.out.println(" se guardaron "+ counter);

        } catch (IOException  e) {
            System.err.println("error " + e.getMessage());
        }
        return counter;
    }
        //readFromFile

    public static ArrayList<weapons1> readWeapons(String file, ArrayList<weapons1> data){
        ArrayList<weapons1> readW= new ArrayList<>();
        try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream(file))){
            int size = ios.readInt();

            for (int i = 0; i < size; i++) {
                weapons1 w = (weapons1) ios.readObject();
                readW.add(w);
            }
        } catch (IOException | ClassNotFoundException  e) {
            System.err.println("error " + e.getMessage());
        }
        
        for (weapons1 w : readW) {
            System.out.println(w.toString());
        }
        return readW;
    }

        //showreads 
    
    public static ArrayList<weapons1> wList(){
        ArrayList<weapons1> weaponsList = new ArrayList<>();

        weaponsList.add(new weapons1("Requiem", "legend", 8));
        weaponsList.add(new weapons1("9mm", "basic", 25));
        weaponsList.add(new weapons1("m16", "basic", 25));
        weaponsList.add(new weapons1("duales", "basic", 25));
        weaponsList.add(new weapons1("ak-47", "epic", 25));
        weaponsList.add(new weapons1("elwebomio", "legend", 45));

        return weaponsList;

    }
}


