package dev.university.springbooks.service;

import dev.university.springbooks.model.Publisher;
import dev.university.springbooks.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    public <S extends Publisher> S save(S entity) {
        return publisherRepository.save(entity);
    }

    public Optional<Publisher> findById(Long aLong) {
        return publisherRepository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        publisherRepository.deleteById(aLong);
    }
}
