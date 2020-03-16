package kz.bitlab.services;

import kz.bitlab.models.Courses;

import java.util.ArrayList;

public interface CoursesService {

    boolean addCourses (Courses courses);

    boolean deleteCourses (Courses courses);

//    Courses findById(Long id);

    ArrayList<Courses> findAll();

}
