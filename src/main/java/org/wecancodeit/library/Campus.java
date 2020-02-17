package org.wecancodeit.library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Campus {

    @Id
    @GeneratedValue
    private Long id;
    private String location;

    public Campus(String location){

        this.location = location;
    }
    public Campus(){}
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
