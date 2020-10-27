package task.util;

import java.util.List;
import org.springframework.stereotype.Component;
import task.model.Department;
import task.model.Lecturer;
import task.service.DepartmentService;
import task.service.LecturerService;

@Component
public class DataInjector {
    private final DepartmentService departmentService;
    private final LecturerService lecturerService;

    public DataInjector(DepartmentService departmentService, LecturerService lecturerService) {
        this.departmentService = departmentService;
        this.lecturerService = lecturerService;
    }

    public void injectDataToDB() {
        Department economicDept = new Department();
        economicDept.setName("Economical department");
        Department lawyerDept = new Department();
        lawyerDept.setName("Law department");
        Department mathDept = new Department();
        mathDept.setName("Math department");
        Department physicsDept = new Department();
        physicsDept.setName("Physics department");
        departmentService.add(economicDept);
        departmentService.add(lawyerDept);
        departmentService.add(mathDept);
        departmentService.add(physicsDept);

        Lecturer lecturer1 = new Lecturer("Ivanov Ivan Ivanovich", 1400L,
                "Assistant", List.of(economicDept, mathDept));
        lecturerService.add(lecturer1);

        Lecturer lecturer2 = new Lecturer("Petov Petro Petrovich", 2200L,
                "Associate professor", List.of(economicDept, mathDept));
        lecturerService.add(lecturer2);

        Lecturer lecturer3 = new Lecturer("Sidorenko Bogdan Ivanovich", 3300L,
                "Professor", List.of(economicDept, mathDept));
        lecturerService.add(lecturer3);

        Lecturer lecturer4 = new Lecturer("Antonov Anton Antonovich", 900L,
                "Assistant", List.of(lawyerDept));
        lecturerService.add(lecturer4);

        Lecturer lecturer5 = new Lecturer("Kiselev Vladislav Ivanovich", 1300L,
                "Associate professor", List.of(lawyerDept, economicDept));
        lecturerService.add(lecturer5);

        Lecturer lecturer6 = new Lecturer("Sidorov Semen Petrovich", 4200L,
                "Professor", List.of(lawyerDept, mathDept, economicDept));
        lecturerService.add(lecturer6);

        Lecturer lecturer7 = new Lecturer("Poznyak Anatoliy Sergeevich", 6700L,
                "Professor", List.of(physicsDept, mathDept));
        lecturerService.add(lecturer7);

        Lecturer lecturer8 = new Lecturer("Lagoon Andrey Andreevich", 4300L,
                "Professor", List.of(economicDept, mathDept, physicsDept));
        lecturerService.add(lecturer8);

        Lecturer lecturer9 = new Lecturer("Jolie Angelina Petrovna", 300L,
                "Assistant", List.of(physicsDept));
        lecturerService.add(lecturer9);

        Lecturer lecturer10 = new Lecturer("Pitt Brad Michaelovich", 1200L,
                "Associate professor", List.of(economicDept, mathDept, physicsDept, lawyerDept));
        lecturerService.add(lecturer10);

        departmentService.setDepartmentHead(lawyerDept, lecturer6);
        departmentService.setDepartmentHead(economicDept, lecturer8);
        departmentService.setDepartmentHead(mathDept, lecturer3);
        departmentService.setDepartmentHead(physicsDept, lecturer7);
    }
}
