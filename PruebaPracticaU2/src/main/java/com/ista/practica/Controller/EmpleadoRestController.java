package com.ista.practica.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.practica.models.Entity.Empleado;
import com.ista.practica.models.Service.IEmpleadoService;

@RestController
@RequestMapping("/api")
public class EmpleadoRestController {

	@Autowired
	private IEmpleadoService empleadoService;
	
	@GetMapping("/empleado")
	public ResponseEntity<List<Empleado>> indext() {
	    List<Empleado> empleados = empleadoService.findAll();
	    return ResponseEntity.ok(empleados);
	}

	
	@GetMapping("/empleado/{id_empleado}")
	public ResponseEntity<Empleado> findById(@PathVariable Long id_empleado) {
	    Empleado empleado = empleadoService.findById(id_empleado);
	    if (empleado == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(empleado);
	}

	
	@PostMapping("/empleado")
	public ResponseEntity<Empleado> create (@RequestBody Empleado empleado) {
		
		Empleado guardarEmpl = empleadoService.save(empleado);
		return ResponseEntity.status(HttpStatus.CREATED).body(guardarEmpl);
	}
	
	@PutMapping("/empleado/{id_empleado}")
	public ResponseEntity<Void> update(@PathVariable Long id_empleado, @RequestBody Empleado empleado) {
		
		Empleado empleadoActual = empleadoService.findById(id_empleado);
		empleadoActual.setApellido(empleado.getApellido());
		empleadoActual.setDias_trabajo(empleado.getDias_trabajo());
		empleadoActual.setDireccion(empleado.getDireccion());
		empleadoActual.setFecha_nacimiento(empleado.getFecha_nacimiento());
		empleadoActual.setNombre(empleado.getNombre());
		empleadoActual.setObservacion(empleado.getObservacion());
		empleadoActual.setSueldo(empleado.getSueldo());
		empleadoActual.setTelefono(empleado.getTelefono());
		
		empleadoService.save(empleadoActual);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	@DeleteMapping("/empleado/{id_empleado}")
	public ResponseEntity<Void> delete(@PathVariable Long id_empleado) {
				
		empleadoService.delete(id_empleado);
		
		return ResponseEntity.noContent().build();
	}
}
