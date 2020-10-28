package task;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import task.config.AppConfig;
import task.model.Department;
import task.model.Lecturer;
import task.service.DepartmentService;
import task.service.LecturerService;
import task.util.DataInjector;

public class Application {
    private static final String intro = "Here are the list of available commands: \n"
            + "1 - Who is head of department {department_name} \n"
            + "2 - Show {department_name} statistics \n"
            + "3 - Show the average salary for the department {department_name} \n"
            + "4 - Show count of employee for {department_name} \n"
            + "5 - Global search by {template} \n"
            + "Please type number of command or type q to quit:";

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        DataInjector dataInjector = context.getBean(DataInjector.class);

        dataInjector.injectDataToDB();
        System.out.println(intro);
        Scanner scanner = new Scanner(System.in);
        DepartmentService departmentService = context.getBean(DepartmentService.class);
        List<String> deptList = departmentService.getAll().stream()
                .map(Department::getName).collect(Collectors.toList());
        label:
        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "1": {
                    System.out.println("Here are the list of department names:");
                    deptList.forEach(System.out::println);
                    System.out.println("Please type the name of "
                            + "department you want to get head of:");
                    String input2 = scanner.nextLine();
                    try {
                        Lecturer head = departmentService.getDepartmentHead(input2);
                        System.out.println("Head of " + input2 + " is " + head.getName());
                    } catch (Exception e) {
                        System.out.println("No such department exists");
                    }
                    System.out.println(intro);
                    break;
                }
                case "2": {
                    System.out.println("Here are the list of department names:");
                    deptList.forEach(System.out::println);
                    System.out.println("Please type the name of department "
                            + " you want to get stats from:");
                    String input2 = scanner.nextLine();
                    try {
                        System.out.println(departmentService.getDepartmentStatistics(input2));
                    } catch (Exception e) {
                        System.out.println("No such department exists");
                    }
                    System.out.println(intro);
                    break;
                }
                case "3": {
                    System.out.println("Here are the list of department names:");
                    deptList.forEach(System.out::println);
                    System.out.println("Please type the name of department "
                            + "you want to get salary from:");
                    String input2 = scanner.nextLine();
                    try {
                        Double average = departmentService.averageSalary(input2);
                        System.out.println("Average salary for " + input2 + " is " + average);
                    } catch (Exception e) {
                        System.out.println("No such department exists");
                    }
                    System.out.println(intro);
                    break;
                }
                case "4": {
                    System.out.println("Here are the list of department names:");
                    deptList.forEach(System.out::println);
                    System.out.println("Please type the name of department "
                            + "you want to get number of lecturers:");
                    String input2 = scanner.nextLine();
                    try {
                        Long count = departmentService.getDepartmentLecturersCount(input2);
                        System.out.println("Number of lecturers for " + input2 + " is " + count);
                    } catch (Exception e) {
                        System.out.println("No such department exists");
                    }
                    System.out.println(intro);
                    break;
                }
                case "5": {
                    LecturerService lecturerService = context.getBean(LecturerService.class);
                    System.out.println("Please enter a template for global search: ");
                    String input2 = scanner.nextLine();
                    List<Lecturer> lecturerList = lecturerService.getByTemplate(input2);
                    lecturerList.stream()
                            .map(Lecturer::getName)
                            .forEach(System.out::println);
                    System.out.println(intro);
                    break;
                }
                case "q":
                    break label;
                default:
                    System.out.println("Invalid number of command");
                    System.out.println(intro);
                    break;
            }
        }
    }
}
