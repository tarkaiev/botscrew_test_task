package task;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import task.config.AppConfig;
import task.model.Department;
import task.model.Lecturer;
import task.service.DepartmentService;
import task.service.LecturerService;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        DepartmentService departmentService = context.getBean(DepartmentService.class);
        Department department1 = new Department();
        department1.setName("DEPARTMENT1");
        departmentService.add(department1);
        Department department2 = new Department();
        department2.setName("DEPARTMENT2");
        departmentService.add(department2);

        Lecturer lecturer1 = new Lecturer();
        //lecturer1.setDepartments(List.of(department1));
        lecturer1.setDegree("prof");
        lecturer1.setName("LECTURER1");
        lecturer1.setSalary(2000L);
        LecturerService lecturerService = context.getBean(LecturerService.class);
        lecturerService.add(lecturer1);
        Lecturer lecturer2 = new Lecturer();
        //lecturer2.setDepartments(List.of(department2));
        lecturer2.setDegree("aspirant");
        lecturer2.setName("LECTURER2");
        lecturer2.setSalary(4000L);
        lecturerService.add(lecturer2);

        departmentService.setDepartmentHead(department1, lecturer1);
        departmentService.setDepartmentHead(department2, lecturer2);

        System.out.println(departmentService.getDepartmentHead("DEPARTMENT1"));

    }
}
