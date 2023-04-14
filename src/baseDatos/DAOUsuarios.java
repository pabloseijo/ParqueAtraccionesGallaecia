/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
}
