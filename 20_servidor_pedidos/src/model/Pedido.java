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
