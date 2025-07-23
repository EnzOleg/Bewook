package com.example.beewook.repository;

import com.example.beewook.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    List<Resume> findTop10ByOrderByIdDesc();

    @Query(value = "SELECT * FROM resumes ORDER BY RANDOM() LIMIT :count", nativeQuery = true)
    List<Resume> findRandomResumes(@Param("count") int count);

    List<Resume> findByUserId(Long userId);
}