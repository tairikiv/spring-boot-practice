package com.example.springbootpractice.services.implementations;

import com.example.springbootpractice.models.City;
import com.example.springbootpractice.models.Student;
import com.example.springbootpractice.repositories.StudentRepository;
import com.example.springbootpractice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllStudentsByCity(City city) {
        return studentRepository.findAllByCity(city);
    }

    @Override
    public void crateStudent(Student student) {
        student.setActive(true);
        studentRepository.save(student);

    }
}
