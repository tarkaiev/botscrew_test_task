package task.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import task.dao.LecturerDao;
import task.model.Lecturer;
import task.service.LecturerService;

@Service
public class LecturerServiceImpl implements LecturerService {
    private final LecturerDao lecturerDao;

    public LecturerServiceImpl(LecturerDao lecturerDao) {
        this.lecturerDao = lecturerDao;
    }

    @Override
    public void add(Lecturer lecturer) {
        lecturerDao.add(lecturer);
    }

    @Override
    public void remove(Lecturer lecturer) {
        lecturerDao.remove(lecturer);
    }

    @Override
    public List<Lecturer> getByTemplate(String template) {
        return lecturerDao.getByTemplate(template);
    }

    @Override
    public List<Lecturer> getAll() {
        return lecturerDao.getAll();
    }
}
