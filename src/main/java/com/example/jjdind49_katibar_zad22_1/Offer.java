package com.example.jjdind49_katibar_zad22_1;

public class Offer {
    private String name;
    private String description;
    private String photoPath;

    public Offer(String name, String description, String photoPath) {
        this.name = name;
        this.description = description;
        this.photoPath = photoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}
