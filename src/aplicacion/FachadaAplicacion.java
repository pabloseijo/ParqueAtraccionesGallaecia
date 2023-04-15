package aplicacion;


/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class FachadaAplicacion {

    GUI.FachadaGUI fachadaGui;
    baseDatos.FachadaBaseDatos fachadaBd;
    GestionUsuarios gestionUsuarios;

    public FachadaAplicacion()  {
        // Inicializamos las fachadas de la bd y gui
        fachadaGui = new GUI.FachadaGUI(this);
        fachadaBd = new baseDatos.FachadaBaseDatos(this);

        // Inicializamos la gestion de usuarios para la autentificacion
        gestionUsuarios = new GestionUsuarios(fachadaGui, fachadaBd);
    }
    


    public static void main(String[] args) {
        FachadaAplicacion fachadaAplicacion;
     
        // Inicializamos las fachas
        fachadaAplicacion = new FachadaAplicacion();
        // Lanzamos la primera ventana
        fachadaAplicacion.iniciaInterfazUsuario();
    }

    public void iniciaInterfazUsuario() {
        fachadaGui.iniciaVista();
    }

    public Boolean comprobarAutentificacion(String idUsuario, String clave) {
        return gestionUsuarios.comprobarAutentificacion(idUsuario, clave);
      }

    

}
