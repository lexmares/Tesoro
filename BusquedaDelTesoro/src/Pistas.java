import javax.swing.*;
import java.awt.*;

public class Pistas {
    JPanel panelPistas;
    JLabel labelNormal;
    JLabel labelSymbol;
    Font letraNormal;
    Font letraSymbol;

    static boolean finalResuelto = false;

    int pistaActual = 0;
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

    public Pistas(){
        panelPistas = new JPanel(new GridLayout(3, 1));
        panelPistas.add(new JLabel("Pista actual", SwingConstants.CENTER));

        labelSymbol = new JLabel("\uF070\uF069\uF073\uF074\uF061\uF073", SwingConstants.CENTER);
        labelNormal = new JLabel("Pistas", SwingConstants.CENTER);

        panelPistas.add(labelSymbol);
        panelPistas.add(labelNormal);

        letraSymbol = new Font("Wingdings", Font.BOLD, 20);
        letraNormal = new Font("Arial", Font.BOLD, 20);

        labelSymbol.setFont(letraSymbol);
        labelNormal.setFont(letraNormal);

    }

    public void mostrarPista(){
        labelSymbol.setText(traduccionPistas[pistaActual]);
        labelNormal.setText(pistas[pistaActual]);

        pistaActual++;
        if(pistaActual == NO_PISTAS){
            pistaActual = 0;
        }
    }

    public JPanel getPanelPistas() {
        return panelPistas;
    }

    public JLabel getLabelNormal() {
        return labelNormal;
    }

    public JLabel getLabelSymbol() {
        return labelSymbol;
    }

    public Font getLetraNormal() {
        return letraNormal;
    }

    public Font getLetraSymbol() {
        return letraSymbol;
    }

    public boolean isFinalResuelto() {
        return finalResuelto;
    }

    public int getPistaActual() {
        return pistaActual;
    }

    public String[] getPistas() {
        return pistas;
    }

    public String[] getTraduccionPistas() {
        return traduccionPistas;
    }
}
