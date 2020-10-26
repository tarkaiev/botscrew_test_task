package task.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import task.dao.DegreeDao;
import task.model.Degree;
import task.service.DegreeService;

@Service
public class DegreeServiceImpl implements DegreeService {

    private final DegreeDao degreeDao;

    public DegreeServiceImpl(DegreeDao degreeDao) {
        this.degreeDao = degreeDao;
    }

    @Override
    public void add(Degree degree) {
        degreeDao.add(degree);
    }

    @Override
    public List<Degree> getAll() {
        return degreeDao.getAll();
    }
}
