package view.adapters;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Pais;
import service.PaisesServiceFactory;

public class TablaPaisesModel extends  AbstractTableModel {
	
	List<Pais> paises;
	final int COLS=3;
	
	public TablaPaisesModel(String continente) {
		paises=PaisesServiceFactory.getPaisesService().paisesPorContinente(continente);//para mostrar los países por continente
	}
	@Override
	public int getRowCount() {
		return paises.size();//tantas filas como países haya
	}
	@Override
	public int getColumnCount() {
		return COLS;
	}
	@Override
	public String getColumnName(int column) {
		/*PARA JAVA 17 Y SS
		return switch(column) {
		case 0->"Nombre";
		case 1->"Email";
		case 2->"Salario";
		default->"Indeterminada";
		};*/
		
		switch(column) {
		case 0:
			return "País";
		case 1:
			return "Capital";
		case 2:
			return "Población";
		default:
			return "Indeterminada";
		}
	}
	@Override
	public Object getValueAt(int row, int column) {//según el número de la fila, sacamos los diferentes valores
		switch(column) {
			case 0:
				return paises.get(row).getNombre();
			case 1:
				return paises.get(row).getCapital();
			case 2:
				return paises.get(row).getPoblacion();
			default:
				return null;
		}
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {//la interrogación de class<?> significa que acepta cualquier tipo de dato
		switch(columnIndex) {
			case 0:
				return String.class;
			case 1:
				return String.class;
			case 2:
				return Long.class;
			default:
				return null;
		}
		
	}
}

