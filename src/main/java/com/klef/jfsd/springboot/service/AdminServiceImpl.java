package com.klef.jfsd.springboot.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Employee;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.EmployeeRepository;

@Service
public class AdminServiceImpl implements AdminService {
   @Autowired
  private EmployeeRepository employeeRepository;
   @Autowired
   private AdminRepository adminRepository;

  @Override
  public List<Employee> ViewAllEmployees() {
    // TODO Auto-generated method stub
    
    return employeeRepository.findAll();
  }
@Override
public Admin checkadminlogin(String uname,String pwd) {
  return adminRepository.checkadminlogin(uname,pwd);
}
@Override
public String deleteemp(int eid) {
  // TODO Auto-generated method stub
   employeeRepository.deleteById(eid);;
   return "Deleted Successfully";
}
@Override
public long empcount() {
	// TODO Auto-generated method stub
	return employeeRepository.count();
}

}