package com.sangwon.springlv3backoffice.lecture.repository;

import com.sangwon.springlv3backoffice.instructor.entity.Instructor;
import com.sangwon.springlv3backoffice.lecture.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    List<Lecture> findByInstructorOrderByCreatedAtDesc(Instructor instructor);
}
