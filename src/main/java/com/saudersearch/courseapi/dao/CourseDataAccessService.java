package com.saudersearch.courseapi.dao;

import com.saudersearch.courseapi.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("postgres")
public class CourseDataAccessService implements CourseDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CourseDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertCourse(Course course) {
        return 0;
    }

    @Override
    public List<Course> selectAllCourses() {
        final String sql = "SELECT courseid, name, credits, prereqs, corereqs, description FROM course";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            String courseid = resultSet.getString("courseid");
            String name = resultSet.getString("name");
            Integer credits = resultSet.getInt("credits");
            String prereqs = resultSet.getString("prereqs");
            String corereqs = resultSet.getString("corereqs");
            String description = resultSet.getString("description");
            return new Course(courseid, name, credits, prereqs, corereqs, description);
        });
    }

    @Override
    public Optional<Course> selectCourseById(String id) {
        final String sql = "SELECT courseid, name, credits, prereqs, corereqs, description FROM course WHERE courseid = ?";

         Course course = jdbcTemplate.queryForObject(
                 sql,
                 new Object[]{id},
                 (resultSet, i) -> {
                    String courseid = resultSet.getString("courseid");
                    String name = resultSet.getString("name");
                    Integer credits = resultSet.getInt("credits");
                    String prereqs = resultSet.getString("prereqs");
                    String corereqs = resultSet.getString("corereqs");
                    String description = resultSet.getString("description");
                    return new Course(courseid, name, credits, prereqs, corereqs, description);
                });

         return Optional.ofNullable((course));
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
