package dev.university.springbooks.service;

import dev.university.springbooks.model.Book;
import dev.university.springbooks.repository.BookRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@NoArgsConstructor
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findByOrderByIdbDesc();
    }

    public <S extends Book> S save(S entity) {
        return bookRepository.save(entity);
    }

    public Optional<Book> findById(Long aLong) {
        return bookRepository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        bookRepository.deleteById(aLong);
    }
}
