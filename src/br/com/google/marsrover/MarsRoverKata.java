package br.com.google.marsrover;

import br.com.google.marsrover.moviment.CardinalPoints;
import br.com.google.marsrover.moviment.CommandRunner;
import br.com.google.marsrover.moviment.Position;

import java.util.List;
public class MarsRoverKata {
    public static void main(String[] args) {
        String commands = "M";

        Position position = Position.builder()
                .cardinalPoint(CardinalPoints.N)
                .x(5)
                .y(4)
                .build();

        String finalPosition = new CommandRunner().runCommands(position, List.of(), commands);
        System.out.println(finalPosition);
    }
}
