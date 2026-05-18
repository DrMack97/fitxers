import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class Marca implements Serializable{

    String name;
    int year;
    public Marca(String name, int year) {
        this.name = name;
        this.year = year;
    }
    
}

class prenda implements Serializable {
    
        String name;
        String size;
        double price;
        Marca modelo;

        public prenda(String name, String size, double price, Marca modelo) {
            this.name = name;
            this.size = size;
            this.price = price;
            this.modelo = modelo;
        }

        public String getName() {
            return name;
        }

        public String getSize() {
            return size;
        }

        public double getPrice() {
            return price;
        }

        public Marca getModelo() {
            return modelo;
        }

        @Override
        public String toString() {
            return "prenda [name=" + name + ", size=" + size + ", price=" + price + ", modelo=" + modelo + "]";
        }
        
        
    }

public class ClothsShop {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<prenda> ropa = loadData();

        int guardados = writeSepare("prendas.dat", "Marcas.dat", ropa);

        System.out.println("se guardaron "+ guardados);

        ropa = readCloths("prendas.dat", "Marcas.dat");

        showCloths(ropa);
    }

    public static ArrayList<prenda> loadData(){
        ArrayList<prenda> clothsList = new ArrayList<>();

        clothsList.add(new prenda("camisa", "s", 32, new Marca("zara", 2026)));
        clothsList.add(new prenda("pants", "xs", 95, new Marca("levis", 2026)));
        clothsList.add(new prenda("chaqueta", "xl", 45, new Marca("ford", 2026)));
        clothsList.add(new prenda("jordan", "A1", 75, new Marca("swag", 2026)));

        return clothsList;
    }

    public static void showCloths(ArrayList<prenda> ropaList){
        if (ropaList == null || ropaList.isEmpty()) {
            System.out.println("Lista vacia");
            return;
        }
        for (prenda prenda : ropaList) {
            System.out.println(prenda.toString());
        }
    }

    //separar 
    
    public static int writeSepare(String prendas , String marcas , ArrayList<prenda> data){
        int counter = 0;
        try (ObjectOutputStream prenda = new ObjectOutputStream(new FileOutputStream(prendas));
            ObjectOutputStream marca = new ObjectOutputStream(new FileOutputStream(marcas))){

                prenda.writeInt(data.size());
                marca.writeInt(data.size());

                for (prenda p : data) {

                    //atributo
                    prenda.writeObject(p.getName());
                    prenda.writeObject(p.getSize());
                    prenda.writeDouble(p.getPrice());

                    //marca
                    
                    marca.writeObject(p.getModelo());

                    counter++;
                }
            
        } catch (IOException e) {
            System.err.println("Error "+ e.getMessage());
        }
        return counter;
    }
    
    public static ArrayList<prenda> readCloths(String prendas , String marcas){
        ArrayList<prenda> cloths = new ArrayList<>();
        //abrir canal
        try (ObjectInputStream prenda = new ObjectInputStream(new FileInputStream(prendas));
            ObjectInputStream marca = new ObjectInputStream(new FileInputStream(marcas))){
            //leer tamaño
            int size = prenda.readInt();
            int size2 = marca.readInt();
            
            //array
            String[] name = new String[size];
            String[] talla = new String[size];
            double[] price = new double[size];
            //otro fichero
            Marca[] modelo = new Marca[size2];
            
            //leer data 
            for (int i = 0; i < size; i++) {
                name[i] = (String) prenda.readObject();
                talla[i] =(String) prenda.readObject();
                price[i] = prenda.readDouble();

                modelo[i]= (Marca) marca.readObject();
            }

            //rebuild 
            for (int i = 0; i < size; i++) {
                prenda p = new prenda(name[i], talla[i], price[i], modelo[i]);
                cloths.add(p);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error "+ e.getMessage());
        }
        
        return cloths;
    }
}
