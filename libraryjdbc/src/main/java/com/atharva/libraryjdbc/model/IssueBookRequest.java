package com.atharva.libraryjdbc.model;

public class IssueBookRequest {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "IssueBookRequest{" +
                "id=" + id +
                '}';
    }
}
