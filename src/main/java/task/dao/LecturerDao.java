package task.dao;

import java.util.List;
import task.model.Lecturer;

public interface LecturerDao {
    void add(Lecturer lecturer);

    void remove(Lecturer lecturer);

    List<Lecturer> getByTemplate(String template);

    List<Lecturer> getAll();
}
