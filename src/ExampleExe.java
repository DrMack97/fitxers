import java.io.*;

//Serializable


class Game implements Serializable {
    String nombre;
    int horas;

    public Game(String nombre, int horas) {
        this.nombre = nombre;
        this.horas = horas;
    }

    public String toString() {
        return nombre + " (" + horas + "h)";
    }

    // separar por atributos 
    
}

public class ExampleExe {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // FASE 1: Crear 3 objetos Game
        // TODO: crea 3 juegos con nombres y horas diferentes

        
        Game G = new Game("The Witcher", 50);
        Game G2 = new Game("Minecraft", 200);
        Game G3 = new Game("HotLineMiami", 24);

        // FASE 2: Escribir los 3 juegos en un fichero "juegos.dat"
        // TODO: usa ObjectOutputStream para escribir los 3 objetos

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("juegos.dat"))) {

            oos.writeObject(G);
            oos.writeObject(G2);
            oos.writeObject(G3);

            oos.close();
        } catch (IOException e) {
            System.out.println("error IO " + e.getMessage());
        }

        // FASE 3: Leer desde el fichero y mostrar
        // TODO: usa ObjectInputStream para leer y mostrar cada uno

        try (ObjectInputStream oir = new ObjectInputStream(new FileInputStream("juegos.dat"))) {
            Game OG = (Game) oir.readObject();
            Game OG2 = (Game) oir.readObject();
            Game OG3 = (Game) oir.readObject();
            oir.close();

            System.out.println(OG.toString() + "\n" + OG2.toString() + "\n" + OG3.toString());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("error " + e.getMessage());
        }

        
    }
    
}
