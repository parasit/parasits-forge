package ibu.forge.basics;

public class Attribute {
	int Value;
	int CurValue;
	
	public Attribute(int value) {
		this.Value = value;
		this.CurValue = this.Value;
	}

	public int getValue() {
		return Value;
	}

	public void setValue(int value) {
		Value = value;
	}

	public int getCurValue() {
		return CurValue;
	}

	public void setCurValue(int curValue) {
		CurValue = curValue;
	}
	
	public void addCurValue(int curValue) {
		CurValue += curValue;
	}
}
