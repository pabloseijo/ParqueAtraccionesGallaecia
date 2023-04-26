package GUI;

import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantsPage extends JDialog{
    private FachadaBaseDatos fachadaBaseDatos;
    private JButton añadirRestauranteButton;
    private JButton eliminarRestauranteButton;
    private JButton eliminarHosteleroButton;
    private JButton añadirHosteleroButton;
    private JButton SALIRButton;
    private JButton VOLVERButton;
    private JPanel MainPanel;

    public RestaurantsPage(JFrame parent, FachadaBaseDatos fachadaBaseDatos) {
        super(parent);
        this.fachadaBaseDatos = fachadaBaseDatos;
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

        //Boton que nos lleva a la pagina principal de admin
        VOLVERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminPage menuAdmin = new AdminPage(null,fachadaBaseDatos);
                dispose();
            }
        });

        //Lanzamos la ventana de eliminar restaurante
        eliminarRestauranteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                DeleteRestaurant ByeByeRestaurant = new DeleteRestaurant(null, fachadaBaseDatos);
            }
        });

        //Lanzamos la ventana de añadir restaurante
        añadirRestauranteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AddRestaurant anhadirRestaurante = new AddRestaurant(null, fachadaBaseDatos);
            }
        });

        //lanzamos la ventana de despedir hostelero
        eliminarHosteleroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                DeleteWaiter ByeByeWaiter = new DeleteWaiter(null, fachadaBaseDatos);
            }
        });


        //Lanzamos la ventana de añadir hostelero
        añadirHosteleroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AddWaiter HireWaiter = new AddWaiter(null,fachadaBaseDatos);
            }
        });

        setVisible(true);
    }
}
