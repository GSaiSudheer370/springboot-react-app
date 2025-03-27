package com.example.studentdemo.service.impl;

import com.example.studentdemo.dto.StudentsDto;
import com.example.studentdemo.entity.Students;
import com.example.studentdemo.exception.ResourceNotFound;
import com.example.studentdemo.repository.StudentsRepository;
import com.example.studentdemo.service.StudentsService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentsServiceImpl implements StudentsService {

    private StudentsRepository studentsRepository;
    private ModelMapper ModelMapper;



    @Override
    public StudentsDto addDto(StudentsDto studentsDto) {

        Students students = ModelMapper.map(studentsDto, Students.class);

        Students savedStudent = studentsRepository.save(students);

        StudentsDto savedStudentDto = ModelMapper.map(savedStudent, StudentsDto.class);

        return savedStudentDto;

    }

    @Override
    public List<StudentsDto> getallDto() {
        List<Students> students = studentsRepository.findAll();
        return students.stream().map((student)-> ModelMapper.map(student,StudentsDto.class)).collect(Collectors.toList());
    }

    @Override
    public StudentsDto getById(Long id) {
        Students students = studentsRepository.findById(id).orElseThrow(()-> new ResourceNotFound("this id is not present"));
        return ModelMapper.map(students,StudentsDto.class) ;
    }

    @Override
    public StudentsDto updateStudents(Long id, StudentsDto studentsDto) {
        Students students = studentsRepository.findById(id).orElseThrow(()-> new ResourceNotFound("this id is not present"));
        students.setFirstName(studentsDto.getFirstName());
        students.setLastName(studentsDto.getLastName());
        students.setCourse(studentsDto.getCourse());
        students.setAddress(students.getAddress());
        students.setBatch(studentsDto.getBatch());
        Students changed = studentsRepository.save(students);
        return ModelMapper.map(changed,StudentsDto.class);
    }

    @Override
    public void deleteStudents(Long id) {
        Students students = studentsRepository.findById(id).orElseThrow(()->new ResourceNotFound("this id is not present"));
        studentsRepository.deleteById(id);

    }


}
