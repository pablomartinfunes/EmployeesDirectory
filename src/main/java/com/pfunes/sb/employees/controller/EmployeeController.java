package com.pfunes.sb.employees.controller;

import java.util.List;

import com.pfunes.sb.employees.entity.Employee;
import com.pfunes.sb.employees.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// get employees from db
		List<Employee> theEmployees = employeeService.findAll();
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "/employee/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model){

		model.addAttribute("employee",new Employee());
		return "/employee/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int idEmployee, Model model){
		model.addAttribute("employee", employeeService.findById(idEmployee));
		return "/employee/employee-form";
	}

	@PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee){
		employeeService.save(employee);
		return "redirect:/employees/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id){
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
}


