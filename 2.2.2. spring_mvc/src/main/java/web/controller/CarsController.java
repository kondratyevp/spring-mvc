package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarsController {

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam("count") int count, ModelMap model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("model1", 1, "color1"));
        cars.add(new Car("model2", 2, "color2"));
        cars.add(new Car("model3", 3, "color3"));
        cars.add(new Car("model4", 4, "color4"));
        cars.add(new Car("model5", 5, "color5"));
        List<Car> carsForWeb = cars.stream().limit(count).collect(Collectors.toList());
        model.addAttribute("carsForWeb", carsForWeb);
        return "cars";
    }

}
