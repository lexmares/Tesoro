import javax.swing.*;
public class Player {
    private String nombreJugador;
    private int idJugador;
    private int progreso;
    private PantallaPrincipal pantallaPrincipal;

    public Player(String nombreJugador, int idJugador, PantallaPrincipal pantallaPrincipal) {
        this.nombreJugador = nombreJugador;
        this.idJugador = idJugador;
        this.pantallaPrincipal = pantallaPrincipal;
        this.progreso = 0;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public int getProgreso() {
        return progreso;
    }

    public void aumentarProgreso() {
        progreso++;
    }
}