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
     * Obtiene un establecimiento por su nombre.
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     * @return el Hosteleria buscado si existe.
     */
    public Hosteleria buscaEstablecimiento(String nombreEstablecimiento) throws SQLException {
        Hosteleria resultado = null;
        ResultSet rsHosteleria;
        PreparedStatement stmHosteleria = null;
        Connection con;
        con = super.getConexion();

        try {
            stmHosteleria = con.prepareStatement("SELECT * FROM Hosteleria WHERE Nombre = ?");
            stmHosteleria.setString(1, nombreEstablecimiento);
            rsHosteleria = stmHosteleria.executeQuery();
            while (rsHosteleria.next()) {
                resultado = new Hosteleria(rsHosteleria.getInt("codigoRegistro"), rsHosteleria.getString("Nombre"), rsHosteleria.getInt("Aforo"), rsHosteleria.getString("Ubicaciones"), rsHosteleria.getTime("HoraApertura"), rsHosteleria.getTime("HoraCierre"), rsHosteleria.getFloat("Recaudacion"));
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
     * Elimina el restaurante seleccionada de la base de datos
     *
     * @param id: identificador del restaurante
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void eliminarRestaurante(int id) throws SQLException{

        //Preparo la variable donde va a estar el statement
        PreparedStatement stmRestaurante = null;

        //concecto con la base
        Connection con;
        con = super.getConexion();

        //intento la consulta y si se cumple la base de datos se actualiza
        try {
            stmRestaurante = con.prepareStatement("DELETE from Hosteleria where codigoRegistro = ?");
            stmRestaurante.setInt(1, id);
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


    /**
     * Añade un nuevo restaurante
     *
     * @param nombre el nombre del restaurante.
     * @param aforo el limite de personas del restaurante.
     * @param ubicaciones ubicacion del restaurante.
     * @param horaApertura hora en la que abre el restaurante.
     * @param horaCierre hora de cierre del restaurante.
     * @param recaudacion recaudacion en el ultimo año fiscal del restaurante.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void anhadirRestaurante(String nombre, int aforo, String ubicaciones, Time horaApertura, Time horaCierre, float recaudacion) throws SQLException{
        Connection con;

        con = super.getConexion();

        PreparedStatement stmRestaurante = null;
        try {
            stmRestaurante = con.prepareStatement("INSERT INTO Hosteleria (Nombre, Aforo, Ubicaciones, HoraApertura, HoraCierre, Recaudacion) values(?,?,?,?,?,?)");
            stmRestaurante.setString(1, nombre);
            stmRestaurante.setInt(2, aforo);
            stmRestaurante.setString(3, ubicaciones);
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
