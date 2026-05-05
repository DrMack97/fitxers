package UX.BMI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BMIPanel extends JPanel{

    private JTextField tfweight, tfHeight, tfresult;

    public BMIPanel(){
        initComponets();
    }

    private void initComponets(){       // inicializar componentes 

        setLayout(new BorderLayout());

        JLabel lbHeader = new JLabel("BMI calculation form");

        lbHeader.setHorizontalAlignment(JLabel.CENTER);

        add(lbHeader, BorderLayout.NORTH);

        JPanel form = createBmiForm();
        add(form, BorderLayout.CENTER);


        //altura
    }

    private JPanel createBmiForm(){
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(0, 2));

        panel.add(new JLabel("Weight: "));
        tfweight = new JTextField(20);
        panel.add(tfweight);

        panel.add(new JLabel("Height: "));
        tfHeight = new JTextField(20);
        panel.add(tfHeight);

        panel.add(new JLabel("result: "));
        tfresult = new JTextField(20);
        panel.add(tfresult);

        return panel;
    }

}
