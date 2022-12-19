package com.example.demo.contoller;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.validation.CustonValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeContoller {


    //lien enter data base et spring boot
    @Autowired
    private EmployeeRepository employeeRepository;
@Autowired
    private CustonValidation custonValidation ;

// select
    @GetMapping("/employee")
    public List<Employee> grtAllEmployees() {

        return employeeRepository.findAll();
    }

// insert

    @PostMapping("/employee")
public Employee saveEmployeeDetails(@RequestBody Employee employee){
 if (!custonValidation.checNamelength(employee.getFirstName() ,  employee.getLastName() , employee.getEmailid())){
     return null;
 }
        return employeeRepository.save(employee);
}


@GetMapping("/employee/{id}")
public Employee getEmployeeById(@PathVariable long id) {
        return employeeRepository.findById(id).get();
}
    // update
@PutMapping("/employee")
public  Employee updateEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
}


// Delete
@DeleteMapping("/employee/{id}")
public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable long id) {
        employeeRepository.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
}


}
