package com.example.discover.model;

public class Post {
    private String name;

    private String Historique;

    private String Description;

    private String toDo;

    private String image;

    public Post(String name, String historique, String description, String toDo, String image) {
        this.name = name;
        Historique = historique;
        Description = description;
        this.toDo = toDo;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getHistorique() {
        return Historique;
    }

    public String getDescription() {
        return Description;
    }

    public String getToDo() {
        return toDo;
    }

    public String getImage() {
        return image;
    }
}
