package ru.netology.sqlfirst.service;

import ru.netology.sqlfirst.repository.AppRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppService {
    private final AppRepository repository;
    public AppService(AppRepository repository) {this.repository = repository;}

    public List<String> getProduct(String name) {
        return repository.getProduct(name);
    }
}