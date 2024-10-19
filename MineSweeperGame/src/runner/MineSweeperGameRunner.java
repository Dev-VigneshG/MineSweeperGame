/*
 * TITLE:Mine Sweeper Game
 * AUTHOR:VIGNESH G
 * DESCRIPTION:
 *  The main objective of this game is open the cells without clicking bomb
 *
 * PACKAGES:
 * 1)game   -contains game glasses
 * 2)runner -used to run the Game
 * 
 * CLASSES:
 * 1)MineSweeper(game)       -represents the game
 * 2)Square(game)              -represent the each cell in the board
 * 3)MineSweeperGameRunner(runner) -This Class runs the game 
 * 
 * TOOL:
 * 1)Java SE 21
 * 2)Eclipse IDE
 */
package runner;
import java.util.Scanner;
import game.MineSweeper;
public class MineSweeperGameRunner {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("********Welcome to MineSweeper!*************");
		System.out.println("Enter No of Rows& No of Columns Of The Board");
		int rows=scanner.nextInt();
		int columns=scanner.nextInt();
		MineSweeper mineSweeper =new MineSweeper(rows,columns);
		mineSweeper.createBoard();
		mineSweeper.play();
        scanner.close();
	}
}
