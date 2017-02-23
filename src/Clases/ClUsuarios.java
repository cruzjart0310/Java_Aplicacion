package Clases;

import Conexion.ClConexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClUsuarios {
//Varibles Globales
    PreparedStatement PS;
    Statement ST;
    ResultSet RS;
    //Funcion para consultar los datos de un usuario.
    public DefaultTableModel getTablaUsuarios() {
        DefaultTableModel tablemodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"Matricula", "Nombre", "Apellidos", "Carrera","Grado","Grupo","Usuario es:"};

        try {
            ClConexion.getInstance();
            PS = ClConexion.conex.prepareStatement("SELECT count(*) as total FROM usuario");
            RS = PS.executeQuery();
            RS.next();
            registros = RS.getInt("total");
            RS.close();

        } catch (SQLException e) {
            System.err.println(e);
        }
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[registros][7];
        try {
            //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
            PS= ClConexion.conex.prepareStatement("SELECT * FROM usuario ORDER BY TipoUsuario;");
                              //pstm=ClConexion.conex.prepareStatement("SELECT * FROM usuario WHERE usuario LIKE CONCAT('%'"+registros+"'%')");
            RS = PS.executeQuery();
            int i = 0;
            while (RS.next()) {
                //data[i][0] = res.getInt("idper" );
                data[i][0] = RS.getString("idUsuario");
                data[i][1] = RS.getString("Nombre");
                data[i][2] = RS.getString("Apellidos");
                data[i][3] = RS.getString("Carrera");
                data[i][4] = RS.getString("Grado");
                data[i][5] = RS.getString("Grupo");
                data[i][6] = RS.getString("TipoUsuario");
                i++;
            }
            RS.close();
            //se añade la matriz de datos en el DefaultTableModel
            tablemodel.setDataVector(data, columNames);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return tablemodel;
    }
    
    
    //Funcion para consultar los datos de un usuario.
    public DefaultTableModel BuscarUsuariosPorNombres(String parametro) {
        DefaultTableModel tablemodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"Matri", "Nombre", "Apellidos", "Carrera","Grado","Grupo","Usuario es:"};

        try {
            ClConexion.getInstance();
            PS = ClConexion.conex.prepareStatement("SELECT count(*) as total FROM usuario");
            RS= PS.executeQuery();
            RS.next();
            registros = RS.getInt("total");
            RS.close();

        } catch (SQLException e) {
            System.err.println("eRROR :"+e);
        }
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[registros][7];
        try {
            //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
            PS = ClConexion.conex.prepareStatement("SELECT * FROM usuario WHERE idUsuario LIKE CONCAT('%" + parametro + "%') or Nombre LIKE CONCAT('%" + parametro +"%') ");
            RS = PS.executeQuery();
            int i = 0;
            while (RS.next()) {
                data[i][0] = RS.getString("idUsuario");
                data[i][1] = RS.getString("Nombre");
                data[i][2] = RS.getString("Apellidos");
                data[i][3] = RS.getString("Carrera");
                data[i][4] = RS.getString("Grado");
                data[i][5] = RS.getString("Grupo");
                data[i][6] = RS.getString("TipoUsuario");
                i++;
            }
            RS.close();
            //se añade la matriz de datos en el DefaultTableModel
            tablemodel.setDataVector(data, columNames);
        } catch (SQLException e) {
            System.err.println("eROR: "+e);
        }
        return tablemodel;
    }


    //Registra un nuevo usuario
    public boolean NuevoUsuario(String idUsuario, String nombre, String apellido, String carrera, String grado,String grupo, String tipousuario,int numPre) {
        try {
            //Uso del patron singleton
            ClConexion.getInstance();
            //Se arma la consulta
            PS = ClConexion.conex.prepareStatement("INSERT INTO usuario VALUES(?,?,?,?,?,?,?,?);");
            PS.setString(1, idUsuario);
            PS.setString(2, nombre);
            PS.setString(3, apellido);
            PS.setString(4, carrera);
            PS.setString(5, grado);
            PS.setString(6, grupo);
            PS.setString(7, tipousuario);
            PS.setInt(8, numPre);
            PS.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        
    }

    //Funcion para eliminar un usuario
    public boolean EliminarProducto(String clave) {
        try {
            //Uso del patron singleton
            ClConexion.getInstance();
            //se arma la consulta
            String q = " DELETE FROM usuario WHERE  IdUsuario='" + clave + "' ";
            //se ejecuta la consulta
            PS = ClConexion.conex.prepareStatement(q);
            PS.execute();
            PS.close();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    //Funcion para actualizar los datos de un usuario
    public boolean actualizarUsuarios(int id) {
        try {
            //Uso del patron singleton
            ClConexion.getInstance();
            //Se arma la consulta
            PS = ClConexion.conex.prepareStatement("UPDATE tbl SET ?=?,?=?,=?,?=?;");
            PS.setInt(1, id);
            PS.execute();

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }

        return true;
    }
    
    /*Metodo para validar los usuarios del sistema*/
    public boolean validarUsuario(String usuario, String contrasenia) {
        try {
            ClConexion.getInstance();
            PS= ClConexion.conex.prepareStatement("SELECT * FROM administrador WHERE usuario=? && password=? ;");
            PS.setString(1, usuario);
            PS.setString(2, contrasenia);
            
            RS = PS.executeQuery();
            
            while(RS.next()){
                return true;
            }
        } catch (Exception e) {
            System.err.println("Usuario o contraseña incorrecta!");
            
        }
        return false;
    }
}
