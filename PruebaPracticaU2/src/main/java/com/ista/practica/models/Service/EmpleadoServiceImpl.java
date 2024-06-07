package com.ista.practica.models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.practica.models.Dao.IEmpleadoDao;
import com.ista.practica.models.Entity.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoDao empleadoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return (List<Empleado>) empleadoDao.findAll();
	}

	@Override
	@Transactional
	public Empleado save(Empleado empleado) {
		// TODO Auto-generated method stub
		if (empleado.getDias_trabajo() < 0) {
			throw new IllegalArgumentException("Los días trabajados no pueden ser negativos");
		}

		double sueldoBase = empleado.getDias_trabajo() * 15.0;
		double bono = 0.0;

		if (empleado.getDias_trabajo() >= 30) {
			bono = sueldoBase * 0.05;
		} else if (empleado.getDias_trabajo() >= 20) {
			bono = sueldoBase * 0.02;
		}

		empleado.setSueldo(sueldoBase + bono);
		return empleadoDao.save(empleado);
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findById(Long id_empleado) {
		// TODO Auto-generated method stub
		return empleadoDao.findById(id_empleado).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id_empleado) {
		// TODO Auto-generated method stub
		empleadoDao.deleteById(id_empleado);
	}

}
