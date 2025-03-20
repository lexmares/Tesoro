import javax.swing.*;

public class Temporizador{

    JPanel panelTemp;
    JLabel labelTime;
    static final int limitePredet = 10;

    private int limiteMin;
    private int minutos;
    private int horas;

    public Temporizador(){
        limiteMin = limitePredet;
    }
    public Temporizador(int limiteMin){
        this.limiteMin = limiteMin;
        labelTime = new JLabel("00:00");

    }

    

}
