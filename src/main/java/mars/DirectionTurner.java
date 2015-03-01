package mars;

import java.util.HashMap;
import java.util.Map;

public class DirectionTurner implements Turner {

	@Override
	public Direction turn(RoverCommand command, Direction direction) {
		Map<Direction, Direction> rightTurnMap = createRightTurnMap();
		Map<Direction, Direction> leftTurnMap = createLeftTurnMap();

		if (isLeftTurn(command))
			direction = leftTurnMap.get(direction);
		else if (isRightTurn(command))
			direction = rightTurnMap.get(direction);
		
		return direction;
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
	
	private boolean isRightTurn(RoverCommand command) {
		return command == RoverCommand.RIGHTTURN;
	}

	private boolean isLeftTurn(RoverCommand command) {
		return command == RoverCommand.LEFTTURN;
	}
	
}
