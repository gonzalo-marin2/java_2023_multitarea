package service;

import static servicelocator.PaisesLocator.getJsonStream;

import java.util.List;

import model.Pais;

public class PaisesServiceImpl implements PaisesService {
	
	

	@Override
	public List<String> getContinente() {
		return getJsonStream()
				.map(con->con.getContinente())
				.distinct()
				.toList();
	}


	@Override
	public List<Pais> paisesPorContinente(String continente) {
		return getJsonStream()
				.filter(pa->pa.getContinente().equals(continente))
				.toList();
	}
	
	

}
