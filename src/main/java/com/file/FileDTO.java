package com.file;

import lombok.Getter;

@Getter
public class FileDTO {
    private String name;
    private String title;
    private String image;
/*
    public FileDTO(String name, String title, String image) {
        this.name = name;
        this.title = title;
        this.image = image;
    }

    public String getName() {
        return (name == null) ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return (title == null) ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return (image == null) ? "" : image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public FileDTO() {
    }*/
}
