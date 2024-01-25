package br.com.google.marsrover.moviment;

import java.util.List;

public class CommandRunner {

    private final Moviment moviment = new Moviment();

    public String runCommands(Position position, List<Obstacle> obstacles, String commands) {
        List<Character> commandList = commands.chars()
                .mapToObj(c -> (char) c)
                .toList();

        for (char command : commandList) {
            switch (command) {
                case 'R' -> moviment.rotateToRight(position);
                case 'L' -> moviment.rotateToLeft(position);
                case 'M' -> moviment.moveRover(position, obstacles);
            }
        }
        return position.printPosition();
    }
}
