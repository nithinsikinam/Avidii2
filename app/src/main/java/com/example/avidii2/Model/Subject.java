package com.example.avidii2.Model;

public class Subject {
    private String name;
    private int icon;

    public Subject(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }

    public String getSubjectName() {
        return this.name;
    }
}
