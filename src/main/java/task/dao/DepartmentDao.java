package task.dao;

import java.util.List;
import java.util.Map;
import task.model.Degree;
import task.model.Department;
import task.model.Lecturer;

public interface DepartmentDao {

    void add(Department department);

    Lecturer getDepartmentHead(String departmentName);

    Map<Degree, Integer> getDepartmentStatistics(String departmentName);

    Double averageSalary(String departmentName);

    List<Department> getAll();
}
