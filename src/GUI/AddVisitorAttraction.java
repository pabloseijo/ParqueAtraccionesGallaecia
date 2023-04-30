package GUI;

import aplicacion.Atraccion;
import aplicacion.Hosteleria;
import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddVisitorAttraction extends JDialog{
    private FachadaBaseDatos fachadaBaseDatos;
    private JTextField DateTextField;
    private JTextField HourTextField;
    private JTextField DNITextField;
    private JTextField AtraccionTextField;
    private JTable table1;
    private JButton VOLVERButton;
    private JButton SALIRButton;
    private JButton ANADIRButton;
    private JPanel MainPanel;

    public AddVisitorAttraction(JFrame parent, FachadaBaseDatos fachadaBaseDatos) {
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
                AttractionPage menuEmployee = new AttractionPage(null, fachadaBaseDatos);
            }
        });

        //Boton para añadir una reserva
        ANADIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lanza una pestaña que con el nombre y el dni hace una consulta en sql y añade un empleado a la base
                String date = DateTextField.getText();
                String hour = HourTextField.getText();
                String dni = DNITextField.getText();
                String attraction = AtraccionTextField.getText();

                /////////////////////////* TRANSFORMAMOS LOS STRING A LOS TIPOS NECESARIOS *////////////////////////////
                // Crea un objeto SimpleDateFormat con el formato deseado
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

                Time BookHour;
                try {
                    // Convierte el String a un float
                    Date date1 = dateFormat.parse(hour);
                    BookHour = new Time(date1.getTime());
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }

                //Casteamos las fechas
                java.sql.Date BookDate = null;
                try {
                    // Convierte el String a un objeto java.sql.Date
                    BookDate = java.sql.Date.valueOf(date);
                    // sqlDate contiene la fecha convertida
                } catch (IllegalArgumentException DateException) {
                    System.out.println("FATAL ERROR: Date could not been converted");
                }

                ////////////////////////////////////////////////////////////////////////////////////////////////////////

                //Hago un try y catch para manejar la excepcion
                try {
                    //Le paso los parametros a para añadir el trabajador, pero espectaculo y atraccion se lo paso a 0 porque se actualizara mas tarde
                    fachadaBaseDatos.reservarEntrada(BookDate, BookHour, dni, attraction);
                    //meter aqui el lazamiento de la pagina siguiente
                    dispose();
                    AddVisitorAttraction AddVisitorAttraction = new AddVisitorAttraction(null, fachadaBaseDatos);

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void createUIComponents() {
        // Crear un modelo de tabla con tres columnas
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Numero de Registro");
        model.addColumn("Nombre");
        model.addColumn("CosteMantenimiento");
        model.addColumn("EnReparacion");

        ArrayList<Atraccion> listaAtracciones = null;
        try {
            listaAtracciones = FachadaBaseDatos.consultarAtracciones();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < listaAtracciones.size(); i++) {
            model.addRow(new Object[]{listaAtracciones.get(i).getNumeroRegistro(), listaAtracciones.get(i).getNombre(),
                    listaAtracciones.get(i).getCosteMantenimiento(), listaAtracciones.get(i).getEnReparacion()});
        }
        // Crear el JTable y asignarle el modelo
        table1 = new JTable(model);

        // Crear el JScrollPane y asignarle el JTable
        JScrollPane scrollPane1 = new JScrollPane(table1);
    }
}
