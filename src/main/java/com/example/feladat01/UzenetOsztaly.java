package com.example.feladat01;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class UzenetOsztaly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Min(2)
    private long id;
    @NotNull
    @Size(min=2, max=30)

    private String content;


    private LocalDateTime elkuldve;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getElkuldve() {
        return elkuldve;
    }

    public void setElkuldve(LocalDateTime elkuldve) {
        this.elkuldve = elkuldve;
    }
}
