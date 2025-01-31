package game;

public class Square {
	//value - 0(Empty)
	//value - -1(bomb)
	//value - >0(Count the bomb around the cell
	int value;   
	String status;//reveal or not
	boolean isFlag=false; //set flag or not
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean getIsFlag() {
		return isFlag;
	}

	public void setIsFlag(boolean isFlag) {
		this.isFlag = isFlag;
	}
   
	public Square(int value, String status) {
		super();
		this.value = value;
		this.status = status;
	}

	public String toString() {
		if(isFlag) return "F ";
		if(status!="not reveal")
		{
			if(value==-1) return "B ";
			return String.valueOf(value+" ");
		}
		else
		{
			return "X ";
		}
	}
	
}
