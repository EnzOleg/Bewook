package com.example.beewook.repository;

import com.example.beewook.model.Startup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StartupRepository extends JpaRepository<Startup, Long> {
    List<Startup> findByUserId(Long userId);

    @Query(value = "SELECT * FROM startups ORDER BY RANDOM() LIMIT :count", nativeQuery = true)
    List<Startup> findRandomStartups(@Param("count") int count);

}
