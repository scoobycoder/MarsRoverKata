package mars;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarsRoverTest {

	@Test
	public void roverShouldTakeInitialCoordinates() {
		
		MarsRover rover = new MarsRover(0,0);
		
		assertEquals(true, rover.alive());
	}
	
}
