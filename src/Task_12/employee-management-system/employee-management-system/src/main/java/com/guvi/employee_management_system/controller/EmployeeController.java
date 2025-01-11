package com.guvi.employee_management_system.controller;

import com.guvi.employee_management_system.model.Employee;
import com.guvi.employee_management_system.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/displayAll")
    public String displayAllEmployees(Model model) {
        List<Employee> employees = service.getAllEmployees();
        model.addAttribute("employees", employees);
        return "displayAll";
    }

    @GetMapping("/display/{id}")
    public String displayEmployeeById(@PathVariable String id, Model model) {
        Employee employee = service.getEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "displayID";
        } else {
            model.addAttribute("error", "Employee not found!");
            return "error";
        }
    }

}
