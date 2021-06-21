package ru.geekbrains.spring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.model.Student;
import ru.geekbrains.spring.repositories.StudentInMemoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentInMemoryRepository studentInMemoryRepository;

    public Optional<Student> findById(Long id) {
        return studentInMemoryRepository.findById(id);
    }

    public List<Student> findAll() {
        return studentInMemoryRepository.findAll();
    }

    public Student saveOrUpdate(Student s) {
        return studentInMemoryRepository.saveOrUpdate(s);
    }

    public void deleteBydId(Long id) {
        studentInMemoryRepository.deleteById(id);
    }
}
