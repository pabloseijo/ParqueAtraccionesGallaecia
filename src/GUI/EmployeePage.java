package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeePage extends JDialog{
    private JPanel MainPanel;
    private JButton añadirEmpleadoButton;
    private JButton actualizarEmpleadoButton;
    private JButton salariosButton;
    private JButton SALIRButton;
    private JButton despedirEmpleadosButton;
    private JButton VOLVERButton;
    private JLabel pulpoMiguel;

    public EmployeePage(JFrame parent) {
        super(parent);
        //ponemos el titulo de la pestaña
        setTitle("Empleados");
        //Mostramos el panel del .form
        setContentPane(MainPanel);
        //Ponemos el tamaño de la ventana
        setMinimumSize(new Dimension(700,500));
        //Centramos la pestaña
        //IMPORTANTE!! La instancia parent se la paso para centrar la pestaña em el centro del ordenador, pero se le pasa null
        setLocationRelativeTo(parent);
        //Esto hace que se cierre al darle a la X
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Boton de salir
        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            dispose();
        }
        });

        //Boton que nos lleva a la pagina de añadir empleado
        añadirEmpleadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //meter aqui el lazamiento de la pagina siguiente
            }
        });

        //Boton que nos lleva a la pagina de despedir empleado
        despedirEmpleadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //meter aqui el lazamiento de la pagina siguiente
            }
        });

        //Boton que nos lleva a la pagina de despedir empleado
        actualizarEmpleadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //meter aqui el lazamiento de la pagina siguiente
            }
        });

        //Boton que nos lleva a la pagina de salarios
        salariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //meter aqui el lazamiento de la pagina siguiente
            }
        });

        //Boton que nos lleva a la pagina principal de admin
        VOLVERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //meter aqui el lazamiento de la pagina anterior
            }
        });

        //Ponemos que se visualice la ventana
        setVisible(true);
    }

}
