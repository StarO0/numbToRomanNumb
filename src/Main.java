import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new Main().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Int to roman numbers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel label = new JLabel("Write number:");
        label.setBounds(10, 20, 100, 25);
        panel.add(label);

        JTextField input = new JTextField(10);
        input.setBounds(120, 20, 150, 25);
        panel.add(input);

        JButton button = new JButton("Submit");
        button.setBounds(80, 60, 140, 25);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(input.getText());
                    String roman = intToRoman(n);
                    showResultFrame(n, roman);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Pls, write correct number", "Error^", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void showResultFrame(int n, String roman) {
        JFrame resultFrame = new JFrame("Result");
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultFrame.setSize(300, 150);
        resultFrame.setLocationRelativeTo(null);

        JPanel resultPanel = new JPanel();
        resultFrame.add(resultPanel);
        resultPanel.setLayout(new GridLayout(3, 1));

        JLabel resultLabel = new JLabel(n + " in roman is: " + roman, SwingConstants.CENTER);
        resultPanel.add(resultLabel);

        JButton resetButton = new JButton("Reset");
        resultPanel.add(resetButton);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultFrame.dispose();
            }
        });

        resultFrame.setVisible(true);
    }

    private String intToRoman(int n) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (n >= values[i]) {
                roman.append(symbols[i]);
                n -= values[i];
            }
        }

        return roman.toString();
    }
}



