import javax.swing.*;
import java.awt.*;

public class Temporizador extends Thread {
    private final int limiteSegundos;
    private int segundosRestantes;
    private boolean activo = false;

    public Temporizador(int limiteSegundos) {
        this.limiteSegundos = limiteSegundos;
        this.segundosRestantes = limiteSegundos;
    }

    public void reiniciar() {
        this.segundosRestantes = limiteSegundos;
        activo = true;
    }

    // Detiene la cuenta regresiva.
    public void detener() {
        activo = false;
    }

    public int getSegundosRestantes() {
        return segundosRestantes;
    }

    @Override
    public void run() {
        while (segundosRestantes > 0 && activo) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            segundosRestantes--;
            //System.out.println("Tiempo restante: " + segundosRestantes + " seg");

        }
        if (segundosRestantes == 0) {
            activo = false;
            JOptionPane.showMessageDialog(null, "Tiempo agotado. Pierdes el turno.");
        }
    }
}