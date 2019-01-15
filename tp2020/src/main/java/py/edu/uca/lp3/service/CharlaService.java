package py.edu.uca.lp3.service;

import java.util.List;

import py.edu.uca.lp3.domain.Charla;

public interface CharlaService {
/**
 * Guarda la charla en la lista de charlas del evento con costo correspondiente a dicho idEvento.
 * Parametros: 
 * 		idEvento, identificador del evento sobre el cual guardar la charla
 * 		charla, charla a ser guardada
 * Retorno:
 * 		Ninguno
 * Posibles Excepciones:
 * 		idEvento null
 * 		charla null
 * 		idEvento inexistente
 * @throws Exception 
 */
	void guardarCharla(Long idEvento, Charla charla) throws Exception;
	
/**
 * Consultar todas las charlas de un evento
 * Parametros:
 * 		idEvento, identificador del evento sobre el cual consultar todas las charlas
 * Retorno:
 * 		lista de todas las charlas del evento
 * Posibles Excepciones:
 * 		idEvento null
 * 		idEvento no existente
 * @throws Exception 
 */
	List<Charla> encontrarTodos(Long idEvento) throws Exception;
	
/**
 * Encuentra la charla correspondiente a dicha idCharla
 * Parametros:
 * 		idCharla, identificador de la charla a ser encontrada
 * Retorno
 * 		charla encontrada
 * Posibles Excepciones:
 * 		idCharla null
 * 		idCharla no existente
 * @throws Exception 
 */
	Charla encontrarPorId(Long idCharla) throws Exception;

/**
 * Eliminar la charla con dicha idCharla
 * Parametros:
 *		idCharla, identificador de la charla a ser eliminado
 * Retorno;
 *		Ninguno
 * Posibles Excepciones:
 * 		idCharla null
 * 		idcharla no existente
 * @throws Exception 
 */
	void eliminarCharla(Long idCharla) throws Exception;
	
/**
 * Listar todas las charlas existentes
 * Parametros:
 * 		Ninguno
 * Retorno:
 * 		Lista de todos las charlas existentes
 * Posibles Excepciones:
 * 		Ninguno
 */
	List<Charla> listarTodos();
}
