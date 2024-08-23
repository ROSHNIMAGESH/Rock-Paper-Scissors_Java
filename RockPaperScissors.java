import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] options = {"rock", "paper", "scissors"};
        boolean keepPlaying = true;

        while (keepPlaying) {
            // Get user input
            System.out.println("Enter your choice (rock, paper, or scissors):");
            String userChoice = scanner.nextLine().toLowerCase();

            // Validate user input
            if (!isValidChoice(userChoice)) {
                System.out.println("Invalid choice. Please choose rock, paper, or scissors.");
                continue;
            }

            // Get computer choice
            String computerChoice = options[random.nextInt(options.length)];
            System.out.println("Computer chose: " + computerChoice);

            // Determine the winner
            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result);

            // Ask if the user wants to play again
            System.out.println("Do you want to play again? (yes or no)");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                keepPlaying = false;
                System.out.println("Thank you for playing!");
            }
        }

        scanner.close();
    }

    private static boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }

    private static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        }

        switch (userChoice) {
            case "rock":
                return computerChoice.equals("scissors") ? "You win!" : "Computer wins!";
            case "paper":
                return computerChoice.equals("rock") ? "You win!" : "Computer wins!";
            case "scissors":
                return computerChoice.equals("paper") ? "You win!" : "Computer wins!";
            default:
                return "Unexpected error.";
        }
    }
}

