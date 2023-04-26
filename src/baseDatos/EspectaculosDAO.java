
package baseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import aplicacion.Espectaculo;
import aplicacion.Asistir;
import aplicacion.TrabajadorEspectaculo;
/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */

public class EspectaculosDAO extends AbstractDAO{

    public EspectaculosDAO (Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    /**
    * Obtiene una lista de todos los espectaculos.
    * 
    * @throws SQLException si hay un error al acceder a la base de datos
    * @return un ArrayList<Espectaculo> con todos los espectaculos.
    */
    public java.util.List<Espectaculo> consultarEspectaculos() throws SQLException {
        java.util.List<Espectaculo> resultado = new java.util.ArrayList<Espectaculo>();
        Espectaculo espectaculoActual;
        Connection con;
        PreparedStatement stmEspectaculos = null;
        ResultSet rsEspectaculos;

        con = this.getConexion();

        try  {
        stmEspectaculos=con.prepareStatement("select ID, Nombre, Sesion, HorarioInicio, HorarioFin, Tematica, Descripcion, Ubicacion from Espectaculos");
        rsEspectaculos=stmEspectaculos.executeQuery();
        while (rsEspectaculos.next())
        {
            espectaculoActual = new Espectaculo(rsEspectaculos.getInt("ID"), rsEspectaculos.getString("Nombre"), rsEspectaculos.getString("Sesion"), rsEspectaculos.getString("HorarioInicio"), rsEspectaculos.getString("HorarioFin"), rsEspectaculos.getString("Tematica"), rsEspectaculos.getString("Descripcion"), rsEspectaculos.getString("Ubicacion"));
            resultado.add(espectaculoActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
        }finally{
          try {stmEspectaculos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

    /**
     * Elimina un espectaculo
     *
     * @param id: identificador de la atraccion
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void eliminarEspectaculo(int id) throws SQLException{

        //Preparo la variable donde va a estar el statement
        PreparedStatement stmEspectaculo = null;

        //concecto con la base
        Connection con;
        con = super.getConexion();

        //intento la consulta y si se cumple la base de datos se actualiza
        try {
            stmEspectaculo = con.prepareStatement("DELETE from Espectaculos where ID = ?");
            stmEspectaculo.setInt(1, id);
            stmEspectaculo.executeUpdate();
            stmEspectaculo.close();
        } catch (SQLException ex) {
            Logger.getLogger(EspectaculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmEspectaculo.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }


    /**
     * Añade un nuevo espectaculo
     *
     * @param nombre el nombre del espectaculo.
     * @param sesion mañana,tarde o noche.
     * @param horaInicio hora de inicio del espectaculo.
     * @param horaFin hora de fin del espectaculo.
     * @param tematica la tematica del espectaculo.
     * @param descripcion descripcion del espectaculos.
     * @param ubicaciones ubicacion del espectaculos.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void anhadirEspectaculo(String nombre, String sesion, Time horaInicio, Time horaFin, String tematica,String descripcion, String ubicaciones) throws SQLException{
        Connection con;

        con = super.getConexion();

        PreparedStatement stmEspectaculo = null;
        try {
            stmEspectaculo = con.prepareStatement("INSERT INTO Espectaculos (Nombre, Sesion, HoraInicio, HoraFin, Tematica, Descripcion, Ubicacion) values(?,?,?,?,?,?,?)");
            stmEspectaculo.setString(1, nombre);
            stmEspectaculo.setString(2, sesion);
            stmEspectaculo.setTime(3, horaInicio);
            stmEspectaculo.setTime(4, horaFin);
            stmEspectaculo.setString(5, tematica);
            stmEspectaculo.setString(6, ubicaciones);
            stmEspectaculo.setString(7, descripcion);
            stmEspectaculo.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EspectaculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmEspectaculo.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

}
