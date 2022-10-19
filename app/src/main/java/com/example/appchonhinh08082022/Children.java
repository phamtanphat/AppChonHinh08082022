package com.example.appchonhinh08082022;

import java.io.Serializable;

/**
 * Created by pphat on 10/19/2022.
 */
public class Children implements Serializable {
    String name;
    String age;

    public Children(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
