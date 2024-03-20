package ua.invest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.invest.models.entities.User;
import ua.invest.repositories.UserRepository;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    @Autowired
    private final UserRepository userRepository;

    @GetMapping
    public ModelAndView getAccount(ModelAndView modelAndView) {
        User user = userRepository.findAll().stream().findFirst().get();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("account.html");
        return modelAndView;
    }
}
