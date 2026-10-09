package com.itvedant.relations.one_many;

import org.springframework.data.rest.core.config.Projection;

@Projection(types= {Employee.class})
public interface EmployeeProjection {
	public int getId() ;
	public String getName() ;
	public String getDesignation() ;
	public String getSalary() ;
	public Department getDepartment() ;
}
