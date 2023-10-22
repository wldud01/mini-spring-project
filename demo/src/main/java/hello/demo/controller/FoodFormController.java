package hello.demo.controller;

import hello.demo.domain.FoodRecInput;
import hello.demo.domain.Member;
import hello.demo.service.FoodRecInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class FoodFormController {
    private final FoodRecInputService foodRecInputService;

    @Autowired
    public FoodFormController(FoodRecInputService foodRecInputService){
        this.foodRecInputService = foodRecInputService;
        System.out.println("memberService = " + foodRecInputService.getClass());
    }

    @GetMapping("/recommend/new")
    public String createForm(){
        return "recommend/createFoodForm";
    }
    @PostMapping("/recommend/new")
    public String create(FoodForm form){
        Member member = new Member();
        member.setName("spring");
        FoodRecInput foodRecInput = new FoodRecInput();
        foodRecInput.setUserId(member);
        foodRecInput.setCookedCategory(form.getCookedCategory());
        foodRecInput.setSelectedKcal(form.getSelectedKcal());
        foodRecInput.setSelectedCar(form.getSelectedCar());
        foodRecInput.setSelectedProtein(form.getSelectedProtein());
        foodRecInput.setSelectedFat(form.getSelectedFat());

        foodRecInputService.saveInput(foodRecInput);
        return "redirect:/";
    }
    @GetMapping("/recommend/result")
    @ResponseBody
    public String FoodRecResult(Model model){
        List<FoodRecInput> foodRecInputs = foodRecInputService.findContent();
        model.addAttribute("foodRecInputs", foodRecInputs);
        return "recommend/FoodRecResult";
    }
}
