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
