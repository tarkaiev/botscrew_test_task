package task.service;

import java.util.List;
import java.util.Map;
import task.model.Degree;
import task.model.Department;
import task.model.Lecturer;

public interface DepartmentService {

    void add(Department department);

    void remove(Department department);

    Lecturer getDepartmentHead(String departmentName);

    Map<Degree, Integer> getDepartmentStatistics(String departmentName);

    Double averageSalary(String departmentName);

    List<Department> getAll();
}
