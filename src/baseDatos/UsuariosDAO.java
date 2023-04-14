package baseDatos;
import aplicacion.Usuario;
import aplicacion.TipoUsuario;
import java.sql.*;


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
        Usuario resultado=null;
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsUsuario;

         // establecemos la conexion
        con = this.getConexion();

        try {
          // hacemos la consulta
        stmUsuario = con.prepareStatement("SELECT Nombre, Clave, TipoUsuario "+
                                        "FROM Usuarios "+
                                        "WHERE Nombre = ? and Clave = ?");
        stmUsuario.setString(1, nombreUsuario);
        stmUsuario.setString(2, clave);

        rsUsuario = stmUsuario.executeQuery();

        // si hay alguno lo almacenamos y los delvemos
        if (rsUsuario.next())
        {
            resultado = new Usuario(rsUsuario.getString("Nombre"), rsUsuario.getString("Clave"), TipoUsuario.valueOf(rsUsuario.getString("TipoUsuario")));

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
     * @return el usuario si existe.
     */
    public void registrarUsuario(String nombreUsuario, String clave) throws SQLException {

      Connection con;
      PreparedStatement stmUsuario = null;
      // establecemos la conexion
      con = this.getConexion();

      // OPCION: añadir a visitantes

      // hacemos la transaccion con los datos introducidos
      stmUsuario = con.prepareStatement("INSERT INTO Usuarios(NombreUsuario, Clave, TipoUsuario)"
              + "VALUES (?, ?, ?)");

      stmUsuario.setString(1, nombreUsuario);
      stmUsuario.setString(2, clave);
      stmUsuario.setString(3, "Normal");
      stmUsuario.executeUpdate();

  }

   
}
