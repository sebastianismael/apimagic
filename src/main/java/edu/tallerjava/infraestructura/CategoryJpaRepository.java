package edu.tallerjava.infraestructura;

import edu.tallerjava.dominio.modelo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryJpaRepository extends JpaRepository<Category, Long>, CustomizedCategoryRepository {

    @Query("from Category where nombre = ?1")
    List<Category> findByName(String name);
}
