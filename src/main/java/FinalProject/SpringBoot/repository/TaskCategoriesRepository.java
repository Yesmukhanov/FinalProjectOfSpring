package FinalProject.SpringBoot.repository;

import FinalProject.SpringBoot.model.TaskCategories;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TaskCategoriesRepository extends JpaRepository<TaskCategories, Long> {
}
