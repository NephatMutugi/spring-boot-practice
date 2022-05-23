package com.kcbgroup.main.posts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kcbgroup.main.user.User;

import javax.persistence.*;

@Entity
@Table
public class Post {

    @Id
    @GeneratedValue
    @Column(insertable = false)
    private Integer id;
    @Column
    private String title;
   @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer postId) {
        this.id = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String postTitle) {
        this.title = postTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String postDesc) {
        this.description = postDesc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + id +
                ", postTitle='" + title + '\'' +
                ", postDesc='" + description + '\'' +
                '}';
    }
}
