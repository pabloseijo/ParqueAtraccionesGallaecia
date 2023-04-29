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
        setTitle("Sumatorio de Salarios");
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
            public void imprimirSuma(String tipoTrabajador) {
                try {
                    float suma = fachadaBaseDatos.sumaSalarios(tipoTrabajador);
                    float total = fachadaBaseDatos.totalSalarios();
                    float porcentaje = (suma / total) * 100;

                    JOptionPane.showMessageDialog(null, "La suma de los salarios de los empleados de tipo " + tipoTrabajador + " es " + suma + "€\n" +
                            "La suma total de los salarios es " + total + "€\n" +
                            "Los empleados de tipo " + tipoTrabajador + " suponen un " + porcentaje + "%");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                String job = TypeTextField.getText();

                // Comprobamos si es un tipo de trabajador válido
                switch (job) {
                    case "Administracion":
                    case "Trabajadores Administracion":
                    case "administracion":
                    case "trabajadores administracion":
                        this.imprimirSuma("TrabajadoresAdministracion");
                        break;
                    case "Mantenimiento":
                    case "mantenimiento":
                    case "Trabajadores Mantenimiento":
                    case "trabajadores mantenimiento":
                        this.imprimirSuma("TrabajadoresMantenimiento");
                        break;
                    case "Espectaculos":
                    case "espectaculos":
                    case "Trabajadores Espectaculos":
                    case "trabajadores espectaculos":
                        this.imprimirSuma("TrabajadoresEspectaculo");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "El tipo de trabajadores introducido no existe.");

                }

            }
        });


    }
}
