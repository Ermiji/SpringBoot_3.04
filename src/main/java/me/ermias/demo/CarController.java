package me.ermias.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class CarController {

    @Autowired
    CarsRepository carsRepository;

    @RequestMapping("/")
    public String listCars(Model model){
        model.addAttribute("cars", carsRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String carsForm(Model model){
        model.addAttribute("cars", new Cars());
        return "carsform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Cars car,
                              BindingResult result){
        if(result.hasErrors()){
            return "carsform";
        }
        carsRepository.save(car);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showCar(@PathVariable("id") long id,
                          Model model){
        model.addAttribute("car", carsRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateCar(@PathVariable("id") long id,
                            Model model){
        model.addAttribute("car", carsRepository.findById(id));
        return "carsform";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") long id){
        carsRepository.deleteById(id);
        return "redirect:/";
    }
}

