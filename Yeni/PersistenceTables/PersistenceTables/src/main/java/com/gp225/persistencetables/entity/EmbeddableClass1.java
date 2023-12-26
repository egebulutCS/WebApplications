package com.gp225.persistencetables.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class EmbeddableClass1 implements Serializable {

    String string1;
    int int1;

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public int getInt1() {
        return int1;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }

}
