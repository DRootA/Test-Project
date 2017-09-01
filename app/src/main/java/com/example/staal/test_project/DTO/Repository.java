package com.example.staal.test_project.DTO;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Repository {

    @SerializedName("id")
    public int id;
    @SerializedName("name")
    private String name;
    @SerializedName("full_name")
    private String full_name;
    @SerializedName("description")
    private String description;
    @SerializedName("stargazers_count")
    private int stargazers_count;
    @SerializedName("forks_count")
    private int forks_count;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getDescription() {
        return description;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public int getForks_count() {
        return forks_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Repository that = (Repository) o;

        if (id != that.id) return false;
        if (stargazers_count != that.stargazers_count) return false;
        if (forks_count != that.forks_count) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (full_name != null ? !full_name.equals(that.full_name) : that.full_name != null)
            return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (full_name != null ? full_name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + stargazers_count;
        result = 31 * result + forks_count;
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }


}
