package com.example.studentdemo.repository;

import com.example.studentdemo.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students,Long> {
}
