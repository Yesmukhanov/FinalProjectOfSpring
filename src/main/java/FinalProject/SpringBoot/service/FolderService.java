package FinalProject.SpringBoot.service;

import FinalProject.SpringBoot.model.Folders;
import FinalProject.SpringBoot.model.TaskCategories;
import FinalProject.SpringBoot.repository.FoldersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FolderService {
    private final FoldersRepository foldersRepository;
    private final CategoryService categoryService;
    public void addFolder(Folders folders){
        foldersRepository.save(folders);
    }

    public List<Folders> allFolders(){
        return foldersRepository.findAll();
    }

    public Folders getFolder(Long id){
        return foldersRepository.findById(id).orElseThrow();
    }

    public void deleteCategory(Long category_id, Long folder_id ){
        Folders folders = getFolder(folder_id);
        TaskCategories taskCategories = categoryService.getCategory(category_id);

        if (folders != null && folders.getCategories().size() > 0){
            folders.getCategories().remove(taskCategories);
        }

        foldersRepository.save(folders);
    }

    public void addCategory(Long folder_id, Long category_id){
        Folders folder = foldersRepository.findById(folder_id).orElseThrow();
        TaskCategories category = categoryService.getCategory(category_id);

        if (folder.getCategories() != null && folder.getCategories().size() > 0){
            folder.getCategories().add(category);
        } else {
            List<TaskCategories> taskCategories = new ArrayList<>();
            taskCategories.add(category);
            folder.setCategories(taskCategories);
        }

        foldersRepository.save(folder);

    }

    public void deleteFolder(Long id){
        foldersRepository.deleteById(id);
    }


}
