package com.example.springbootpractice.services.implementations;

import com.example.springbootpractice.models.City;
import com.example.springbootpractice.models.Teacher;
import com.example.springbootpractice.repositories.TeacherRepository;
import com.example.springbootpractice.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
   @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Teacher> findAllTeachersByCity(City city) {
        return teacherRepository.findAllByCity(city);
    }

    @Override
    public void crateTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }
}
