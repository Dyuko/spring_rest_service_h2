package py.edu.uca.lp3.service;

import java.util.List;

import py.edu.uca.lp3.domain.Pregunta;

public interface PreguntaService {
/**
 * Guarda la pregunta en la lista de preguntas de la charla con dicho idCharla
 * Parametros:
 *		idCharla, identificador de la charla sobre el cual guardar la pregunta
 *		pregunta, pregunta a ser guardada
 * Retorno:
 *		Ninguno
 *	Posibles Excepciones:
 *		idCharla null
 *		idCharla no existente
 *		pregunta NULL
 * @throws Exception 
 */
	void guardarPregunta(Long idCharla, Pregunta pregunta) throws Exception;
	
/**
 * Elimina la pregunta correspondiente a dicha idPregunta
 * Parametros:
 * 		idPregunta, identificador de la pregunta a ser eliminada
 * Retorno:
 * 		Ninguno
 * Posibles Excepciones:
 * 		idPregunta null
 * 		idPregunta no existente
 * @throws Exception 
 */
	void eliminarPregunta(Long idPregunta) throws Exception;
	
/**
 * Encuentra la pregunta correspondiente a dicha idPregunta
 * Parametros:
 * 		idPregunta, identificador de la pregunta a ser encontrada
 * Retorno:
 * 		pregunta encontrada
 * Posibles Excepciones:
 * 		idPregunta null
 * 		idPregunta no existente
 * @throws Exception 
 */
	Pregunta encontrarPorId(Long idPregunta) throws Exception;
	
/**
 * Encuentra la lista de preguntas correspondiente a una fecha
 * Parametros:
 * 		fecha, fecha en el cual se desea consultar las preguntas hechas
 * Retorno:
 * 		lista de preguntas encontradas en dicha fecha
 * Posibles Excepciones:
 * 		fecha NULL
 * @throws Exception 
 */	
	List<Pregunta> encontrarPorFecha(String fecha) throws Exception;
	
/**
 * Encuentra todas las preguntas de una charla.
 * Parametros:
 * 		idCharla, identificador de la charla en el cual se desea consultar todas las preguntas
 * Retorno:
 * 		lista de preguntas hechas de la charla
 * Posibles Excepciones:
 * 		idCharla null
 * 		idCharla no existente
 * @throws Exception 
 */
	List<Pregunta> encontrarTodos(Long idCharla) throws Exception;
	
/**
 * Consulta la cantidad de votos positivos recibidos en una pregunta
 * Parametros:
 * 		idPregunta: identificador de la pregunta en la cual se consulta los votos positivos
 * Retorno:
 * 		cantidad de votos positivos de la pregunta
 * Posibles Excepciones:
 * 		idPregunta null
 * 		idPregunta no existente
 * @throws Exception 
 */
	Integer consultarVotosPositivos(Long idPregunta) throws Exception;
	
/**
 * Consulta la cantidad de votos negativos recibidos en una pregunta
 * Parametros:
 * 		idPregunta: identificador de la pregunta en la cual se consulta los votos negativos
 * Retorno:
 * 		cantidad de votos negativos de la pregunta
 * Posibles Excepciones:
 * 		idPregunta null
 * 		idPregunta no existente
 * @throws Exception 
 */	
	Integer consultarVotosNegativos(Long idPregunta) throws Exception;
	
/**
 * Asignar voto positivo a una pregunta
 * Parametros:
 * 		idPregunta, identificador de la pregunta a la cual asignar voto positivo
 * Retorno:
 * 		Ninguno
 * Posibles Excepciones:
 * 		idPregunta null
 * 		idPregunta no existente
 * @throws Exception 
 */
	void asignarVotoPositivo(Long idPregunta) throws Exception;
	
/**
 * Asignar voto negativo a una pregunta
 * Parametros:
 * 		idPregunta, identificador de la pregunta a la cual asignar voto negativo
 * Retorno:
 * 		Ninguno
 * Posibles Excepciones:
 * 		idPregunta null
 * 		idPregunta no existente
 * @throws Exception 
 */
	void asignarVotoNegativo(Long idPregunta) throws Exception;

/**
 * Listar todas las preguntas
 * Parametros:
 * 		Ninguno
 * Retorno:
 * 		Lista de todas las preguntas
 * Posibles excepciones:
 * 		Ninguno
 */
	List<Pregunta> listarTodos();
	
/**
 * Listar todas las preguntas dada una fecha
 * Parametros:
 * 		Fecha de la cual consultar las preguntas
 * Retorno
 * 		Lista de preguntas hechas en la fecha
 * Posibles excepciones:
 * 		fecha null
 * @throws Exception 
 */
	List<Pregunta> listarPorFecha(String fecha) throws Exception;
	
/**
 * Listar todas las preguntas dada una fecha y una charla
 * Parametros:
 * 		Fecha de la cual consultar las preguntas
 * 		idCharla, identificador de la charla sobre la cual consultar las preguntas
 * Retorno:
 * 		Lista de preguntas que pertenezcan a la charla hechas en la fecha
 * Posibles exepciones:
 * 		fecha null
 * 		idcharla null
 * 		idcharla inexistente
 * @throws Exception 
 */
	List<Pregunta> listarPorFechayCharla(String fecha, Long idCharla) throws Exception;
}
