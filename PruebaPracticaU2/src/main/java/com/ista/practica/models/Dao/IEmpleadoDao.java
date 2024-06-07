package com.ista.practica.models.Dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.practica.models.Entity.Empleado;

public interface IEmpleadoDao extends CrudRepository<Empleado, Long>{

}
