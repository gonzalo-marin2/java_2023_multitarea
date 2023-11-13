package service;

import java.util.List;

import model.Pais;

public interface PaisesService {
	List<String> getContinente();
	List<Pais> paisesPorContinente(String continente);
}
