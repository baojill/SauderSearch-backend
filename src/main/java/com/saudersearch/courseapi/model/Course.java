package com.saudersearch.courseapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Course {

    @NotBlank(message = "Course ID may not be blank")
    private String courseID;
    @NotBlank(message = "Course name may not be blank")
    private String name;

    private int credits;

    @NotNull(message = "Course name may not be blank")
    private String prereqs;
    @NotNull(message = "Course name may not be blank")
    private String corereqs;
    @NotBlank(message = "Course description may not be blank")
    private String description;

    public Course(@JsonProperty("courseID") String courseID,
                  @JsonProperty("name") String name,
                  @JsonProperty("credits") int credits,
                  @JsonProperty("prereqs") String prereqs,
                  @JsonProperty("corereqs") String corereqs,
                  @JsonProperty("description") String description) {
        this.courseID = courseID;
        this.name = name;
        this.credits = credits;
        this.prereqs = prereqs;
        this.corereqs = corereqs;
        this.description = description;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getPrereqs() {
        return prereqs;
    }

    public String getCorereqs() {
        return corereqs;
    }

    public String getDescription() {
        return description;
    }
}
