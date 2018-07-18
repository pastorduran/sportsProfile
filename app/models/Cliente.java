package models;

import entities.Client;

public class Cliente {
	
	private Integer id;
	private String dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private String correo;
	private String estado;
	
	public Cliente() {
		
	}
	
	public Cliente(Integer id, String dni, String nombre, 
			String apellido, String telefono, String correo, String estado) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.correo = correo;
		this.estado = estado;
	}
	
	public Cliente(Client client) {
		this.id = client.getId();
		this.dni = client.getDni();
		this.nombre = client.getName();
		this.apellido = client.getLastName();
		this.telefono = client.getPhone();
		this.correo = client.getEmail();
		this.estado = client.getStatus();
	}

	public Integer getId() {
		return id;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
