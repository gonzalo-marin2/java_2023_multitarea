package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
//sacamos los datos desde el json, no desde la bbdd, las dos siguientes anotaciones no harían falta
//tampòco los hibernates, las dependencias, etc..
@Entity
@Table(name="pedidos")

public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedidos;
	private String producto;
	private String tienda;
	private LocalDate fechaPedido;
	private double precio;
}
