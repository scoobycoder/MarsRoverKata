package mars;

import java.util.ArrayList;

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

	public boolean move(ArrayList<RoverCommand> commands) {
		return true;
	}
	
}
