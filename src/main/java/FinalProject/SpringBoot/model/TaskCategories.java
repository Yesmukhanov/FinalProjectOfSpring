package FinalProject.SpringBoot.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "task-categories")
@Data
public class TaskCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
