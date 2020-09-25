package com.saudersearch.courseapi.dao;

import com.saudersearch.courseapi.model.Course;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository("postgres")
public class CourseDataAccessService implements CourseDao {

    @Override
    public int insertCourse(Course course) {
        return 0;
    }

    @Override
    public List<Course> selectAllCourses() {
        return Arrays.asList(new Course("COMM 101", "Business Fundamentals", 3, "none", "none", "lol"));
    }

    @Override
    public Optional<Course> selectCourseById(String id) {
        return Optional.empty();
    }

    @Override
    public int deleteCourseById(String id) {
        return 0;
    }

    @Override
    public int updateCourseById(String id, Course course) {
        return 0;
    }
}
