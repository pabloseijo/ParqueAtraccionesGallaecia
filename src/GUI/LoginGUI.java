package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import baseDatos.*;
import aplicacion.*;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */

public class LoginGUI extends JDialog{
    private baseDatos.FachadaBaseDatos fachadaBaseDatos;
    private JTextField UserTextField;
    private JButton entrarButton;
    private JLabel Usuario;
    private JLabel Password;
    private JPanel MainPanel;
    private JButton CancelarButton;
    private JPanel Panel2;
    private JPasswordField PasswordTextField;

    // Importante fachada para validar usuario
    public LoginGUI (JFrame parent, baseDatos.FachadaBaseDatos fachadaBaseDatos){
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

      this.fachadaBaseDatos = fachadaBaseDatos;
      
      //Añado un actionlistener al boton de entrar para que pueda relaizar la accion de comprobacion de las credenciales
      entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = UserTextField.getText();
                String contraseña = PasswordTextField.getText();
                Usuario usuarioComprobacion = fachadaBaseDatos.validarUsuario(usuario, contraseña);
                
                // Si encuentra un usuario válido
                if( (usuarioComprobacion.getTipoUsuario().equals("Administrador")) ){
                    // lanzamos menuAdministrador
                    dispose();
                }
                else{
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

 
    private void getAuthenticatedUser(String NombreUsuario, String Constrasenha){
        /*
        // ESTO NON FARIA FALTA HAI FUNCION!

        Usuario user = null;

        //conectar a la base de datos
        //Url de la base de datos
        final String DB_URL = ;
        //Nombre del usuario de la bd root por ejemplo
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            //conectarla correctamente

            //Preparamos una consulta en la base de datos para comprobar las crendenciales
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Usuarios WHERE NombreUsuario = ? AND Password = ?";
            //Creamos la variable preparedStatement y le pasamos la consulta
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //Le pasamos a la consulta lo que el usuario introduce en la ventana
            preparedStatement.setString(1, NombreUsuario);
            preparedStatement.setString(2, Constrasenha);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                //pasamos a la siguiente pestaña de usuario
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return user:
        */
    }




}
