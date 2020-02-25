package org.wecancodeit.library.models;

import org.hibernate.annotations.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HashTag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    protected HashTag(){}
    public HashTag(String name) {

        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
