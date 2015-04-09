package Clases;

import Conexion.ClConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class ClEjemplar {

    //Variables
    PreparedStatement PS;
    Statement ST;
    ResultSet RS;

    //Metodo para registrar un nuevo ejemplar
    public boolean RegistroEjemplar(String isbn,String clasificacion ,String titulo, String autor,String editorial, int canInventario,int cantExistente,int estadistica) {
        try {
            ClConexion.getInstance();
            PS = ClConexion.conex.prepareStatement("INSERT INTO ejemplar VALUES(?,?,?,?,?,?,?,?);");
            PS.setString(1, isbn);
            PS.setString(2, clasificacion);
            PS.setString(3, titulo);
            PS.setString(4, autor);
            PS.setString(5, editorial);
            PS.setInt(6, canInventario);
            PS.setInt(7, cantExistente);
            PS.setInt(8, estadistica);
            PS.execute();
        } catch (Exception e) {
            System.err.println("Error"+ e);
            return false;
        }
        return true;
    }

    //Metodo para eliminar ejemplares
    public boolean EliminarEjemplar(String isbn) {
        try {
            ClConexion.getInstance();
            PS = ClConexion.conex.prepareStatement("DELETE FROM ejemplar WHERE ISBN=?;");
            PS.setString(1, isbn);
            PS.execute();
        } catch (Exception e) {
            System.err.println("Error"+ e);
            return false;
        }
        return true;
    }

    //Metodo para modificar un ejemplar
    public boolean ModificarEjemplar(String clasificacion ,String titulo, String autor,String editorial, int canInventario,String isbn) {
        try {
            ClConexion.getInstance();
            PS = ClConexion.conex.prepareStatement("UPDATE ejemplar SET clasificacion=?,titulo=?,autor=?,editorial=?,CantidadInventario=? WHERE isbn=?;");
           
            PS.setString(1, clasificacion);
            PS.setString(2, titulo);
            PS.setString(3, autor);
            PS.setString(4, editorial);
            PS.setInt(5, canInventario);
            PS.setString(6, isbn);
            PS.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error"+ e);
            return false;
        }
        return true;
    }

    //Metodo para consulta de ejemplar
    public DefaultTableModel ConsultaEjemplar() {
        DefaultTableModel tabla = new DefaultTableModel();
        String[] titulos = {"ISBN", "Clasificación", "Título", "Autor", "Editorial", "Cant. Inventario", "Cant. Existente"};
        int registro = 0;
        try {
            ClConexion.getInstance();
            PS = ClConexion.conex.prepareStatement("SELECT count(*) as total FROM ejemplar");
            RS= PS.executeQuery();
            RS.next();
            registro = RS.getInt("total");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        Object dato[][] = new String[registro][7];
        try {
            ClConexion.getInstance();
            ST = ClConexion.conex.createStatement();
            RS = ST.executeQuery("SELECT * FROM ejemplar ORDER BY ISBN;");
            //String valor="";
            //rs = st.executeQuery("SELECT * FROM ejemplar where ISBN LIKE CONCAT('%'"+valor+"'%')");
            int i = 0;
            while (RS.next()) {
                dato[i][0] = RS.getString("ISBN");
                dato[i][1] = RS.getString("Clasificacion");
                dato[i][2] = RS.getString("Titulo");
                dato[i][3] = RS.getString("Autor");
                dato[i][4] = RS.getString("Editorial");
                dato[i][5] = RS.getString("CantidadInventario");
                dato[i][6] = RS.getString("CantidadExistente");
                i++;
            }
            RS.close();
            tabla.setDataVector(dato, titulos);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return tabla;
    }

    //Metodo para consultar un ejemplar por su titulo
    public DefaultTableModel ConsultaEjemplarPorNombre(String parametro) {
        DefaultTableModel tabla = new DefaultTableModel();
        String[] titulos = {"ISBN", "Clasificación", "Título", "Autor", "Editorial", "Cant. Inventario", "Cant. Existente"};
        int registro = 0;
        try {
            ClConexion.getInstance();
            PS = ClConexion.conex.prepareStatement("SELECT count(*) as total FROM ejemplar");
            RS= PS.executeQuery();
            RS.next();
            registro = RS.getInt("total");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        Object dato[][] = new String[registro][7];
        try {
            ClConexion.getInstance();
            ST = ClConexion.conex.createStatement();
            //rs = st.executeQuery("SELECT * FROM ejemplar where titulo =ORDER BY ISBN;");
            //String valor="";
            RS = ST.executeQuery("SELECT * FROM ejemplar where ISBN LIKE CONCAT('%" + parametro + "%') or Titulo LIKE CONCAT('%" + parametro +"%')" );
            //RS = ST.executeQuery("SELECT * FROM ejemplar where Titulo LIKE CONCAT('%" + parametro + "%')");
            int i = 0;
            while (RS.next()) {
                dato[i][0] = RS.getString("ISBN");
                dato[i][1] = RS.getString("Clasificacion");
                dato[i][2] = RS.getString("Titulo");
                dato[i][3] = RS.getString("Autor");
                dato[i][4] = RS.getString("Editorial");
                dato[i][5] = RS.getString("CantidadInventario");
                dato[i][6] = RS.getString("CantidadExistente");
                i++;
            }
            RS.close();
            tabla.setDataVector(dato, titulos);

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return tabla;
    }
}
