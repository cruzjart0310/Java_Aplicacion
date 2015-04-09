package Clases;

public class validarDatos {
        //Metodo para validar un numero entero
        public static boolean esEntero( String n ) {
        try {
            Integer.parseInt(n);
            return true;
        } catch( Exception e ) {
            return false;
        }
    }
        //Metodo para validar un numero decimal
        public static boolean esDecimal( String n ) {
        try {
            Float.parseFloat(n);
            return true;
        } catch( Exception e ) {
            return false;
        }
    }
}
