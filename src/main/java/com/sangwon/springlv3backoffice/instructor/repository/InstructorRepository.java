package com.sangwon.springlv3backoffice.instructor.repository;

import com.sangwon.springlv3backoffice.instructor.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
