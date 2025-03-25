import javax.swing.*;
import java.awt.*;

public class ClasePruebaMain extends JFrame {

    public ClasePruebaMain(){
        this.setSize(1250,650);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        AcertijosV2 acertijosV2 = new AcertijosV2();
        this.add(acertijosV2.getPanelAcertijo(), BorderLayout.EAST);

        //Pistas pistas = new Pistas();
        //this.add(pistas.getPanelPistas());

        JButton boton = new JButton("accion");
        this.add(boton, BorderLayout.SOUTH);
        boton.addActionListener(e ->{
            acertijosV2.mostrarAcertijo();
            //pistas.problemaFinal();
        });


    }

    public static void main(String[] args) {
        ClasePruebaMain clasePruebaMain = new ClasePruebaMain();
        clasePruebaMain.setVisible(true);
    }
}
