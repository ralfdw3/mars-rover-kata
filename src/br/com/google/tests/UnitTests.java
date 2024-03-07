package br.com.google.tests;

import br.com.google.marsrover.movement.CommandRunner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static br.com.google.tests.Stubs.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitTests {

    private final CommandRunner commandRunner = new CommandRunner();

    @Test
    public void ShouldMoveHorizontallyWithSuccess() {
        String finalPosition = commandRunner.runCommands(buildPositionN54(), List.of(), MOVE_ONE_TIME);

        assertEquals("5 | 5 | N", finalPosition);
    }

    @Test
    public void ShouldMoveVerticallyWithSuccess() {
        String finalPosition = commandRunner.runCommands(buildPositionE45(), List.of(), MOVE_ONE_TIME);

        assertEquals("5 | 5 | E", finalPosition);
    }

    @Test
    public void ShouldMoveSuccessfully() {
        String finalPosition = commandRunner.runCommands(buildPositionN12(), List.of(), "MMRMMRMRRM");

        assertEquals("5 | 1 | E", finalPosition);
    }

    @Test
    public void ShouldStayInsideTheDefinedArea() {
        String finalPosition = commandRunner.runCommands(buildPositionN99(), List.of(), "MMMMMMRMMMMMM");

        assertEquals("10 | 10 | E", finalPosition);
    }

    @Test
    public void ShouldStopAndDontMoveAtTheObstacle() {
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> commandRunner.runCommands(buildPositionN54(), buildObstacles(), "MMM"));
        assertEquals("Unable to move because there is and obstacle: uma baita pedra, tchê", exception.getMessage());
    }
}
