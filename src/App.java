import javax.swing.JOptionPane;

public class App {
    // Possible Gestures in game enum
    public enum Gesture {
        ROCK,
        PAPER,
        SCISSORS,
    }

    public static void main (String[] args) {
        String player1 = ask_player_name("Player 1");
        String player2 = ask_player_name("Player 2"); 

        Gesture first = ask_input(player1);
        Gesture second = ask_input(player2);

        String winner = who_won(first, second, player1, player2);

        if (winner == null) {
            JOptionPane.showMessageDialog(null, "It was a Draw, Whooo!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, winner + " won the game, Whooo!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Asking player their name and cofirming it
    // If the Confirmed name was different,
    // warning them and asking again
    static String ask_player_name(String player) {
        String input = "";
        while (true) {
            input = JOptionPane.showInputDialog(null, "Create a name", player);
            String confirmed_name = JOptionPane.showInputDialog(null, "Confirm your name.", player);
            if (confirmed_name.equals(input)) {
                break;
            }
            JOptionPane.showMessageDialog(null,
            "Confirmed name was different", "Confermation Failed", JOptionPane.ERROR_MESSAGE);
        }

        return input;
    }

    // Asking player's pick and
    // mapping the answer to Gesture enum
    static Gesture ask_input(String player) {
        String[] options = {"Rock", "Paper", "Scissors"};
        int input_index = JOptionPane.showOptionDialog(null, "Pick", player,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]
            );
        
        if (input_index == 0)
            return Gesture.ROCK;
        if (input_index == 1)
            return Gesture.PAPER;
        if (input_index == 2)
            return Gesture.SCISSORS;

        return null;
    }

    // Checking who won the game,
    // If both pick the same thing, It was a draw,
    // else checked for each combination
    static String who_won(Gesture first, Gesture second, String player1, String player2) {
        if (first == second)
            return null;
        
        if (first == Gesture.ROCK) {
            if (second == Gesture.PAPER)
                return player2;
            return player1;
        }
        else if (first == Gesture.PAPER) {
            if (second == Gesture.SCISSORS)
                return player2;
            return player1;
        }
        else {
            if (second == Gesture.ROCK)
                return player2;
            return player1;
        }
    }
}