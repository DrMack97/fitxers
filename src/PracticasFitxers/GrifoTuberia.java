package PracticasFitxers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GrifoTuberia {

    public static void main(String[] args) {
        File mine = new File("Documentos", "notas.txt");

        if (mine.exists() && mine.isFile()) {
            //abre la tuberia y cierra al terminar 
            try (BufferedReader br = new BufferedReader(new FileReader(mine))){

                String linea;
                System.out.println("--- inicio del archivo ---");
                // mientras haya lineas en el archivo (agua en la tuberia)
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }

                System.out.println("--- Fin del Archivo ---");

                
            } catch (IOException e) {
                System.out.println("no pude leer el contenido");
            }
        }else{
            System.out.println("la caja no existe o no es un archivo");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(mine))){
            
            String texto = "ola, esto es un texto";

            // para escribir dentro de texto 
            bw.write(texto);
            bw.newLine(); // salto de texto
            // linea nueva 
            bw.write("nuevo texto");
        } catch (IOException e) {
            System.out.println("no se puedo escribir en el archivo ");
        }
    }

}
