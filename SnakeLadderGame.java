import java.util.Random;   // For generating random dice rolls
import java.util.Map;      // For using Map (Snakes & Ladders)
import java.util.HashMap;  // For storing the Snake & Ladder positions
import java.util.Scanner;  // For taking user input

public class SnakeLadderGame {
    private static final int WINNING_POSITION = 100;
    private static final Random random = new Random();
    private static final Map<Integer, Integer> snakeLadderMap = new HashMap<>();

    static {
        // Define snakes (Head -> Tail)
        snakeLadderMap.put(99, 7);
        snakeLadderMap.put(90, 48);
        snakeLadderMap.put(75, 32);
        snakeLadderMap.put(55, 13);
        snakeLadderMap.put(40, 3);
        
        // Define ladders (Bottom -> Top)
        snakeLadderMap.put(4, 25);
        snakeLadderMap.put(23, 69);
        snakeLadderMap.put(41, 80);
        snakeLadderMap.put(63, 95);
        snakeLadderMap.put(71, 92);
    }

    private static int rollDice() {
        return random.nextInt(6) + 1; // Returns a random number between 1 and 6
    }

    private static int movePlayer(int position) {
        int diceValue = rollDice();
        int newPosition = position + diceValue;

        if (newPosition > WINNING_POSITION) {
            return position; // Stay at the same position if it exceeds 100
        }

        // Check for snake or ladder
        if (snakeLadderMap.containsKey(newPosition)) {
            newPosition = snakeLadderMap.get(newPosition);
        }

        System.out.println("Rolled: " + diceValue + " | Moved to: " + newPosition);
        return newPosition;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int player1 = 0, player2 = 0;
        boolean isPlayer1Turn = true;

        System.out.println("Welcome to Snake and Ladder Game!");

        while (player1 < WINNING_POSITION && player2 < WINNING_POSITION) {
            System.out.println("\n" + (isPlayer1Turn ? "Player 1" : "Player 2") + "'s turn. Press Enter to roll dice.");
            scanner.nextLine(); // Wait for player to press enter

            if (isPlayer1Turn) {
                player1 = movePlayer(player1);
                if (player1 == WINNING_POSITION) {
                    System.out.println("🎉 Player 1 wins! 🎉");
                    break;
                }
            } else {
                player2 = movePlayer(player2);
                if (player2 == WINNING_POSITION) {
                    System.out.println("🎉 Player 2 wins! 🎉");
                    break;
                }
            }

            isPlayer1Turn = !isPlayer1Turn; // Switch turns
        }

        scanner.close();
    }
}
