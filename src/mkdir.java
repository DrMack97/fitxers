import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class mkdir {

    public static void main(String[] args) {

        // Options rm path elimina directorio si puede
        // Options mk path crea directorio si puede
        // optioms mk -f crea fichero
        // Options wr path [lines] puede haber mas de una "primera linea "
        // Option rd path
        // Option & path mandatory

        // create dir:

        boolean execute = false;
        // validacion de argumetos

        if (args.length >= 2 && args.length <= 3) {

            execute = true;
        }

        if (execute) {

            mkdir dir = new mkdir();

            if (args[0].equalsIgnoreCase("rm")) {
                dir.deleteDir(args[1]);

            } else if (args[0].equalsIgnoreCase("mk")) {

                if (args[1].equalsIgnoreCase("-f")) {
                    dir.createFile(args[2]);
                } else {
                    dir.createDir(args[1]);
                }

            } else if (args[0].equalsIgnoreCase("wr")) {

                String path = args[1];

                ArrayList<String> data = new ArrayList<>();
            }else if (args[0].equalsIgnoreCase("rd")){
                
            }
        }
    }

    public void createDir(String path) {

        File dir = new File(path);

        if (!dir.exists()) {
            System.out.printf("Directory %s created!", path);
        } else {
            System.out.println("File already exits...");
        }
    }

    public void deleteDir(String path) {

        File dir = new File(path);

        // solo elimina si el directorio esta vacio

        if (dir.exists()) {
            System.out.printf("Directory %s deleted!", path);
        } else {
            System.out.println("File already exits...");
        }
    }

    public void createFile(String filename) {
        File file = new File(filename);

        boolean success = false;

        try {

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void deleteFile(String path) {
        File f = new File(path);

        boolean success = false;

        if (success) {
            System.out.printf("Directoru %s deleted", path);
        } else {
            System.out.println("no existe ");
        }
    }

    // Buferring

    public int saveLinesToFile(List<String> data, String filename) {
        int counter = 0;

        try {
            // obrir fitxer per guardar linies

            // PrintStream out = new PrintStream(new File(filename));

            PrintStream out = new PrintStream(new fileOutPutStream(filename, true));
            for (String line : data) {

                out.println(line);

                counter++;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return counter;
    }

    public List<String> readLinesFromFile(String fileName) {

        List<String> data = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException IOE) {
            IOE.printStackTrace();
        }
    }
}