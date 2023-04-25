package baseDatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import aplicacion.Hosteleria;


/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class HosteleriaDAO extends AbstractDAO{

    public HosteleriaDAO (Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    /**
    * Obtiene una lista de todos los establecimientos.
    * 
    * @throws SQLException si hay un error al acceder a la base de datos
    * @return un ArrayList<Hosteleria> con todos los establecimientos.
    */
    public ArrayList<Hosteleria> getEstablecimientos() throws SQLException {
        ArrayList<Hosteleria> resultado = new ArrayList<>();
        ResultSet rsHosteleria;
        PreparedStatement stmHosteleria = null;
        Connection con;
        con = super.getConexion();

        try {
            stmHosteleria = con.prepareStatement("SELECT * FROM Hosteleria ORDER BY Nombre");
            rsHosteleria = stmHosteleria.executeQuery();
            Hosteleria establecimiento;
            while (rsHosteleria.next()) {
                establecimiento = new Hosteleria(rsHosteleria.getInt("codigoRegistro"), rsHosteleria.getString("Nombre"), rsHosteleria.getInt("Aforo"), rsHosteleria.getString("Ubicaciones"), rsHosteleria.getTime("HoraApertura"), rsHosteleria.getTime("HoraCierre"), rsHosteleria.getFloat("Recaudacion"));
                resultado.add(establecimiento);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HosteleriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmHosteleria.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }


    /**
     * Obtiene una lista de todos las atracciones.
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     * @return elimina el restaurante seleccionada de la base de datos
     */
    public void eliminarRestaurante(int ID) throws SQLException{

        //Preparo la variable donde va a estar el statement
        PreparedStatement stmRestaurante = null;

        //concecto con la base
        Connection con;
        con = super.getConexion();

        //intento la consulta y si se cumple la base de datos se actualiza
        try {
            stmRestaurante = con.prepareStatement("DELETE from Hosteleria where codigoRegistro = ?");
            stmRestaurante.setInt(1, ID);
            stmRestaurante.executeUpdate();
            stmRestaurante.close();
        } catch (SQLException ex) {
            Logger.getLogger(AtraccionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmRestaurante.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }


    /**
     * Añade un nuevo trabajador de espectaculos
     *
     * @param nombre el nombre del trabajador.
     * @param aforo el limite de personas de la atraccion.
     * @param Ubicaciones ubicacion de la atraccion dentro del parque.
     * @param horaApertura hora en la que abre el restaurante.
     * @param horaCierre hora de cierre del restaurante.
     * @param recaudacion recaudacion en el ultimo año fiscal del restaurante.
     * @throws SQLException si hay un error al acceder a la base de datos
     * @return añade un restaurante a la base de datos
     */
    public void anhadirRestaurante(String nombre, int aforo, String Ubicaciones, Time horaApertura, Time horaCierre, float recaudacion) throws SQLException{
        Connection con;

        con = super.getConexion();

        PreparedStatement stmRestaurante = null;
        try {
            stmRestaurante = con.prepareStatement("INSERT INTO Hosteleria (Nombre, Aforo, Ubicaciones, HoraApertura, HoraCierre, Recaudacion) values(?,?,?,?,?,?)");
            stmRestaurante.setString(1, nombre);
            stmRestaurante.setInt(2, aforo);
            stmRestaurante.setString(3, Ubicaciones);
            stmRestaurante.setTime(4, horaApertura);
            stmRestaurante.setTime(5, horaCierre);
            stmRestaurante.setFloat(6, recaudacion);
            stmRestaurante.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AtraccionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmRestaurante.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
}
