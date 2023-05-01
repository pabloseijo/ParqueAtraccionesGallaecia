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
    public ArrayList<Atraccion> consultarAtracciones() throws SQLException{
        ArrayList<Atraccion> resultado = new ArrayList<Atraccion>();
        Atraccion atraccionActual;
        Connection con;
        PreparedStatement stmAtracciones = null;
        ResultSet rsAtracciones;

        con=this.getConexion();

        try  {
        stmAtracciones = con.prepareStatement("SELECT * FROM Atracciones");
        rsAtracciones = stmAtracciones.executeQuery();
        while (rsAtracciones.next())
        {
            atraccionActual = new Atraccion(rsAtracciones.getInt("NumeroRegistro"), rsAtracciones.getString("Nombre"),
                    rsAtracciones.getInt("Aforo"), rsAtracciones.getInt("AlturaMin"), rsAtracciones.getFloat("CosteMantenimiento"),
                    rsAtracciones.getBoolean("EnReparacion"), rsAtracciones.getString("Ubicaciones"), rsAtracciones.getString("Descripcion"));
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
     * Busca una atraccion en concreto por su nombre
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     * @return la Atraccion buscada si existe.
     */
    public Atraccion buscaAtraccion(String nombreAtraccion) throws SQLException {
        Atraccion resultado = null;
        Connection con;
        PreparedStatement stmAtracciones=null;
        ResultSet rsAtracciones;

        con = this.getConexion();

        try  {
            stmAtracciones = con.prepareStatement("SELECT * FROM Atracciones WHERE Nombre = ?");
            stmAtracciones.setString(1, nombreAtraccion);
            rsAtracciones = stmAtracciones.executeQuery();
            while (rsAtracciones.next())
            {
                resultado = new Atraccion(rsAtracciones.getInt("NumeroRegistro"), rsAtracciones.getString("Nombre"), rsAtracciones.getInt("Aforo"), rsAtracciones.getInt("AlturaMin"), rsAtracciones.getFloat("CosteMantenimiento"), rsAtracciones.getBoolean("EnReparacion"), rsAtracciones.getString("Ubicacion"), rsAtracciones.getString("Descripcion"));
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try {stmAtracciones.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

    /**
     * Elimina una atraccion
     *
     * @param id: identificador de la atraccion
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void eliminarAtraccion(int id) throws SQLException{

        //Preparo la variable donde va a estar el statement
        PreparedStatement stmAtraccion = null;

        //concecto con la base
        Connection con;
        con = super.getConexion();

        //intento la consulta y si se cumple la base de datos se actualiza
        try {
            stmAtraccion = con.prepareStatement("DELETE from Atracciones where NumeroRegistro = ?");
            stmAtraccion.setInt(1, id);
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
     * Añade una nueva atraccion.
     *
     * @param nombre el nombre de la atraccion.
     * @param aforo aforo de la atraccion.
     * @param alturaMin altura minima para entrar a la atraccion.
     * @param costeMantenimiento coste del mantenimiento de la atraccion.
     * @param enReparacion boolean, true si la atraccion esta en reparacion.
     * @param ubicaciones ubicacion de la atraccion.
     * @param descripcion descripcion de la atraccion.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void anhadirAtraccion(String nombre, int aforo, int alturaMin, float costeMantenimiento, boolean enReparacion, String ubicaciones, String descripcion) throws SQLException{
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
            stmAtraccion.setString(6, ubicaciones);
            stmAtraccion.setString(7, descripcion);
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

    /**
     * Suma los salarios de un tipo de trabajador
     *
     * @param id de la atraccion
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public float contarVisitantes(int id) throws SQLException{

        float contarEspectadores = 0.0f;

        Connection con;

        con = super.getConexion();

        PreparedStatement stmConsulta = null;
        ResultSet rs = null;
        try {
            //hago una columba llamada conteo para meter la cuenta de los datos
            stmConsulta = con.prepareStatement("SELECT COUNT(*) as conteo FROM Ir WHERE atraccion = ?");
            stmConsulta.setInt(1, id);
            rs = stmConsulta.executeQuery();
            if (rs.next()) {
                contarEspectadores = rs.getInt("conteo");
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmConsulta != null) {
                    stmConsulta.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return contarEspectadores;
    }
}

   
