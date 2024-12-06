package com.klef.jfsd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Employee;
import com.klef.jfsd.springboot.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmployeeController 
{
  @Autowired
  private EmployeeService employeeService;
  
  @GetMapping("/")
  public ModelAndView home() 
  {
    ModelAndView mv=new ModelAndView("home");
    return mv;
    
  }
  @GetMapping("empreg")
  public ModelAndView empreg() 
  {
    ModelAndView mv=new ModelAndView();
    mv.setViewName("empreg");
    return mv;
  }
  
  @PostMapping("insertemp")
  public ModelAndView insertemp(HttpServletRequest request)
  {
     String name = request.getParameter("ename");
   String gender = request.getParameter("egender");
   String dob = request.getParameter("edob");
   String dept = request.getParameter("edept");
   double salary = Double.parseDouble(request.getParameter("esalary"));
   String location = request.getParameter("elocation");
   String email = request.getParameter("eemail");
   String password = request.getParameter("epwd");
   String contact = request.getParameter("econtact");
   String status = "Registered";
   
     Employee emp = new Employee();
     emp.setName(name);
     emp.setGender(gender);
     emp.setDepartment(dept);
     emp.setDateofbirth(dob);
     emp.setSalary(salary);
     emp.setLocation(location);
     emp.setEmail(email);
     emp.setPassword(password);
     emp.setContact(contact);
     emp.setStatus(status);
     
     String msg = employeeService.EmployeeRegistration(emp);
     
     ModelAndView mv = new ModelAndView("regsuccess");
     mv.addObject("message", msg);
   
     return mv;

  }
  @GetMapping("adminlogin")
  public ModelAndView adminlogin() 
  {
    ModelAndView mv=new ModelAndView();
      mv.setViewName("adminlogin");
      return mv;
  }
  
  @GetMapping("emplogin")
  public ModelAndView emplogin() 
  {
    ModelAndView mv=new ModelAndView();
      mv.setViewName("emplogin");
      return mv;
  }
    
  @GetMapping("emphome")
   public ModelAndView emphome() 
   {
     ModelAndView mv=new ModelAndView();
       mv.setViewName("emphome");
       return mv;
   }
  
  @GetMapping("emplogout")
   public ModelAndView emplogout(HttpServletRequest request) 
   {
	  HttpSession session = request.getSession();
	  session.removeAttribute("employee");
     ModelAndView mv=new ModelAndView();
       mv.setViewName("emplogin");
       return mv;
   }
  @GetMapping("empsessionfail")
  public ModelAndView empsessionfail() 
  {
    ModelAndView mv=new ModelAndView();
      mv.setViewName("empsessionfail");
      return mv;
  }
  
  @PostMapping("checkemplogin")
  public ModelAndView checkemplogin(HttpServletRequest request)
  {
    ModelAndView mv = new ModelAndView();
    String eemail = request.getParameter("eemail");
    String epwd = request.getParameter("epwd");
    
    Employee emp = employeeService.checkemplogin(eemail, epwd);
    
    if(emp!=null)
    {
    	HttpSession session = request.getSession();
    	session.setAttribute("employee", emp);
    	//employee is session variable
      mv.setViewName("emphome");
    }
    else
    {
      mv.setViewName("emploginfail");
      mv.addObject("message", "Login Failed");
    }
    return mv;
  }
  @GetMapping("empprofile")
  public ModelAndView empprofile() 
  {
    ModelAndView mv=new ModelAndView();
      mv.setViewName("empprofile");
      return mv;
  }
  @GetMapping("updateemp")
  public ModelAndView updateemp()
  {
    ModelAndView mv=new ModelAndView();
      mv.setViewName("updateemp");
      return mv;
  }
  @PostMapping("update")
  public ModelAndView update(HttpServletRequest request)
  {
     int id =Integer.parseInt(request.getParameter("eid"));
     String name = request.getParameter("ename");
   String gender = request.getParameter("egender");
   String dob = request.getParameter("edob");
   String dept = request.getParameter("edept");
   double salary = Double.parseDouble(request.getParameter("esalary"));
   String location = request.getParameter("elocation");
   String password = request.getParameter("epwd");
   String contact = request.getParameter("econtact");


     Employee emp = new Employee();
     emp.setId(id);
     emp.setName(name);
     emp.setGender(gender);
     emp.setDepartment(dept);
     emp.setDateofbirth(dob);
     emp.setSalary(salary);
     emp.setLocation(location);
     emp.setPassword(password);
     emp.setContact(contact);
     
     String msg = employeeService.updateemp(emp);
     
     ModelAndView mv = new ModelAndView("updatesuccess");
     mv.addObject("message", msg);
   
     return mv;

  }
  
  
  
  @GetMapping("viewempsbydept")
  public ModelAndView viewempbydept(HttpServletRequest request)
  {
	  ModelAndView mv = new ModelAndView("viewempsbydept");
	  HttpSession session = request.getSession();
	  Employee emp = (Employee)session.getAttribute("employee");
	  List<Employee> emplist = employeeService.displayEmpsByDepartment(emp.getDepartment());
	  mv. addObject("emplist",emplist);
	  return mv;
  }
  
  
  
  
  
  
  
}