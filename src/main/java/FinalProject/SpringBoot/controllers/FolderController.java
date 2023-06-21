package FinalProject.SpringBoot.controllers;

import FinalProject.SpringBoot.model.Folders;
import FinalProject.SpringBoot.model.TaskCategories;
import FinalProject.SpringBoot.service.CategoryService;
import FinalProject.SpringBoot.service.FolderService;
import FinalProject.SpringBoot.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class FolderController {

    private final FolderService folderService;
    private final CategoryService categoryService;
    private final TaskService taskService;

    @PostMapping("add-folder")
    public String addFolder(Folders folders) {
        folderService.addFolder(folders);
        return "redirect:/";
    }


    @GetMapping("/details/{folderId}")
    public String folderPage(@PathVariable(name = "folderId") Long id,
                             Model model) {
        model.addAttribute("folders", folderService.getFolder(id));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("tasks", taskService.findAllById(id));
        return "details";
    }

    @PostMapping(value = "/delete-category")
    public String deleteCategory(@RequestParam(name = "category_id") Long category_id,
                                 @RequestParam(name = "folder_id") Long folder_id) {
        folderService.deleteCategory(category_id, folder_id);
        return "redirect:/details/" + folder_id;
    }

    @PostMapping(value = "/add-category")
    public String addCategory(@RequestParam(name = "folder_id") Long folder_id,
                              @RequestParam(name = "category_id") Long category_id){
        folderService.addCategory(folder_id, category_id);
        return "redirect:/details/" + folder_id;
    }

    @PostMapping(value = "/delete-folder")
    public String deleteFolder(@RequestParam(name = "id") Long id){
        taskService.deleteAllTask(id);
        folderService.deleteFolder(id);
        return "redirect:/";
    }
}
