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
		rover = new MarsRover(0, 0, Direction.NORTH);
		commands = new ArrayList<RoverCommand>();
	}
	
	@Test
	public void roverShouldTakeInitialCoordinates() {
		assertEquals(true, rover.alive());
	}

	@Test
	public void roverShouldReceiveOneCommandAndReportItMoved() {
		commands.add(RoverCommand.FORWARD);
		assertEquals(true, rover.move(commands));
	}
	
	@Test @Ignore
	public void roverShouldTurnLeftAndReportSuccess() {
		
	}

}
