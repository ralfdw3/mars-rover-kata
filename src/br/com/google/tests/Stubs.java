package br.com.google.tests;

import br.com.google.marsrover.moviment.CardinalPoints;
import br.com.google.marsrover.moviment.Obstacle;
import br.com.google.marsrover.moviment.Position;

import java.util.List;

public class Stubs {
    public static final String MOVE_ONE_TIME = "M";

    public static Position buildPositionN54() {
        return Position.builder()
                .cardinalPoint(CardinalPoints.N)
                .x(5)
                .y(4)
                .build();
    }

    public static Position buildPositionE45() {
        return Position.builder()
                .cardinalPoint(CardinalPoints.E)
                .x(4)
                .y(5)
                .build();
    }

    public static Position buildPositionN99() {
        return Position.builder()
                .cardinalPoint(CardinalPoints.N)
                .x(9)
                .y(9)
                .build();
    }
    public static Position buildPositionN12() {
        return Position.builder()
                .cardinalPoint(CardinalPoints.E)
                .x(3)
                .y(3)
                .build();
    }

    public static Position buildObstaclePositionN55() {
        return Position.builder()
                .x(5)
                .y(5)
                .build();
    }

    public static List<Obstacle> buildObstacles() {
        return List.of(new Obstacle(buildObstaclePositionN55(), "uma baita pedra, tchê"));
    }
}
