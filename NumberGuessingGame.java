import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGame {
    private int numberToGuess;
    private int numberOfTries;
    private JFrame frame;
    private JTextField guessField;
    private JLabel messageLabel;
    private JButton submitButton;

    public NumberGuessingGame() {
        
        numberToGuess = new Random().nextInt(100) + 1; 
        numberOfTries = 0;

        frame = new JFrame("Number Guessing Game");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 120);

        guessField = new JTextField(10);
        messageLabel = new JLabel("Guess a number between 1 and 100.");
        submitButton = new JButton("Submit Guess");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        frame.add(guessField);
        frame.add(submitButton);
        frame.add(messageLabel);

        frame.setVisible(true);
    }

    private void checkGuess() {
        try {
            int playerGuess = Integer.parseInt(guessField.getText());
            numberOfTries++;

            if (playerGuess < numberToGuess) {
                messageLabel.setText("Try higher. Tries: " + numberOfTries);
            } else if (playerGuess > numberToGuess) {
                messageLabel.setText("Try lower. Tries: " + numberOfTries);
            } else {
                messageLabel.setText("Congratulations! You guessed the number in " + numberOfTries + " tries.");
                guessField.setEnabled(false);
                submitButton.setEnabled(false);
            }
        } catch (NumberFormatException e) {
            messageLabel.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGuessingGame();
            }
        });
    }
}
