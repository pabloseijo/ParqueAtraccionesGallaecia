package GUI;

import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteRestaurant extends JDialog{
    private JPanel MainPanel;
    private JTextField IDTextField;
    private JButton BORRARButton;
    private JButton VOLVERButton;
    private JButton SALIRButton;


    public DeleteRestaurant(JFrame parent, FachadaBaseDatos fachadaBaseDatos) {

        super(parent);
        setTitle("HireEmployee");
        setContentPane(MainPanel);
        setMinimumSize(new Dimension(900, 300));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Boton de salir (Cierra la ventana)
        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //Boton de volver a la pestaña anterior
        VOLVERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeePage menuUsuario = new EmployeePage(null, fachadaBaseDatos);
                dispose();
            }
        });

        //Boton de borrar restaurante
        BORRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lanza una pestaña que con el nombre y el dni hace una consulta en sql y añade un empleado a la base
                String ID = IDTextField.getText();

                int NumeroRegistro = 0;
                try {
                    // Convierte el String a un float
                    NumeroRegistro = Integer.parseInt(ID);
                    // floatValue contiene el número convertido
                } catch (NumberFormatException IntException) {
                    // El String no se pudo convertir
                }

                try {
                    fachadaBaseDatos.eliminarRestaurante(NumeroRegistro);
                    //meter aqui el lazamiento de la pagina siguiente
                    dispose();
                    DeleteRestaurant ByeByeRestaurant = new DeleteRestaurant(null, fachadaBaseDatos);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
