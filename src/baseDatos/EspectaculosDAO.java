
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public java.util.List<Espectaculo> consultarEspectaculos(){
        java.util.List<Espectaculo> resultado = new java.util.ArrayList<Espectaculo>();
        Espectaculo espectaculoActual;
        Connection con;
        PreparedStatement stmEspectaculos=null;
        ResultSet rsEspectaculos;

        con=this.getConexion();

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
}
