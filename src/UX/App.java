package UX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;

public class App {
    public static void main(String[] args) throws Exception {

        try { //Que se vea moderno
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            
        }
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });

    }


    private static void createAndShowGUI(){

        JFrame.setDefaultLookAndFeelDecorated(true); //Crea el objeto, no la ventana

        JFrame frame = new JFrame("HOLAAA"); //Añadir título a ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Comportamiento al cerrar ventana

        

        JLabel label = new JLabel("xdddd"); //Crea un label que añadir a la app
        frame.getContentPane().add(label); //Le añade el label al frame

        JLabel label2 = new JLabel("lol"); //Crea un label que añadir a la app
        frame.getContentPane().add(label2); //Le añade el label al frame

        

        //frame.pack(); //Adapta el tamaño de la ventana con la info
        frame.setSize(1920,1080); //Tamaño por defecto de la ventana que queremos que tenga
        frame.setVisible(true); //Que se vea la ventana 

        
        Container pane = frame.getContentPane(); // inicializa el panel

        pane.setLayout(new BorderLayout()); // crea la disposicion del espacio 

        ArrayList<JLabel> labels = new ArrayList<>();

        labels.add(new JLabel("Welcome"));
        labels.add(new JLabel("DAM1"));
        labels.add(new JLabel("DAY"));
        labels.add(new JLabel("MONTH"));
        labels.add(new JLabel("HOUR"));

        for (JLabel jLabel : labels) {
            label.setHorizontalAlignment(SwingConstants.CENTER); //para todos los labels añadidios la posicion es centrada 
        }



        pane.add(labels.get(0), BorderLayout.NORTH);

        labels.get(0).setBackground(Color.GREEN);
        labels.get(0).setOpaque(true);

        pane.add(labels.get(1), BorderLayout.CENTER);
        pane.add(labels.get(2), BorderLayout.WEST );
        pane.add(labels.get(3), BorderLayout.EAST);
        pane.add(labels.get(4), BorderLayout.SOUTH);


    }
}
