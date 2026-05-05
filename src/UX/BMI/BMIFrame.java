package UX.BMI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BMIFrame extends JFrame {

    BMIPanel bmiPanel;

    public BMIFrame(){
        initComponets();
    }

    private void initComponets(){
        
        setTitle("BMI APP");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setUpMenu(); // ejecuta menu

        bmiPanel = new BMIPanel();

        setSize(400, 300);  // el espacio de la ventana

        setLocationRelativeTo(null);

    }

    private void setUpMenu(){                       // SET Menu

        JMenuBar  menuBar = new JMenuBar();          //puede tener otros menu dentro 
        JMenu     menu;
        JMenuItem menuItem;

        menu = new JMenu("File");   //Construye

        menuItem = new JMenuItem("Exit");
        menuItem.setActionCommand("Exit");

        menu.add(menuItem);         // Agrega
        menuBar.add(menu);

        //Menu Help con menuItem about

        menu = new JMenu("Help");

        menuItem = new JMenuItem("About");
        menuItem.setActionCommand("about");  //Construye


        //TODO add listener

        // Agrega

        menu.add(menuItem); // menu particular 

        menuBar.add(menu);  // barra de menu es General 

        setJMenuBar(menuBar);

        //FIX: no se 
    }
}
