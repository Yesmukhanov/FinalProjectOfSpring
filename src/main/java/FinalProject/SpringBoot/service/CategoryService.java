package FinalProject.SpringBoot.service;

import FinalProject.SpringBoot.model.TaskCategories;
import FinalProject.SpringBoot.repository.TaskCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private TaskCategoriesRepository taskCategoriesRepository;
    public TaskCategories getCategory(Long id){
        return taskCategoriesRepository.findById(id).orElseThrow();
    }
    public List<TaskCategories> getAllCategories(){
        return taskCategoriesRepository.findAll();
    }
}
