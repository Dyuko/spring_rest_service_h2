package py.edu.uca.lp3.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.BaseEvento;
import py.edu.uca.lp3.domain.Charla;
import py.edu.uca.lp3.domain.ComentarioPregunta;
import py.edu.uca.lp3.domain.ExpositorEstudiante;
import py.edu.uca.lp3.domain.ExpositorInvestigador;
import py.edu.uca.lp3.domain.ExpositorProfesionalInvitado;
import py.edu.uca.lp3.domain.ExpositorProfesor;
import py.edu.uca.lp3.domain.Facultad;
import py.edu.uca.lp3.domain.PersonaConId;
import py.edu.uca.lp3.domain.Pregunta;
import py.edu.uca.lp3.domain.Universidad;
import py.edu.uca.lp3.repository.CharlaRepository;
import py.edu.uca.lp3.repository.ExpositorEstudianteRepository;
import py.edu.uca.lp3.repository.ExpositorInvestigadorRepository;
import py.edu.uca.lp3.repository.ExpositorProfesionalInvitadoRepository;
import py.edu.uca.lp3.repository.ExpositorProfesorRepository;
import py.edu.uca.lp3.service.CharlaService;
import py.edu.uca.lp3.service.ComentarioPreguntaService;
import py.edu.uca.lp3.service.EventoService;
import py.edu.uca.lp3.service.ExpositorService;
import py.edu.uca.lp3.service.PreguntaService;

@Service
public class ExpositorServiceImpl implements ExpositorService {

	@Autowired
	private ExpositorEstudianteRepository expositorEstudianteRepository;
	@Autowired
	private ExpositorInvestigadorRepository expositorInvestigadorRepository;
	@Autowired
	private ExpositorProfesionalInvitadoRepository expositorProfesionalInvitadoRepository;
	@Autowired
	private ExpositorProfesorRepository expositorProfesorRepository;
	@Autowired
	private CharlaService charlaService;
	@Autowired
	private CharlaRepository charlaRepository;
	@Autowired
	private EventoService eventoService;
	@Autowired
	private PreguntaService preguntaService;
	@Autowired
	private ComentarioPreguntaService comentarioPreguntaService;

	@Override
	public List<ExpositorEstudiante> encontrarTodosEstudiante(Long idEvento) throws Exception {
		if (idEvento == null) {
			throw new Exception("Se ha recibido idEvento nulo");
		}
		if (eventoService.encontrarPorId(idEvento) == null) {
			throw new Exception("No existe Evento con dicho identificador");
		}
		// Busco todas las charlas del evento, y por cada charla verifico si su idExpositor esta en el repositorio
		List<Charla> charlas;
		charlas = charlaService.encontrarTodos(idEvento);
		Iterator<Charla> charlasIterator = charlas.iterator();
		List<ExpositorEstudiante> expositoresEstudiante = new ArrayList<>();
		Charla charla;
		ExpositorEstudiante expositorEstudiante;
		while (charlasIterator.hasNext()) {
			charla = charlasIterator.next();
			if (charla.getIdExpositor() != null) {
				expositorEstudiante = expositorEstudianteRepository.findOne(charla.getIdExpositor());
				if (expositorEstudiante != null) {
					expositoresEstudiante.add(expositorEstudiante);
				}
			}
		}
		return expositoresEstudiante;
	}

	@Override
	public List<ExpositorInvestigador> encontrarTodosInvestigador(Long idEvento) throws Exception {
		if (idEvento == null) {
			throw new Exception("Se ha recibido idEvento nulo");
		}
		if (eventoService.encontrarPorId(idEvento) == null) {
			throw new Exception("No existe Evento con dicho identificador");
		}
		// Busco todas las charlas del evento
		List<Charla> charlas;
		charlas = charlaService.encontrarTodos(idEvento);
		Iterator<Charla> charlasIterator = charlas.iterator();
		// Listo todos los Expositores investigadores
		List<ExpositorInvestigador> expositoresInvestigador = new ArrayList<>();
		Charla charla;
		ExpositorInvestigador expositorInvestigador;
		while (charlasIterator.hasNext()) {
			charla = charlasIterator.next();
			if (charla.getIdExpositor() != null) {
				expositorInvestigador = expositorInvestigadorRepository.findOne(charla.getIdExpositor());
				if (expositorInvestigador != null) {
					expositoresInvestigador.add(expositorInvestigador);
				}
			}
		}
		return expositoresInvestigador;
	}

	@Override
	public List<ExpositorProfesionalInvitado> encontrarTodosProfesional(Long idEvento) throws Exception {
		if (idEvento == null) {
			throw new Exception("Se ha recibido idEvento nulo");
		}
		if (eventoService.encontrarPorId(idEvento) == null) {
			throw new Exception("No existe Evento con dicho identificador");
		}
		// Busco todas las charlas del evento
		List<Charla> charlas;
		charlas = charlaService.encontrarTodos(idEvento);
		Iterator<Charla> charlasIterator = charlas.iterator();
		// Listo todos los Expositores Profesionales Invitados
		List<ExpositorProfesionalInvitado> expositoresProfesionalInvitado = new ArrayList<>();
		Charla charla;
		ExpositorProfesionalInvitado expositorProfesionalInvitado;
		while (charlasIterator.hasNext()) {
			charla = charlasIterator.next();
			if (charla.getIdExpositor() != null) {
				expositorProfesionalInvitado = expositorProfesionalInvitadoRepository.findOne(charla.getIdExpositor());
				if (expositorProfesionalInvitado != null) {
					expositoresProfesionalInvitado.add(expositorProfesionalInvitado);
				}
			}
		}
		return expositoresProfesionalInvitado;
	}

	@Override
	public List<ExpositorProfesor> encontrarTodosProfesor(Long idEvento) throws Exception {
		if (idEvento == null) {
			throw new Exception("Se ha recibido idEvento nulo");
		}
		if (eventoService.encontrarPorId(idEvento) == null) {
			throw new Exception("No existe Evento con dicho identificador");
		}
		// Busco todas las charlas del evento
		List<Charla> charlas;
		charlas = charlaService.encontrarTodos(idEvento);
		Iterator<Charla> charlasIterator = charlas.iterator();
		// Listo todos los Expositores profesores
		List<ExpositorProfesor> expositoresProfesor = new ArrayList<>();
		Charla charla;
		ExpositorProfesor expositorProfesor;
		while (charlasIterator.hasNext()) {
			charla = charlasIterator.next();
			if (charla.getIdExpositor() != null) {
				expositorProfesor = expositorProfesorRepository.findOne(charla.getIdExpositor());
				if (expositorProfesor != null) {
					expositoresProfesor.add(expositorProfesor);
				}
			}
		}
		return expositoresProfesor;
	}

	@Override
	public List<PersonaConId> encontrarTodos(Long idEvento) throws Exception {
		if (idEvento == null) {
			throw new Exception("Se ha recibido idEvento nulo");
		}
		if (eventoService.encontrarPorId(idEvento) == null) {
			throw new Exception("No existe Evento con dicho identificador");
		}
		List<PersonaConId> personas = new ArrayList<>();
		personas.addAll(encontrarTodosEstudiante(idEvento));
		personas.addAll(encontrarTodosInvestigador(idEvento));
		personas.addAll(encontrarTodosProfesional(idEvento));
		personas.addAll(encontrarTodosProfesor(idEvento));
		return personas;
	}

	@Override
	public void guardarExpositorEstudianteCharla(Long idCharla, ExpositorEstudiante expositor) throws Exception {
		if (idCharla == null) {
			throw new Exception("Se ha recibido idCharla nulo");
		}
		if (expositor == null) {
			throw new Exception("Se ha recibido expositor nulo");
		}
		if (charlaService.encontrarPorId(idCharla) == null) {
			throw new Exception("No existe Charla con dicho identificador");
		}
		if (expositor.getFacultad() == null) {
			throw new Exception("Facultad no puede ser null");
		}
		if (expositor.getUniversidad() == null) {
			throw new Exception("Universidad no puede ser null");
		}
		expositorEstudianteRepository.save(expositor);
		Charla charla;
		charla = charlaService.encontrarPorId(idCharla);
		Long idExpositor=charla.getIdExpositor();
		charla.setIdExpositor(expositor.getIdExpositor());
		if(idExpositor!=null)
		{
			eliminarExpositor(idExpositor);
		}
		charlaRepository.save(charla);
	}

	@Override
	public void guardarExpositorInvestigadorCharla(Long idCharla, ExpositorInvestigador expositor) throws Exception {
		if (idCharla == null) {
			throw new Exception("Se ha recibido idCharla nulo");
		}
		if (expositor == null) {
			throw new Exception("Se ha recibido expositor nulo");
		}
		if (charlaService.encontrarPorId(idCharla) == null) {
			throw new Exception("No existe Charla con dicho identificador");
		}
		expositorInvestigadorRepository.save(expositor);
		Charla charla;
		charla = charlaService.encontrarPorId(idCharla);
		Long idExpositor=charla.getIdExpositor();
		charla.setIdExpositor(expositor.getIdExpositor());
		if(idExpositor!=null)
		{
			eliminarExpositor(idExpositor);
		}
		charlaRepository.save(charla);
	}

	@Override
	public void guardarExpositorProfesionalCharla(Long idCharla, ExpositorProfesionalInvitado expositor)
			throws Exception {
		if (idCharla == null) {
			throw new Exception("Se ha recibido idCharla nulo");
		}
		if (expositor == null) {
			throw new Exception("Se ha recibido expositor nulo");
		}
		if (charlaService.encontrarPorId(idCharla) == null) {
			throw new Exception("No existe Charla con dicho identificador");
		}
		expositorProfesionalInvitadoRepository.save(expositor);
		Charla charla;
		charla = charlaService.encontrarPorId(idCharla);
		Long idExpositor=charla.getIdExpositor();
		charla.setIdExpositor(expositor.getIdExpositor());
		if(idExpositor!=null)
		{
			eliminarExpositor(idExpositor);
		}
		charlaRepository.save(charla);
	}

	@Override
	public void guardarExpositorProfesorCharla(Long idCharla, ExpositorProfesor expositor) throws Exception {
		if (idCharla == null) {
			throw new Exception("Se ha recibido idCharla nulo");
		}
		if (expositor == null) {
			throw new Exception("Se ha recibido expositor nulo");
		}
		if (charlaService.encontrarPorId(idCharla) == null) {
			throw new Exception("No existe Charla con dicho identificador");
		}
		expositorProfesorRepository.save(expositor);
		Charla charla;
		charla = charlaService.encontrarPorId(idCharla);
		Long idExpositor=charla.getIdExpositor();
		charla.setIdExpositor(expositor.getIdExpositor());
		if(idExpositor!=null)
		{
			eliminarExpositor(idExpositor);
		}
		charlaRepository.save(charla);
	}

	@Override
	public Universidad encontrarUniversidadEstudiante(String documentoIdentidad) throws Exception {
		if (documentoIdentidad == null) {
			throw new Exception("Se ha recibido documentoIdentidad nulo");
		}
		Iterator<ExpositorEstudiante> expositoresEstudianteIterator = expositorEstudianteRepository.findAll()
				.iterator();
		ExpositorEstudiante expositorEstudiante;
		while (expositoresEstudianteIterator.hasNext()) {
			expositorEstudiante = expositoresEstudianteIterator.next();
			if (expositorEstudiante.getDocumentoIdentidad().compareTo(documentoIdentidad) == 0) {
				return expositorEstudiante.getUniversidad();
			}
		}
		throw new Exception("No existe Estudiante con dicho documento de Identidad");
	}

	@Override
	public Facultad encontrarFacultadEstudiante(String documentoIdentidad) throws Exception {
		if (documentoIdentidad == null) {
			throw new Exception("Se ha recibido documentoIdentidad nulo");
		}
		Iterator<ExpositorEstudiante> expositoresEstudianteIterator = expositorEstudianteRepository.findAll()
				.iterator();
		ExpositorEstudiante expositorEstudiante;
		while (expositoresEstudianteIterator.hasNext()) {
			expositorEstudiante = expositoresEstudianteIterator.next();
			if (expositorEstudiante.getDocumentoIdentidad().compareTo(documentoIdentidad) == 0) {
				return expositorEstudiante.getFacultad();
			}
		}
		throw new Exception("No existe Estudiante con dicho documento de Identidad");
	}

	@Override
	public List<Charla> encontrarCharlaInvestigador(String documentoIdentidad) throws Exception {
		if (documentoIdentidad == null) {
			throw new Exception("Se ha recibido documentoIdentidad nulo");
		}
		//Primero busco idExpositor vinculado a dicho documentoIdentidad
		Iterator<ExpositorInvestigador> expositoresInvestigadorIterator = expositorInvestigadorRepository.findAll().iterator();
		ExpositorInvestigador expositorInvestigador;
		Long idExpositor = null;
		while(expositoresInvestigadorIterator.hasNext())
		{
			expositorInvestigador=expositoresInvestigadorIterator.next();
			if(expositorInvestigador.getDocumentoIdentidad().compareTo(documentoIdentidad)==0)
			{
				idExpositor=expositorInvestigador.getIdExpositor();
				break;
			}
		}
		if (idExpositor == null) {
			throw new Exception("Documento de Identidad no corresponde a un Investigador");
		}
		//Una vez que tengo su idExpositor, listo todas las charlas con dicho id
		Iterator<Charla> charlasIterator=charlaService.listarTodos().iterator();
		List<Charla> charlas= new ArrayList<>();
		Charla charla;
		while(charlasIterator.hasNext())
		{
			charla= charlasIterator.next();
			if(charla.getIdExpositor()==idExpositor)
			{
				charlas.add(charla);
			}
		}
		return charlas;
	}

	@Override
	public List<BaseEvento> encontrarEventoInvestigador(String documentoIdentidad) throws Exception {
		if (documentoIdentidad == null) {
			throw new Exception("Se ha recibido documentoIdentidad nulo");
		}
		// Para listar todos los eventos, primero se necesita todas sus charlas
		Iterator<Charla> charlasIterator = encontrarCharlaInvestigador(documentoIdentidad).iterator();
		// Una vez obtenidas sus charlas, se lista todos los eventos vinculados a las
		// charlas
		Charla charla;
		List<BaseEvento> eventos = new ArrayList<>();
		while (charlasIterator.hasNext()) {
			charla = charlasIterator.next();
			eventos.add(eventoService.encontrarPorId(charla.getIdEvento()));
		}
		return eventos;
	}

	@Override
	public void eliminarExpositor(Long idExpositor) throws Exception {
		if (idExpositor == null) {
			throw new Exception("Se ha recibido idExpositor null");
		}
		if (expositorEstudianteRepository.findOne(idExpositor) != null) {
			expositorEstudianteRepository.delete(idExpositor);
		} else if (expositorInvestigadorRepository.findOne(idExpositor) != null) {
			expositorInvestigadorRepository.delete(idExpositor);
		} else if (expositorProfesionalInvitadoRepository.findOne(idExpositor) != null) {
			expositorProfesionalInvitadoRepository.delete(idExpositor);
		} else if (expositorProfesorRepository.findOne(idExpositor) != null) {
			expositorProfesorRepository.delete(idExpositor);
		} else {
			throw new Exception("No existe Expositor con dicho documento de Identidad");
		}
		Iterator<Charla> charlasIterator = charlaService.listarTodos().iterator();
		Charla charla;
		Iterator<Pregunta> preguntasIterator;
		Pregunta pregunta;
		Iterator<ComentarioPregunta> comentariosIterator;
		ComentarioPregunta comentarioPregunta;
		while (charlasIterator.hasNext()) {
			charla = charlasIterator.next();
			if (charla.getIdExpositor().compareTo(idExpositor) == 0) {
				preguntasIterator = preguntaService.listarTodos().iterator();

				while (preguntasIterator.hasNext()) {
					pregunta = preguntasIterator.next();

					comentariosIterator = comentarioPreguntaService.encontrarTodos(pregunta.getIdPregunta()).iterator();
					while (comentariosIterator.hasNext()) {
						comentarioPregunta = comentariosIterator.next();
						if (comentarioPregunta.getIdPregunta() == pregunta.getIdPregunta()) {
							// Se elimina todos los comentarios de las perguntas
							comentarioPreguntaService.eliminarComentario(comentarioPregunta.getIdComentario());
						}
					}
					if (pregunta.getIdCharla() == charla.getIdCharla()) {
						// Se eliminan las preguntas de las charlas
						preguntaService.eliminarPregunta(pregunta.getIdPregunta());
					}
				}
				// Se eliminan sus charlas
				charlaService.eliminarCharla(charla.getIdCharla());
			}
		}
	}

	@Override
	public ExpositorEstudiante encontrarExpositorEstudiante(String documentoIdentidad) throws Exception {
		if (documentoIdentidad == null) {
			throw new Exception("Se ha recibido documentoIdentidad nulo");
		}
		Iterator<ExpositorEstudiante> expositoresEstudianteIterator = expositorEstudianteRepository.findAll().iterator();
		ExpositorEstudiante expositorEstudiante;
		while(expositoresEstudianteIterator.hasNext())
		{
			expositorEstudiante=expositoresEstudianteIterator.next();
			if(expositorEstudiante.getDocumentoIdentidad().compareTo(documentoIdentidad)==0)
			{
				return expositorEstudiante;
			}
		}
		return null;
	}

	@Override
	public ExpositorInvestigador encontrarExpositorInvestigador(String documentoIdentidad) throws Exception {
		if (documentoIdentidad == null) {
			throw new Exception("Se ha recibido documentoIdentidad nulo");
		}
		Iterator<ExpositorInvestigador> expositoresInvestigadorIterator = expositorInvestigadorRepository.findAll().iterator();
		ExpositorInvestigador expositorInvestigador;
		while(expositoresInvestigadorIterator.hasNext())
		{
			expositorInvestigador=expositoresInvestigadorIterator.next();
			if(expositorInvestigador.getDocumentoIdentidad().compareTo(documentoIdentidad)==0)
			{
				return expositorInvestigador;
			}
		}
		return null;
	}

	@Override
	public ExpositorProfesionalInvitado encontrarExpositorProfesionalInvitado(String documentoIdentidad)throws Exception {
		if (documentoIdentidad == null) {
			throw new Exception("Se ha recibido documentoIdentidad nulo");
		}
		Iterator<ExpositorProfesionalInvitado> expositoresProfesionalIterator = expositorProfesionalInvitadoRepository.findAll().iterator();
		ExpositorProfesionalInvitado expositorProfesional;
		while(expositoresProfesionalIterator.hasNext())
		{
			expositorProfesional=expositoresProfesionalIterator.next();
			if(expositorProfesional.getDocumentoIdentidad().compareTo(documentoIdentidad)==0)
			{
				return expositorProfesional;
			}
		}
		return null;
	}

	@Override
	public ExpositorProfesor encontrarExpositorProfesor(String documentoIdentidad) throws Exception {
		if (documentoIdentidad == null) {
			throw new Exception("Se ha recibido documentoIdentidad nulo");
		}
		Iterator<ExpositorProfesor> expositoresProfesorIterator = expositorProfesorRepository.findAll().iterator();
		ExpositorProfesor expositorProfesor;
		while(expositoresProfesorIterator.hasNext())
		{
			expositorProfesor=expositoresProfesorIterator.next();
			if(expositorProfesor.getDocumentoIdentidad().compareTo(documentoIdentidad)==0)
			{
				return expositorProfesor;
			}
		}
		return null;
	}

	@Override
	public PersonaConId encontrarExpositor(String documentoIdentidad) throws Exception {
		if (documentoIdentidad == null) {
			throw new Exception("Se ha recibido documentoIdentidad nulo");
		}
		if (encontrarExpositorEstudiante(documentoIdentidad) != null) {
			return encontrarExpositorEstudiante(documentoIdentidad);
		}
		if (encontrarExpositorInvestigador(documentoIdentidad) != null) {
			return encontrarExpositorInvestigador(documentoIdentidad);
		}
		if (encontrarExpositorProfesionalInvitado(documentoIdentidad) != null) {
			return encontrarExpositorProfesionalInvitado(documentoIdentidad);
		}
		if (encontrarExpositorProfesor(documentoIdentidad) != null) {
			return encontrarExpositorProfesor(documentoIdentidad);
		}
		return null;
	}

	@Override
	public List<ExpositorEstudiante> listarTodosEstudiante() {
		List<ExpositorEstudiante> expositores = new ArrayList<>();
		Iterator<ExpositorEstudiante> expositoresIterator = expositorEstudianteRepository.findAll().iterator();
		while (expositoresIterator.hasNext()) {
			expositores.add(expositoresIterator.next());
		}
		return expositores;
	}

	@Override
	public List<ExpositorInvestigador> listarTodosInvestigador() {
		List<ExpositorInvestigador> expositores = new ArrayList<>();
		Iterator<ExpositorInvestigador> expositoresIterator = expositorInvestigadorRepository.findAll().iterator();
		while (expositoresIterator.hasNext()) {
			expositores.add(expositoresIterator.next());
		}
		return expositores;
	}

	@Override
	public List<ExpositorProfesionalInvitado> listarTodosProfesional() {
		List<ExpositorProfesionalInvitado> expositores = new ArrayList<>();
		Iterator<ExpositorProfesionalInvitado> expositoresIterator = expositorProfesionalInvitadoRepository.findAll().iterator();
		while (expositoresIterator.hasNext()) {
			expositores.add(expositoresIterator.next());
		}
		return expositores;
	}

	@Override
	public List<ExpositorProfesor> listarTodosProfesor() {
		List<ExpositorProfesor> expositores = new ArrayList<>();
		Iterator<ExpositorProfesor> expositoresIterator = expositorProfesorRepository.findAll().iterator();
		while (expositoresIterator.hasNext()) {
			expositores.add(expositoresIterator.next());
		}
		return expositores;
	}

}
