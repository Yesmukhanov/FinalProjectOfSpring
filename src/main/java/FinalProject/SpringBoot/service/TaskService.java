package FinalProject.SpringBoot.service;

import FinalProject.SpringBoot.model.TaskCategories;
import FinalProject.SpringBoot.model.Tasks;
import FinalProject.SpringBoot.repository.TaskCategoriesRepository;
import FinalProject.SpringBoot.repository.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TasksRepository tasksRepository;
    private final FolderService folderService;

    public List<Tasks> getAllTasks() {
        return tasksRepository.findAll();
    }

    public void addTask(Tasks tasks, Long folder_id){
        tasks.setStatus(0);
        tasks.setFolders(folderService.getFolder(folder_id));
        tasksRepository.save(tasks);
    }

    public Tasks getTask(Long id){
        return tasksRepository.findById(id).orElseThrow();
    }

    public List<Tasks> findAllById(Long id){
        return tasksRepository.findAllByFolders_Id(id);
    }

    public void updateTask(Tasks tasks, Long id){
        tasks.setFolders(folderService.getFolder(id));
        tasksRepository.save(tasks);
    }

    public void deleteTask(Long id){
        tasksRepository.deleteById(id);
    }

    public void deleteAllTask(Long id){
        tasksRepository.deleteByFolders_Id(id);
    }


}
