package pe.uni.eurekaapp.controller;

import java.util.List;
import java.util.Map;
import pe.uni.eurekaapp.service.RepoService;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class RepoController {

	private RepoService repoService;

	public RepoController() {
		repoService = new RepoService();
	}
	
	public List<Map<String, ?>> traerMovimientos(String cuenta) {
		return repoService.getMovimientos(cuenta);
	}
	
}
