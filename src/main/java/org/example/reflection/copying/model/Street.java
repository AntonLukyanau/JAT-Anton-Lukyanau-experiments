package org.example.reflection.copying.model;

import java.util.Objects;

public class Street {

    private final String name;
    private final Integer trafficLine;
    private final Boolean leftSidewalk;
    private final Boolean rightSidewalk;

    public Street(String name, int trafficLine, boolean leftSidewalk, boolean rightSidewalk) {
        this.name = name;
        this.trafficLine = trafficLine;
        this.leftSidewalk = leftSidewalk;
        this.rightSidewalk = rightSidewalk;
    }

    public String getName() {
        return name;
    }

    public int getTrafficLine() {
        return trafficLine;
    }

    public boolean hasLeftSidewalk() {
        return leftSidewalk;
    }

    public boolean hasRightSidewalk() {
        return rightSidewalk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Street)) return false;
        Street street = (Street) o;
        return getTrafficLine() == street.getTrafficLine()
                && hasLeftSidewalk() == street.hasLeftSidewalk()
                && hasRightSidewalk() == street.hasRightSidewalk()
                && Objects.equals(getName(), street.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getTrafficLine(), hasLeftSidewalk(), hasRightSidewalk());
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", trafficLine=" + trafficLine +
                ", leftSidewalk=" + leftSidewalk +
                ", rightSidewalk=" + rightSidewalk +
                '}';
    }
}
