package com.example.studentdemo.service;

import com.example.studentdemo.dto.StudentsDto;

import java.util.List;

public interface StudentsService  {

    StudentsDto addDto (StudentsDto studentsDto);

    List<StudentsDto> getallDto();

    StudentsDto getById(Long id);

    StudentsDto updateStudents(Long id,StudentsDto studentsDto);

    void deleteStudents(Long id);
}
