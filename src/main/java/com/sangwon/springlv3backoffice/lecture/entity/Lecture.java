package com.sangwon.springlv3backoffice.lecture.entity;

import com.sangwon.springlv3backoffice.admin.entity.Admin;
import com.sangwon.springlv3backoffice.instructor.entity.Instructor;
import com.sangwon.springlv3backoffice.lecture.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Lecture(String title, String price, String description, Category category, Instructor instructor, Admin admin) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.instructor = instructor;
        this.admin = admin;
    }

    public void update(String title, String price, String description, Category category) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
    }

}
