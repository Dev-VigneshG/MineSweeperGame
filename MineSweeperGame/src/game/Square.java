package game;

public class Square {
	int value;
	String status;
	boolean isFlag=false;
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
