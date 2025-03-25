import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;

public class Pistas {
    JPanel panelPistas;
    JLabel labelNormal;
    JLabel labelSymbol;
    Font letraNormal;
    Font letraSymbol;

    int pistaActual = 0; // número de pistas ya activadas
    static final int NO_PISTAS = 8;

    String[] pistas = {
            "plano",
            "rumbo",
            "clave",
            "cofre",
            "isla",
            "dinero",
            "y",
            "hallar"
    };

    String[] traduccionPistas = {
            "\uF070\uF06C\uF061\uF06E\uF06F",
            "\uF072\uF075\uF06D\uF062\uF06F",
            "\uF063\uF06C\uF061\uF076\uF065",
            "\uF063\uF06F\uF066\uF072\uF065",
            "\uF069\uF073\uF06C\uF061",
            "\uF064\uF069\uF06E\uF065\uF072\uF06F",
            "\uF079",
            "\uF068\uF061\uF06C\uF06C\uF061\uF072"
    };

    // Acertijo final; asumiremos que la respuesta correcta es "tesoro"
    String acertijoFinal =
            "\uF063\uF06F\uF06E\uF020\uF065\uF06C\uF020\uF070\uF06C\uF061\uF06E\uF06F\uF020\uF079\uF020\uF072\uF075\uF06D\uF062\uF06F\uF020\uF063\uF06F\uF072\uF072\uF065\uF063\uF074\uF06F\uF020\uF064\uF065\uF073\uF063\uF069\uF066\uF072\uF061\uF020\uF06C\uF061\uF020\uF063\uF06C\uF061\uF076\uF065\uF020\uF071\uF075\uF065\uF020\uF061\uF062\uF072\uF065\uF020\uF065\uF06C\uF020\uF063\uF06F\uF066\uF072\uF065\uF020\uF065\uF06E\uF020\uF06C\uF061\uF020\uF069\uF073\uF06C\uF061\uF020\uF070\uF061\uF072\uF061\uF020\uF068\uF061\uF06C\uF06C\uF061\uF072\uF020\uF065\uF06C\uF020\uF064\uF069";
    String respuestaFinalEsperada = "tesoro";

    public Pistas() {
        panelPistas = new JPanel(new GridLayout(3, 1));
        panelPistas.add(new JLabel("Pista actual", SwingConstants.CENTER));

        labelSymbol = new JLabel("\uF070\uF069\uF073\uF074\uF061\uF073", SwingConstants.CENTER);
        labelNormal = new JLabel("Pistas", SwingConstants.CENTER);

        letraSymbol = new Font("Wingdings", Font.BOLD, 20);
        letraNormal = new Font("Arial", Font.BOLD, 20);

        labelSymbol.setFont(letraSymbol);
        labelNormal.setFont(letraNormal);

        panelPistas.add(labelSymbol);
        panelPistas.add(labelNormal);
    }

    // Muestra la siguiente pista (solo se activa una vez)
    public void mostrarPista() {
        if (pistaActual < NO_PISTAS) {
            labelSymbol.setText(traduccionPistas[pistaActual]);
            labelNormal.setText(pistas[pistaActual]);
            pistaActual++;
        } else {
            labelNormal.setText("No hay más pistas");
        }
    }

    // Acertijo final: retorna true si el jugador responde correctamente.
    public boolean problemaFinal() {
        String input = JOptionPane.showInputDialog("Acertijo final:\n" + acertijoFinal);
        return (input != null && input.trim().equalsIgnoreCase(respuestaFinalEsperada));
    }
}