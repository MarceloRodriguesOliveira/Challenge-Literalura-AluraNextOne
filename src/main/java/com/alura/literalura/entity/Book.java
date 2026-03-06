package com.alura.literalura.entity;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    private Long id;

    private String title;
    private String language;
    private int download_count;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(Long id, String title, String language, int download_count, Author author) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.download_count = download_count;
        this.author = author;
    }
}
