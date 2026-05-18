import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class estudiantes {

    String name;
    String Asignatura;
    double nota;
    String observaciones;

    public estudiantes(String name, String asignatura, double nota, String observaciones) {
        this.name = name;
        Asignatura = asignatura;
        this.nota = nota;
        this.observaciones = observaciones;
    }

    public String getName() {
        return name;
    }

    public String getAsignatura() {
        return Asignatura;
    }

    public double getNota() {
        return nota;
    }

    public String getObservaciones() {
        return observaciones;
    }

    @Override
    public String toString() {
        return "estudiantes [name=" + name + ", Asignatura=" + Asignatura + ", nota=" + nota + ", observaciones="
                + observaciones + "]";
    }

}

public class dialogosEXM {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // FASE 1: Mostrar originales
        System.out.println("=== Datos Originales ===");
        ArrayList<estudiantes> data = loadData();

        // FASE 2: Guardar
        System.out.println("\n=== Guardando ===");
        int count = writeOrder(data);
        System.out.println("Written records: " + count);

        // FASE 3: Leer
        System.out.println("\n=== Leyendo ===");
        ArrayList<String> lines = readStudents();

        // FASE 4: Mostrar leído
        System.out.println("\n=== Contenido del Fichero ===");
        Display(lines);
    }

    static ArrayList<estudiantes> loadData() {
        ArrayList<estudiantes> alu = new ArrayList<>();

        alu.add(new estudiantes("david", "Programacion", 9, "distraido"));
        alu.add(new estudiantes("rafa", "marcas", 10, "listo"));
        alu.add(new estudiantes("gerad", "sistemas", 6, "bello"));

        return alu;
    }

    // escribir linea por linea
    static int writeOrder(ArrayList<estudiantes> data) {
        int counter = 0;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("calificaciones.txt"))) {

            for (estudiantes e : data) {
                bw.write(e.getName());
                bw.newLine();
                bw.write(e.getAsignatura() + ": " + e.getNota());
                bw.newLine();
                bw.write("Observaciones: " + e.getObservaciones());
                bw.newLine();
                bw.write("------------------");
                bw.newLine();

                counter++;
            }

        } catch (IOException e) {
            System.err.println("error" + e.getMessage());
        }

        return counter;
    }
    // leer linea por linea

    static ArrayList<String> readStudents() {
        ArrayList<String> esList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("calificaciones.txt"))) {

            String lines;
            while ((lines = br.readLine()) != null) {
                esList.add(lines);
            }
        } catch (IOException e) {
            System.err.println("error" + e.getMessage());
        }

        return esList;
    }

    // mostrar

    static void Display(ArrayList<String> data) {
        for (String s : data) {
            System.out.println(s);
        }
    }
}
