package mars;

public class Globe {

	private int xMax;
	private int yMax;

	public Globe(int xMax, int yMax) {
		this.setxMax(xMax);
		this.yMax = yMax;
	}
	
	public int getyMax() {
		return yMax;
	}

	public void setyMax(int yMax) {
		this.yMax = yMax;
	}


	public int getxMax() {
		return xMax;
	}

	public void setxMax(int xMax) {
		this.xMax = xMax;
	}

}
