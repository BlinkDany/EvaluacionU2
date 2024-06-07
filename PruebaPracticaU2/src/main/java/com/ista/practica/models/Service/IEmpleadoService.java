package com.ista.practica.models.Service;

import java.util.List;

import com.ista.practica.models.Entity.Empleado;

public interface IEmpleadoService {

	public List<Empleado> findAll();
	
	public Empleado save (Empleado empleado);
	
	public Empleado findById(Long id_empleado);
	
	public void delete(Long id_empleado);
}
