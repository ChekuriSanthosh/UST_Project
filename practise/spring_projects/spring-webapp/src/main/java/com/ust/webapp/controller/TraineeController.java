package com.ust.webapp.controller;

import com.ust.webapp.dto.TraineeDto;
import com.ust.webapp.model.Trainee;
import com.ust.webapp.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.ust.webapp.util.EntityDtoUtil.convertToEntity;

@Controller
public class TraineeController {

    @Autowired
    private TraineeService traineeService;

    @GetMapping("/trainee")
    public String getTrainee() {
        return "traineeform.jsp";
    }

    @GetMapping("/get-trainee")
    public String getTrainee(Model m, @RequestParam("searchid") int searchid) {
        TraineeDto t = traineeService.searchbyid(searchid);
        List<TraineeDto> res=List.of(t);
        m.addAttribute("trainees", res);
        boolean flag=false;
        m.addAttribute("flag", flag);
        return "view-trainee.jsp";
    }

    @GetMapping("/delete-trainee")
    public String deleteTrainee(Model m, @RequestParam("id") int id) {
        traineeService.deletebyidService(id);
        List<TraineeDto> res = traineeService.displaytraineeService();
        m.addAttribute("trainees", res);
        boolean flag=false;
        m.addAttribute("flag", flag);
        return "view-trainee.jsp";
    }

    @GetMapping("/viewtrainee")
    public String viewTrainee(Model m) {
        List<TraineeDto> res = traineeService.displaytraineeService();
        m.addAttribute("trainees", res);
        boolean flag=false;
        m.addAttribute("flag", flag);
        return "view-trainee.jsp";
    }

    @PostMapping("/add-trainee")
    public String addTrainee(Model m, @RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("location") String location) {
        TraineeDto t = new TraineeDto(id, name, location);
        boolean flag = traineeService.alreadyexists(t.id());
        if (!flag) {
            traineeService.addtraineeService(convertToEntity(t));
        }
        List<TraineeDto> res = traineeService.displaytraineeService();
        m.addAttribute("flag", flag);
        m.addAttribute("trainees", res);
        return "view-trainee.jsp";
    }

}
