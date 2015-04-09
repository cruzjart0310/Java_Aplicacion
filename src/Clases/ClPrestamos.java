package Clases;
/*Importamos todos los paquetes necesarios para poder trabajar con las librerias correspondientes......*/
import Conexion.ClConexion;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class ClPrestamos {

    //Varibles Globales
    PreparedStatement PS;
    Statement ST;
    ResultSet RS;
    
    //Metodo para guardar los datos de un prestamo
    public boolean Pretamo(String idPrestamo, String FechaPrestamo, String idUsuario) {
        try {
            //Uso del patrON singletON
            ClConexion.getInstance();
            //Se arma la cONsulta
            PS = ClConexion.conex.prepareStatement("INSERT INTO prestamo VALUES(?,?,?);");
            PS.setString(1, idPrestamo);
            PS.setString(2, FechaPrestamo);
            PS.setString(3, idUsuario);
            PS.execute();
        } catch (SQLException e) {//Para cachar u obtener posibles errores
            System.err.println("Error al insertar datos:" + e);
            return false;
        }

        return true;
    }

    public boolean DetallePretamo(int idPrestamo, String isbn, int CantidadPrestada) {
        try {
            //Uso del patrON singletON
            ClConexion.getInstance();
            //Se arma la cONsulta
            PS = ClConexion.conex.prepareStatement("INSERT INTO DetallePrestamo VALUES(?,?,?);");
            PS.setInt(1, idPrestamo);
            PS.setString(2, isbn);
            PS.setInt(3, CantidadPrestada);
            PS.execute();
        } catch (SQLException e) {//Para cachar u obtener posibles errores
            System.err.println("Error al insertar datos:" + e);
            return false;
        }

        return true;
    }

    //Metodo para consultar todos los pretamos existentes en la base de datos
    public DefaultTableModel ConsultarPrestamos(String nombre) {
        //Creamos un objeto de tipo DefaultTableModel 
        DefaultTableModel tabla = new DefaultTableModel();
        //Variable para obtener los registros totales actuales
        int registros = 0;
        //Arreglo de tipo String donde guarda todos los titulos que apareceran en la tabla
        String[] titulosColumnas = {"Fecha préstamo","Nombre usuario","Apellidos","Carrera","Gdo. / Gpo.", "# Ejemplares prestados","# Préstamos"};

        try {
            //Uso del patron singleton
            ClConexion.getInstance();
            //Se arma la consulta
            PS = ClConexion.conex.prepareStatement("SELECT count(*) as total FROM prestamo");
            RS = PS.executeQuery();
            RS.next();
            registros = RS.getInt("total");
            RS.close();

        } catch (SQLException e) {
            System.err.println("Error al recuperar los datos:"+ e);
        }

        try {
            //Matriz para almacenar filas y columnas
            Object dato[][] = new String[registros][8];
            //Uso del patrON singletON
            ClConexion.getInstance();
            //Se arma la cONsulta
             ST = ClConexion.conex.createStatement();
             RS = ST.executeQuery("SELECT pr.IdPrestamo,pr.FechaPrestamo,us.Nombre,us.Apellidos,us.Carrera,us.Grado,us.Grupo,sum(cantidadPrestada) as totalPrestamo,count(pr.IdPrestamo) as NumPrestamos from prestamo as pr\n"
                    + " INNER JOIN detalleprestamo as dp on dp.IdPrestamo= pr.IdPrestamo\n"
                    + " INNER JOIN usuario as us on us.idUsuario=pr.IdUsuario\n"
                    + " WHERE dp.CantidadPrestada>0 and Nombre LIKE CONCAT('%" + nombre + "%')\n"
                    + " GROUP BY us.idUsuario\n"
                    + " ORDER BY pr.IdPrestamo;");
            int i = 0;
            while (RS.next()) {
                dato[i][0] = RS.getString("FechaPrestamo");
                dato[i][1] = RS.getString("Nombre");
                dato[i][2] = RS.getString("Apellidos");
                dato[i][3] = RS.getString("Carrera");
                dato[i][4] = RS.getString("Grado")+ " / " +RS.getString("Grupo");
                dato[i][5] = RS.getString("totalPrestamo");
                dato[i][6] = RS.getString("NumPrestamos");
                i++;
            }
            RS.close();
			//Con esta linea llenamos la tabla..con las filas y columnas correspondientes
            tabla.setDataVector(dato, titulosColumnas);
        } catch (SQLException e) {
            System.err.println("Error al recuperar los datos: " + e);
        }
        return tabla;
    }

    //Metodo para consultar el detalle de los pretamos existentes en la base de datos
    public DefaultTableModel DetallePrestamos(String nombre) {
        //Creamos un objeto de tipo DefaultTableModel 
        DefaultTableModel tabla = new DefaultTableModel();
        //Variable para obtener los registros totales actuales
        int registros = 0;
        //Arreglo de tipo String donde guarda todos los titulos que apareceran en la tabla
        String[] titulosColumnas = {"Fecha préstamo", "ISBN", " Título ", "Usuario", "Cant. Prestada", "Cant. Devuelta", "Cant. por Devolver"};

        try {
            //Uso del patron singletón
            ClConexion.getInstance();
            //Se arma la consulta
            PS = ClConexion.conex.prepareStatement("SELECT count(*) as total FROM prestamo");
            RS = PS.executeQuery();
            RS.next();
            registros = RS.getInt("total");
            RS.close();

        } catch (SQLException e) {
            System.err.println("Error al recuperar los datos:"+ e);
        }

        try {
            //Matriz para almacenar filas y columnas
            Object dato[][] = new String[registros][8];
            //Uso del patrON singletON
            ClConexion.getInstance();
            //Se arma la cONsulta
             ST = ClConexion.conex.createStatement();
             RS = ST.executeQuery("SELECT pr.IdPrestamo,pr.FechaPrestamo,ej.ISBN,ej.Titulo,us.Nombre,dp.CantidadPrestada,\n"
                    + "	dd.CantidadDevuelta,(dp.CantidadPrestada-dd.CantidadDevuelta)\n"
                    + " AS CantidadPorDevolver FROM prestamo AS pr\n"
                    + " INNER JOIN detalleprestamo AS dp ON dp.IdPrestamo=pr.IdPrestamo \n"
                    + "	INNER JOIN usuario AS us ON us.idUsuario=pr.IdUsuario\n"
                    + "	INNER JOIN ejemplar AS ej ON ej.ISBN=dp.ISBN\n"
                    + "	INNER JOIN detalledevoluciON AS dd ON dd.IdPrestamo=dp.IdPrestamo\n"
                    + " WHERE us.Nombre='" + nombre + "'"
                    + "	ORDER BY pr.IdPrestamo");
            
            int i = 0;
            while (RS.next()) {
                dato[i][0] = RS.getString("FechaPrestamo");
                dato[i][1] = RS.getString("ISBN");
                dato[i][2] = RS.getString("Titulo");
                dato[i][3] = RS.getString("Nombre");
                dato[i][4] = RS.getString("CantidadPrestada");
                dato[i][5] = RS.getString("CantidadDevuelta");
                dato[i][6] = RS.getString("CantidadPorDevolver");
                i++;
            }
            RS.close();
			//Con esta linea llenamos la tabla..con las filas y columnas correspondientes
            tabla.setDataVector(dato, titulosColumnas);
        } catch (SQLException e) {
            System.err.println("Error al recuperar los datos:"+ e);
        }
        return tabla;
    }

    //////////////////////////////////////////////////////////////////////////
    //Metodo para consultar detalle pretamos dado el nombre
    public DefaultTableModel DetallePrestamo(String nombre) {
        //Creamos un objeto de tipo DefaultTableModel 
        DefaultTableModel tabla = new DefaultTableModel();
        //Variable para obtener los registros totales actuales
        int registros = 0;
        //Arreglo de tipo String donde guarda todos los titulos que apareceran en la tabla
        String[] titulosColumnas = {"Cód. préstamo","Fecha préstamo", "ISBN", " Título ", "Cant. Prestada"};

        try {
            //Uso del patron singletón
            ClConexion.getInstance();
            //Se arma la consulta
            PS= ClConexion.conex.prepareStatement("SELECT count(*) as total FROM detallePrestamo");
            RS = PS.executeQuery();
            RS.next();
            registros = RS.getInt("total");
            RS.close();

        } catch (SQLException e) {
            System.err.println("Error al recuperar los datos:"+ e);
        }

        try {
            //Matriz para almacenar filas y columnas
            Object dato[][] = new String[registros][8];
            //Uso del patrON singletON
            ClConexion.getInstance();
            //Se arma la cONsulta
            ST = ClConexion.conex.createStatement();
            //System.out.println("Entro aqui");
            RS = ST.executeQuery("SELECT pr.IdPrestamo,pr.FechaPrestamo,ej.ISBN,ej.Titulo,us.Nombre,dp.CantidadPrestada\n"
                    + " FROM prestamo AS pr\n"
                    + " INNER JOIN detalleprestamo AS dp on dp.IdPrestamo=pr.IdPrestamo \n"
                    + " INNER JOIN usuario AS us ON us.idUsuario=pr.IdUsuario\n"
                    + " INNER JOIN ejemplar AS ej ON ej.ISBN=dp.ISBN"
                    + " WHERE us.Nombre='" + nombre + "' AND CantidadPrestada>0"
                    + "	ORDER BY pr.IdPrestamo");
            
            int i = 0;
            while (RS.next()) {
                dato[i][0] = RS.getString("IdPrestamo");
                dato[i][1] = RS.getString("FechaPrestamo");
                dato[i][2] = RS.getString("ISBN");
                dato[i][3] = RS.getString("Titulo");
                dato[i][4] = RS.getString("CantidadPrestada");
                i++;
            }
            RS.close();
			//Con esta linea llenamos la tabla con las filas y columnas respectivas
            tabla.setDataVector(dato, titulosColumnas);
        } catch (SQLException e) {
            System.err.println("Error al recuperar los datos:"+ e);
        }
        return tabla;
    }
    
   //Método para actulaizar el campo existencia de la tabla ejemplar
    public boolean ActualizarExistenciaMin(int cantidad,String isbn){
        try {
            //Uso del patrON singletON
            ClConexion.getInstance();
            //Se arma la cONsulta
            PS = ClConexion.conex.prepareStatement("UPDATE ejemplar SET CantidadExistente=CantidadExistente-? WHERE ISBN=?;");
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
