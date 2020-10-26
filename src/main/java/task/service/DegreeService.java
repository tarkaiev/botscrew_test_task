package task.service;

import java.util.List;
import task.model.Degree;

public interface DegreeService {

    void add(Degree degree);

    void remove(Degree degree);

    List<Degree> getAll();
}
