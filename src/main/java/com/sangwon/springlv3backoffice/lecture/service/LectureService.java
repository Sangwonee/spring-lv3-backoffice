package com.sangwon.springlv3backoffice.lecture.service;

import com.sangwon.springlv3backoffice.admin.entity.Admin;
import com.sangwon.springlv3backoffice.admin.repository.AdminRepository;
import com.sangwon.springlv3backoffice.exception.BusinessLogicException;
import com.sangwon.springlv3backoffice.exception.ExceptionCode;
import com.sangwon.springlv3backoffice.instructor.entity.Instructor;
import com.sangwon.springlv3backoffice.instructor.repository.InstructorRepository;
import com.sangwon.springlv3backoffice.lecture.dto.LectureRegisterDto;
import com.sangwon.springlv3backoffice.lecture.dto.LectureRegisterResponseDto;
import com.sangwon.springlv3backoffice.lecture.dto.LectureUpdateDto;
import com.sangwon.springlv3backoffice.lecture.dto.LectureUpdateResponseDto;
import com.sangwon.springlv3backoffice.lecture.entity.Lecture;
import com.sangwon.springlv3backoffice.lecture.enums.Category;
import com.sangwon.springlv3backoffice.lecture.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;
    private final InstructorRepository instructorRepository;
    private final AdminRepository adminRepository;

    @Transactional
    public LectureRegisterResponseDto registerLecture(LectureRegisterDto lectureRegisterDto, String email) {
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.ADMIN_NOT_FOUND));

        Instructor instructor = instructorRepository.findById(lectureRegisterDto.getInstructorId())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.INSTRUCTOR_NOT_FOUND));

        Lecture lecture = lectureRegisterDto.toEntity(instructor, admin);

        Lecture savedLecture = lectureRepository.save(lecture);

        return new LectureRegisterResponseDto(savedLecture);
    }

    @Transactional
    public LectureUpdateResponseDto updateLecture(Long id, LectureUpdateDto lectureUpdateDto) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.LECTURE_NOT_FOUND));

        lecture.update(
                lectureUpdateDto.getTitle(),
                lectureUpdateDto.getPrice(),
                lectureUpdateDto.getDescription(),
                lectureUpdateDto.getCategory()
        );

        Lecture updatedLecture = lectureRepository.save(lecture);

        return new LectureUpdateResponseDto(updatedLecture);
    }

    @Transactional(readOnly = true)
    public LectureRegisterResponseDto getLecture(Long id) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.LECTURE_NOT_FOUND));
        return new LectureRegisterResponseDto(lecture);
    }


    @Transactional(readOnly = true)
    public List<LectureRegisterResponseDto> getLecturesByCategory(Category category) {
        return lectureRepository.findAll().stream()
                .filter(lecture -> lecture.getCategory().equals(category))
                .map(LectureRegisterResponseDto::new).toList();
    }

    @Transactional(readOnly = true)
    public List<LectureRegisterResponseDto> getLecturesByInstructor(Long instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.INSTRUCTOR_NOT_FOUND));
        return lectureRepository.findByInstructorOrderByCreatedAtDesc(instructor).stream()
                .map(LectureRegisterResponseDto::new).toList();
    }


    @Transactional
    public void deleteLecture(Long id) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.LECTURE_NOT_FOUND));
        lectureRepository.delete(lecture);
    }
}
