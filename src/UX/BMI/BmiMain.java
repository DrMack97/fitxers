package UX.BMI;

import javax.swing.SwingUtilities;

public class BmiMain {

    public static void main(String[] args) {

        //inicializa BMIFrame
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run(){
                BMIFrame mainFrame = new BMIFrame();

                mainFrame.setVisible(true);


            }
            
            //fix - no sale el resultado esperado
            
        });
    }

}
