import javax.swing.*;
import java.awt.*;

public class ClasePruebaMain extends JFrame {

    public ClasePruebaMain(){
        this.setSize(400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        Pistas pistas = new Pistas();

        this.add(pistas.panelPistas, BorderLayout.EAST);

        JButton boton = new JButton("accion");
        this.add(boton, BorderLayout.SOUTH);
        boton.addActionListener(e ->{pistas.mostrarPista();});


    }

    public static void main(String[] args) {
        ClasePruebaMain clasePruebaMain = new ClasePruebaMain();
        clasePruebaMain.setVisible(true);
    }
}
