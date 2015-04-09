package Clases;

import java.text.DateFormat;
import java.util.Date;
import javax.swing.JTextField;

public class ClHoraFecha {
    
    //Metodo para calcular la fecha  en un textfield
    public static void Hora(final JTextField j) {
        final DateFormat d = DateFormat.getTimeInstance();
        
        Thread hilo = new Thread(
                new Runnable() {
            public void run() {
                while (true) {
                    try {
                        j.setText(d.format(new Date()));
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        hilo.start();
    }
    
    //Funcion para generar la fecha actual con formato "/"
    public static String fechaAcatual() {
        Date fcha = new Date();
        String fecha = "" + (fcha.getYear() + 1900) + "/ " + (fcha.getMonth() + 1) + "/ " + fcha.getDate();
        
        return fecha;
    }
    
    //Funcion para generar la fecha actual con formato "-"
    public static String FechaFormatoDos(){
        Date fcha = new Date();
        String fecha=""+ (fcha.getYear() + 1900) + "-" + (fcha.getMonth() + 1) + "-" + fcha.getDate();
        
        return fecha;
    }
}
