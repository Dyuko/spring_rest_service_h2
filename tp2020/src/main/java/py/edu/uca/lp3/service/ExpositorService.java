package py.edu.uca.lp3.service;

import java.util.List;

import py.edu.uca.lp3.domain.Charla;
import py.edu.uca.lp3.domain.BaseEvento;
import py.edu.uca.lp3.domain.ExpositorEstudiante;
import py.edu.uca.lp3.domain.ExpositorInvestigador;
import py.edu.uca.lp3.domain.ExpositorProfesionalInvitado;
import py.edu.uca.lp3.domain.ExpositorProfesor;
import py.edu.uca.lp3.domain.Facultad;
import py.edu.uca.lp3.domain.PersonaConId;
import py.edu.uca.lp3.domain.Universidad;

public interface ExpositorService {

/**
 * Listar todos los expositores de un evento	
 * Parametros:
 * 		idEvento:  identificador del evento en el cual se desea consultar todos los expositores
 * Retorno:
 * 		lista de todos los expositores
 * Posibles Excepciones:
 * 		idEvento null
 * 		idEvento no existente
 * @throws Exception 
 */
	List<PersonaConId> encontrarTodos(Long idEvento) throws Exception; 
	
/**
 * Listar todos los expositores estudiantes de un evento	
 * Parametros:
 * 		idEvento:  identificador del evento en el cual se desea consultar todos los expositores
 * Retorno:
 * 		lista de todos los expositores
 * Posibles Excepciones:
 * 		idEvento null
 * 		idEvento no existente
 * @throws Exception 
 */
	List<ExpositorEstudiante> encontrarTodosEstudiante(Long idEvento) throws Exception; 
	
/**
 * Listar todos los expositores investigadores  de un evento	
 * Parametros:
 * 		idEvento:  identificador del evento en el cual se desea consultar todos los expositores
 * Retorno:
 * 		lista de todos los expositores
 * Posibles Excepciones:
 * 		idEvento null
 * 		idEvento no existente
 * @throws Exception 
 */
	List<ExpositorInvestigador> encontrarTodosInvestigador(Long idEvento) throws Exception; 
	
/**
 * Listar todos los expositores profesionales invitados de un evento	
 * Parametros:
 * 		idEvento:  identificador del evento en el cual se desea consultar todos los expositores
 * Retorno:
 * 		lista de todos los expositores
 * Posibles Excepciones:
 * 		idEvento null
 * 		idEvento no existente
 * @throws Exception 
 */
	List<ExpositorProfesionalInvitado> encontrarTodosProfesional(Long idEvento) throws Exception; 
	
/**
 * Listar todos los expositores profesores de un evento	
 * Parametros:
 * 		idEvento:  identificador del evento en el cual se desea consultar todos los expositores
 * Retorno:
 * 		lista de todos los expositores
 * Posibles Excepciones:
 * 		idEvento null
 * 		idEvento no existente
 * @throws Exception 
 */
	List<ExpositorProfesor> encontrarTodosProfesor(Long idEvento) throws Exception; 
	
/**
 * Guarda un expositor estudiante en una charla
 * Parametros:
 * 		idCharla, identificador de la charla en la cual ubicar un expositor
 *		expositor, expositor a ser ubicado en una charla
 * Retorno:
 * 		Ninguno
 * Posibles Excepciones:
 * 		idCharla null
 * 		idcharla no existente
 * 		expositor NULL
 * @throws Exception 
 */
	void guardarExpositorEstudianteCharla(Long idCharla, ExpositorEstudiante expositor) throws Exception;

/**
 * Guarda un expositor investigador en una charla
 * Parametros:
 * 		idCharla, identificador de la charla en la cual ubicar un expositor
 *		expositor, expositor a ser ubicado en una charla
 * Retorno:
 * 		Ninguno
 * Posibles Excepciones:
 * 		idCharla null
 * 		idcharla no existente
 * 		expositor NULL
 * @throws Exception 
 */
	void guardarExpositorInvestigadorCharla(Long idCharla, ExpositorInvestigador expositor) throws Exception;
	
/**
 * Guarda un expositor profesional en una charla
 * Parametros:
 * 		idCharla, identificador de la charla en la cual ubicar un expositor
 *		expositor, expositor a ser ubicado en una charla
 * Retorno:
 * 		Ninguno
 * Posibles Excepciones:
 * 		idCharla null
 * 		idcharla no existente
 * 		expositor NULL
 * @throws Exception 
 */
	void guardarExpositorProfesionalCharla(Long idCharla, ExpositorProfesionalInvitado expositor) throws Exception;
	
/**
 * Guarda un expositor profesor en una charla
 * Parametros:
 * 		idCharla, identificador de la charla en la cual ubicar un expositor
 *		expositor, expositor a ser ubicado en una charla
 * Retorno:
 * 		Ninguno
 * Posibles Excepciones:
 * 		idCharla null
 * 		idcharla no existente
 * 		expositor NULL
 * @throws Exception 
 */
	void guardarExpositorProfesorCharla(Long idCharla, ExpositorProfesor expositor) throws Exception;
	
/**
 * Consulta la Universidad de un expositor estudiante
 * Parametros: 
 * 		documentoIdentidad, identificador del expositor estudiante
 * Retorno:
 * 		universidad del expositor estudiante
 * Posibles Excepciones:
 * 		documentoIdentidad null
 * 		documentoIdentidad no existente
 * @throws Exception 
 */
	Universidad encontrarUniversidadEstudiante(String documentoIdentidad) throws Exception;
	
/**
 * Consulta la Universidad de un expositor estudiante
 * Parametros:
 * 		documentoIdentidad, identificador del expositor estudiante
 * Retorno:
 * 		facultad del expositor estudiante
 * Posibles Excepciones:
 * 		documentoIdentidad null
 * 		documentoIdentidad no existente
 * @throws Exception 
 */
	Facultad encontrarFacultadEstudiante(String documentoIdentidad) throws Exception;

/**
 * Consulta las charlas de un investigador
 * Parametros:
 *  	documentoIdentidad, identificador del expositor
 * Retorno:
 * 		Ninguno
 * Posibles Excepciones:
 * 		documentoIdentidad null
 * 		documentoIdentidad no existente
 * @throws Exception 
 */
	
	List<Charla> encontrarCharlaInvestigador(String documentoIdentidad) throws Exception;
	
/**
 * Consulta los eventos en los que un expositor investigador ha sido invitado como orador	
 * Parametros:
 * 		documentoIdentidad, identificador del expositor investigador
 * Retorno:
 * 		lista de eventos en los que el investigador haya participado como orador
 * Posibles Excepciones:
 * 		documentoIdentidad null
 * 		documentoIdentidad no existente
 * @throws Exception 
 */
	List<BaseEvento> encontrarEventoInvestigador(String documentoIdentidad) throws Exception;
	
/**
 * Eliminar expositor dado su identificador, en cadena se eliminan todas sus charlas, preguntas y los comentarios de las preguntas
 * Parametros:
 * 		idExpositor, identificador del expositor a eliminar
 * Retorno:
 * 		Ninguno
 * Posibles Excepciones:
 * 		idExpositor null
 * @throws Exception 
 */
	void eliminarExpositor(Long idExpositor) throws Exception;

/**
 * Encuentra Expositor Estudiante
 * Parametros:
 * 		documentoIdentidad, identificador del expositor a encontrar
 * Retorno:
 * 		expositor encontrado
 * Posibles excepciones:
 * 		documentoIdentidad null
 * @throws Exception 
 */
	ExpositorEstudiante encontrarExpositorEstudiante(String documentoIdentidad) throws Exception;
/**
 * Encuentra Expositor Estudiante
 * Parametros:
 * 		documentoIdentidad, identificador del expositor a encontrar
 * Retorno:
 * 		expositor encontrado
 * Posibles excepciones:
 * 		documentoIdentidad null
 * @throws Exception 
 */
	ExpositorInvestigador encontrarExpositorInvestigador(String documentoIdentidad) throws Exception;
/**
 * Encuentra Expositor Estudiante
 * Parametros:
 * 		documentoIdentidad, identificador del expositor a encontrar
 * Retorno:
 * 		expositor encontrado
 * Posibles excepciones:
 * 		documentoIdentidad null
 * @throws Exception 
 */
	ExpositorProfesionalInvitado encontrarExpositorProfesionalInvitado(String documentoIdentidad) throws Exception;
/**
 * Encuentra Expositor Estudiante
 * Parametros:
 * 		documentoIdentidad, identificador del expositor a encontrar
 * Retorno:
 * 		expositor encontrado
 * Posibles excepciones:
 * 		documentoIdentidad null
 * @throws Exception 
 */
	ExpositorProfesor encontrarExpositorProfesor(String documentoIdentidad) throws Exception;
/**
 * Encuentra Expositor
 * Parametros:
 * 		documentoIdentidad, identificador del expositor a encontrar
 * Retorno:
 * 		expositor encontrado
 * Posibles excepciones:
 * 		documentoIdentidad null
 * @throws Exception 
 */
	PersonaConId encontrarExpositor(String documentoIdentidad) throws Exception;
/**
 * Lista todos los expositores estudiantes
 * Parametros:
 * 		Ninguno
 * Retorno:
 * 		Lista de expositores estudiantes
 * Posibles excepciones:
 * 		Ninguno
 * @return
 */
	List<ExpositorEstudiante> listarTodosEstudiante();
	/**
	 * Lista todos los expositores investigadores
	 * Parametros:
	 * 		Ninguno
	 * Retorno:
	 * 		Lista de expositores investigadores
	 * Posibles excepciones:
	 * 		Ninguno
	 * @return
	 */
	List<ExpositorInvestigador> listarTodosInvestigador();
	/**
	 * Lista todos los expositores profesionales invitados
	 * Parametros:
	 * 		Ninguno
	 * Retorno:
	 * 		Lista de expositores profesionales invitados
	 * Posibles excepciones:
	 * 		Ninguno
	 * @return
	 */
	List<ExpositorProfesionalInvitado> listarTodosProfesional();
	/**
	 * Lista todos los expositores profesores
	 * Parametros:
	 * 		Ninguno
	 * Retorno:
	 * 		Lista de expositores profesores
	 * Posibles excepciones:
	 * 		Ninguno
	 * @return
	 */
	List<ExpositorProfesor> listarTodosProfesor();
}
