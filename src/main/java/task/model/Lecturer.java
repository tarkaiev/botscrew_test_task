package task.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "lecturers")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long salary;
    private String degree;
    @ManyToMany
    @ToString.Exclude
    private List<Department> departments;

    public Lecturer(String name, Long salary, String degree, List<Department> departments) {
        this.name = name;
        this.salary = salary;
        this.degree = degree;
        this.departments = departments;
    }
}
