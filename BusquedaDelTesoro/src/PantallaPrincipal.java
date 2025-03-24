import javax.swing.*;
import java.awt.*;

public class PantallaPrincipal extends JFrame {
    static final int dimensionesTablero = 7;
    static final int maxJugadores = 4;

    JPanel interfazPrincipal;
    JPanel interfazDerecha;


    JPanel panelPlayers;
    JLabel[] jugadores;

    JPanel menu;
    JPanel tablero;



    JButton[][] casillas;

    //jugador
    Player[] players;

    //temporizador
    static Temporizador tempo;
    JPanel panelTemp;
    JLabel labelSec;
    static int TIEMPO_FACIL = 90;
    static int TIEMPO_NORMAL = 60;
    static int TIEMPO_DIFICIL = 30;
    int tiempoTempo;


    //elementos visuales para la interfaz derecha
    //Acertijos acertijos = new Acertijos();
    AcertijosV2 acertijosV2 = new AcertijosV2();
    Pistas pistas = new Pistas();

    int noJugadores;

    public PantallaPrincipal(int noJugadores, String dificultad){

        definirDificultad(dificultad); //defin el temporizador segun la dificultad
        labelSec = new JLabel(tiempoTempo+"", SwingConstants.CENTER);

        labelSec.setFont(new Font("Arial", Font.BOLD, 30));

        panelTemp = new JPanel(new GridLayout(2,1));
        panelTemp.add(new JLabel("Segundos restantes. Resuelve el acertijo:", SwingConstants.CENTER));
        panelTemp.add(labelSec, SwingConstants.CENTER);


        seleccionJugadores(noJugadores);


        this.setSize(1250, 650);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Game");
        this.setLocationRelativeTo(null);

        interfazPrincipal = new JPanel(new BorderLayout());

        this.add(interfazPrincipal);
        inicializarComponentes();


    }

    private void  inicializarComponentes() {
        panelPlayers = new JPanel(new GridLayout(1, maxJugadores)); //contenedor principal
        menu = new JPanel(new GridLayout(1,2)); // panel de la derecha



        tablero = new JPanel(new GridLayout(dimensionesTablero, dimensionesTablero));//tablero de 7x7
        //panel para usar los botones


        //tablero = new JPanel(new GridLayout(7,7));
        generarTablero(tablero);
        interfazPrincipal.add(tablero, BorderLayout.CENTER);

        interfazDerecha = new JPanel(new GridLayout(4, 1));
        configurarInterfazDerecha();
        interfazPrincipal.add(interfazDerecha, BorderLayout.EAST);

        //iniciarJuego();
        tempo = new Temporizador(tiempoTempo, acertijosV2, labelSec);
        tempo.start();
    }

    public void definirDificultad(String dificultad){
        switch (dificultad){
            case "Fácil":
                tiempoTempo = TIEMPO_FACIL;
            case "Normal":
                tiempoTempo =  TIEMPO_NORMAL;
            case "Difícil":
                tiempoTempo = TIEMPO_DIFICIL;
            default:
                tiempoTempo = TIEMPO_FACIL;
        }
    }

    private void seleccionJugadores(int noJugadores){
        this.noJugadores = noJugadores;
        players = new Player[noJugadores];

        for(int i = 0; i < noJugadores; i++){
            players[i] = new Player(JOptionPane.showInputDialog("Jugador " + (i+1) + " ingrese su nombre." ), "", this);
        }
    }

    private void generarTablero(JPanel tablero){
        casillas = new JButton[7][7];
        for (int i=0; i<7; i++){
            for (int j=0; j<7; j++){
                JButton casilla= new JButton();
                casillas[i][j]= casilla;


                if (i == 0 || i == 6 || j == 0 || j == 6) {
                    casillas[i][j].setVisible(true);
                } else {
                    casillas[i][j].setVisible(false);
                }

                tablero.add(casillas[i][j]);
            }
            }

        int numCasilla=1;
        for (int j = 0; j < 7; j++) {
            casillas[0][j].setText(String.valueOf(numCasilla++));
        }
        for (int i = 1; i < 7; i++) {
            casillas[i][6].setText(String.valueOf(numCasilla++));
        }
        for (int j = 5; j >= 0; j--) {
            casillas[6][j].setText(String.valueOf(numCasilla++));
        }
        for (int i = 5; i > 0; i--) {
            casillas[i][0].setText(String.valueOf(numCasilla++));
        }
    }

    private void configurarInterfazDerecha(){

        interfazDerecha.add(pistas.getPanelPistas());
        pistas.getPanelPistas().setBackground(Color.ORANGE);

        interfazDerecha.add(panelTemp);
        labelSec.setBackground(Color.CYAN);

        interfazDerecha.add(acertijosV2.getPanelAcertijo());
        acertijosV2.getPanelAcertijo().setBackground(Color.LIGHT_GRAY); //colores provicionales

    }

    public void iniciarJuego(){
        mecanismoDeJuego();
    }


    public void mecanismoDeJuego() {
        for (int i = 0; i < noJugadores; i++) {



        }





//        for(int i = 0; i < noJugadores; i++){
//
//            if(isFinal(players[i])){
//                pistas.problemaFinal();
//            }else {
//                tempo.reiniciar();
//                players[i].start();
//            try{
//                players[i].join();
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//                if (acertijosV2.isCorrecto) {
//                    aumentaProgresoPlayer(players[i]);
//                }
//            }
//        }
    }

    public synchronized void avanceJugador(Player player)   {
//        acertijosV2.mostrarAcertijo();
//        ejecutarTimer();
//
//        try{
//            Thread.sleep(1000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }

        //incompleto
    }

    private void aumentaProgresoPlayer(Player player){
        //player.setProgreso(player.getProgreso() + 1);
    }

    private void juegoTerminado(){
        if(pistas.isFinalResuelto()){
            JOptionPane.showMessageDialog(null,"La búsqueda ha finalizado.");
            dispose();
//            PantallaFinal pantallaFinal = new PantallaFinal(players);
//            pantallaFinal.setVisible(true);
        }
    }
//    private boolean isFinal(HiloJugador player){
//        return player.getProgreso() == 24;
//    }

}

