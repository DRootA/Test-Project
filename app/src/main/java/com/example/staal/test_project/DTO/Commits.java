package com.example.staal.test_project.DTO;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Commits {

    @SerializedName("commit")
    private Commit commit;

    private Commit getCommit() {
        return commit;
    }

    public String getNameAuthor(){
        return getCommit().getAuthor().getName();
    }

    public String getDateAdd(){
        return getCommit().getAuthor().getDate();
    }

    public String message(){
        return getCommit().getMessage();
    }

    public class Author {
        @SerializedName("name")
        private String name;
        @SerializedName("date")
        String date;

        public String getName() {
            return name;
        }

        String getDate() {
            return date;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Author author = (Author) o;

            if (name != null ? !name.equals(author.name) : author.name != null) return false;
            return date != null ? date.equals(author.date) : author.date == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (date != null ? date.hashCode() : 0);
            return result;
        }
    }

    public class Commit {
        @SerializedName("author")
        Author author;
        @SerializedName("message")
        String message;

        Author getAuthor() {
            return author;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Commit commit = (Commit) o;

            if (author != null ? !author.equals(commit.author) : commit.author != null)
                return false;
            return message != null ? message.equals(commit.message) : commit.message == null;
        }

        @Override
        public int hashCode() {
            int result = author != null ? author.hashCode() : 0;
            result = 31 * result + (message != null ? message.hashCode() : 0);
            return result;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commits commits = (Commits) o;

        return commit != null ? commit.equals(commits.commit) : commits.commit == null;
    }

    @Override
    public int hashCode() {
        return commit != null ? commit.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.valueOf(0);
    }
}
