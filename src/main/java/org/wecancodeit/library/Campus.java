package org.wecancodeit.library;

import java.util.Objects;

public class Campus {
    private String location;

    public Campus(String location){

        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campus campus = (Campus) o;
        return Objects.equals(location, campus.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
