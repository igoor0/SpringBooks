package dev.university.springbooks.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idp;
    private String name;
    private String address;
    @OneToMany
    @JoinColumn(name="publisher_idp")
    private List<Book> books;
}
