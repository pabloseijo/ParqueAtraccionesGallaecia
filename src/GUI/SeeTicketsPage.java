package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SeeTicketsPage {
    private JPanel Panel;
    private JLabel UsuarioIcon;
    private JLabel UsuarioTexto;
    private JLabel PulpoIcon;
    private JTable table1;
    private JPanel MainPanel;
    private JButton SALIRButton;
    private JButton VOLVERButton;

    private void createTable(){
        Object[][] data={
                {"Ejemplo", "Ejemplo", "Ejemplo"},
                {"Ejemplo", "Ejemplo", "Ejemplo"}
        };

        table1.setModel(new DefaultTableModel(
                data,
                new String[]{"DNI", "Nombre", "Edad"}
        ));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        createTable();
    }

}
