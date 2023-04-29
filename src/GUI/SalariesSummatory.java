package GUI;

import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SalariesSummatory extends JDialog {
    private FachadaBaseDatos fachadaBaseDatos;
    private JTextField TypeTextField;
    private JButton VOLVERButton;
    private JButton SALIRButton;
    private JButton SUMARButton;
    private JPanel MainPanel;


    public SalariesSummatory(JFrame parent, FachadaBaseDatos fachadaBaseDatos) {
        super(parent);
        this.fachadaBaseDatos = fachadaBaseDatos;
        //ponemos el titulo de la pestaña
        setTitle("Empleados");
        //Mostramos el panel del .form
        setContentPane(MainPanel);
        //Ponemos el tamaño de la ventana
        setMinimumSize(new Dimension(700, 500));
        //Centramos la pestaña
        //IMPORTANTE!! La instancia parent se la paso para centrar la pestaña em el centro del ordenador, pero se le pasa null
        setLocationRelativeTo(parent);
        //Esto hace que se cierre al darle a la X
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        //Boton de salir
        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //Boton que nos lleva a la pagina principal de admin
        VOLVERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminPage menuAdmin = new AdminPage(null, fachadaBaseDatos);
            }
        });

        SUMARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Job = TypeTextField.getText();

                try {
                    float sumaSalarios = fachadaBaseDatos.sumaSalarios(Job);
                    JOptionPane.showMessageDialog(null, "La suma de los salarios de los empleados de tipo " + Job + " es " + sumaSalarios);

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


    }
}
