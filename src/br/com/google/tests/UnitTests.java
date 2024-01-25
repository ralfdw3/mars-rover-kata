package br.com.google.tests;

import br.com.google.marsrover.moviment.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitTests {

    private final CommandRunner commandRunner = new CommandRunner();

    @Test
    public void ShouldMoveToTheNewLocation() {
        String commands = "M";

        Position position = Position.builder()
                .cardinalPoint(CardinalPoints.N)
                .x(5)
                .y(4)
                .build();

        String finalPosition = commandRunner.runCommands(position, List.of(), commands);

        assertEquals("5 | 5 | N", finalPosition);
    }

    @Test
    public void ShouldStayInsideTheDefinedArea() {
        String commands = "MMMMMMRMMMMMM";

        Position position = Position.builder()
                .cardinalPoint(CardinalPoints.N)
                .x(9)
                .y(9)
                .build();

        String finalPosition = commandRunner.runCommands(position, List.of(), commands);

        assertEquals("10 | 10 | E", finalPosition);
    }

    @Test
    public void ShouldStopAndDontMoveAtTheObstacle() {
        String commands = "MMM";

        Position position = Position.builder()
                .cardinalPoint(CardinalPoints.N)
                .x(5)
                .y(4)
                .build();

        Position positionObstacle = Position.builder()
                .x(5)
                .y(5)
                .build();

        List<Obstacle> obstacle = List.of(new Obstacle(positionObstacle, "uma baita pedra, tchê"));

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> commandRunner.runCommands(position, obstacle, commands));
        assertEquals("Unable to move because there is and obstacle: uma baita pedra, tchê", exception.getMessage());
    }
}
