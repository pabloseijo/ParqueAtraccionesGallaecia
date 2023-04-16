package baseDatos;
import aplicacion.Usuario;
import aplicacion.TipoUsuario;
import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;


/**
 *
  * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */


public class UsuariosDAO extends AbstractDAO{

    public UsuariosDAO (Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    /**
     * Comprueba si un usuario está en la base de datos.
     * 
     * @param nombreUsuario el nombre del usuario.
     * @param clave la contraseña del usuario.
     * @return el usuario si existe.
     */
    public Usuario validarUsuario(String nombreUsuario, String clave){
        Usuario resultado = null;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;

         // establecemos la conexion
        con = this.getConexion();

        try {
            // hacemos la consulta
          stmUsuario = con.prepareStatement("SELECT Nombre, Email, Clave, TipoUsuario "+
                                          "FROM Usuarios "+
                                          "WHERE Nombre = ? and Clave = ?");
          stmUsuario.setString(1, nombreUsuario);
          stmUsuario.setString(2, clave);

          rsUsuario = stmUsuario.executeQuery();

          // si hay alguno lo almacenamos y los delvemos
          if (rsUsuario.next())
          {
              resultado = new Usuario(rsUsuario.getString("Nombre"), rsUsuario.getString("Email"), rsUsuario.getString("Clave"), TipoUsuario.valueOf(rsUsuario.getString("TipoUsuario")));

          }
        } catch (SQLException e) {
          System.out.println(e.getMessage());
        } finally {
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }

        return resultado;
    }

    /**
     * Registra nuevos usuarios normales
     * 
     * @param nombreUsuario el nombre del usuario.
     * @param clave la contraseña del usuario.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void registrarUsuario(String nombreUsuario, String email, String clave) throws SQLException {

      Connection con;
      PreparedStatement stmUsuario = null;
      // establecemos la conexion
      con = this.getConexion();

      // OPCION: añadir a visitantes

      // hacemos la transaccion con los datos introducidos
      try {
        stmUsuario = con.prepareStatement("INSERT INTO Usuarios(NombreUsuario, Email, Clave, TipoUsuario)"
                + "VALUES (?, ?, ?, ?)");

        stmUsuario.setString(1, nombreUsuario);
        stmUsuario.setString(2, email);
        stmUsuario.setString(3, clave);
        stmUsuario.setString(4, "Normal");
        stmUsuario.executeUpdate();
      } catch (SQLException ex) {
        Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
      stmUsuario.close();
      } catch (SQLException e) {
          System.out.println("Imposible cerrar cursores");
      }
    }

  }

    /**
     * Cambia la contraseña del usuario
     * 
     * @param nombreUsuario el nombre del usuario.
     * @param claveActual la contraseña actual del usuario.
     * @param nuevaClave la contraseña futura del usuario.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void cambiarContraseña(String nombreUsuario, String claveActual, String nuevaClave) throws SQLException {

      Connection con;
      PreparedStatement stmUsuario = null;
      // establecemos la conexion
      con = this.getConexion();

      try {
      // hacemos la transaccion con los datos introducidos
      stmUsuario = con.prepareStatement("UPDATE Usuarios SET Clave = ? WHERE Nombre = ? and Clave = ?");
      stmUsuario.setString(1, nuevaClave);
      stmUsuario.setString(2, nombreUsuario);
      stmUsuario.setString(3, claveActual);
      stmUsuario.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
      stmUsuario.close();
      } catch (SQLException e) {
          System.out.println("Imposible cerrar cursores");
      }
    }

  }
   


    /**
     * Cambia el nombre del usuario
     * 
     * @param nombreUsuarioActual el nombre actual del usuario.
     * @param nombreUsuarioFuturo el nombre futuro del usuario.
     * @param clave la contraseña del usuario.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void cambiarNombre(String nombreUsuarioActual, String nombreUsuarioFuturo, String clave) throws SQLException {

      Connection con;
      PreparedStatement stmUsuario = null;
      // establecemos la conexion
      con = this.getConexion();

      try {
      // hacemos la transaccion con los datos introducidos
      stmUsuario = con.prepareStatement("UPDATE Usuarios SET Nombre = ? WHERE Nombre = ? and Clave = ?");
      stmUsuario.setString(1, nombreUsuarioFuturo);
      stmUsuario.setString(2, nombreUsuarioActual);
      stmUsuario.setString(3, clave);
      stmUsuario.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
      stmUsuario.close();
      } catch (SQLException e) {
          System.out.println("Imposible cerrar cursores");
      }
  }

  }
}

   

