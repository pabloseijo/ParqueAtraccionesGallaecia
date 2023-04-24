package baseDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import aplicacion.Atraccion;
import aplicacion.TrabajadorMantenimiento;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */

public class AtraccionesDAO extends AbstractDAO{

    public AtraccionesDAO (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    /**
    * Obtiene una lista de todos las atracciones.
    * 
    * @throws SQLException si hay un error al acceder a la base de datos
    * @return un ArrayList<Atraccion> con todas las atracciones.
    */
    public java.util.List<Atraccion> consultarAtracciones() throws SQLException{
        java.util.List<Atraccion> resultado = new java.util.ArrayList<Atraccion>();
        Atraccion atraccionActual;
        Connection con;
        PreparedStatement stmAtracciones=null;
        ResultSet rsAtracciones;

        con=this.getConexion();

        try  {
        stmAtracciones=con.prepareStatement("SELECT * FROM Atracciones");
        rsAtracciones=stmAtracciones.executeQuery();
        while (rsAtracciones.next())
        {
            atraccionActual = new Atraccion(rsAtracciones.getInt("NumeroRegistro"), rsAtracciones.getString("Nombre"), rsAtracciones.getInt("Aforo"), rsAtracciones.getInt("AlturaMin"), rsAtracciones.getFloat("CosteMantenimiento"), rsAtracciones.getBoolean("EnReparacion"), rsAtracciones.getString("Ubicacion"), rsAtracciones.getString("Descripcion"));
            resultado.add(atraccionActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
        }finally{
          try {stmAtracciones.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

    /**
     * Obtiene una lista de todos las atracciones.
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     * @return elimina la atraccion seleccionada de la base de datos
     */
    public void eliminarAtraccion(int ID) throws SQLException{

        //Preparo la variable donde va a estar el statement
        PreparedStatement stmAtraccion = null;

        //concecto con la base
        Connection con;
        con = super.getConexion();

        //intento la consulta y si se cumple la base de datos se actualiza
        try {
            stmAtraccion = con.prepareStatement("DELETE from Atracciones where NumeroRegistro = ?");
            stmAtraccion.setInt(1, ID);
            stmAtraccion.executeUpdate();
            stmAtraccion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AtraccionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmAtraccion.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    /**
     * Añade un nuevo trabajador de espectaculos
     *
     * @param nombre el nombre del trabajador.
     * @param aforo la direccion del trabajador.
     * @param alturaMin el salario del trabajador.
     * @param costeMantenimiento el telefono del trabajador.
     * @param enReparacion la fecha en la que el trabajador empezó a trabajar en el parque.
     * @param Ubicaciones la fecha en la que el trabajador nació.
     * @param Descripcion descripcion de los estudios del trabajador.
     * @throws SQLException si hay un error al acceder a la base de datos
     * @return añade la atraccion a la base de datos
     */
    public void anhadirAtraccion(String nombre, int aforo, int alturaMin, float costeMantenimiento, boolean enReparacion, String Ubicaciones, String Descripcion) throws SQLException{
        Connection con;

        con = super.getConexion();

        PreparedStatement stmAtraccion = null;
        try {
            stmAtraccion = con.prepareStatement("INSERT INTO Atracciones (Nombre, Aforo, AlturaMin, CosteMantenimiento, EnReparacion, Ubicaciones, Descripcion) values(?,?,?,?,?,?,?)");
            stmAtraccion.setString(1, nombre);
            stmAtraccion.setInt(2, aforo);
            stmAtraccion.setInt(3, alturaMin);
            stmAtraccion.setFloat(4, costeMantenimiento);
            stmAtraccion.setBoolean(5, enReparacion);
            stmAtraccion.setString(6, Ubicaciones);
            stmAtraccion.setString(7, Descripcion);
            stmAtraccion.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AtraccionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmAtraccion.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
}

   
