package kz.bitlab.models;

public class Lesson {
    private Long id;
    private String title;
    private String description;
    private int courseId;
    private int ordering;

    public Lesson() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getOrdering() {
        return ordering;
    }

    public void setOrdering(int ordering) {
        this.ordering = ordering;
    }

    public Lesson(Long id, String title, String description, int courseId, int ordering) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.courseId = courseId;
        this.ordering = ordering;
    }
}
