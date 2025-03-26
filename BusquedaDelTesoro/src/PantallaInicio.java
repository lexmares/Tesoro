import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaInicio extends JFrame implements ActionListener {

    int selectionPlayers = 1;
    String selectionDifficulty = "Fácil";
    JPanel screen;
    JPanel northPanel;
    JPanel centerPanel;
    JPanel southPanel;
    JPanel gameConfig;
    JComboBox<String> selectionP;
    JComboBox<String> selectionD;
    JLabel title;
    JButton startButton;

    public PantallaInicio() {
        this.setSize(1250, 650);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Búsqueda del Tesoro");

        screen = new JPanel(new BorderLayout()) {
            private Image fondo = new ImageIcon("BusquedaDelTesoro/Graphics/pantallaInicio.png").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        initComp();
        this.add(screen);
    }

    private void initComp() {


        southPanel = new JPanel(new GridLayout(1,2));
        southPanel.setOpaque(false);

        gameConfig = new JPanel(new GridLayout(2,2,10,10));
        JLabel players = new JLabel("Jugadores");
        players.setBackground(Color.lightGray);
        JLabel difficulty = new JLabel("Dificultad");
        difficulty.setBackground(Color.lightGray);

        gameConfig.add(players);
        gameConfig.add(difficulty);

        playerSelection(gameConfig);
        difficultySelection(gameConfig);
        southPanel.add(gameConfig);



        startButton = new JButton("START");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButtonActionPerformed();
            }
        });

        southPanel.add(startButton);

        screen.add(southPanel, BorderLayout.SOUTH);


    }

    private void startButtonActionPerformed() {
        dispose();
        PantallaPrincipal p = new PantallaPrincipal(selectionPlayers, selectionDifficulty);
        p.setVisible(true);


    }

    private void playerSelection(JPanel gameConfig) { //seleccion de numero de jugadores
        String[] options = {"1", "2", "3", "4"};
        selectionP = new JComboBox<>(options);
        selectionP.addActionListener(this);
        selectionP.setBackground(Color.lightGray);
        gameConfig.add(selectionP);
    }

    private void difficultySelection(JPanel gameConfig) { //seleccion de dificultad
        String[] options = {"Fácil","Normal","Difícil"};
        selectionD = new JComboBox<>(options);
        selectionD.addActionListener(this);
        gameConfig.add(selectionD);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectionP) {
            selectionPlayers = Integer.parseInt((String) selectionP.getSelectedItem());
        }else
            selectionDifficulty = (String) selectionD.getSelectedItem();
    }}

