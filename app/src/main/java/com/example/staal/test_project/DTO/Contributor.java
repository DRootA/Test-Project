package com.example.staal.test_project.DTO;


import com.google.gson.annotations.SerializedName;

public class Contributor {

    @SerializedName("login")
    private String login;
    @SerializedName("id")
    private int id;
    @SerializedName("avatar_url")
    private String avatar_url;
    @SerializedName("url")
    private String url;

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contributor that = (Contributor) o;

        if (id != that.id) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (avatar_url != null ? !avatar_url.equals(that.avatar_url) : that.avatar_url != null)
            return false;
        return url != null ? url.equals(that.url) : that.url == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (avatar_url != null ? avatar_url.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
