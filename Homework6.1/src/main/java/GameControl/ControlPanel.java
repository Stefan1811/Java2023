package GameControl;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JPanel;
import GameConfig.DrawingPanel;
import GameConfig.MainFrame;
import GameConfig.SaveGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;




public class ControlPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    JButton exportBtn = new JButton("Export");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        frame.setLayout(new GridLayout(1, 5));
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);
        add(exportBtn);

        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadData);
        saveBtn.addActionListener(this::saveData);
        resetBtn.addActionListener(this::resetGame);
        exportBtn.addActionListener(this::exportBoard);
    }

    private void add(JButton exportBtn) {
    }

    private void exportBoard(ActionEvent e) {

        frame.getCanvas().createImage();
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void loadData(ActionEvent e) {
        SaveGame svg = new SaveGame(frame.getCanvas());
        svg.loadFromFile(frame.getCanvas());
    }

    private void saveData(ActionEvent e) {
        SaveGame svg = new SaveGame(frame.getCanvas());
        svg.saveToFile();
    }

    private void resetGame(ActionEvent e) {
        this.frame.getCanvas().resetGame();
    }

}

