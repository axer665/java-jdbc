package ru.netology.sqlfirst.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;
import ru.netology.sqlfirst.entity.Customer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Repository
public class AppRepository {
    private final String QUERY_RESOURCE_FILE = "select.sql";
    private String query;

    @PersistenceContext
    private EntityManager entityManager;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    AppRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @PostConstruct
    public void readQueryFromResourceFile() throws IOException {
        File resource = new ClassPathResource(QUERY_RESOURCE_FILE).getFile();
        query = new String(Files.readAllBytes(resource.toPath()));
    }

    public List<String> getProduct(String name) {
        return entityManager
                .createQuery(query, String.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Customer> getAllCustomers() {
        return entityManager
                .createQuery("select c from Customer c", Customer.class)
                .getResultList();
    }
}
