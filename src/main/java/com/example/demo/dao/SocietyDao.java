package com.example.demo.dao;

import com.example.demo.entity.Society;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocietyDao extends JpaRepository<Society, String> {
}
