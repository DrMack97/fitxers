package UX.BMI;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WelcomePana extends JPanel implements ActionListener {
    //Muestre mensaje de bienvenida 
    //Boton about 
    // Al pulsar-se muestra dialogo con nombre de la empresa
    // Al empezar se vea este panel 

    private ActionListener listener;

    public void initComponets(){
        setLayout(new BorderLayout());

        JLabel welcome = new Label("Welcome to the app");
        welcome.setHorizontalAlignment(JLabel.CENTER);
        add(welcome, BorderLayout.CENTER);

        JButton aboutButton = new JButton("About");
        aboutButton.setActionCommand("showAbout");
        aboutButton.addActionListener(listener);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Proven SL\n666666666\nProven@software.com"
        , TOOL_TIP_TEXT_KEY, ABORT);
}
