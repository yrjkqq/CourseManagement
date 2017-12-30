package com.cdsxt.web.controller;

import com.cdsxt.po.Course;
import com.cdsxt.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping
    public String index(Model model) {
        model.addAttribute("courses", courseService.queryAll());
        return "course/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Course course) {
        this.courseService.add(course);
        return "redirect:/course";
    }
}
