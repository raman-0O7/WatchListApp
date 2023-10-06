package com.example.CRUDWebApp.WachlistApp.model;

//import jakarta.annotation.Priority;
import com.example.CRUDWebApp.WachlistApp.model.annotations.Comments;
import com.example.CRUDWebApp.WachlistApp.model.annotations.Priority;
import com.example.CRUDWebApp.WachlistApp.model.annotations.Rating;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.Comment;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "Title should br filled")
    private String title;
    @Priority
    private String priority;
    @Rating
    private double rating;
    @Comments
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
