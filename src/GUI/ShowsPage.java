package GUI;

import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowsPage extends JDialog{
    private FachadaBaseDatos fachadaBaseDatos;
    private JPanel MainPanel;
    private JButton añadirEspectaculoButton;
    private JButton eliminarEspectaculoButton;
    private JButton SALIRButton;
    private JButton VOLVERButton;
    private JButton añadirEspectaculoButton2;


    public ShowsPage(JFrame parent, FachadaBaseDatos fachadaBaseDatos) {
        super(parent);
        this.fachadaBaseDatos = fachadaBaseDatos;
        //ponemos el titulo de la pestaña
        setTitle("Espectaculos");
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
                dispose();
                AdminPage menuAdmin = new AdminPage(null,fachadaBaseDatos);
            }
        });

        //Lanzar la ventana de eliminar atraccion
        eliminarEspectaculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                DeleteShow ByeByeShow = new DeleteShow(null,fachadaBaseDatos);
            }
        });

        //Lanzar la ventana de añadir atraccion
        añadirEspectaculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AddShow addShow = new AddShow(null,fachadaBaseDatos);
            }
        });

        //Ponemos que se visualice la ventana
        setVisible(true);

        añadirEspectaculoButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AddViewer AddViewer = new AddViewer(null, fachadaBaseDatos);
            }
        });
    }
}
