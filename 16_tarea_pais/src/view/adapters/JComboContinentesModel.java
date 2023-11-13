package view.adapters;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Pais;
import service.PaisesServiceFactory;

public class JComboContinentesModel extends DefaultComboBoxModel<String> {

	List<String> continentes;
	
	public JComboContinentesModel() {
		continentes=new ArrayList<>(PaisesServiceFactory.getPaisesService().getContinente());
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return continentes.size();
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return continentes.get(index);
	}
}
