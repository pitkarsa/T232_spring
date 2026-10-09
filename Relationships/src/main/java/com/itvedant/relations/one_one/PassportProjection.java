package com.itvedant.relations.one_one;

import java.time.LocalDate;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = {Passport.class})
public interface PassportProjection {
	public int getId() ;
	public String getPassNo() ;
	public LocalDate getIssueDate() ;
	public LocalDate getExpDate() ;
	public Person getPerson() ;
}
