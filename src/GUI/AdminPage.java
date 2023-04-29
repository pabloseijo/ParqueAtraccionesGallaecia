package GUI;

import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage  extends JFrame {
    private JPanel Panel1;
    private JLabel JLabel1;
    private JLabel IconoAdmin;
    private JButton EMPLEADOSButton;
    private JButton ATRACCIONESButton;
    private JButton ESPECTACULOSButton;
    private JButton SALIRButton;
    private JLabel PulpoMiguel;
    private JButton HOSTELERIAButton;

    public AdminPage(JFrame parent, FachadaBaseDatos fachadaBaseDatos){
        //ponemos el titulo de la pestaña
        setTitle("Administrador");
        //Mostramos el panel del .form
        setContentPane(Panel1);
        //Ponemos el tamaño de la ventana
        setMinimumSize(new Dimension(700,500));
        //Centramos la pestaña
        setLocationRelativeTo(parent);
        //Esto hace que se cierre al darle a la X
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Lanzamos la ventana de empleados
        EMPLEADOSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeePage menuEmpleado = new EmployeePage(null, fachadaBaseDatos);
                dispose();
            }
        });

        //Lanzamos la ventana de atracciones
        ATRACCIONESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AttractionPage menuAtracciones = new AttractionPage(null, fachadaBaseDatos);
                dispose();
            }
        });

        //Lanzamos la ventana de espectaculos
        ESPECTACULOSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowsPage menuEspectaculos = new ShowsPage(null, fachadaBaseDatos);
                dispose();
            }
        });

        HOSTELERIAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RestaurantsPage menuHosteleria = new RestaurantsPage(null, fachadaBaseDatos);
                dispose();
            }
        });

        //Boton de Cancelar
        setVisible(true);
        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
}