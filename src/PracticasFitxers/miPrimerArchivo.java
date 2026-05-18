package PracticasFitxers;
import java.io.File;
import java.io.IOException;

public class miPrimerArchivo {
    public static void main(String[] args) {

        File mine = new File("Documentos", "notas.txt");
        //EXITS?
        if (mine.exists()) {
            if (mine.isFile()) {
                System.out.println("es un archivo");
                System.out.println("Size: "+ mine.length() + " Ultima modificacion: "+mine.lastModified());
            }
            if (mine.isDirectory()) {
                System.out.println("es un carpeta");
            }
        } else {
            System.out.println("no hay nada");
        }
        //CREATE
        try {
            if (mine.createNewFile()) {
                System.out.println("hemos creado la caja fisica");
            }else{
                System.out.println("ya existe!");
            }
        } catch (IOException e) {
            System.out.println("Ocurrio un error");
        }

        //DELETE
            if (mine.exists()) {
                mine.delete();
            }else{
                System.out.println("no existe");
            }
    
        //LISTAR list() (devuelve String[]) // listFiles() (un array de objetos File[]) // 

        File carpeta = new File("Documents");

        if (carpeta.exists() && carpeta.isDirectory()) { // si carpeta existe y es un directorio
            String[] inventario = carpeta.list();
            
            System.out.println("contenido de la carpeta");

            for (String name : inventario) {
                System.out.println("- "+ name);               
            }
        } 

        System.out.println("Archivos que pesen mas de 1024 bytes");

        File[] files = mine.listFiles();

        for (File file : files) {
            if (file.length() > 1024) {
                System.out.println("Nombre: "+file.getName()+ " Size: "+file.length());
            } 
        }


    }

}
