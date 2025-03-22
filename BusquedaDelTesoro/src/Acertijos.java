import javax.swing.*;
import java.awt.*;

public class Acertijos {
    static final int NO_ACERTIJOS = 32;

    int acertijoActual = 0;
    JPanel panelCartas;
    CardLayout cardLayout = new CardLayout();
    JLabel[] acertijosLabels;
    JLabel predet;

    String[] acertijos = {
            "Sin rostro y sin ojos. Sin embargo, lloro cuando me cortan.",
            "Tengo cuello, pero no tengo cabeza. Tengo cuerpo, pero no tengo piernas. ¿Qué soy?",
            "Tengo cuello sin cabeza, cuerpo sin piernas y brazos sin manos.",
            "Cuanto más como, más flaca me pongo.",
            "Vuelo sin alas, soy invisible y puedo matar sin ser visto.",
            "Tengo un ojo, pero no puedo ver.",
            "Nací de un fuego, pero muero en él.",
            "Tengo dientes, pero no puedo comer.",
            "Me lleno de agua, pero nunca me mojo.",
            "Calor o frío, da igual lo que me eches: lo aguantaré todo.",
            "Cuando es, no es, y solo es si no es, ¿qué es?",
            "Canto sin boca y vuelo sin alas.",
            "¿Quién sabe responder cualquier pregunta y en cualquier idioma?",
            "Tengo un pie, pero no puedo caminar.",
            "¿Qué sube cuando la lluvia baja?",
            "Si las dejas se pasan, pero para venderlas las pesas.",
            "Cuánto más me quitas, más grande soy.",
            "Cien hermanitos en una sola tabla, si nadie los toca ninguno habla.",
            "Lana sube, lana baja. ¿Qué será?",
            "Sobre la mesa me ponen, me doblan, me usan, pero no me comen.",
            "Cuando nos atan salimos y cuando nos sueltan nos quedamos.",
            "Tengo ojos pero no veo, agua pero no bebo y barba pero no me afeito.",
            "Nazco sin tener padre, muero y va naciendo mi madre. ¿Quién soy?",
            "Me abrigo con paños blancos, tengo blanca cabellera y por mi causa llora hasta la mejor cocinera.",
            "¿Qué es lo que se hace de noche, que no se puede hacer de día?",
            "Largo largero, Martín Caballero, sin patas ni manos y corre ligero.",
            "No muerde ni ladra, pero tiene dientes y la casa guarda.",
            "28 caballeros con espalda negra y lisa, por delante con agujeros que para dominar se dan prisa.",
            "Entre pared y pared hay una flor colorada, llueva o no llueva siempre está mojada.",
            "¿Qué está siempre delante de ti, pero no se ve?",
            "Tengo un lecho, pero no duermo.",
            "Vengo y voy, voy y vengo dejando blanco lo que era negro."
    };

    String[] respuestas = {
            "río",
            "botella",
            "camisa",
            "vela",
            "tiempo",
            "aguja",
            "carbón",
            "peine",
            "esponja",
            "taza",
            "mentira",
            "viento",
            "eco",
            "árbol",
            "paraguas",
            "uvas",
            "agujero",
            "piano",
            "navaja",
            "servilleta",
            "zapatos",
            "coco",
            "nieve",
            "cebolla",
            "trasnochar",
            "tren",
            "llave",
            "dominó",
            "lengua",
            "futuro",
            "río",
            "goma"
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

        predet = new JLabel("???", SwingConstants.CENTER);
        panelCartas.add(predet, "predeterminado");

        cardLayout.show(panelCartas, "predeterminado");

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

    public void mostrarAcertijo(){
        cardLayout.show(panelCartas, "ac" + solicitarAcertijo());
    }
    public void mostrarCaraPredeterminada(){
        cardLayout.show(panelCartas, "predeterminado");
    }


}
