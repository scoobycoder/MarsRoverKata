package mars;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MarsRoverTest {

	private MarsRover rover;
	private ArrayList<RoverCommand> commands;
	
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
		commands.add(RoverCommand.FORWARD);
		Coordinates expectedCoordinates = new Coordinates(0,1);

		Coordinates actualCoordinates = rover.move(commands);
		
		assertEquals(expectedCoordinates.getX(), actualCoordinates.getX());
		assertEquals(expectedCoordinates.getY(), actualCoordinates.getY());
	}
	
	@Test
	public void roverShouldTurnLeftAndReportCoordinates() {
		commands.add(RoverCommand.LEFTTURN);
		Coordinates expectedCoordinates = new Coordinates(0,0);
		
		Coordinates actualCoordinates = rover.move(commands);
		
		assertEquals(expectedCoordinates.getX(), actualCoordinates.getY());
		assertEquals(expectedCoordinates.getY(), actualCoordinates.getX());
	}
	

}
