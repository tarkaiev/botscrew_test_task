package task.dao.impl;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import task.dao.DepartmentDao;
import task.model.Degree;
import task.model.Department;
import task.model.Lecturer;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    @Override
    public void add(Department department) {

    }

    @Override
    public void remove(Department department) {

    }

    @Override
    public Lecturer getDepartmentHead(String departmentName) {
        return null;
    }

    @Override
    public Map<Degree, Integer> getDepartmentStatistics(String departmentName) {
        return null;
    }

    @Override
    public Double averageSalary(String departmentName) {
        return null;
    }

    @Override
    public List<Department> getAll() {
        return null;
    }
}
