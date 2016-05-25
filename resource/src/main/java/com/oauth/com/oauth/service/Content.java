package com.oauth.com.oauth.service;

import java.io.Serializable;

public class Content implements Serializable {

    private String owner;

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content content = (Content) o;
        if (owner != null ? !owner.equals(content.owner) : content.owner != null) return false;
        return text != null ? text.equals(content.text) : content.text == null;
    }

    @Override
    public int hashCode() {
        int result = owner != null ? owner.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Content{" +
                "owner='" + owner + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
