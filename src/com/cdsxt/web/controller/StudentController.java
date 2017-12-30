package com.cdsxt.web.controller;

import com.cdsxt.po.Course;
import com.cdsxt.po.Student;
import com.cdsxt.service.CourseService;
import com.cdsxt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

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

    // 选课功能
    @RequestMapping(value = "selectCourse/{sid}", method = RequestMethod.GET)
    public String selectCourse(Model model, @PathVariable("sid") Integer sid) {
        // 将已选择课程添加到作用域中, 并返回页面中
        model.addAttribute("selectedCourses", this.studentService.querySelectedCourses(sid));
        // 还需要将所有课程查询到一起返回
        model.addAttribute("courses", courseService.queryAll());
        // 需要知道当前是哪个学生选课, 作为参数返回到选课页面上
        Student student = studentService.queryById(sid);
        model.addAttribute("currentStudent", student);
        return "student/selectCourse";
    }

    @RequestMapping(value = "selectCourse/{currentStudentId}", method = RequestMethod.POST)
    public String selectCourse(Integer[] selectedCourse, @PathVariable("currentStudentId") Integer currentStudentId) {
        // 使用 List<Course> 集合保存当前学生所选的课程
        Set<Course> courseList = new HashSet<>();
        for (Integer cid : selectedCourse) {
            Course course = new Course();
            course.setCid(cid);
            courseList.add(course);
        }

        // 因为直接更新学生, 会清空原来的属性; 所以需要先查询出来原信息, 然后为当前对象设置属性;
        // 但是一旦进入事务中, 数据库中的信息已经被清空, 所以需要在 Controller 层进行设置属性
        // 更正: 应该使用从数据库中查询出来的学生, 如果再次 new 出来新对象, 会重复; Session 中会存在两个 id 相同的 student 对象, 不行
        Student student = studentService.queryById(currentStudentId);
        this.studentService.selectCourse(student, courseList);
        return "redirect:/student";
    }
}
