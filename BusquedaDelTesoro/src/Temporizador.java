import javax.swing.*;
import java.awt.*;

public class Temporizador extends Thread{

    static final int limitePredet = 60;

    
    private int limiteSec;
    Timer timer;
    private int segundos = 60;
    AcertijosV2 acertijosV2;
    JLabel labelSec;

    public Temporizador(int limiteSec, AcertijosV2 acertijosV2, JLabel labelSec){
        this.acertijosV2 = acertijosV2;

        this.limiteSec = limiteSec;

        this.labelSec = labelSec;

        segundos = limiteSec;
    }



    @Override
    public void run(){
        mecanismoTempo();
    }

    private void mecanismoTempo() {
        timer = new Timer(1000, e ->{
            procesoTiempo();
            if(segundos == 0){
                timer.stop();
                acertijosV2.avisoRespuesta();

            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    public void reiniciar(){
        segundos = limiteSec;
        labelSec.setText(String.format("%02d", segundos));
    }

    private void procesoTiempo() {
        segundos--;
        labelSec.setText(String.format("%02d", segundos));
    }


    public int getLimiteSec() {
        return limiteSec;
    }

    public Timer getTimer() {
        return timer;
    }

    public int getSegundos() {
        return segundos;
    }

}
