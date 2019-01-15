package py.edu.uca.lp3.service;

import java.util.List;

import py.edu.uca.lp3.domain.BaseEvento;

public interface EventoService {
/**
 * Encuentra todos los eventos realizados
 * Parametros:
 * 		Ninguno
 * Retorno:
 * 		Lista de todos los eventos
 * Posibles Excepciones:
 * 		Ninguno
 */
	List<BaseEvento> encontrarTodos();

/**
 * Encuentra el evento correspondiente a dicho idEvento
 * Parametros:
 * 		idEvento, identificador del evento a ser encontrado
 * Retorno:
 * 		evento encontrado
 * Posibles Excepciones:
 * 		idEvento null
 * 		idEvento no existente
 * @throws Exception 
 */
	BaseEvento encontrarPorId(Long idEvento) throws Exception;
		
/**
 * Elimina el evento correspondiente a dicho idEvento
 * Parametros:
 * 		idEvento, identificador del evento a ser eliminado
 * Retorno:
 * 		Ninguno
 * Posibles Excepciones:
 * 		idEvento null
 * 		idEvento no existente
 * @throws Exception 
 */
	void eliminarEvento(Long idEvento) throws Exception;
}
