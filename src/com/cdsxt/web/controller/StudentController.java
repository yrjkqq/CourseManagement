package com.cdsxt.web.controller;

import com.cdsxt.po.Student;
import com.cdsxt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("students", this.studentService.queryAll());
        return "student/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Student student) {
        this.studentService.add(student);
        return "redirect:/student";
    }
}
