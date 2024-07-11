package com.sangwon.springlv3backoffice.instructor.entity;

import com.sangwon.springlv3backoffice.admin.entity.Admin;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer experienceYears;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String introduction;

    public Instructor(String name, Integer experienceYears, String company, String phone, String introduction, Admin admin) {
        this.name = name;
        this.experienceYears = experienceYears;
        this.company = company;
        this.phone = phone;
        this.introduction = introduction;
        this.admin = admin;
    }

    public void update(Integer experienceYears, String company, String phone, String introduction) {
        this.experienceYears = experienceYears;
        this.company = company;
        this.phone = phone;
        this.introduction = introduction;
    }
}
