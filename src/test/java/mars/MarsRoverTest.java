package mars;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MarsRoverTest {

	private MarsRover rover;
	private ArrayList<RoverCommand> commands;
	
	private void newCoordinatesCorrect(Coordinates expectedCoordinates,
			Coordinates actualCoordinates) {
		assertEquals(expectedCoordinates.getX(), actualCoordinates.getX());
		assertEquals(expectedCoordinates.getY(), actualCoordinates.getY());
	}
	
	private void moveForward() {
		commands.add(RoverCommand.FORWARD);
	}
	
	private void turnLeft() {
		commands.add(RoverCommand.LEFTTURN);
	}
	
	private void turnRight() {
		commands.add(RoverCommand.RIGHTTURN);
	}
	
	@Before
	public void setup() {
		Coordinates startCoordinates = new Coordinates(0,0);
		rover = new MarsRover(startCoordinates, Direction.NORTH);
		commands = new ArrayList<RoverCommand>();
	}
	
	@Test
	public void roverShouldTakeInitialCoordinates() {
		assertEquals(true, rover.alive());
	}

	@Test
	public void roverShouldReceiveOneCommandAndReportCoordinates() {
		moveForward();
		Coordinates expectedCoordinates = new Coordinates(0,1);

		Coordinates actualCoordinates = rover.move(commands);
		
		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}
	
	@Test
	public void roverShouldTurnLeftAndReportCoordinates() {
		turnLeft();
		Coordinates expectedCoordinates = new Coordinates(0,0);
		
		Coordinates actualCoordinates = rover.move(commands);
		
		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}
	
	@Test
	public void roverShouldTurnLeftMoveForwardAndReportCoordinates() {
		turnLeft();
		moveForward();
		Coordinates expectedCoordinates = new Coordinates(-1,0);
		
		Coordinates actualCoordinates = rover.move(commands);

		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}
	
	@Test
	public void roverShouldTurnRightMoveForwardAndReportCoordinates() {
		turnRight();
		moveForward();
		Coordinates expectedCoordinates = new Coordinates(1,0);

		Coordinates actualCoordinates = rover.move(commands);

		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}

}
