/*
 * Simple Tic Tac Toe Game
 * Author : Swapnil Rajput
 * Date : 01/02/2024
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends Frame implements ActionListener {

    Button[] b = new Button[9];

    int k = 0, x = 8, y = 28; // For the 9 buttons
    int a = 0; // O and X
    int z = 0, z1 = 0, z2 = 0, z3 = 0, z4 = 0, z5 = 0, z6 = 0, z7 = 0, z8 = 0; // For the 9 buttons

    Button b1; // New game
    int l = 70; //For label
    boolean gameOver = false;
    Label p1ScoreLabel;
    Label p2ScoreLabel;
    int p1Score = 0;
    int p2Score = 0;

    Game() {

        setLayout(null);
        setVisible(true);
        setSize(800, 600);
        setLocation(400, 100);
        setBackground(Color.black);
        setForeground(Color.white);

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

        b1 = new Button("New Game"); // Button text
        b1.setSize(150, 40);
        b1.setLocation(600, 300);
        b1.setFont(new Font("", Font.BOLD, 20));
        b1.setForeground(Color.white); // Text color

        add(b1);
        b1.addActionListener(this);

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

    public void actionPerformed(ActionEvent e) {

        // For new game
        if (e.getSource() == b1) {

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

        if (e.getSource() == b[0] && z == 0) {

            if (a % 2 == 0) {
                b[0].setLabel("O");
                z++;
                a++;
            } else {
                b[0].setLabel("X");
                z++;
                a++;
            }

        }
        if (e.getSource() == b[1] && z1 == 0) {

            if (a % 2 == 0) {
                b[1].setLabel("O");
                z1++;
                a++;
            } else {
                b[1].setLabel("X");
                z1++;
                a++;
            }

        }
        if (e.getSource() == b[2] && z2 == 0) {

            if (a % 2 == 0) {
                b[2].setLabel("O");
                z2++;
                a++;
            } else {
                b[2].setLabel("X");
                z2++;
                a++;
            }

        }
        if (e.getSource() == b[3] && z3 == 0) {

            if (a % 2 == 0) {
                b[3].setLabel("O");
                z3++;
                a++;
            } else {
                b[3].setLabel("X");
                z3++;
                a++;
            }

        }
        if (e.getSource() == b[4] && z4 == 0) {

            if (a % 2 == 0) {
                b[4].setLabel("O");
                z4++;
                a++;
            } else {
                b[4].setLabel("X");
                z4++;
                a++;
            }

        }
        if (e.getSource() == b[5] && z5 == 0) {

            if (a % 2 == 0) {
                b[5].setLabel("O");
                z5++;
                a++;
            } else {
                b[5].setLabel("X");
                z5++;
                a++;
            }

        }
        if (e.getSource() == b[6] && z6 == 0) {

            if (a % 2 == 0) {
                b[6].setLabel("O");
                z6++;
                a++;
            } else {
                b[6].setLabel("X");
                z6++;
                a++;
            }

        }
        if (e.getSource() == b[7] && z7 == 0) {

            if (a % 2 == 0) {
                b[7].setLabel("O");
                z7++;
                a++;
            } else {
                b[7].setLabel("X");
                z7++;
                a++;
            }

        }
        if (e.getSource() == b[8] && z8 == 0) {

            if (a % 2 == 0) {
                b[8].setLabel("O");
                z8++;
                a++;
            } else {
                b[8].setLabel("X");
                z8++;
                a++;
            }

        }

        // Winning conditions

        Font f = new Font("", Font.BOLD, 20);
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
