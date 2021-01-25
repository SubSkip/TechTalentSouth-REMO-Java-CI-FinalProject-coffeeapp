package com.tts.coffeeproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CoffeeController {
    @Autowired
    private CoffeeRepository coffeeRepository;
    private static List<Coffee> reviews = new ArrayList<>();

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        return "about";
    }

    @RequestMapping("/location")
    public String location(Model model) {
        return "location";
    }

    @RequestMapping("/coffee")
    public String coffee(Model model) {
        return "coffee";
    }

    @GetMapping("/reviews")
    public String reviews(Coffee coffee, Model model) {
        reviews.clear();
        for (Coffee review : coffeeRepository.findAll()) {
            reviews.add(review);
        }
        model.addAttribute("reviews", reviews);
        return "reviews";
    }

    @GetMapping(value = "/new")
    public String newReview(Coffee coffee) {
        return "new";
    }

    @PostMapping(value = "/new")
    public String addNewReview(Coffee coffee, Model model) {
        coffeeRepository.save(new Coffee(coffee.getproduct(), coffee.getAuthor(), coffee.getcoffeeReview()));
        model.addAttribute("coffee", coffee);
        return "redirect:/reviews";
    }

}
