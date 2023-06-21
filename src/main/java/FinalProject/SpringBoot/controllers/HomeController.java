package FinalProject.SpringBoot.controllers;

import FinalProject.SpringBoot.model.Folders;
import FinalProject.SpringBoot.repository.FoldersRepository;
import FinalProject.SpringBoot.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class HomeController {

    @Autowired
    private FolderService folderService;
    @GetMapping("/")
    public String mainPage(Model model){
        List<Folders> foldersList = folderService.allFolders();
        model.addAttribute("folders", foldersList);
        return "main_page";
    }

}
