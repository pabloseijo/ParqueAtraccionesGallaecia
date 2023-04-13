
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class AsistirDAO extends AbstractDAO {

    public AsistirDAO (Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public void comprarEntrada(java.sql.Date fecha, String dni, String nombreEspectaculo) {  //FU1


    }

    public void cancelarCompra(Date fecha, String dni, String nombreEspectaculo) {  //FU1

    
    }

}
