import javax.swing.*;
import java.awt.*;

public class Acertijos {
    static final int NO_ACERTIJOS = 39;
    int acertijoActual = 0;
    JPanel panelCartas;
    CardLayout cardLayout = new CardLayout();
    JLabel[] acertijosLabels;
    String[] acertijos = {
            "Vuelo sin alas, lloro sin ojos. ¿Qué soy?",
            "Blanca por dentro, verde por fuera. Si quieres que te lo diga, espera. ¿Qué es?",
            "Tengo llaves, pero no abro puertas. ¿Qué soy?",
            "Sube llena y baja vacía. ¿Qué es?",
            "No es cama ni es león, pero desaparece en cualquier rincón. ¿Qué es?",
            "Cuelga en la pared, da la hora y no es reloj. ¿Qué es?",
            "Tiene dientes y no come, tiene cabeza y no es hombre. ¿Qué es?",
            "Te lo digo y lo olvidas, te lo pregunto y lo piensas, pero si lo sabes, lo aprendes. ¿Qué es?",
            "Cuanto más la lavas, más sucia está. ¿Qué es?",
            "Si lo nombras, desaparece. ¿Qué es?",
            "Tiene agujas y no cose. ¿Qué es?",
            "Vuelo sin alas, silbo sin boca. ¿Qué soy?",
            "Si me nombras, me rompes. ¿Qué soy?",
            "No es planta ni es animal, pero en el bosque vive. ¿Qué es?",
            "Es más grande que el sol, aunque cabe en un rincón. ¿Qué es?",
            "Tiene un ojo y no puede ver. ¿Qué es?",
            "Vuelo de noche, duermo en el día y nunca verás plumas en ala mía. ¿Qué soy?",
            "Tiene cabeza, tiene cola, pero no tiene cuerpo. ¿Qué es?",
            "Me llenan de letras y solo digo la verdad. ¿Qué soy?",
            "Si lo tiras, se rompe, si lo dejas, se cae. ¿Qué es?",
            "Soy pequeño y delgado, y por el ojo de una aguja paso. ¿Qué soy?",
            "Tiene alas y no vuela, tiene pico y no picotea. ¿Qué es?",
            "Tengo cuatro patas y no puedo andar. ¿Qué soy?",
            "Si me das de comer, vivo. Si me das de beber, muero. ¿Qué soy?",
            "Tengo ciudades, pero no casas; montañas, pero no árboles; agua, pero no peces. ¿Qué soy?",
            "Tiene pies, pero no anda. ¿Qué es?",
            "Soy un animal con nombre de otro animal. ¿Qué soy?",
            "Cuando me miras a la cara, siempre ves lo mismo. ¿Qué soy?",
            "Oro parece, plata no es. ¿Qué es?",
            "Soy alto cuando soy joven y bajo cuando soy viejo. ¿Qué soy?",
            "Camina sin pies, vuela sin alas, llora sin ojos. ¿Qué es?",
            "Tiene ojo, pero no ve, agua, pero no bebe. ¿Qué es?",
            "Siempre sube y nunca baja. ¿Qué es?",
            "Siempre está en el agua y nunca se moja. ¿Qué es?",
            "Lo puedes ver en el día, pero nunca en la noche. ¿Qué es?",
            "Cuando estoy vivo, avanzo, pero cuando muero, corro. ¿Qué soy?",
            "Si tienes hambre, lo comes y si estás cansado, te acuestas en él. ¿Qué es?",
            "Es un animal y también una forma de pago. ¿Qué es?",
            "Me rascan y no me quejo, me planchan y no me arrugo. ¿Qué soy?"
    };

    String[] respuestas = {
            "Viento", "Sandía", "Teclado", "Cubo", "Camaleón", "Calendario", "Peine", "Pregunta", "Carbón", "Silencio",
            "Reloj", "Viento", "Silencio", "Hongo", "Sombra", "Aguja", "Murciélago", "Moneda", "Libro", "Vaso",
            "Hilo", "Balanza", "Mesa", "Fuego", "Mapa", "Zapato", "Gato", "Espejo", "Plátano", "Vela",
            "Nube", "Pozo", "Edad", "Pez", "Sol", "Río", "Cama", "Cheque", "Pizarra"
    };

    public Acertijos(){
        acertijosLabels = new JLabel[NO_ACERTIJOS];

        for(int i = 0; i < NO_ACERTIJOS; i++){
            acertijosLabels[i] = new JLabel(acertijos[i], SwingConstants.CENTER);
        }
        iniciarComponentes();
    }
    public void iniciarComponentes(){
        cardLayout = new CardLayout();
        panelCartas = new JPanel(cardLayout);

        agregarLabelsAlPanel();
    }

    private void agregarLabelsAlPanel() {
        for(int i = 0; i < NO_ACERTIJOS; i++){
            panelCartas.add(acertijosLabels[i], "ac" + i);
        }
    }

    public int solicitarAcertijo(){
        acertijoActual = (int) (Math.random() * NO_ACERTIJOS);
        return acertijoActual;
    }



}
