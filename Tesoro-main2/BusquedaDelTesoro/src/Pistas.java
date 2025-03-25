import javax.swing.*;
import java.awt.*;

public class Pistas {
    JPanel panelPistas;
    JLabel labelNormal;
    JLabel labelSymbol;
    Font letraNormal;
    Font letraSymbol;

    boolean finalResuelto = false;

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
    String acertijoFinal = "\uF063\uF06F\uF06E\uF020\uF065\uF06C\uF020\uF070\uF06C\uF061\uF06E\uF06F\uF020\uF079\uF020\uF072\uF075\uF06D\uF062\uF06F\uF020\uF063\uF06F\uF072\uF072\uF065\uF063\uF074\uF06F\uF020\uF064\uF065\uF073\uF063\uF069\uF066\uF072\uF061\uF020\uF06C\uF061\uF020\uF063\uF06C\uF061\uF076\uF065\uF020\uF071\uF075\uF065\uF020\uF061\uF062\uF072\uF065\uF020\uF065\uF06C\uF020\uF063\uF06F\uF066\uF072\uF065\uF020\uF065\uF06E\uF020\uF06C\uF061\uF020\uF069\uF073\uF06C\uF061\uF020\uF070\uF061\uF072\uF061\uF020\uF068\uF061\uF06C\uF06C\uF061\uF072\uF020\uF065\uF06C\uF020\uF064\uF069\uF06E\uF065\uF072\uF06F";
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

    public void problemaFinal(){
        String respuestaFinal = JOptionPane.showInputDialog("Acetijo final: " + acertijoFinal);

//        if(respuestaFinal == null){
//            finalResuelto = false;
//        }else
            if(respuestaFinal.trim().equalsIgnoreCase(fraseFinal)){
            finalResuelto = true;
            JOptionPane.showMessageDialog(null, "LO LOGASTE!");
        }else{
            JOptionPane.showMessageDialog(null, "Te equivcaste, intentalo de nuevo después");
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

    public String getFraseFinal() {
        return fraseFinal;
    }

    public String getAcertijoFinal() {
        return acertijoFinal;
    }
}
