package task.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import task.dao.DepartmentDao;
import task.model.Degree;
import task.model.Department;
import task.model.Lecturer;
import task.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDao departmentDao;

    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public void add(Department department) {
        departmentDao.add(department);
    }

    @Override
    public void remove(Department department) {
        departmentDao.remove(department);
    }

    @Override
    public Lecturer getDepartmentHead(String departmentName) {
        return departmentDao.getDepartmentHead(departmentName);
    }

    @Override
    public Map<Degree, Integer> getDepartmentStatistics(String departmentName) {
        return departmentDao.getDepartmentStatistics(departmentName);
    }

    @Override
    public Double averageSalary(String departmentName) {
        return departmentDao.averageSalary(departmentName);
    }

    @Override
    public List<Department> getAll() {
        return departmentDao.getAll();
    }
}
