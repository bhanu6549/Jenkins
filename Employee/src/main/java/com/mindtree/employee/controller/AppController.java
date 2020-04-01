package com.mindtree.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.employee.entity.Employee;
import com.mindtree.employee.service.EmployeeService;

@Controller
public class AppController {
	@Autowired
	EmployeeService empSer;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Employee> listEmployees = empSer.listAll();
		model.addAttribute("listEmployees", listEmployees);
		return "index";
	}

	@RequestMapping("/new")
	public String showNewEmployeePage(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return "new_Employee";
	}

	@RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		empSer.save(employee);

		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") long id) {
		ModelAndView mav = new ModelAndView("edit_employee");
		Employee employee = empSer.get(id);
		mav.addObject("employee", employee);
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") long id) {
		empSer.delete(id);
		return "redirect:/";
	}
}
