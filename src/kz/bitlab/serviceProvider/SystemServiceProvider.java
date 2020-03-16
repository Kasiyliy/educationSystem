package kz.bitlab.serviceProvider;

import kz.bitlab.services.CoursesService;
import kz.bitlab.services.impl.service.CoursesServiceImpl;

public class SystemServiceProvider {
    public static CoursesService coursesService(){
        return new CoursesServiceImpl();
    }
}
