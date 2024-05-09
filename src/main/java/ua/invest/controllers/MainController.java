package ua.invest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MainController {

    @GetMapping
    public ModelAndView getMainPage(ModelAndView modelAndView){
        modelAndView.setViewName("index.html");
        return modelAndView;
    }
}
