package py.edu.uca.lp3.service;

import java.util.List;

import py.edu.uca.lp3.domain.EventoLibreAcceso;

public interface EventoLibreAccesoService {
/**
 * Encuentra todos los eventos de Libre Acceso realizados
 * Parametros:
 * 		Ninguno
 * Retorno:
 * 		Lista de todos los eventos
 * Posibles Excepciones:
 * 		Ninguno
 */
	List<EventoLibreAcceso> encontrarTodos();

/**
 * Encuentra el evento de libre acceso correspondiente a dicho idEvento
 * Parametros:
 * 		idEvento, identificador del evento a ser encontrado
 * Retorno:
 * 		evento encontrado
 * Posibles Excepciones:
 * 		idEvento null
 * 		idEvento no existente
 * @throws Exception 
 */
	EventoLibreAcceso encontrarPorId(Long idEvento) throws Exception;
			
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
	void eliminarEventoLibreAcceso(Long idEvento) throws Exception;
/**
 * Guardar evento de libre acceso 
 * Parametros: 
 * 		eventoLibreAcceso, evento a ser guardado
 * Retorno: 
 * 		Ninguno
 * Posibles Excepciones:
 * 		eventoLibreAcceso null
 * @throws Exception 
 **/
	void guardarEventoLibreAcceso(EventoLibreAcceso eventoLibreAcceso) throws Exception;
	
}
