package com.example.testdauvao.repositories;

import com.example.testdauvao.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CateRepository extends JpaRepository<Category,Long> {
}
