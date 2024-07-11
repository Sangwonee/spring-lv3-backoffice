package com.sangwon.springlv3backoffice.instructor.controller;

import com.sangwon.springlv3backoffice.instructor.dto.InstructorRegisterDto;
import com.sangwon.springlv3backoffice.instructor.dto.InstructorRegisterResponseDto;
import com.sangwon.springlv3backoffice.instructor.dto.InstructorUpdateDto;
import com.sangwon.springlv3backoffice.instructor.dto.InstructorUpdateResponseDto;
import com.sangwon.springlv3backoffice.instructor.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;

    @PostMapping
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<InstructorRegisterResponseDto> registerInstructor(@RequestBody InstructorRegisterDto instructorRegisterDto, Authentication authentication) {
        String email = authentication.getName();
        InstructorRegisterResponseDto responseDto = instructorService.registerInstructor(instructorRegisterDto, email);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<InstructorUpdateResponseDto> updateInstructor(@PathVariable Long id, @RequestBody InstructorUpdateDto instructorUpdateDto) {
        InstructorUpdateResponseDto responseDto = instructorService.updateInstructor(id, instructorUpdateDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<InstructorRegisterResponseDto> getInstructor(@PathVariable Long id) {
        InstructorRegisterResponseDto responseDto = instructorService.getInstructor(id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
