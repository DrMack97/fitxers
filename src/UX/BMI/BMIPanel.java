package UX.BMI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BMIPanel extends JPanel implements ActionListener{

    private Bmi model;

    private JTextField tfweight, tfHeight, tfBmi;

    private ActionListener listener;


    public BMIPanel(){
        model = new Bmi();
        listener = this;  // va al inicio  
        initComponets();
        doClear();
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
        //
        panel.add(new JLabel("Weight: "));
        tfweight = new JTextField(20);
        panel.add(tfweight);
        //
        panel.add(new JLabel("Height: "));
        tfHeight = new JTextField(20);
        panel.add(tfHeight);
        //
        panel.add(new JLabel("result: "));
        tfBmi = new JTextField(20);
        panel.add(tfBmi);
        //
        JButton btClear = new JButton("Clear");     //visualizacion del bottom
        btClear.setActionCommand("clear");
        //ToDo ADD Listener
        btClear.addActionListener(listener); //la activacion del bottom en caso de ser pulsado
        panel.add(btClear);


        JButton btCalc = new JButton("Calculate");
        btCalc.setActionCommand("calculate");
        btCalc.addActionListener(listener);


        return panel;
    }

    public void actionPerformed(ActionEvent e){
        String actionComand = e.getActionCommand();

        switch (actionComand) {
            case "clear":

                doClear();
                break;

            case "calculate":

                doCalculate();
                break;         
            default:
                break;
        }
    }

    private void doClear(){
        tfweight.setText("0.0");
        tfHeight.setText("0.0");
        tfBmi.setText("0.0");
    }

    private void doCalculate(){
        try {
            String sWeight = tfweight.getText();
            String sHeight = tfHeight.getText();

            //procesamos que dean doubles 

            double weight = Double.parseDouble(sWeight);
            double height = Double.parseDouble(sHeight);
            //Calculamos el bmi 

            double bmi =  model.bmiCalc(weight, height);
            //Añadimos resultados en textField de resultado
            tfBmi.setText(String.valueOf(bmi));

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Invalid data, must be double", "", ABORT);
        }
    }

}