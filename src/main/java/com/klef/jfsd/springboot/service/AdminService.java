package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Employee;

public interface AdminService  {
	public List<Employee> ViewAllEmployees();
	public Admin checkadminlogin(String uname,String pwd);
	public String deleteemp(int eid);
public long empcount();
}
