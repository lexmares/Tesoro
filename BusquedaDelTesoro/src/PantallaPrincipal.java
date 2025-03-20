import javax.swing.*;
import java.awt.*;
//xdxd
public class PantallaPrincipal extends JFrame {
    static final int dimensionesTablero = 7;
    static final int maxJugadores = 4;

    JPanel interfazPrincipal;
    JPanel panelPlayers;
    JLabel[] jugadores;

    JPanel menu;
    JPanel tablero;
    JPanel espacioCartas;
    CardLayout cardLayout;
    JPanel[] cartas;
    JLabel[] contenidoCartas;
    JLabel temporizador;

    JButton[][] casillas;

    //jugador
    HiloJugador[] players;

    //temporizador
    Temporizador tempo;

    public PantallaPrincipal(){
        this.setSize(1250, 650);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Games");

        interfazPrincipal = new JPanel(new BorderLayout());
        inicializarComponentes();
    }

    private void  inicializarComponentes() {
        panelPlayers = new JPanel(new GridLayout(1, maxJugadores)); //contenedor principal
        menu = new JPanel(new GridLayout(1,2)); // panel de la derecha
        cardLayout = new CardLayout();
        espacioCartas = new JPanel(cardLayout); //espacio de las cartas para el card layout

        tablero = new JPanel(new GridLayout(dimensionesTablero, dimensionesTablero));//tablero de 7x7
        //panel para usar los botones


    }



    private void seleccionJugadores(int noJugadores){
        switch (noJugadores){

        }
    }

    public static void avanceJugador(){

    }



}
