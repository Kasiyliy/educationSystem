package kz.bitlab.services.impl.service;

import kz.bitlab.models.Courses;
import kz.bitlab.services.MysqlConnector;
import kz.bitlab.services.CoursesService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CoursesServiceImpl implements CoursesService {

    @Override
    public boolean addCourses(Courses courses) {

        Connection connection = MysqlConnector.getConnect();
        boolean result = false;
        try{

           if(connection==null){
               PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO courses "+
                       "(title,description,visible,active) VALUES (?,?,?,?)");

               preparedStatement.setString(1,courses.getTitle());
               preparedStatement.setString(2,courses.getDescription());
               preparedStatement.setBoolean(3, courses.isVisible());
               preparedStatement.setBoolean(4, courses.isActive());

               result = preparedStatement.executeUpdate()>0;
               preparedStatement.close();


           }


       }catch (Exception e){
            e.printStackTrace();
       }
        return result;
    }

    @Override
    public boolean deleteCourses(Courses courses) {

        Connection connection = MysqlConnector.getConnect();
        boolean result = false;

        try{

            if(connection==null){
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE courses "+
                        "set active false, visible=0");

                result = preparedStatement.executeUpdate()>0;
                preparedStatement.close();


            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public ArrayList<Courses> findAll(){

        ArrayList<Courses> courses = new ArrayList<>();

        Connection connection = MysqlConnector.getConnect();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT id, title, description,like_count FROM courses"+
                            " WHERE visible=1 and active=1 order by like_count DESC");

        ResultSet resultSet = preparedStatement.executeQuery();



        while(resultSet.next()){

            courses.add(new Courses(resultSet.getLong("id"),
                    resultSet.getString("title"),
                    resultSet.getString("description"),
                    resultSet.getInt("like_count")));
        }

        preparedStatement.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }
}
