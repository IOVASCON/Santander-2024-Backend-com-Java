package me.dio.dominio.model;

import jakarta.persistence.Entity;

@Entity(name = "tb_news")
public class News extends BaseItem {

    private String icon;
    private String description;

    // Getters and Setters
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
