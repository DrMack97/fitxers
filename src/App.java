import java.io.File;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

                // SRC / FOLDER1 
                //     / FODLER2 

                // -r Folder 1 
                // -r Folder 2     ./ folder 1
                //                 ./ folder 1

        System.out.println("ARGUMENTS");

        String pathName = ".\\";

        boolean execute = true;

            // -r relativo
            if (args.length > 0) {
                // -r path (relativo + path)
                if (args[0].equalsIgnoreCase("-r")) {
                    if (args.length == 2) {
                        pathName += args[1]; 
                    }

                // -a path absolute   
                }else if (args[0].equalsIgnoreCase("-a")) {
                    if (args.length == 2) {
                        pathName = args[1];
                    }else{

                        System.out.println("Missing absolute path");
                        execute = false;
                        
                    }
                    
                }else if(args[0].equalsIgnoreCase("-h")) {
                        System.out.println("USAGE: ");
                        System.out.println("-r path - Show relative path ");
                        System.out.println("-a path - requires absolute path");

                }
            }
            //clase *File*

        System.out.println("");

        File dir = new File(pathName);
        System.out.println(Arrays.toString(dir.list()));
        dir.list();
    }
}
