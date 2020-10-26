package task;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import task.config.AppConfig;
import task.model.Lecturer;
import task.service.LecturerService;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        LecturerService lecturerService = context.getBean(LecturerService.class);
        Lecturer lecturer1 = new Lecturer();
        lecturer1.setName("valera");
        lecturer1.setSalary(100L);
        lecturerService.add(lecturer1);
        Lecturer lecturer2 = new Lecturer();
        lecturer2.setName("vitalik");
        lecturer2.setSalary(200L);
        lecturerService.add(lecturer2);
        lecturerService.getAll().forEach(System.out::println);
        System.out.println(lecturerService.getByTemplate("alik"));

    }
}
