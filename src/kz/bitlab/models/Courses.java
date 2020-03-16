package kz.bitlab.models;

import javax.swing.*;

public class Courses {
    private Long id;
    private String title;
    private String description;
    private boolean visible;
    private boolean active;
    private Integer like;

    public Courses(Long id, String title, String description, boolean visible, boolean active, Integer like) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.visible = visible;
        this.active = active;
        this.like = like;
    }

    public Courses(Long id, String title, String description, Integer like) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.like = like;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

}

