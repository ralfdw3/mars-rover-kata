package br.com.google.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import br.com.google.marsrover.CardinalPoints;
import br.com.google.marsrover.Position;
import br.com.google.marsrover.Move;
import br.com.google.obstacle.Obstacle;

public class UnitTests {

	@Test
	public void ShouldMoveToTheNewLocation() {

		String commands = "M";

		Position position = new Position(CardinalPoints.N, 5, 4);

		char[] commandsArray = commands.toCharArray();

		for (char c : commandsArray) {

			position.setNextMove(c);

			Move move = new Move();

			position = move.rotate(position);
			position = move.drive(position);

		}
		
		Assertions.assertEquals("5 | 5 | N", position.getPosition());

	}
	
	@Test
	public void ShouldStayInsideTheDefinedArea() {

		String commands = "MMMMMMRMMMMMM";

		Position position = new Position(CardinalPoints.N, 9, 9);

		char[] commandsArray = commands.toCharArray();

		for (char c : commandsArray) {

			position.setNextMove(c);

			Move move = new Move();

			position = move.rotate(position);
			position = move.drive(position);

		}
		
		Assertions.assertEquals("10 | 10 | E", position.getPosition());

	}
	
	@Test
	public void ShouldStopAndDontMoveAtTheObstacle() {

		String commands = "MMM";
		
		Position position = new Position(CardinalPoints.N, 5, 4);
		Position obstacle = new Obstacle(5,5);
		List <Position> obstacles = new ArrayList<>();	
		
		obstacles.add(obstacle);
		
		char[] commandsArray = commands.toCharArray();
		
		for (char c : commandsArray) {
			
			position.setNextMove(c);
			
			Move move = new Move();
			
			position = move.rotate(position);
			position = move.driveWithObstacle(position, obstacles);
			
		}
		Assertions.assertEquals("5 | 4 | N", position.getPosition());

	}

}
