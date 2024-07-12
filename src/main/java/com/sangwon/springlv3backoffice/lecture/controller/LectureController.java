package com.sangwon.springlv3backoffice.lecture.controller;

import com.sangwon.springlv3backoffice.lecture.dto.LectureRegisterDto;
import com.sangwon.springlv3backoffice.lecture.dto.LectureRegisterResponseDto;
import com.sangwon.springlv3backoffice.lecture.dto.LectureUpdateDto;
import com.sangwon.springlv3backoffice.lecture.dto.LectureUpdateResponseDto;
import com.sangwon.springlv3backoffice.lecture.enums.Category;
import com.sangwon.springlv3backoffice.lecture.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lectures")
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;

    @PostMapping
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<LectureRegisterResponseDto> registerLecture(@RequestBody LectureRegisterDto lectureRegisterDto, Authentication authentication) {
        String email = authentication.getName();
        LectureRegisterResponseDto responseDto = lectureService.registerLecture(lectureRegisterDto, email);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<LectureUpdateResponseDto> updateLecture(@PathVariable Long id, @RequestBody LectureUpdateDto lectureUpdateDto) {
        LectureUpdateResponseDto responseDto = lectureService.updateLecture(id, lectureUpdateDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<LectureRegisterResponseDto> getLecture(@PathVariable Long id) {
        LectureRegisterResponseDto responseDto = lectureService.getLecture(id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<List<LectureRegisterResponseDto>> getLecturesByCategory(@PathVariable Category category) {
        List<LectureRegisterResponseDto> responseDtoList = lectureService.getLecturesByCategory(category);
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @GetMapping("/instructor/{instructorId}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<List<LectureRegisterResponseDto>> getLecturesByInstructor(@PathVariable Long instructorId) {
        List<LectureRegisterResponseDto> responseDtoList = lectureService.getLecturesByInstructor(instructorId);
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<Void> deleteLecture(@PathVariable Long id) {
        lectureService.deleteLecture(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
