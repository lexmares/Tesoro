import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class AcertijosV2 {
    // Para simplificar se usan pocos acertijos; puedes agregarlos hasta 32 o más.
    String[] acertijos = {
            "Sin rostro y sin ojos. Sin embargo, lloro cuando me cortan.",
            "Tengo cuello, pero no tengo cabeza. Tengo cuerpo, pero no tengo piernas. ¿Qué soy?",
            "Vuelo sin alas, soy invisible y puedo matar sin ser visto.",
            "Tengo un ojo, pero no puedo ver.",
            "Si me comes, muero."
    };

    String[] respuestas = {
            "cebolla",
            "botella",
            "tiempo",
            "aguja",
            "fuego"
    };

    int acertijoActual = -1;

    // Muestra un acertijo aleatorio.
    public void mostrarAcertijo() {
        int nuevo;
        do {
            nuevo = (int)(Math.random() * respuestas.length);
        } while(nuevo == acertijoActual);
        acertijoActual = nuevo;
        JOptionPane.showMessageDialog(null, "Acertijo:\n" + acertijos[acertijoActual]);
    }

    // Comprueba si la respuesta ingresada es correcta para el acertijo mostrado.
    public boolean comprobarRespuesta(String respuestaJugador) {
        if (respuestaJugador == null) return false;
        return respuestaJugador.trim().equalsIgnoreCase(respuestas[acertijoActual]);
    }
}