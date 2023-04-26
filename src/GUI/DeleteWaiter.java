package GUI;

import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteWaiter extends JDialog{
    private FachadaBaseDatos fachadaBaseDatos;
    private JTextField IDTextField;
    private JButton BORRARButton;
    private JButton VOLVERButton;
    private JButton SALIRButton;
    private JPanel MainPanel;


    public DeleteWaiter(JFrame parent, FachadaBaseDatos fachadaBaseDatos) {
        super(parent);
        this.fachadaBaseDatos = fachadaBaseDatos;
        //ponemos el titulo de la pestaña
        setTitle("Borrar Hostelero");
        //Mostramos el panel del .form
        setContentPane(MainPanel);
        //Ponemos el tamaño de la ventana
        setMinimumSize(new Dimension(500, 300));
        //Centramos la pestaña
        //IMPORTANTE!! La instancia parent se la paso para centrar la pestaña em el centro del ordenador, pero se le pasa null
        setLocationRelativeTo(parent);
        //Esto hace que se cierre al darle a la X
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        VOLVERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RestaurantsPage menuRestaurante = new RestaurantsPage(null, fachadaBaseDatos);
            }
        });

        //Ponemos que se visualice la ventana
        setVisible(true);
        BORRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lanza una pestaña que con el nombre y el dni hace una consulta en sql y añade un empleado a la base
                String ID = IDTextField.getText();

                //Hago un try y catch para manejar la excepcion
                try {
                    fachadaBaseDatos.eliminarHostelero(ID);
                    //meter aqui el lazamiento de la pagina siguiente
                    dispose();
                    DeleteWaiter ByeByeWaiter = new DeleteWaiter(null, fachadaBaseDatos);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }
}
        