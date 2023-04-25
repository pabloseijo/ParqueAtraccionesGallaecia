package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import baseDatos.*;
import aplicacion.*;
import GUI.EmployeePage;
import GUI.AdminPage;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */

public class LoginGUI extends JDialog{
    private JTextField UserTextField;
    private JButton entrarButton;
    private JLabel Usuario;
    private JLabel Password;
    private JPanel MainPanel;
    private JButton CancelarButton;
    private JPanel Panel2;
    private JPasswordField PasswordTextField;

    // Importante fachada para validar usuario
    // QUITAR PADRE, ESTA ES LA PRIMERA VENTANA
    // ******************************
    public LoginGUI (JFrame parent, aplicacion.FachadaAplicacion fachadaAplicacion, FachadaBaseDatos fachadaBaseDatos) {
      super(parent);
      //ponemos el titulo de la pestaña
      setTitle("Login");
      //Mostramos el panel del .form
      setContentPane(MainPanel);
      //Ponemos el tamaño de la ventana
      setMinimumSize(new Dimension(450,350));
      setModal(true);
      //Centramos la pestaña
      setLocationRelativeTo(parent);
      //Esto hace que se cierre al darle a la X
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
      //Añado un actionlistener al boton de entrar para que pueda relaizar la accion de comprobacion de las credenciales
      entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = UserTextField.getText();
                String contraseña = PasswordTextField.getText();
                Usuario usuarioComprobacion = fachadaAplicacion.comprobarAutentificacion(usuario, contraseña);
                
                // Si encuentra un usuario válido
                if( (usuarioComprobacion.getTipoUsuario().equals(TipoUsuario.Administrador)) ){
                    AdminPage menuAdmin = new AdminPage(null, fachadaBaseDatos);
                    dispose();
                }
                else if( (usuarioComprobacion.getTipoUsuario().equals(TipoUsuario.Normal)) ){

                }
                else {
                    //Si el usuario es null se muestra un mensaje de error
                    JOptionPane.showMessageDialog(LoginGUI.this,
                            "Usuario o Contraseña Incorrectos","Intentelo de Nuevo",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        });
      
      //añadimos el listener del boton de cancelar para cancelar la accion
      CancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
