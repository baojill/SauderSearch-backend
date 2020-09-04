package com.saudersearch.courseapi.dao;

import com.saudersearch.courseapi.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseDao {

    int insertCourse(Course course);

    default int addCourse(Course course) {
        return insertCourse(course);
    }

    List<Course> selectAllCourses();

    Optional<Course> selectCourseById(String id);

    int deleteCourseById(String id);

    int updateCourseById(String id, Course course);
}
