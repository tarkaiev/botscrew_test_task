package task.service;

import java.util.List;
import java.util.Map;
import task.model.Department;
import task.model.Lecturer;

public interface DepartmentService {

    void add(Department department);

    void setDepartmentHead(Department department, Lecturer lecturer);

    Lecturer getDepartmentHead(String departmentName);

    Map<String, Integer> getDepartmentStatistics(String departmentName);

    Double averageSalary(String departmentName);

    Integer getDepartmentLecturersCount(String departmentName);

    List<Department> getAll();
}
