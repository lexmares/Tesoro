import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
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

    public PantallaPrincipal(int noJugadores, String dificultad) {

        definirDificultad(dificultad); //defin el temporizador segun la dificultad
        labelSec = new JLabel(tiempoTempo + "", SwingConstants.CENTER);

        labelSec.setFont(new Font("Arial", Font.BOLD, 30));

        panelTemp = new JPanel(new GridLayout(2, 1));
        panelTemp.add(new JLabel("Segundos restantes. Resuelve el acertijo:", SwingConstants.CENTER));
        panelTemp.add(labelSec, SwingConstants.CENTER);


        seleccionJugadores(noJugadores);


        this.setSize(1180, 850);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Game");
        this.setLocationRelativeTo(null);

        interfazPrincipal = new JPanel(new BorderLayout());

        this.add(interfazPrincipal);
        inicializarComponentes();


    }

    private void inicializarComponentes() {
        panelPlayers = new JPanel(new GridLayout(1, maxJugadores)); //contenedor principal
        menu = new JPanel(new GridLayout(1, 2)); // panel de la derecha

        tablero = new JPanel() {
            private Image fondo = new ImageIcon("BusquedaDelTesoro/Graphics/board.png").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        tablero.setLayout(new GridLayout(dimensionesTablero, dimensionesTablero));  // Tablero de 7x7
        tablero.setSize(630, 630);
        tablero.setBorder(new LineBorder(Color.BLACK, 5));
        generarTablero(tablero);

        interfazPrincipal.add(tablero, BorderLayout.CENTER);

        generarPanelPlayers(panelPlayers, noJugadores);
        interfazPrincipal.add(panelPlayers, BorderLayout.NORTH);

        interfazDerecha = new JPanel(new GridLayout(4, 1));
        configurarInterfazDerecha();
        interfazPrincipal.add(interfazDerecha, BorderLayout.EAST);

        //iniciarJuego();
        tempo = new Temporizador(tiempoTempo, acertijosV2, labelSec);
        tempo.start();
    }


    private void generarPanelPlayers(JPanel panelPlayers, int noJugadores) {
        JLabel[] labelPlayers = new JLabel[noJugadores];
        int jugador = 1;
        for (int i = 0; i < noJugadores; i++) {
            JLabel fichaPlayer = new JLabel();
            fichaPlayer.setText("JUGADOR " + jugador);
            ImageIcon originalIcon = new ImageIcon("BusquedaDelTesoro/Graphics/Players/" + (i + 1) + ".png");
            Image scaledImage = originalIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            fichaPlayer.setIcon(new ImageIcon(scaledImage));
            jugador++;
            fichaPlayer.setBackground(new Color(59,31,25));
            fichaPlayer.setBorder(new LineBorder(Color.BLACK, 5));
            fichaPlayer.setOpaque(true);
            fichaPlayer.setFont(new Font("Yu Gothic",Font.BOLD,12));
            fichaPlayer.setForeground(Color.WHITE);
            fichaPlayer.setHorizontalAlignment(SwingConstants.CENTER);
            fichaPlayer.setVerticalAlignment(SwingConstants.CENTER);

            fichaPlayer.setHorizontalTextPosition(SwingConstants.CENTER);
            fichaPlayer.setVerticalTextPosition(SwingConstants.BOTTOM);
            labelPlayers[i] = fichaPlayer;
            panelPlayers.add(labelPlayers[i]);
        }
    }

    public void definirDificultad(String dificultad) {
        switch (dificultad) {
            case "Fácil":
                tiempoTempo = TIEMPO_FACIL;
            case "Normal":
                tiempoTempo = TIEMPO_NORMAL;
            case "Difícil":
                tiempoTempo = TIEMPO_DIFICIL;
            default:
                tiempoTempo = TIEMPO_FACIL;
        }
    }

    private void seleccionJugadores(int noJugadores) {
        this.noJugadores = noJugadores;
        players = new Player[noJugadores];

        for (int i = 0; i < noJugadores; i++) {
            players[i] = new Player(JOptionPane.showInputDialog("Jugador " + (i + 1) + ", ingrese su nombre:"), "", this);
        }
    }

    private void generarTablero(JPanel tablero) {


        casillas = new JButton[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                JButton casilla = new JButton();
                casilla.setSize(100, 100);
                casilla.setHorizontalAlignment(SwingConstants.RIGHT);
                casilla.setVerticalAlignment(SwingConstants.BOTTOM);
                casilla.setOpaque(false);
                casilla.setForeground(Color.WHITE);
                casilla.setContentAreaFilled(false);
                casilla.setFont(new Font("Arial",Font.BOLD,17));

                casillas[i][j] = casilla;

                if (i == 0 || i == 6 || j == 0 || j == 6) {
                    casilla.setBorder(new LineBorder(Color.BLACK, 5));
                } else {
                    casilla.setBorder(null);
                }

                tablero.add(casillas[i][j]);
            }
        }

        int numCasilla = 1;


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

    private void configurarInterfazDerecha() {

        interfazDerecha.add(pistas.getPanelPistas());
        pistas.getPanelPistas().setBackground(Color.ORANGE);
        pistas.getPanelPistas().setVisible(true);

        interfazDerecha.add(panelTemp);
        labelSec.setBackground(Color.CYAN);


        interfazDerecha.add(acertijosV2.getPanelAcertijo());
        acertijosV2.getPanelAcertijo().setBackground(Color.LIGHT_GRAY); //colores provicionales

    }
}




