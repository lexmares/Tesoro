import javax.swing.*;
import java.awt.*;

public class Temporizador extends Thread{

    JPanel panelTemp;
    //JLabel labelMins;
    JLabel labelsec;
    static final int limitePredet = 60;

    //private int limiteMin;
    private int limiteSec;
    Timer timer;
    private int segundos = 60;


    public Temporizador(int limiteSec){
        this.limiteSec = limiteSec;
        panelTemp = new JPanel(new GridLayout(1,1));
        segundos = limiteSec;
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        labelsec = new JLabel(limiteSec+"", SwingConstants.CENTER);

        labelsec.setFont(new Font("Arial", Font.BOLD, 30));

        panelTemp.add(labelsec);

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

                segundos = limiteSec;
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    private void procesoTiempo() {
        segundos--;
        labelsec.setText(String.format("%02d", segundos));
    }
    public JPanel getPanel() {
        return panelTemp;
    }


}
