package SpringMVCStart.controller;

import SpringMVCStart.entity.Employee;
import SpringMVCStart.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping(value="/employees")
public class EmployeeController {
    @Autowired
    EmployeeService service;
    @GetMapping("")
    public List<Employee> findAll(){
        return service.findAll();
    }
    @GetMapping("{id}")
    public Employee findOne(@PathVariable("id") String id){
        return service.findOne(id);
    }

    @PostMapping("")
    public Employee create(@RequestBody Employee employee){
        return service.create(employee);
    }

    @PutMapping("{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee){
        return service.update(id, employee);
    }

    @DeleteMapping("{id}")
    public void delete(String id){
        service.delete(id);
    }
}
