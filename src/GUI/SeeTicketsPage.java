package GUI;

import aplicacion.Trabajador;
import aplicacion.Visitante;
import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeeTicketsPage extends JDialog{
    private FachadaBaseDatos fachadaBaseDatos;
    private JPanel Panel;
    private JLabel UsuarioIcon;
    private JLabel UsuarioTexto;
    private JLabel PulpoIcon;
    private JTable table1;
    private JPanel MainPanel;
    private JButton SALIRButton;
    private JButton VOLVERButton;
    private JScrollPane scrollPane1;



    public SeeTicketsPage(JFrame parent, FachadaBaseDatos fachadaBaseDatos, String usuario) {
        super(parent);
        this.fachadaBaseDatos = fachadaBaseDatos;
        //ponemos el titulo de la pestaña
        setTitle("Empleados");
        //Mostramos el panel del .form
        setContentPane(MainPanel);
        createUIComponents(usuario);

        //Ponemos el tamaño de la ventana
        setMinimumSize(new Dimension(700,500));
        //Centramos la pestaña
        //IMPORTANTE!! La instancia parent se la paso para centrar la pestaña em el centro del ordenador, pero se le pasa null
        setLocationRelativeTo(parent);
        //Esto hace que se cierre al darle a la X
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        VOLVERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                UserPage menuUsuario = new UserPage(null, fachadaBaseDatos, usuario);
            }
        });
        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
    }

    private void createUIComponents(String usuario) {
        // Crear un modelo de tabla con tres columnas
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("DNI");
        model.addColumn("Nombre");
        model.addColumn("Edad");

        ArrayList<Visitante> listaEntradas = null;
        try {
            listaEntradas = FachadaBaseDatos.getEntradas(usuario);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < listaEntradas.size(); i++) {
            model.addRow(new Object[]{listaEntradas.get(i).getDNI(), listaEntradas.get(i).getNombre(), listaEntradas.get(i).getEdad()});
        }
        // Crear el JTable y asignarle el modelo
        table1 = new JTable(model);

        // Crear el JScrollPane y asignarle el JTable
        scrollPane1 = new JScrollPane(table1);
    }
}


