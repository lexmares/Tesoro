import javax.swing.*;

public class HiloJugador extends Thread{
    private String nombreJugador;
    private ImageIcon iconoJugador;
    private int progreso;
    public HiloJugador(String nombreJugador, String direction){
        this.nombreJugador = nombreJugador;
        iconoJugador = new ImageIcon(direction);
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

    public void run(){
        PantallaPrincipal.avanceJugador();
    }
}
