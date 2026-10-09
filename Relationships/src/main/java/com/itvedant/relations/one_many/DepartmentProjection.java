package com.itvedant.relations.one_many;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;
@Projection(types = {Department.class})
public interface DepartmentProjection {
	public int getId() ;
	public String getName() ;
	public List<Employee> getAllEmployees() ;
}
