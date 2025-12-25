/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jv.rockpaperscissors;

/**
 *
 * @author JV
 */

import javax.swing.JOptionPane;

public class RockPaperScissors {
    public static void main(String[] args) {
        int playerScore = 0;
        int computerScore = 0;
        boolean playAgain = true;
        
        JOptionPane.showMessageDialog(null, 
                "Welcome to Rock-Paper-Scissors+Fire!\n"
                +"Instructions\n"
                +"1. Choose Rock, Paper, Scissors, or Fire.\n"
                +"2. Rock beats Scissors and Fire.\n"
                +"3. Paper beats Rock.\n"
                +"4. Scissors beats Paper.\n"
                +"5. Fire beats Paper and Scissors.\n"
                +"6. Play as many rounds as you like, good luck playa!"
        );
        
        while (playAgain){
            String playerChoice = JOptionPane.showInputDialog("Enter Rock, Paper, Scissors, or Fire:");
            
            if (playerChoice == null){ // cancel button 
                break; 
            }
            
            playerChoice = playerChoice.toLowerCase();
            
            if (!playerChoice.equals("rock") && !playerChoice.equals("paper")
                    && !playerChoice.equals("scissors") && !playerChoice.equals("fire")){
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter Rock, Paper, Scissors, or Fire.");
                continue;
            } 
            
            int randomNum = (int)(Math.random() * 4) + 1;
            String computerChoice = "";
            
            if (randomNum == 1) computerChoice = "rock";
            else if (randomNum == 2) computerChoice = "paper";
            else if (randomNum == 3) computerChoice = "scissors";
            else computerChoice = "fire";
            
            String result;
            
            if (playerChoice.equals(computerChoice)) {
            result = "It's a tie!";
            }
            
            // Player win conditions
            else if (
                    (playerChoice.equals("rock") && 
                        (computerChoice.equals("scissors") || computerChoice.equals("fire"))) ||

                    (playerChoice.equals("paper") && computerChoice.equals("rock")) ||

                    (playerChoice.equals("scissors") && computerChoice.equals("paper")) ||

                    (playerChoice.equals("fire") && 
                        (computerChoice.equals("paper") || computerChoice.equals("scissors")))
                    ) {
                result = "You win this round!";
                playerScore++;
                }
                // Otherwise, computer wins
            else {
                    result = "Computer wins this round!";
                    computerScore++;
                 }               

            // Display result
            JOptionPane.showMessageDialog(null,
                    "You chose: " + playerChoice + "\n"
                    + "Computer chose: " + computerChoice + "\n"
                    + result + "\n\n"
                    + "Score so far:\nYou: " + playerScore + "\nComputer: " + computerScore);
            
            // Replay Option
            String again = JOptionPane.showInputDialog("Do you want to play again? (Y/N)");
            if (again == null || !again.equalsIgnoreCase("Y")) {
                playAgain = false;
            }
        }
        
        // Final score
         JOptionPane.showMessageDialog(null,
                "Final Scores:\nYou: " + playerScore + "\nComputer: " + computerScore + "\n"
                + (playerScore > computerScore ? "🔥 You are the overall winner!" :
                   playerScore < computerScore ? "💻 Computer wins overall!" : "It's an overall tie!")
        );

        JOptionPane.showMessageDialog(null, "Thanks for playing, playa!");
    }
}
