package com.example.SpringBootJpaTesting.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootJpaTesting.entity.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long>{

	Optional<Employe> findByEmail(String email);
}
