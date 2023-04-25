package GUI;

import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteShow extends JDialog{
    private FachadaBaseDatos fachadaBaseDatos;
    private JTextField IDTextField;
    private JButton BORRARButton;
    private JButton VOLVERButton;
    private JButton SALIRButton;
    private JPanel MainPanel;

    public DeleteShow(JFrame parent, FachadaBaseDatos fachadaBaseDatos) {
        super(parent);
        this.fachadaBaseDatos = fachadaBaseDatos;
        //ponemos el titulo de la pestaña
        setTitle("Borrar Espectaculo");
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
                AttractionPage menuAtraccion = new AttractionPage(null, fachadaBaseDatos);
                dispose();
            }
        });

        //Ponemos que se visualice la ventana
        setVisible(true);
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

                //Hago un try y catch para manejar la excepcion
                try {
                    fachadaBaseDatos.eliminarEspectaculo(NumeroRegistro);
                    //meter aqui el lazamiento de la pagina siguiente
                    dispose();
                    DeleteAttraction ByeByeAttraction = new DeleteAttraction(null, fachadaBaseDatos);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }
}
