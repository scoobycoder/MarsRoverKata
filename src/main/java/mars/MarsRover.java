package mars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MarsRover {

	private static final int MOVE_WEST = -1;
	private static final int MOVE_EAST = 1;
	private static final int MOVE_NORTH = 1;
	private static final int MOVE_SOUTH = -1;
	private static final int NO_MOVE = 0;
	private Coordinates coordinates;
	private Direction direction;

	public MarsRover(Coordinates startCoordinates, Direction startDirection) {
		coordinates = startCoordinates;
		direction = startDirection;
	}

	public boolean alive() {
		return true;
	}

	public Coordinates move(ArrayList<RoverCommand> commands) {
		for (RoverCommand command : commands) {
			setDirection(command);
			moveDirection(command);
		}

		return coordinates;
	}

	private void moveDirection(RoverCommand command) {
		if (forwardCommand(command))
			forwardMovement();
		else if (backwardCommand(command))
			backwardMovement();
	}

	private boolean backwardCommand(RoverCommand command) {
		return command == RoverCommand.BACKWARD;
	}

	private boolean forwardCommand(RoverCommand command) {
		return command == RoverCommand.FORWARD;
	}

	private void backwardMovement() {
		if (north()) {
			coordinates = createNewCoordinates(NO_MOVE, MOVE_SOUTH);
		} else if (west()) {
			coordinates = createNewCoordinates(MOVE_EAST, NO_MOVE);
		} else if (east()) {
			coordinates = createNewCoordinates(MOVE_WEST, NO_MOVE);
		} else
			coordinates = createNewCoordinates(NO_MOVE, MOVE_NORTH);
	}

	private void forwardMovement() {
		if (north())
			coordinates = createNewCoordinates(NO_MOVE, MOVE_NORTH);
		else if (south())
			coordinates = createNewCoordinates(NO_MOVE, MOVE_SOUTH);
		else if (east())
			coordinates = createNewCoordinates(MOVE_EAST, NO_MOVE);
		else
			coordinates = createNewCoordinates(MOVE_WEST, NO_MOVE);
	}

	private void setDirection(RoverCommand command) {
		Map<Direction, Direction> rightTurnMap = createRightTurnMap();
		Map<Direction, Direction> leftTurnMap = createLeftTurnMap();

		if (command == RoverCommand.LEFTTURN)
			direction = leftTurnMap.get(direction);
		else if (command == RoverCommand.RIGHTTURN)
			direction = rightTurnMap.get(direction);
	}

	private Coordinates createNewCoordinates(int adjustX, int adjustY) {
		return new Coordinates(coordinates.getX() + adjustX, coordinates.getY()
				+ adjustY);
	}

	private Map<Direction, Direction> createLeftTurnMap() {
		Map<Direction, Direction> leftTurnMap = new HashMap<Direction, Direction>();
		leftTurnMap.put(Direction.NORTH, Direction.WEST);
		leftTurnMap.put(Direction.WEST, Direction.SOUTH);
		leftTurnMap.put(Direction.SOUTH, Direction.EAST);
		leftTurnMap.put(Direction.EAST, Direction.NORTH);
		return leftTurnMap;
	}

	private Map<Direction, Direction> createRightTurnMap() {
		Map<Direction, Direction> rightTurnMap = new HashMap<Direction, Direction>();
		rightTurnMap.put(Direction.NORTH, Direction.EAST);
		rightTurnMap.put(Direction.EAST, Direction.SOUTH);
		rightTurnMap.put(Direction.SOUTH, Direction.WEST);
		rightTurnMap.put(Direction.WEST, Direction.NORTH);
		return rightTurnMap;
	}

	private boolean east() {
		return direction.equals(Direction.EAST);
	}

	private boolean west() {
		return direction.equals(Direction.WEST);
	}

	private boolean north() {
		return direction.equals(Direction.NORTH);
	}

	private boolean south() {
		return direction.equals(Direction.SOUTH);
	}

}
