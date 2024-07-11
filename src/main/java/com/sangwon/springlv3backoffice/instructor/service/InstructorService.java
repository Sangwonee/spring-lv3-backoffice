package com.sangwon.springlv3backoffice.instructor.service;

import com.sangwon.springlv3backoffice.admin.entity.Admin;
import com.sangwon.springlv3backoffice.admin.repository.AdminRepository;
import com.sangwon.springlv3backoffice.exception.BusinessLogicException;
import com.sangwon.springlv3backoffice.exception.ExceptionCode;
import com.sangwon.springlv3backoffice.instructor.dto.InstructorRegisterDto;
import com.sangwon.springlv3backoffice.instructor.dto.InstructorRegisterResponseDto;
import com.sangwon.springlv3backoffice.instructor.dto.InstructorUpdateDto;
import com.sangwon.springlv3backoffice.instructor.dto.InstructorUpdateResponseDto;
import com.sangwon.springlv3backoffice.instructor.entity.Instructor;
import com.sangwon.springlv3backoffice.instructor.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InstructorService {
    private final InstructorRepository instructorRepository;
    private final AdminRepository adminRepository;
    @Transactional
    public InstructorRegisterResponseDto registerInstructor(InstructorRegisterDto instructorRegisterDto, String email) {
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("관리자를 찾을 수 없습니다."));

        Instructor instructor = instructorRegisterDto.toEntity(admin);

        Instructor savedInstructor = instructorRepository.save(instructor);

        return new InstructorRegisterResponseDto(savedInstructor);
    }

    @Transactional
    public InstructorUpdateResponseDto updateInstructor(Long id, InstructorUpdateDto instructorUpdateDto) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.INSTRUCTOR_NOT_FOUND));

        instructor.update(
                instructorUpdateDto.getExperienceYears(),
                instructorUpdateDto.getCompany(),
                instructorUpdateDto.getPhone(),
                instructorUpdateDto.getIntroduction()
        );
        Instructor updatedInstructor = instructorRepository.save(instructor);

        return new InstructorUpdateResponseDto(updatedInstructor);
    }

    @Transactional(readOnly = true)
    public InstructorRegisterResponseDto getInstructor(Long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.INSTRUCTOR_NOT_FOUND));
        return new InstructorRegisterResponseDto(instructor);
    }

    @Transactional
    public void deleteInstructor(Long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.INSTRUCTOR_NOT_FOUND));
        instructorRepository.delete(instructor);
    }
}
