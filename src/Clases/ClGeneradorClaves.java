package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import Conexion.ClConexion;
import java.sql.SQLException;

public class ClGeneradorClaves {

    //Método para generar los codigos de los prestmos
    public static String GenerarCodigoPrestamo() {
        String codigo = "";
        try {
            //Uso del patron singletón
            ClConexion.getInstance();
            //Armamos la consulta
            PreparedStatement PS = ClConexion.conex.prepareStatement("select max(idPrestamo) as codigo from  prestamo");
            ResultSet RS = PS.executeQuery();
            RS.next();
            if (RS.getString("codigo") != null) {
                Scanner s = new Scanner(RS.getString("codigo"));
                int c = s.useDelimiter("0").nextInt() + 1;

                if (c < 10) {
                    codigo = "0000000" + c;
                } else {
                    if (c < 100) {
                        codigo = "000000" + c;
                    } else {
                        if (c < 1000) {
                            codigo = "00000" + c;
                        } else {
                            if (c < 10000) {
                                codigo = "0000" + c;
                            } else {
                                if (c < 100000) {
                                    codigo = "000" + c;
                                } else {
                                    if (c < 1000000) {
                                        codigo = "00" + c;
                                    } else {
                                        return "0" + c;
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                codigo = "00000001";
            }
        } catch (SQLException e) {
            e.getMessage();
        } catch (Exception es) {
            es.getMessage();
        }
        return codigo;
    }

    //Método para generar los codigos de las devolucioones
    public static String GenerarCodigoDevolucion() {
        String codigo = "";

        try {
            //Uso del patron singletón
            ClConexion.getInstance();
            //Se arma la consulta
            PreparedStatement PS = ClConexion.conex.prepareStatement("select max(idDevolucion) as codigo from devolucion");
            ResultSet RS = PS.executeQuery();
            RS.next();
            if (RS.getString("codigo") != null) {
                Scanner s = new Scanner(RS.getString("codigo"));
                int c = s.useDelimiter("0").nextInt() + 1;

                if (c < 10) {
                    codigo = "0000000" + c;
                } else {
                    if (c < 100) {
                        codigo = "000000" + c;
                    } else {
                        if (c < 1000) {
                            codigo = "00000" + c;
                        } else {
                            if (c < 10000) {
                                codigo = "0000" + c;
                            } else {
                                if (c < 100000) {
                                    codigo = "000" + c;
                                } else {
                                    if (c < 1000000) {
                                        codigo = "00" + c;
                                    } else {
                                        return "0" + c;
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                codigo = "00000001";
            }
        } catch (SQLException e) {
            e.getMessage();
        } catch (Exception es) {
            es.getMessage();
        }
        return codigo;
    }

    //Metodo para generar los el últomo id de la tabla prestamo
    public static int obtenerUltimoIdPrestamo() {
        try {
            //Uso del patron singletón
            ClConexion.getInstance();
            //Se arma la consulta
            PreparedStatement st = ClConexion.conex.prepareStatement("SELECT MAX(idprestamo) as idp from prestamo;");
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                //  System.out.println("Estoy trayendo un vaor");
            }
            int valor = rs.getInt("idp");
            return valor;
        } catch (Exception e) {
            return 0;
        }
    }

    //Método para generar los codigos de la tabla devolución
    public static int obtenerUltimoIdDevolucion() {
        try {
            //Uso del patron singletón
            ClConexion.getInstance();
            //Se arma la consulta
            PreparedStatement st = ClConexion.conex.prepareStatement("SELECT MAX(iddevolucion) as idDev from devolucion;");
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                // System.out.println("Estoy trayendo un vaor");
            }
            int valor = rs.getInt("idDev");
            return valor;
        } catch (Exception e) {
            return 0;
        }
    }
}
