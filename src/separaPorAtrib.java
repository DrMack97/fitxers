import java.io.*;

class Arma implements Serializable {
        String nombre;
        int daño;

        public Arma(String nombre, int daño) {
            this.nombre = nombre;
            this.daño = daño;
        }

        @Override
        public String toString() {
            return "Arma [nombre=" + nombre + ", daño=" + daño + "]";
        }

    }

    class personaje implements Serializable {

        String nombre;
        int vida;
        Arma arma;

        public personaje(String nombre, int vida, Arma arma) {
            this.nombre = nombre;
            this.vida = vida;
            this.arma = arma;
        }

        @Override
        public String toString() {
            return "personaje [nombre=" + nombre + ", vida=" + vida + ", arma=" + arma + "]";
        }
    }

public class separaPorAtrib {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // SEPARAR POR ATRIBUTOS

        // FASE 1: Crear 2 personajes
        // TODO: crea 2 personajes con nombre, vida y arma

        personaje p1 = new personaje("Arthas", 80, new Arma("Frozmurths", 50));

        personaje p2 = new personaje("Mago", 80, new Arma("Varita", 15));

        // FASE 2: Escribir SEPARADO en 2 ficheros

        // TODO: escribe en ambos ficheros

        // - Fichero "personajes.dat": nombre y vida

        // ObjectOutputStream

        try (ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream("personajes.dat"))) {

            // personaje 1
            oos.writeObject(p1.nombre);
            oos.writeInt(p1.vida);

            // personaje 2
            oos.writeObject(p2.nombre);
            oos.writeInt(p2.vida);

        } catch (IOException e) {
            System.out.println("error " + e.getMessage());
        }

        // - Fichero "armas.dat": arma
        try (ObjectOutputStream oos2 = new ObjectOutputStream(
            new FileOutputStream("armas.dat"))) {

            // personaje 1 weapon
            oos2.writeObject(p1.arma);

            // personaje 2 weapon
            oos2.writeObject(p2.arma);


        } catch (IOException e) {
            System.out.println("error " + e.getMessage());
        }

        // FASE 3: Leer y reconstruir
        // TODO: lee desde ambos ficheros
        
        String[] names = new String[2];
        int[] lifes = new int[2];
        Arma[] weapon = new Arma[2];

        //Canal para status
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personajes.dat"))) {

            // name and life character
            for (int i = 0; i < 2; i++) {
                names[i] = (String) ois.readObject();
                lifes[i] = ois.readInt();
            }
        }catch(IOException | ClassNotFoundException e){
            System.out.println("Error " + e.getMessage());
        }
        //Canal para weapons
        try(ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("armas.dat"))){
            
            for (int i = 0; i < weapon.length; i++) {
                weapon[i] = (Arma) ois2.readObject();
            }
        
        }catch(IOException | ClassNotFoundException e){
            System.out.println("Error " + e.getMessage());
        }
        
        for (int i = 0; i < 2; i++) {
            System.out.println(names[i] + " | vida "+ lifes[i]+" | armas "+weapon[i]);
        }
        
    }
}


