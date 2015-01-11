package mars;

public class MarsRover {

	private int x;
	private int y;

	public MarsRover(int x_coord, int y_coord, Direction direction) {
		this.x = x_coord;
		this.y = y_coord;
	}

	public boolean alive() {
		return true;
	}

	public boolean move(String[] commands) {
		if (commands[0] == null || commands[0].equals(""))
			return false;
		
		return true;
	}
	
}
