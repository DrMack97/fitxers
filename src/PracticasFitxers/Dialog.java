package PracticasFitxers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Dialog {

    // Dialogo por turnos

    // programa que simula un dialogo de un juego RPG
    // el dialogo se guarda en un fichero que se denomina con el personaje
    // a la hora de mostrar el dialogo siempre habla un personaje primero contesta
    // con el format

    // el nombre que printa tiene que venir del nombre del fichero,
    // no se le dice al programa como se llaman
    // debe haber al menos dos

    /*
     * Heroe: que tal por aqui?
     * villano: pues desde que que viniste mal...
     * .
     * .
     * .
     */

    // version facil sin ENTER
    // un poco mas compleja pulsar enter para la contestacion

    public static void main(String[] args) {

        // FASE 1:

        // crear ubicacion de dialogos
        String rutaDialogos = "C:\\Users\\usuario\\Documents\\java con Efrain\\fitxers\\Dialogs";

        File carpetaDialog = new File(rutaDialogos);

        // nuevo obj File espesifico para crear las carpetas:

        if (carpetaDialog != null && !carpetaDialog.exists()) {
            carpetaDialog.mkdirs();
        }

        File diag1 = new File(carpetaDialog, "Comander.txt");
        File diag2 = new File(carpetaDialog, "TheVillian.txt");

        // escribimos en ambos files:

        /*
         * - Estructura -
         * //Try
         * -Try Diag1
         * -Try Diag 2
         * //catch
         */

        try {
            // diag2
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(diag1))) {
                String eres = "- te voi a parti esa cara lok";

                bw.write(eres);
                bw.newLine();
                bw.write("- ya verasss ");
            }
            // diag2
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(diag2))) {
                bw.write("+ ya llego la basura esta ");
                bw.newLine();
                bw.write("no creo");
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        // FASE 2 LOGICA INTERCAMBIO DE LIRICA:

        // obtener nombres

        System.out.println("--- Dialogo ---");

        String Villano = diag2.getName().replace(".txt", "");
        String jabon = diag1.getName().replace(".txt", "");

        System.out.println("Personajes: " + Villano + " vs " + jabon);

        Scanner sc = new Scanner(System.in); // para el ENTER

        try (BufferedReader br1 = new BufferedReader(new FileReader(diag1));
            BufferedReader br2 = new BufferedReader(new FileReader(diag2))) {

            String linea1, linea2;

            linea1 = br2.readLine();
            linea2 = br1.readLine();

            while (linea1 != null || linea2 != null) {

                if (linea1 != null) {
                    System.out.println("empieza " + Villano + " diciendo " + linea1);
                    sc.nextLine();
                    linea1 = br2.readLine();
                }
                if (linea2 != null) {
                    System.out.println("Continua " + jabon + " diciendo " + linea2);
                    sc.nextLine();
                    linea2 = br1.readLine();

                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }

}
