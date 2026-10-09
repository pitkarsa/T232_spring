package com.itvedant.relations.one_many;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = DepartmentProjection.class)
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
