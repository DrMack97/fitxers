import java.io.File;

public class file1 {

    public static void main(String[] args) {

        File f = new File("C:\\\\Users\\\\usuario\\\\Documents\\\\java con Efrain");
        //

        System.out.println("Nombre:    " + f.getName());
        System.out.println("Ruta absoluta: " + f.getAbsolutePath());
        System.out.println("existe? " + f.exists());
        System.out.println("es fichero? " + f.isFile());
        System.out.println("es directorio? " + f.isDirectory());

        //////////////////////////////Permisos////////////////////////////////
        System.out.println();

        System.out.println("\n--- Permisos ---");

        System.out.println("es lectura? " + f.canRead());
        System.out.println("escritura? " + f.canWrite());
        System.out.println("se ejecuta? " + f.canExecute());

        System.out.println("\n--- Tamaño ---");

        System.out.println("tamaño (bytes): " + f.length());

        ///////////////////////////Contenido////////////////////////////////
        System.out.println();
        System.out.println("\n--- Contenido ---");
        System.out.println();

        if (f.isDirectory()) {          // si es directorio
            File[] contenido = f.listFiles(); //inicializa un array de FILE with .listFiles()

            int countDIR = 0;
            int countFIC = 0;

            if (contenido != null) {
                
                for (File files : contenido) {
                    String tipo = files.isDirectory() ? "[DIR]" : "[FIC]"; // crea un String y con .isDirectory + el ternario ? le asigna un tipo
                    System.out.println(tipo + files.getName());

                    if (tipo.equalsIgnoreCase("[DIR]")) { //(es mejor usar file.isDirector())
                        countDIR++;
                    }else if (tipo.equalsIgnoreCase("[FIC]")) { // no me hace falta comparlo de nuevo (porque es redundante )
                        countFIC++;
                    }
                }
                
            }

            System.out.println("Total DIR: "+countDIR + " - Total FIC: "+ countFIC);
        }

    }

}
