package com.example.strweb_6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/") //по данному гет-запросу будет вызываться данная функция
    public String menu(Model model){
        String xmlFilePath = "info.xml";
        System.out.println(menuService.loadMenuFromXml(xmlFilePath));
        model.addAttribute("menu", menuService.loadMenuFromXml(xmlFilePath));
        return "menu"; //название представления
    }

}