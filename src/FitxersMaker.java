import java.io.File;
import java.io.IOException;

public class FitxersMaker {

    public static void main(String[] args) {

        //Creacion de archivo 1.0

        //ruta abasoluta que finalizara siempre con el nuevo archivo
        String ruta = "C:\\Users\\usuario\\Documents\\java con Efrain\\fitxers\\example.txt";

        File dialogo = new File(ruta);

        //si la carpeta existe "obtenemos la carpeta en la direccion en la que deberia estar ^"

        File carpetaDeDialog = dialogo.getParentFile();

        
        
        //si no existe nos la invantamos
        if (carpetaDeDialog != null && !carpetaDeDialog.exists()) { // si es null y no existe
            // crea carpetas
            carpetaDeDialog.mkdirs(); // crea toda la ruta hasta la carpeta que elegimos
        }

        try {
            if (dialogo.createNewFile()) {
            System.out.println("exito archivo creado en:"+ dialogo.getAbsolutePath());
        }
        } catch (IOException e) {
            System.out.println("no se pudo "+ e.getMessage());
        }


    }

}
