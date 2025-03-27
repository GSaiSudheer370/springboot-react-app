package com.example.studentdemo.controller;

import com.example.studentdemo.dto.StudentsDto;
import com.example.studentdemo.service.StudentsService;
import com.example.studentdemo.service.impl.StudentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @PostMapping
    public ResponseEntity<StudentsDto> addStudents( @RequestBody StudentsDto studentsDto){
        StudentsDto saveStudentsData = studentsService.addDto(studentsDto);
        return new ResponseEntity<>(saveStudentsData,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentsDto>> allStudents(){
        List<StudentsDto> saveAllStudents = studentsService.getallDto();
        return new ResponseEntity<>(saveAllStudents, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentsDto> getById(@PathVariable("id") Long id){
        StudentsDto ourId = studentsService.getById(id);
        return new ResponseEntity<>(ourId,HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<StudentsDto> updateStudents(@PathVariable("id") Long id,@RequestBody StudentsDto studentsDto){
        StudentsDto updated = studentsService.updateStudents(id,studentsDto);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudents(@PathVariable("id") Long id){
        studentsService.deleteStudents(id);
        return new ResponseEntity<>("id is deleted",HttpStatus.OK);
    }


}
