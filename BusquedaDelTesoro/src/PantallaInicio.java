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

        screen = new JPanel(new BorderLayout());
        initComp();
        this.add(screen);
    }

    private void initComp() {
        northPanel = new JPanel();
        title = new JLabel("Búsqueda del Tesoro", SwingConstants.CENTER);
        northPanel.add(title);

        centerPanel = new JPanel();

        gameConfig = new JPanel(new GridLayout(2,2,10,10));
        JLabel players = new JLabel("Jugadores");
        JLabel difficulty = new JLabel("Dificultad");

        gameConfig.add(players);
        gameConfig.add(difficulty);

        playerSelection(gameConfig);
        difficultySelection(gameConfig);
        centerPanel.add(gameConfig);

        southPanel = new JPanel();

        startButton = new JButton("START");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButtonActionPerformed();
            }
        });

        southPanel.add(startButton);

        screen.add(northPanel, BorderLayout.NORTH);
        screen.add(centerPanel, BorderLayout.CENTER);
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
        gameConfig.add(selectionP);
    }

    private void difficultySelection(JPanel gameConfig) { //seleccion de dificultad
        String[] options = {"Fácil", "Normal", "Difícil"};
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

