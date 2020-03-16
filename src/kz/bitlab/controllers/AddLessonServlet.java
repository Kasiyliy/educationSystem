package kz.bitlab.controllers;

import kz.bitlab.db.dbManager;
import kz.bitlab.helper.Helper;
import kz.bitlab.models.Lesson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addLesson")
public class AddLessonServlet extends HttpServlet {
    private dbManager dbManager;
    public void init(){
        dbManager = new dbManager();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("lessonTitle");
        String description = request.getParameter("lessonDescription");
        String courseIdStr = request.getParameter("courseId");
        String orderingStr = request.getParameter("ordering");

        if(Helper.allNotNull(title,description,courseIdStr,orderingStr) && Helper.isNumber(courseIdStr) && Helper.isNumber(orderingStr)){
            Lesson lesson = new Lesson(null,title,description,Integer.parseInt(courseIdStr),Integer.parseInt(orderingStr));
            dbManager.addLesson(lesson);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
