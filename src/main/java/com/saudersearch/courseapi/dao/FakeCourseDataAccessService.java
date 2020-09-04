package com.saudersearch.courseapi.dao;

import com.saudersearch.courseapi.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeDao")
public class FakeCourseDataAccessService implements CourseDao {

    private static List<Course> DB = new ArrayList<>();

    @Override
    public int insertCourse(Course course) {
        DB.add(new Course(course.getCourseID(),course.getName(),course.getCredits(),course.getPrereqs(),course.getCorereqs(),course.getDescription()));
        return 1;
    }

    @Override
    public List<Course> selectAllCourses() {
        return DB;
    }

    @Override
    public Optional<Course> selectCourseById(String id) {
        return DB.stream()
                .filter(course -> course.getCourseID().equals(id)).findFirst();
    }

    @Override
    public int deleteCourseById(String id) {
        Optional<Course> courseMaybe = selectCourseById(id);
        if (courseMaybe.isPresent()) {
            DB.remove(courseMaybe.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updateCourseById(String id, Course course) {
        return selectCourseById(id)
                .map(c -> {
                    int indexOfCourseToUpdate = DB.indexOf(c);
                    if (indexOfCourseToUpdate >= 0) {
                        DB.set(indexOfCourseToUpdate, new Course(course.getCourseID(),course.getName(),course.getCredits(),course.getPrereqs(),course.getCorereqs(),course.getDescription()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

}
