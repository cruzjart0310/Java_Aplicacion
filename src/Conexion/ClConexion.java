package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*Clase que implementa el patron de Diseño Singleton...el cual provee 
 la creacion de una unica intancia para el acceso a esta misma*/
public class ClConexion {

    //Variable de Tipo ClConexion
    public static ClConexion miConexion;
    //Variable de conexion
    public static Connection conex;
    //Varibles para crear la URL de Conexion
    private String db = "Bibliotecanew";
    private String url = "jdbc:mysql://localhost/" + db;

    //Constructor 
    private ClConexion() {
        try {
            //Driver para mysql
            Class.forName("com.mysql.jdbc.Driver");
            //Obtenemos la conexión
            conex = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) { //Obtenemos posibles errores SQL
            System.err.println(e.getMessage());
        } catch (Exception e) { //Obtenemos otros posibles erroes
            System.err.println(e.getMessage());
        }
    }

    //Creamos el unico acceso a la Clase ClConexion que a la vez retorna o devuleve
    //Clase ClConexion
    public static ClConexion getInstance() {
        if (miConexion == null) {
            miConexion = new ClConexion();
        }
        return miConexion;
    }
}
