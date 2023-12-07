package dev.university.springbooks.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idb;
    private String title;

    @ManyToOne
    private Publisher publisher;

    @ManyToOne
    private Category category;

    @OneToMany
    @JoinColumn(name="publisher_idp")
    private List<Book> books;

}