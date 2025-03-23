import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Pistas {
    JPanel panelPistas;
    JLabel labelNormal;
    JLabel labelSymbol;
    Font letraNormal;
    Font letraSymbol;

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

    String fraseFinal = "con el plano y rumbo correcto descifra la clave que abre el cofre en la isla para hallar el dinero";

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

    private Font cargarFuente(String ruta, int tamano) {
        try {
            File archivoFuente = new File(ruta);
            if (!archivoFuente.exists()) {
                System.out.println("Error: La fuente no existe en la ruta: " + ruta);
                return new Font("Arial", Font.BOLD, tamano);
            }

            Font fuente = Font.createFont(Font.TRUETYPE_FONT, archivoFuente);
            System.out.println("Fuente cargada correctamente: " + fuente.getFontName());

            // Registrar la fuente
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fuente);

            return fuente.deriveFont((float) tamano);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            System.out.println("No se pudo cargar la fuente, usando Arial.");
            return new Font("Arial", Font.BOLD, tamano);
        }
    }

    public JPanel getPanelPistas() {
        return panelPistas;
    }

    public void setPanelPistas(JPanel panelPistas) {
        this.panelPistas = panelPistas;
    }

    public JLabel getLabelNormal() {
        return labelNormal;
    }

    public void setLabelNormal(JLabel labelNormal) {
        this.labelNormal = labelNormal;
    }

    public JLabel getLabelSymbol() {
        return labelSymbol;
    }

    public void setLabelSymbol(JLabel labelSymbol) {
        this.labelSymbol = labelSymbol;
    }

    public Font getLetraNormal() {
        return letraNormal;
    }

    public void setLetraNormal(Font letraNormal) {
        this.letraNormal = letraNormal;
    }

    public Font getLetraSymbol() {
        return letraSymbol;
    }

    public void setLetraSymbol(Font letraSymbol) {
        this.letraSymbol = letraSymbol;
    }

    public int getPistaActual() {
        return pistaActual;
    }

    public void setPistaActual(int pistaActual) {
        this.pistaActual = pistaActual;
    }

    public String[] getPistas() {
        return pistas;
    }

    public void setPistas(String[] pistas) {
        this.pistas = pistas;
    }

    public String[] getTraduccionPistas() {
        return traduccionPistas;
    }

    public void setTraduccionPistas(String[] traduccionPistas) {
        this.traduccionPistas = traduccionPistas;
    }

    public String getFraseFinal() {
        return fraseFinal;
    }

    public void setFraseFinal(String fraseFinal) {
        this.fraseFinal = fraseFinal;
    }
}
