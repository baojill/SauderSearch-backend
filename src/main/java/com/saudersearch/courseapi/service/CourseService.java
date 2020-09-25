package com.saudersearch.courseapi.service;

import com.saudersearch.courseapi.dao.CourseDao;
import com.saudersearch.courseapi.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseDao courseDao;

    @Autowired
    public CourseService(@Qualifier("postgres") CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public int addCourse(Course course) {
        return courseDao.insertCourse(course);
    }

    public List<Course> getAllCourses() {
        return courseDao.selectAllCourses();
    }

    public Optional<Course> getCourseById(String id) {
        return courseDao.selectCourseById(id);
    }

    public int deleteCourse(String id) {
        return courseDao.deleteCourseById(id);
    }

    public int updateCourse(String id, Course newCourse) {
        return courseDao.updateCourseById(id, newCourse);
    }
}
