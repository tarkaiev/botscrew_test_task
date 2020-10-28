package task.dao;

import java.util.List;
import task.model.Department;
import task.model.Lecturer;

public interface DepartmentDao {

    void add(Department department);

    void setDepartmentHead(Department department, Lecturer lecturer);

    Lecturer getDepartmentHead(String departmentName);

    List<Lecturer> getDepartmentStatistics(String departmentName);

    Double averageSalary(String departmentName);

    Long getDepartmentLecturersCount(String departmentName);

    List<Department> getAll();
}
