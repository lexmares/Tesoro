import javax.swing.*;

public class HiloPlayer extends Thread{

    Player player;
    int numeroDeJugador;


    AcertijosV2 acertijosV2;

    PantallaPrincipal pantallaPrincipal;

    HiloPlayer(int numeroDeJugador, Player player, AcertijosV2 acertijosV2, PantallaPrincipal pantallaPrincipal){
        this.numeroDeJugador = numeroDeJugador;
        this.player = player;
        this.acertijosV2 = acertijosV2;
        this.pantallaPrincipal = pantallaPrincipal;
    }

    @Override
    public void run() {
        JOptionPane.showMessageDialog(null, "Turno del jugador " + numeroDeJugador);
        if(player.getProgreso() > 1){
            pantallaPrincipal.acertijosV2.mostrarProblemaFinal();
        }else{
            acertijosV2.mostrarAcertijo();
        }


        for(int i = 0; i < pantallaPrincipal.tiempoTempo; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(AcertijosV2.acertijoRespondido){
                break;
            }
        }

        if(player.getProgreso() > 1){
            acertijosV2.problemaFinal(player);
        }else {
            acertijosV2.avisoRespuesta();
            if (acertijosV2.isCorrecto) {
                int avance = (int) (Math.random() * 3) + 1;
                player.setProgreso(player.getProgreso() + avance);
                JOptionPane.showMessageDialog(null, "El jugador " + numeroDeJugador + " avanza " + avance + " casillas.");
            }
            player.numeroDeTurnos++;
            if (player.numeroDeTurnos % 2 == 0) {
                pantallaPrincipal.pistas.mostrarPista();
            }
        }
    }
}
