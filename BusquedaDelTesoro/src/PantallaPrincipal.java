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

//    JPanel espacioCartas;
//    CardLayout cardLayout;
    JPanel[] cartas;
    JLabel[] contenidoCartas;


    JButton[][] casillas;

    //jugador
    HiloJugador[] players;

    //temporizador
    Temporizador tempo;

    //elementos visuales para la interfaz derecha
    //Acertijos acertijos = new Acertijos();
    AcertijosV2 acertijosV2 = new AcertijosV2();
    Pistas pistas = new Pistas();

    public PantallaPrincipal(int noJugadores, String dificultad){

        tempo = new Temporizador(definirDificultad(dificultad)); //defin el temporizador segun la dificultad
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

        //cardLayout = new CardLayout();
        //espacioCartas = new JPanel(cardLayout); //espacio de las cartas para el card layout

        tablero = new JPanel(new GridLayout(dimensionesTablero, dimensionesTablero));//tablero de 7x7
        //panel para usar los botones


        tablero = new JPanel(new GridLayout(7,7));
        generarTablero(tablero);
        interfazPrincipal.add(tablero, BorderLayout.CENTER);

        interfazDerecha = new JPanel(new GridLayout(4, 1));
        configurarInterfazDerecha();
        interfazPrincipal.add(interfazDerecha, BorderLayout.EAST);

    }

    public void ejecutarTimer(){
        tempo.start();
    }

    public int definirDificultad(String dificultad){
        switch (dificultad){
            case "Fácil":
                return 60;
            case "Normal":
                return 30;
            case "Difícil":
                return 15;
            default:
                return 60;
        }
    }



    private void seleccionJugadores(int noJugadores){
        players = new HiloJugador[noJugadores];
    }



    public static void avanceJugador(){

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

        interfazDerecha.add(tempo.getPanelTemp());
        tempo.getLabelsec().setBackground(Color.CYAN);

        interfazDerecha.add(acertijosV2.getPanelAcertijo());
        acertijosV2.getPanelAcertijo().setBackground(Color.LIGHT_GRAY); //color provicional

    }

}

