import javax.swing.*;
import java.awt.*;

public class PantallaInicio extends JFrame {
 JPanel screen;
 JPanel selectPlayers;
 JButton[] players;
 JLabel title;
 public PantallaInicio(){
     this.setSize(1250, 650);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
     this.setTitle("Búsqueda del Tesoro");

     screen = new JPanel(new BorderLayout());
     initComp();
     this.add(screen);
 }

         private void initComp(){
             title = new JLabel("Búsqueda del Tesoro", (int) CENTER_ALIGNMENT);
             screen.add(title, BorderLayout.NORTH);

             selectPlayers = new JPanel(new GridLayout(PantallaPrincipal.maxJugadores,1));
             genButton(selectPlayers);
             screen.add(selectPlayers, BorderLayout.SOUTH);
         }

         private void genButton(JPanel selectPlayers){
             players = new JButton[PantallaPrincipal.maxJugadores];
             for (int i = 0 ; i<PantallaPrincipal.maxJugadores; i++){
                 if (i==0){
                     players[i] = new JButton((i+1) + " jugador");
                     selectPlayers.add(players[i]);
                 }else{
                     players[i] = new JButton((i+1) + " jugadores");
                     selectPlayers.add(players[i]);
                 }
             }
         }


}
