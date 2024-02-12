/*
 * Simple Tic Tac Toe Game
 * Author : Swapnil Rajput
 * Date : 08/02/2024
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends Frame implements ActionListener {
    int k = 0, x = 8, y = 28; // For the 9 buttons
    int a = 0; // O and X
    int z = 0, z1 = 0, z2 = 0, z3 = 0, z4 = 0, z5 = 0, z6 = 0, z7 = 0, z8 = 0; // For the 9 buttons

    Button buttonNewGame; // New game
    Label p1ScoreLabel,p2ScoreLabel;
    int p1Score = 0;
    int p2Score = 0;
    Button[] b = new Button[9];

    Game() {

        setLayout(null);
        setVisible(true);
        setSize(800, 600);
        setLocation(400, 100);
        setBackground(Color.black);
        setForeground(Color.white);

        // For creating GRID
        for (int i = 1; i <= 3; i++) {

            for (int j = 1; j <= 3; j++) {

                b[k] = new Button();
                b[k].setSize(100, 100);
                b[k].setLocation(x, y);
                b[k].setFont(new Font("", Font.BOLD, 40));

                add(b[k]);

                b[k].addActionListener(this);
                b[k].setBackground(new Color(255, 141, 28)); // ORANGE
                k++;
                x = x + 100;
            }
            x = 8;
            y = y + 100;
        }

        //New game button
        buttonNewGame = new Button("New Game"); // Button text
        buttonNewGame.setSize(150, 40);
        buttonNewGame.setLocation(600, 300);
        buttonNewGame.setFont(new Font("", Font.BOLD, 20));
        buttonNewGame.setForeground(Color.white); // Text color
        add(buttonNewGame);
        buttonNewGame.addActionListener(this);


        // Score labels
        p1ScoreLabel = new Label("Player 1 Score: " + p1Score);
        p1ScoreLabel.setSize(300, 50);
        p1ScoreLabel.setLocation(320, 70);
        p1ScoreLabel.setFont(new Font("", Font.BOLD, 20));
        p1ScoreLabel.setForeground(Color.white); // Text color
        add(p1ScoreLabel);

        p2ScoreLabel = new Label("Player 2 Score: " + p2Score);
        p2ScoreLabel.setSize(300, 50);
        p2ScoreLabel.setLocation(320, 120);
        p2ScoreLabel.setFont(new Font("", Font.BOLD, 20));
        p2ScoreLabel.setForeground(Color.white); // Text color
        add(p2ScoreLabel);
    }

    //On button click
    public void actionPerformed(ActionEvent e) {

        // For new game
        if (e.getSource() == buttonNewGame) {

            for (int i = 0; i <= 8; i++) {
                b[i].setLabel("");
            }
            z = 0;
            z1 = 0;
            z2 = 0;
            z3 = 0;
            z4 = 0;
            z5 = 0;
            z6 = 0;
            z7 = 0;
            z8 = 0;
        }


        // For the 9 buttons
        int[] zArray = {z, z1, z2, z3, z4, z5, z6, z7, z8};
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == b[i] && zArray[i] == 0) {
                if (a % 2 == 0) {
                    b[i].setLabel("O");
                } else {
                    b[i].setLabel("X");
                }
                zArray[i]++;
                a++;
            }
        }
        // Update the z variables
        z = zArray[0];
        z1 = zArray[1];
        z2 = zArray[2];
        z3 = zArray[3];
        z4 = zArray[4];
        z5 = zArray[5];
        z6 = zArray[6];
        z7 = zArray[7];
        z8 = zArray[8];

        // Winning conditions
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (b[i * 3].getLabel().equals(b[i * 3 + 1].getLabel()) && b[i * 3 + 1].getLabel().equals(b[i * 3 + 2].getLabel()) && !b[i * 3].getLabel().equals("")) {
                updateScore(b[i * 3].getLabel());
            }

            // Check columns
            if (b[i].getLabel().equals(b[i + 3].getLabel()) && b[i + 3].getLabel().equals(b[i + 6].getLabel()) && !b[i].getLabel().equals("")) {
                updateScore(b[i].getLabel());
            }
        }

        // Check diagonals
        if (b[0].getLabel().equals(b[4].getLabel()) && b[4].getLabel().equals(b[8].getLabel()) && !b[0].getLabel().equals("")) {
            updateScore(b[0].getLabel());
        }
        if (b[2].getLabel().equals(b[4].getLabel()) && b[4].getLabel().equals(b[6].getLabel()) && !b[2].getLabel().equals("")) {
            updateScore(b[2].getLabel());
        }
    }

    private void updateScore(String winner) {
        if (winner.equals("O")) {
            p1Score++;
            p1ScoreLabel.setForeground(Color.green);
            p1ScoreLabel.setText("Player 1 Score: " + p1Score);
        } else {
            p2Score++;
            p2ScoreLabel.setForeground(Color.green);
            p2ScoreLabel.setText("Player 2 Score: " + p2Score);
        }
        Timer timer = new Timer(3000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                p1ScoreLabel.setForeground(Color.white);
                p2ScoreLabel.setForeground(Color.white);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}
