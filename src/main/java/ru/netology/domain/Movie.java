package ru.netology.domain;

public class Movie {
    private String id;
    private String imageUrl;
    private String name;
    private String genre;

    public Movie(String id, String imageUrl, String name, String genre) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}