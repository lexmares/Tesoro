import javax.swing.*;

public class Player {
    //PantallaPrincipal pantallaPrincipal;
    private String nombreJugador;
    private ImageIcon iconoJugador;
    private int progreso;
    public Player(String nombreJugador, String direction, PantallaPrincipal pantallaPrincipal){
        this.nombreJugador = nombreJugador;
        iconoJugador = new ImageIcon(direction);
        //this.pantallaPrincipal = pantallaPrincipal;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public ImageIcon getIconoJugador() {
        return iconoJugador;
    }

    public void setIconoJugador(ImageIcon iconoJugador) {
        this.iconoJugador = iconoJugador;
    }

    public int getProgreso() {
        return progreso;
    }

    public void setProgreso(int progreso) {
        this.progreso = progreso;
    }


}
