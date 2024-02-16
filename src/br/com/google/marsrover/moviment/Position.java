package br.com.google.marsrover.moviment;

import java.util.Objects;

public class Position {

    CardinalPoints cardinalPoint;
    int x;
    int y;

    public String printPosition() {
        return this.x + " | " + this.y + " | " + this.cardinalPoint;
    }

    public CardinalPoints getCardinalPoint() {
        return cardinalPoint;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCardinalPoint(CardinalPoints cardinalPoint) {
        this.cardinalPoint = cardinalPoint;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position(CardinalPoints cardinalPoint, int x, int y) {
        this.cardinalPoint = cardinalPoint;
        this.x = x;
        this.y = y;
    }

    public static PositionBuilder builder() {
        return new PositionBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y && cardinalPoint == position.cardinalPoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardinalPoint, x, y);
    }

    public static class PositionBuilder {
        private CardinalPoints cardinalPoint;
        private int x;
        private int y;

        private PositionBuilder() {
        }

        public PositionBuilder cardinalPoint(CardinalPoints cardinalPoint) {
            this.cardinalPoint = cardinalPoint;
            return this;
        }

        public PositionBuilder x(int x) {
            this.x = x;
            return this;
        }

        public PositionBuilder y(int y) {
            this.y = y;
            return this;
        }

        public Position build() {
            return new Position(cardinalPoint, x, y);
        }
    }
}
