package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee (@RequestBody EmployeeDto employeeDto) {
        // @RequestBody annotation: will extract the Json from the Http request and it will convert that Json into employee Java object.

        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById (@PathVariable Long id) {

        EmployeeDto employeeDto = employeeService.getEmployeeById(id);

        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees () {

        List<EmployeeDto> employeeDto = employeeService.getAllEmployees();

        return ResponseEntity.ok(employeeDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee (@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employeeDto) {

        EmployeeDto updatedEmployee = employeeService.updateEmployee(employeeId, employeeDto);

        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee (@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);

        return new ResponseEntity("Employee deleted successfully!", HttpStatus.OK);
    }
}
