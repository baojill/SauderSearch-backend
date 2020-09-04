package com.saudersearch.courseapi.api;

import com.saudersearch.courseapi.model.Course;
import com.saudersearch.courseapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/courses")
@RestController
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public void addCourse(@Valid @NotNull @RequestBody Course course) {
        courseService.addCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping(path = "{id}")
    public Course getCourseById(@PathVariable("id") String id) {
        return courseService.getCourseById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCourseById(@PathVariable("id") String id) {
        courseService.deleteCourse(id);
    }

    @PutMapping(path = "{id}")
    public void updateCourse(@PathVariable("id") String id, @Valid @NotNull @RequestBody Course courseToUpdate) {
        courseService.updateCourse(id, courseToUpdate);
    }
}
