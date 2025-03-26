import javax.swing.*;
import java.awt.*;

public class Temporizador extends Thread{

    static final int limitePredet = 60;
    PantallaPrincipal pantallaPrincipal;

    private int limiteSec;

    private int segundos = 60;
    AcertijosV2 acertijosV2;
    JLabel labelSec;

    //static volatile boolean[] turno = {false, false, false, false};

    public Temporizador(int limiteSec, AcertijosV2 acertijosV2, JLabel labelSec, PantallaPrincipal pantallaPrincipal){
        this.acertijosV2 = acertijosV2;

        this.limiteSec = limiteSec;

        this.labelSec = labelSec;

        segundos = limiteSec;

        this.pantallaPrincipal = pantallaPrincipal;
    }



    @Override
    public void run() {
        int i = -1;
        while(!Pistas.finalResuelto) {
            i++;
            if(i == pantallaPrincipal.noJugadores)
                i = 0;

            reiniciar();
            pantallaPrincipal.hiloPlayers[i] = new HiloPlayer(i+1,pantallaPrincipal.players[i], pantallaPrincipal.acertijosV2, pantallaPrincipal);
            pantallaPrincipal.hiloPlayers[i].start();
            while (segundos > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                if(AcertijosV2.acertijoRespondido){
                    break;
                }

                segundos--;
                labelSec.setText(String.format("%02d", segundos));

            }
            //acertijosV2.avisoRespuesta();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            AcertijosV2.acertijoRespondido = false;
        }
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




}
