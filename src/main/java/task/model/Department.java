package task.model;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Department {

    private Long id;
    private String name;
    private Lecturer headOfDept;
    private List<Lecturer> lecturers;

}
