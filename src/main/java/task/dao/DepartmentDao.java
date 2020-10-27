package task.dao;

import java.util.List;
import java.util.Map;
import task.model.Department;
import task.model.Lecturer;

public interface DepartmentDao {

    void add(Department department);

    void setDepartmentHead(Department department, Lecturer lecturer);

    Lecturer getDepartmentHead(String departmentName);

    Map<String, Integer> getDepartmentStatistics(String departmentName);

    Double averageSalary(String departmentName);

    List<Department> getAll();
}
