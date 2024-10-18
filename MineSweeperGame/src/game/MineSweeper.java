package game;
import java.util.Random;
import java.util.Scanner;
public class MineSweeper {
	private int columns;
	private int rows;
	private Square[][] board;
	private int score=0;
	private Scanner scanner;
	private boolean isGameOver=false;
	private int numberOfBombs;
	private Random random;
	public MineSweeper(int rows,int columns)
	{
		this.rows=rows;
		this.columns=columns;
		scanner=new Scanner(System.in);
		random=new Random();
	}

	public int getNumberOfBombs() {
		return numberOfBombs;
	}
	public void setNumberOfBombs(int numberOfBombs) {
		this.numberOfBombs=numberOfBombs;
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}

	public void createBoard()
	{
		board=new Square[rows][columns];
		for(int row=0;row<rows;row++)
		{
			for(int column=0;column<columns;column++)
			{
				board[row][column]=new Square(0,"not reveal");
			}
		}
		System.out.println("Enter Row & Column to open :");
		int r=scanner.nextInt();
		int c=scanner.nextInt();
		System.out.println("Enter No of Bombs");
		int noOfBombs=scanner.nextInt();
		setNumberOfBombs(noOfBombs);
		int bomb=0;
		while(bomb<getNumberOfBombs())
		{
			int row=random.nextInt(rows);
			int col=random.nextInt(columns);
			if(row==r&&col==c)
			{
				continue;
			}
			if(isValid(row,col)&&board[row][col].getValue()!=-1)
			{
				if(setBomb(row, col))
					bomb++;
			}
		}
		reveal(r,c);


	}
	public boolean isValid(int row,int column)
	{
		if(row>=0&&column>=0&&row<rows&&column<columns)
			return true;
		return false;
	}

	public void play()
	{
		while(!isGameOver()&&!isWin())
		{
			display();
			System.out.println("Enter Row & column :");
			int r=scanner.nextInt();
			int c=scanner.nextInt();
			System.out.println("Enter Your Choice :");
			System.out.println("1.Set/Remove Flag");
			System.out.println("2.Reveal");
			int choice=scanner.nextInt();
			if(choice==1)
			{
				toggleFlag(r,c);

			}
			else if(choice==2)
			{
				reveal(r,c);
			}
		}
		if(isGameOver())
		{
			System.out.println("Game over!");
			System.out.print("Score:"+getScore());
		}
		else if(isWin())
		{
			System.out.println("Congrats!.You win the game!!");
			System.out.print("Score:"+getScore());
		}

	}
	public void revealAdjacent(int row,int column)
	{
		if(isValid(row,column)&&board[row][column].getValue()>0&&board[row][column].getStatus()=="not reveal") 
		{
			board[row][column].setStatus("reveal");
			score++;
			return;}
		if(isValid(row,column)&&(board[row][column].getStatus()=="not reveal")&&(board[row][column].getValue()==0))
		{
			board[row][column].setStatus("reveal");
			score++;
			for(int i=row-1;i<=row+1;i++)
			{
				for(int j=column-1;j<=column+1;j++)
				{
					if(i==row&&j==column) continue;
					revealAdjacent(i,j);		
				}
			}
		}
	}
	public void reveal(int row,int column)
	{
		if(!isValid(row,column))
		{
			System.out.print("Invalid Row and column");
		}
		else if(isValid(row,column)&&isBomb(row,column))
		{
			setGameOver(true);
		}
		else if(isValid(row,column)&&board[row][column].getStatus()!="reveal")
		{
			if(board[row][column].getValue()==0)
			{
				revealAdjacent(row,column);
			}
			board[row][column].setStatus("reveal"); 
			setScore(getScore()+1);
		}

		else
		{
			System.out.println("Already Revealed");
		}
	}
	public void toggleFlag(int r,int c)
	{
		board[r][c].isFlag=!board[r][c].isFlag;
	}
	public void display()
	{
		for(int row=0;row<rows;row++)
		{
			for(int column=0;column<columns;column++)
			{
				System.out.print(board[row][column]+" ");
			}
			System.out.println();
		}
	}
	public boolean setBomb(int row,int column)
	{
		if(isValid(row,column)&&board[row][column].value!=-1)
		{
			board[row][column]=new Square(-1,"reveal");
			for(int i=row-1;i<=row+1;i++)
			{
				for(int j=column-1;j<=column+1;j++)
				{
					if(isValid(i,j)&&board[i][j].value!=-1)
					{
						board[i][j].setValue(board[i][j].getValue()+1);
					}
				}
			}
		}
		else 
		{
			System.out.println("Invalid Row or Column or Already Seted");
			return false;
		}
		return true;
	}

	public boolean isBomb(int row,int column)
	{
		if(board[row][column].getValue()==-1)
			return true;
		return false;
	}
	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public boolean isWin()
	{
		if((getScore()+getNumberOfBombs())==(getRows()*getColumns()))
		{
			return true;
		}
		return false;
	}
}
