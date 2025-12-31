package com.example.main.controllers;

import com.example.main.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @GetMapping("/{employeeID}")
    public EmployeeDTO getEmployeeByID(@PathVariable(name = "employeeID") Long id) {
        return new EmployeeDTO(id, "abc", "abc@abc.com", 27, LocalDate.of(2025, 1, 2), true);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age) {

        List<EmployeeDTO> employees = List.of(
                new EmployeeDTO(1L, "Alice", "alice@abc.com", 25, LocalDate.of(2023, 1, 10), true),
                new EmployeeDTO(2L, "Bob", "bob@abc.com", 30, LocalDate.of(2022, 5, 20), true),
                new EmployeeDTO(3L, "Charlie", "charlie@abc.com", 27, LocalDate.of(2024, 3, 15), false)
        );

        if (age == null) {
            return employees;
        }

        return employees.stream()
                .filter(e -> e.getAge().equals(age))
                .toList();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee) {
        inputEmployee.setId(12L);
        return inputEmployee;
    }


}
