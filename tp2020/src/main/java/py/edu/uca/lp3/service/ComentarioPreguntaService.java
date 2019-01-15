package py.edu.uca.lp3.service;

import java.util.List;

import py.edu.uca.lp3.domain.ComentarioPregunta;

public interface ComentarioPreguntaService {
/**
 * Guarda un comentario vinculado a una pregunta, la fechaEnvio se guarda como la fecha actual
 * Parametros:
 * 		idPregunta, identificador de la pregunta al cual agregar un comentario
 * 		comentarioPregunta, comentario a ser agregado en una pregunta
 * Retorno:
 * 		Ninguno
 * Posibles Excepciones:
 * 		idPregunta null
 *  	comentarioPregunta NULL
 * 		idPregunta no existente
 * @throws Exception 
 */
	void guardarComentario(Long idPregunta, ComentarioPregunta comentarioPregunta) throws Exception;
	
/**
 * Elimina un comentario de una pregunta
 * Parametros:
 * 		idComentario, identificador del comentario a ser eliminado
 * Retorno:
 * 		Ninguno
 * Posibles Excepciones:
 * 		idComentario null
 * 		idComentario no existente
 * @throws Exception 
 */
	void eliminarComentario(Long idComentario) throws Exception;

/**
 * Consulta todos los comentarios de una pregunta
 * Parametros:
 * 		idPregunta, identificador de la pregunta a ser consultada sus comentarios
 * Retorno:
 * 		lista de comentarios de la pregunta
 * Posibles Excepciones:
 * 		idPregunta null
 * 		idPregunta no existente
 * @throws Exception 
 */
	List<ComentarioPregunta> encontrarTodos(Long idPregunta) throws Exception;
	
/**
 * Listar todos los comentarios
 * Parámetros:
 * 		Ninguno
 * Retorno:
 * 		lista de todos los comentarios
 * Posibles excepciones:
 * 		Ninguno
 */
	List<ComentarioPregunta> listarTodos();
}
