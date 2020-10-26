package task.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Lecturer {
    private Long id;
    private String name;
    private Department department;
    private Long salary;
    private Degree degree;
}
