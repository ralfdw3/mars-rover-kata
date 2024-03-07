package br.com.google.marsrover.movement;

import java.util.List;

public class CommandRunner {

    private final Movement movement = new Movement();

    public String runCommands(Position position, List<Obstacle> obstacles, String commands) {
        List<Character> commandList = commands.chars()
                .mapToObj(c -> (char) c)
                .toList();

        for (char command : commandList) {
            switch (command) {
                case 'R' -> movement.rotateToRight(position);
                case 'L' -> movement.rotateToLeft(position);
                case 'M' -> movement.moveRover(position, obstacles);
            }
        }
        return position.printPosition();
    }
}
