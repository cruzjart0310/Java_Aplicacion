package Clases;
import Conexion.ClConexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClDevoluciones {
    
    //Varibles Globales
    PreparedStatement PS;
    
    //Funcion para llenar la tabla de devolución
    public boolean realizarDevolucion(String idDevolucion, String Fecha,String idUsuario){
        try {
            //Uso del patron singleton
            ClConexion.getInstance();
            //Se arma la consulta
            PS= ClConexion.conex.prepareStatement("INSERT INTO devolucion VALUES (?,?,?);");
            PS.setString(1, idDevolucion);
            PS.setString(2, Fecha);
            PS.setString(3, idUsuario);
            PS.execute();
            
        } catch (Exception e) {//Cachamos u obtenemos los posibles errores
            System.err.println("Error al insertar los datos:" + e);
            return false;
        }
        return true;
    }
    
    //Funcion para llenar la tabla detalleDevolución
    public boolean DetalleDevolucion(int idPrestamo,int idDevolucion,String ISBN, int cantDevuelta){
        try {
            //Uso del patron singleton
            ClConexion.getInstance();
            //Se arma la consulta
            PS= ClConexion.conex.prepareStatement("INSERT INTO detalleDevolucion VALUES (?,?,?,?);");
            PS.setInt(1, idPrestamo);
            PS.setInt(2, idDevolucion);
            PS.setString(3, ISBN);
            PS.setInt(4, cantDevuelta);
            PS.execute();
            
        } catch (Exception e) {//Cachamos u obtenemos los posibles errores
            System.err.println("Error al insertar los datos:" + e);
            return false;
        }
        return true;
    }
    
    //Función para actualizar la cantidad prestada de ejemplares
    public boolean ActualizarCantidadPrestada(int cantidad,String isbn){
        try {
            //Uso del patrON singletON
            ClConexion.getInstance();
            //Se arma la cONsulta
            PS = ClConexion.conex.prepareStatement("UPDATE detallePrestamo SET CantidadPrestada=CantidadPrestada-? WHERE ISBN=?;");
            PS.setInt(1, cantidad);
            PS.setString(2, isbn);
            PS.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en la actualizacion:" + e);
            return false;
        }
        return true;
    }
    
    //Método para actulaizar el campo existencia de la tabla ejemplar
    public boolean ActualizarExistenciaMax(int cantidad,String isbn){
        try {
            //Uso del patrON singletON
            ClConexion.getInstance();
            //Se arma la cONsulta
            PS = ClConexion.conex.prepareStatement("UPDATE ejemplar SET CantidadExistente=CantidadExistente+? WHERE ISBN=?;");
            PS.setInt(1, cantidad);
            PS.setString(2, isbn);
            PS.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error en la actualizacion:" + e);
            return false;
        }
        return true;
    }
    
}
