package GUI;

import aplicacion.Hosteleria;
import aplicacion.Trabajador;
import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookRestaurant extends JDialog{
    private FachadaBaseDatos fachadaBaseDatos;
    private JLabel JLabel1;
    private JLabel IconoAdmin;
    private JLabel PulpoMiguel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTable table1;
    private JButton VOLVERButton;
    private JButton SALIRButton;
    private JButton ANADIRButton;
    private JPanel MainPanel;

    public BookRestaurant(JFrame parent, FachadaBaseDatos fachadaBaseDatos, String user) {
        super(parent);
        this.fachadaBaseDatos = fachadaBaseDatos;
        //ponemos el titulo de la pestaña
        setTitle("Empleados");
        //Mostramos el panel del .form
        setContentPane(MainPanel);
        createUIComponents();

        //Ponemos el tamaño de la ventana
        setMinimumSize(new Dimension(700,500));
        //Centramos la pestaña
        //IMPORTANTE!! La instancia parent se la paso para centrar la pestaña em el centro del ordenador, pero se le pasa null
        setLocationRelativeTo(parent);
        //Esto hace que se cierre al darle a la X
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

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
                dispose();
                UserPage menuEmployee = new UserPage(null, fachadaBaseDatos, user);
            }
        });
    }

    private void createUIComponents() {
        // Crear un modelo de tabla con tres columnas
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Ubicacion");
        model.addColumn("HoraApertura");
        model.addColumn("HoraCierre");

        ArrayList<Hosteleria> listaRestaurantes = null;
        try {
            listaRestaurantes = FachadaBaseDatos.getEstablecimientos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < listaRestaurantes.size(); i++) {
            model.addRow(new Object[]{listaRestaurantes.get(i).getNombre(), listaRestaurantes.get(i).getUbicacion(),
                    listaRestaurantes.get(i).getHoraInicio(), listaRestaurantes.get(i).getHoraFin()});
        }
        // Crear el JTable y asignarle el modelo
        table1 = new JTable(model);

        // Crear el JScrollPane y asignarle el JTable
        JScrollPane scrollPane1 = new JScrollPane(table1);
    }
}
