package Clases;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ClValidarCamposDeTexto {

    public static void ValidarSoloNumeros(JTextField CajaText, KeyEvent evt) {
        int e = (int) evt.getKeyChar();
        if ((e >= 32 && e <= 47) || (e >= 58 && e <= 126) || (e >= 128 && e <= 255)) { //ACEPTA SOLO NUMEROS ENTEROS Y si pongo "e >= 32 && e <= 45" acepta el punto que sirve para numeros decimales
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);//BORRA EL CARACTER ESCRITO EN AL CAJA DE TEXTO
            JOptionPane.showMessageDialog(null, "Se acepta sólo números", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
        }
        if (e == 10) {
            CajaText.transferFocus();
        }
    }
    //METODO PARA VALIDAR CAJA DE TEXTO SOLO LETRAS
    public static void ValidarSoloLetras(JTextField CajaText, KeyEvent evt) {
        int k = (int) evt.getKeyChar();
        if (k > 47 && k < 58) { //ACEPTA SOLO LETRAS Y EL PUNTO y otros caracteres
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);//BORRA EL CARACTER ESCRITO EN LA CAJA DE TEXTO
            JOptionPane.showMessageDialog(null, "Se acepta sólo letras", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
        }
        if (k == 10) {
            CajaText.transferFocus();
        }
    }
    //METODO PARA VALIDAR EL NUMERO DE CARACTERES QUE EL USUARIO PUEDE INGRESAR EN CADA CAJA DE TEXTO
    public static void ValidarTamanio(JTextField CajaText , KeyEvent evt){
        char LimiteCaracter = evt.getKeyChar();
        if (CajaText.getText().length() == 10) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de carácteres");
            CajaText.transferFocus();
        }
    }
}
