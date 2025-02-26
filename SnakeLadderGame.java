

public class SnakeLadderGame {
 private static final int WINNING_POSITION = 100;
    private static final Random random = new Random();
    private static final Map<Integer, Integer> board = Map.of(99, 7, 90, 48, 75, 32, 55, 13, 40, 3, 4, 25, 23, 69, 41, 80, 63, 95, 71, 92);

    private static int rollDice() { return random.nextInt(6) + 1; }

    private static int move(int pos) {
        int newPos = pos + rollDice();
        return (newPos > WINNING_POSITION) ? pos : board.getOrDefault(newPos, newPos);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] players = {0, 0};
        int turn = 0;

        System.out.println("🎲 Welcome to Snake and Ladder Game!");

        while (true) {
            System.out.println("\nPlayer " + (turn + 1) + "'s turn. Press Enter to roll dice.");
            sc.nextLine();
            players[turn] = move(players[turn]);
            System.out.println("Moved to: " + players[turn]);

            if (players[turn] == WINNING_POSITION) {
                System.out.println("🎉 Player " + (turn + 1) + " wins! 🎉");
                break;
            }
            turn = 1 - turn; // Switch player
        }
        sc.close();
    }
}
    
       
     
}
