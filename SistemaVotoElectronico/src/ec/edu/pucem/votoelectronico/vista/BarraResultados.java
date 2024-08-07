package ec.edu.pucem.votoelectronico.vista;

import javax.swing.*;
import java.awt.*;

public class BarraResultados extends JPanel {
    private static final long serialVersionUID = 1L;
    private int[] values;
    private String[] labels;
    private Color[] barColors;

    public BarraResultados(int[] values, String[] labels, Color[] barColors) {
        this.values = values;
        this.labels = labels;
        this.barColors = barColors;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int barWidth = 80;
        int barSpacing = 50;
        int x = (getWidth() - (barWidth * values.length + barSpacing * (values.length - 1))) / 2;
        int maxBarHeight = getHeight() - 80;

        int maxVotes = 0;
        for (int value : values) {
            if (value > maxVotes) {
                maxVotes = value;
            }
        }

        FontMetrics metrics = g2d.getFontMetrics();
        for (int i = 0; i < values.length; i++) {
            int barHeight = (int) ((values[i] / (double) maxVotes) * maxBarHeight);
            int barX = x;
            int barY = getHeight() - barHeight - 50;

            g2d.setColor(barColors[i]);
            g2d.fillRect(barX, barY, barWidth, barHeight);

            g2d.setColor(Color.BLACK);
            g2d.drawString(labels[i], barX + barWidth / 2 - metrics.stringWidth(labels[i]) / 2, getHeight() - 10);

            String votesText = String.valueOf(values[i]);
            int textWidth = metrics.stringWidth(votesText);
            g2d.drawString(votesText, barX + barWidth / 2 - textWidth / 2, barY - 5);

            x += barWidth + barSpacing;
        }
    }

    public static void main(String[] args) {
        int[] values = {50, 80, 60, 90};
        String[] labels = {"A", "B", "C", "D"};
        Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.ORANGE};

        JFrame frame = new JFrame("Bar Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new BarraResultados(values, labels, colors));
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
