
package triviaGame;
import java.io.PrintStream;
import java.util.Random;



public class GameRunner {

	private static boolean notAWinner;

//	public static void main(String[] args) {
//		Random rand = new Random();
//		run(rand, System.out);
//	}

	public static void run(Random rand, PrintStream out) {
		Game aGame = new Game(out);
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");
		do {
			aGame.roll(rand.nextInt(5) + 1);
			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}
		} while (notAWinner);
	}

	public static void runAThousandGames(PrintStream out) {
		Random rand = new Random(7919);
		for (int i = 0; i < 1000; i++)
			GameRunner.run(rand, out);
	}
}
