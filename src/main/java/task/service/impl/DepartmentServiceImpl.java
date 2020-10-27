package task.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import task.dao.DepartmentDao;
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
    public void setDepartmentHead(Department department, Lecturer lecturer) {
        departmentDao.setDepartmentHead(department, lecturer);
    }

    @Override
    public Lecturer getDepartmentHead(String departmentName) {
        return departmentDao.getDepartmentHead(departmentName);
    }

    @Override
    public Map<String, Integer> getDepartmentStatistics(String departmentName) {
        List<Lecturer> lecturerList = departmentDao.getDepartmentStatistics(departmentName);
        Map<String, Integer> departmentStats = new HashMap<>();
        for (Lecturer lecturer : lecturerList) {
            departmentStats.merge(lecturer.getDegree(), 1, Integer::sum);
        }
        return departmentStats;
    }

    @Override
    public Integer getDepartmentLecturersCount(String departmentName) {
        return departmentDao.getDepartmentLecturersCount(departmentName);
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
