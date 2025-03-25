import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;

public class PantallaPrincipal extends JFrame {
    static final int DIMENSION_TABLERO = 7;
    static final int MAX_JUGADORES = 4;

    Player[] players;
    AcertijosV2 acertijosV2 = new AcertijosV2();
    Pistas pistas = new Pistas();
    int noJugadores;
    int nextSpecialCell = 3; // Umbral para activar la siguiente casilla especial

    public PantallaPrincipal(int noJugadores, String dificultad) {
        this.noJugadores = noJugadores;
        players = new Player[noJugadores];
        for (int i = 0; i < noJugadores; i++) {
            String nombre = JOptionPane.showInputDialog("Jugador " + (i + 1) + ": Ingrese su nombre:");
            players[i] = new Player(nombre, i, this);
        }

        // Configuración básica de la ventana (puedes ampliar la interfaz)
        setSize(1250, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Juego de Acertijos");
        setLayout(new BorderLayout());
        // Aquí podrías agregar paneles para el tablero y zona de pistas.
        add(pistas.panelPistas, BorderLayout.EAST);
        setVisible(true);

        iniciarJuego(dificultad);
    }

    // Define el tiempo máximo en función de la dificultad.
    private int definirDificultad(String dificultad) {
        switch(dificultad) {
            case "Fácil": return 90;
            case "Normal": return 60;
            case "Difícil": return 30;
            default: return 60;
        }
    }

    public void iniciarJuego(String dificultad) {
        int tiempoMax = definirDificultad(dificultad);
        boolean juegoTerminado = false;

        // Bucle principal de turnos. Cada jugador juega su turno de forma secuencial.
        while (!juegoTerminado) {
            for (Player player : players) {
                JOptionPane.showMessageDialog(this, "Turno del jugador: " + player.getNombreJugador());

                // Muestra un acertijo al azar.
                acertijosV2.mostrarAcertijo();

                // Inicia el temporizador (instancia nueva cada turno).
                Temporizador temp = new Temporizador(tiempoMax);
                temp.reiniciar();
                temp.start();

                // Se pide la respuesta del jugador (bloqueante).
                String respuesta = JOptionPane.showInputDialog("Tienes " + tiempoMax + " segundos.\nIngresa tu respuesta:");
                // Al haber ingresado la respuesta (o cancelado), detenemos el temporizador.
                temp.detener();
                try {
                    temp.join(); // Espera a que finalice el hilo del temporizador.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Si el temporizador se terminó o el jugador no ingresó respuesta, se pierde el turno.
                if (temp.getSegundosRestantes() == 0 || respuesta == null || respuesta.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Turno perdido.");
                } else {
                    if (acertijosV2.comprobarRespuesta(respuesta)) {
                        player.aumentarProgreso();
                        JOptionPane.showMessageDialog(this, "¡Respuesta correcta! Avanzas a la casilla " + player.getProgreso());

                        // Si el jugador alcanza o supera la casilla especial (cada 3 avances) y esta no se ha activado ya,
                        // se actualiza la pista (solo se activa una vez por umbral).
                        if (player.getProgreso() >= nextSpecialCell) {
                            while (player.getProgreso() >= nextSpecialCell) {
                                pistas.mostrarPista();
                                nextSpecialCell += 3;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Respuesta incorrecta. Pierdes el turno.");
                    }
                }

                // Si el jugador alcanza la casilla 24, se le presenta el acertijo final.
                if (player.getProgreso() >= 24) {
                    JOptionPane.showMessageDialog(this, "¡Has llegado a la casilla 24!\nAhora debes resolver el acertijo final.");
                    boolean resFinal = pistas.problemaFinal();
                    if (resFinal) {
                        JOptionPane.showMessageDialog(this, "¡Felicidades, " + player.getNombreJugador() + "! Has ganado el juego.");
                        juegoTerminado = true;
                        break;
                    } else {
                        JOptionPane.showMessageDialog(this, "Acertijo final incorrecto. El juego continúa.");
                    }
                }
            } // fin de for de jugadores.
        } // fin del while principal.
    }
}