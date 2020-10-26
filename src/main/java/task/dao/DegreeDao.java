package task.dao;

import java.util.List;
import task.model.Degree;

public interface DegreeDao {

    void add(Degree degree);

    List<Degree> getAll();
}
