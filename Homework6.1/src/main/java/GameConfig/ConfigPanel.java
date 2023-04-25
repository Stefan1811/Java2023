package GameConfig;
import javax.swing.*;
import java.io.Serializable;
public class ConfigPanel extends JPanel implements Serializable {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox<Double> linesCombo;
    JButton createButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        linesLabel = new JLabel("Edge probability:");
        Double[] lineValues = {0.1,0.2,0.3,0.4,0.5,0.6, 0.7, 0.8, 0.9, 1.0};
        linesCombo = new JComboBox<Double>(lineValues);
        createButton = new JButton("Create");

        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);

        createButton.addActionListener(e -> {
            frame.canvas.createBoard();
        });
    }
}
