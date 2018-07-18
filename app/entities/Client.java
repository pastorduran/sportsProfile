package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import models.Cliente;

@Entity
@Table(name = "clients")
@FilterDef(name = "filterName", parameters = @ParamDef(name = "clientName", type = "string"))
@Filter(name = "filterName", condition = "LOWER(name) LIKE :clientName")
@FilterDef(name = "filterLastName", parameters = @ParamDef(name = "clientLastName", type = "string"))
@Filter(name = "filterLastName", condition = "LOWER(last_name) LIKE :clientLastName")
@FilterDef(name = "filterPhone", parameters = @ParamDef(name = "clientPhone", type = "string"))
@Filter(name = "filterPhone", condition = "LOWER(phone) LIKE :clientPhone")
@FilterDef(name = "filterEmail", parameters = @ParamDef(name = "clientEmail", type = "string"))
@Filter(name = "filterEmail", condition = "LOWER(email) LIKE :clientEmail")
@NamedQueries({
	@NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c") 
})
public class Client implements Serializable {

	private static final long serialVersionUID = -8034854026819883935L;
	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	@Column(name = "dni")
	private String dni;
	@Column(name = "name")
	private String name;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "phone")
	private String phone;
	@Column(name = "email")
	private String email;
	@Column(name = "status")
	private String status;

	public Client() {
	}

	public Client(String dni, String name, String lastName, String phone, String email, String status) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.status = status;
	}

	public Client(Cliente cliente) {
		this.dni = cliente.getDni();
		this.name = cliente.getNombre();
		this.lastName = cliente.getApellido();
		this.phone = cliente.getTelefono();
		this.email = cliente.getCorreo();
		this.status = cliente.getEstado();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

}
