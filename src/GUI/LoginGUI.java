package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginGUI extends JDialog{
    private JTextField UserTextField;
    private JButton entrarButton;
    private JLabel Usuario;
    private JLabel Password;
    private JPanel MainPanel;
    private JButton CancelarButton;
    private JPanel Panel2;
    private JPasswordField PasswordTextField;

    public LoginGUI (JFrame parent){
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
      /*
      //Añado un actionlistener al boton de entrar para que pueda relaizar la accion de comprobacion de las credenciales
      entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Usuario = UserTextField.getText();
                String Contraseña = PasswordTextField.getText();

                Usuario = getAuthenticatedUser(Usuario, Contraseña);

                if(user != null){
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
      */
      //añadimos el listener del boton de cancelar para cancelar la accion
      CancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
/*
    public Usuario usuario;
    private Usuario getAuthenticatedUser(String NombreUsuario, String Constrasenha){
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
    }
*/
    public static void main(String[] args){
        //Creamos la instancia
        LoginGUI myLogin = new LoginGUI(null);
        /*
        Usuario user = LoginGUI.user
        if(user != null){
            System.out.println("Bienvenido a Gallaecia: " + user.Nombre);
            //ponemos lo siguiente de pasar a la siguiente pestaña
        }
        else{
            System.out.println("Autentificacion cancelada");
        }*/
    }



}
