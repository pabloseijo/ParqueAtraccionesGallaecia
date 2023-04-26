package GUI;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */

public class FachadaGUI {
    aplicacion.FachadaAplicacion fachadaAplicacion;
    baseDatos.FachadaBaseDatos fachadaBaseDatos;

    public FachadaGUI(aplicacion.FachadaAplicacion fachadaAplicacion, baseDatos.FachadaBaseDatos fachadaBaseDatos){
        this.fachadaAplicacion = fachadaAplicacion;
        this.fachadaBaseDatos = fachadaBaseDatos;
    }


    /**
     * Inicia la ventana de autentificación
     *
     */
    public void iniciaVista(){
        LoginGUI vAutentificacion;

        // Iniciar login y ventana inicial

        vAutentificacion = new LoginGUI(null, fachadaAplicacion, fachadaBaseDatos);
    }

}

