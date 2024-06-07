package com.ista.practica.models.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_empleado;
	
	@NotNull
    @Size(max = 45)
	private String apellido;
	
	@NotNull
    @Size(max = 45)
	private String nombre;
	
	@NotNull
    @Size(max = 15)
	private String telefono;
	private String direccion;
	
    @Temporal(TemporalType.DATE)
	private Date fecha_nacimiento;
    
    @NotNull
    @Size(max = 45)
	private String observacion;
    
    @NotNull
    @Min(0)
	private int dias_trabajo;
	
	@NotNull
    @DecimalMin(value = "0.00", inclusive = false)
    @Digits(integer=10, fraction=2)
	private double sueldo;

	public Long getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Long id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public int getDias_trabajo() {
		return dias_trabajo;
	}

	public void setDias_trabajo(int dias_trabajo) {
		this.dias_trabajo = dias_trabajo;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public void setDias_trabajo(Integer dias_trabajo) {
        this.dias_trabajo = dias_trabajo;
        this.sueldo = dias_trabajo * 15.0;
    }
}
