package ru.geekbrains.spring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.model.Student;
import ru.geekbrains.spring.services.StudentService;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping // GET http://localhost:8189/app/students
    public String showAll(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @PostMapping("/add_student")
    public String addStudents(@ModelAttribute Student student, @RequestParam(required = false) Long id, @RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        if ((id == null) || (name.equals("")) || (age == null)) {
            return "redirect:/students/";
        }
        studentService.saveOrUpdate(student);
        return "redirect:/students/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Long id, HttpServletResponse response) {
        studentService.deleteBydId(id);
        return "redirect:/students"; // [http://localhost:8189/app]/students
    }
}
