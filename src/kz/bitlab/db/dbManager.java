package kz.bitlab.db;

import kz.bitlab.models.Lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class dbManager {
    private static Connection connection;
    public  dbManager() {connect();}

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationsystem?serverTimezone=UTC","root", "admin@123");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean addLesson(Lesson lesson) {
        boolean result = false;

        try {
            if(connection==null){
                connect();
            }
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO lessons (lessons.title, lessons.description, lessons.course_id, lessons.ordering) VALUES (?,?,?,?)"
            );
        statement.setString(1, lesson.getTitle());
        statement.setString(2, lesson.getDescription());
        statement.setInt(3, lesson.getCourseId());
        statement.setInt(4, lesson.getOrdering());
        result = statement.executeUpdate()>0;
        statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
