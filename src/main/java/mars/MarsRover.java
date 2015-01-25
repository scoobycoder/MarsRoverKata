package mars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MarsRover {

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
		BackwardMover mover = new BackwardMover(coordinates);
		coordinates = mover.move(direction);
	}

	private void forwardMovement() {
		ForwardMover mover = new ForwardMover(coordinates);
		coordinates = mover.move(direction);
	}

	private void setDirection(RoverCommand command) {
		Map<Direction, Direction> rightTurnMap = createRightTurnMap();
		Map<Direction, Direction> leftTurnMap = createLeftTurnMap();

		if (command == RoverCommand.LEFTTURN)
			direction = leftTurnMap.get(direction);
		else if (command == RoverCommand.RIGHTTURN)
			direction = rightTurnMap.get(direction);
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

}
