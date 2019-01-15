package py.edu.uca.lp3.service;

import java.util.List;

import py.edu.uca.lp3.domain.EventoPreInscripcion;
import py.edu.uca.lp3.domain.Inscripto;

public interface EventoPreInscripcionService {
	/**
	 * Encuentra todos los eventos de Pre Inscripcion realizados
	 * Parametros:
	 * 		Ninguno
	 * Retorno:
	 * 		Lista de todos los eventos
	 * Posibles Excepciones:
	 * 		Ninguno
	 */
	List<EventoPreInscripcion> encontrarTodos();

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
	EventoPreInscripcion encontrarPorId(Long idEvento) throws Exception;
				
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
	void eliminarEventoPreInscripcion(Long idEvento) throws Exception;
	/**
	 * Guardar evento con Pre-Inscripcion obligatoria 
	 * Parametros: 
	 * 		eventoPreInscripcion, evento a ser guardado
	 * Retorno: 
	 * 		Ninguno
	 * Posibles Excepciones:
	 * 		eventoPreInscripcion NULL
	 * @throws Exception 
	 */
	void guardarEventoPreInscripcion(EventoPreInscripcion eventoPreInscripcion) throws Exception;
	
	/**
	 * Inscribe una persona a un evento con Pre-Inscripcion obligatoria
	 * Se pretende que encontrado el evento con idEvento, se introduzca el inscripto en su lista de personas.
	 * Parametros:
	 * 		idEvento, identificador del evento donde ser inscripto
	 * 		inscripto, persona a ser inscripta en el evento
	 * Retorno:
	 * 		Ninguno
	 * Posibles Excepciones:
	 * 		idEvento null
	 * 		idEvento no existente
	 * 		inscripto NULL
	 * @throws Exception 
	 */
	void inscribirPersona(Long idEvento, Inscripto inscripto) throws Exception;
	
	/**
	 * Lista todos los inscriptos a un evento
	 * Parametros
	 * 		idEvento, identificador del evento
	 * Retorno:
	 * 		Lista de inscriptos al evento
	 * Posibles Excepciones:
	 * 		idEvento null
	 * @throws Exception 
	 */
	List<Inscripto> encontrarTodosInscripto(Long idEvento) throws Exception;
	
	/**
	 * Listar todos los inscriptos de todos los eventos con preinscripcion
	 * Parametros:
	 * 		Ninguno
	 * Retorno:
	 * 		Lista de todos los inscriptos en todos los eventos pre inscripción
	 * Posibles excepciones:
	 * 		Ninguno
	 */
	List<Inscripto> listarTodosInscripto();
}
