package dev.university.springbooks.service;

import dev.university.springbooks.model.Category;
import dev.university.springbooks.repository.CategoryRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public <S extends Category> S save(S entity) {
        return categoryRepository.save(entity);
    }

    public Optional<Category> findById(Long aLong) {
        return categoryRepository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        categoryRepository.deleteById(aLong);
    }
}
