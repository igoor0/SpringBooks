package dev.university.springbooks.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.thymeleaf.standard.processor.StandardNonRemovableAttributeTagProcessor;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idc;
    private String description;
    @OneToMany
    @JoinColumn(name="category_idc")
    private List<Book> books;
}
