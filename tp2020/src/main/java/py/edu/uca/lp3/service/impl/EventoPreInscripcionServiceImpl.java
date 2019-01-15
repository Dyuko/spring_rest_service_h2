package py.edu.uca.lp3.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.Charla;
import py.edu.uca.lp3.domain.ComentarioPregunta;
import py.edu.uca.lp3.domain.EventoPreInscripcion;
import py.edu.uca.lp3.domain.Inscripto;
import py.edu.uca.lp3.domain.Pregunta;
import py.edu.uca.lp3.repository.EventoPreInscripcionRepository;
import py.edu.uca.lp3.repository.InscriptoRepository;
import py.edu.uca.lp3.service.CharlaService;
import py.edu.uca.lp3.service.ComentarioPreguntaService;
import py.edu.uca.lp3.service.EventoPreInscripcionService;
import py.edu.uca.lp3.service.PreguntaService;

@Service
public class EventoPreInscripcionServiceImpl implements EventoPreInscripcionService {

	@Autowired
	private EventoPreInscripcionRepository eventoPreInscripcionRepository;
	@Autowired
	private InscriptoRepository inscriptoRepository;
	@Autowired
	private CharlaService charlaService;
	// @Autowired
	// private ExpositorService expositorService;
	@Autowired
	private PreguntaService preguntaService;
	@Autowired
	private ComentarioPreguntaService comentarioPreguntaService;

	@Override
	public List<EventoPreInscripcion> encontrarTodos() {
		List<EventoPreInscripcion> eventosPreInscripcion = new ArrayList<>();
		Iterator<EventoPreInscripcion> eventosPreInscripcionIterator = eventoPreInscripcionRepository.findAll()
				.iterator();
		while (eventosPreInscripcionIterator.hasNext()) {
			eventosPreInscripcion.add(eventosPreInscripcionIterator.next());
		}
		return eventosPreInscripcion;
	}

	@Override
	public EventoPreInscripcion encontrarPorId(Long idEvento) throws Exception {
		if (idEvento == null) {
			throw new Exception("Se ha recibido idEvento nulo");
		}
		return eventoPreInscripcionRepository.findOne(idEvento);
	}

	@Override
	public void eliminarEventoPreInscripcion(Long idEvento) throws Exception {
		Charla charla;
		Inscripto inscripto;
		Pregunta pregunta;
		if (idEvento == null) {
			throw new Exception("El identificador es nulo");
		}
		if (eventoPreInscripcionRepository.findOne(idEvento) == null) {
			throw new Exception("No existe Evento con dicho identificador");
		}

		// Se elimina sus inscriptos
		Iterator<Inscripto> inscriptosIterator = encontrarTodosInscripto(idEvento).iterator();
		while (inscriptosIterator.hasNext()) {
			inscripto = inscriptosIterator.next();
			inscriptoRepository.delete(inscripto.getDocumentoIdentidad());
		}
		// Traemos todas las charlas del evento
		Iterator<Charla> charlasIterator = charlaService.encontrarTodos(idEvento).iterator();
		ComentarioPregunta comentarioPregunta;
		Iterator<Pregunta> preguntasIterator;
		Iterator<ComentarioPregunta> comentariosPreguntaIterator;

		while (charlasIterator.hasNext()) {
			charla = charlasIterator.next();
			// No eliminamos el expositor de la charla porque puede estar vinculado a otras
			// charlas
			// expositorService.eliminarExpositor(charla.getIdExpositor());

			// Por cada pregunta traemos todas sus preguntas
			preguntasIterator = preguntaService.encontrarTodos(charla.getIdCharla()).iterator();

			while (preguntasIterator.hasNext()) {
				pregunta = preguntasIterator.next();
				// Eliminamos los comentarios de las preguntas
				comentariosPreguntaIterator = comentarioPreguntaService.encontrarTodos(pregunta.getIdPregunta())
						.iterator();
				while (comentariosPreguntaIterator.hasNext()) {
					comentarioPregunta = comentariosPreguntaIterator.next();
					comentarioPreguntaService.eliminarComentario(comentarioPregunta.getIdComentario());
				}
				// Eliminamos las preguntas de la charla
				preguntaService.eliminarPregunta(pregunta.getIdPregunta());
			}
			// Eliminamos las charlas del Evento
			charlaService.eliminarCharla(charla.getIdCharla());
		}
		// Se elimina el evento
		eventoPreInscripcionRepository.delete(idEvento);
	}

	@Override
	public void guardarEventoPreInscripcion(EventoPreInscripcion eventoPreInscripcion) throws Exception {
		if (eventoPreInscripcion == null) {
			throw new Exception("Se ha recibido eventoPreInscripcion nulo");
		}
		eventoPreInscripcionRepository.save(eventoPreInscripcion);
	}

	@Override
	public void inscribirPersona(Long idEvento, Inscripto inscripto) throws Exception {
		/* Para no cambiar la interfaz, idEvento viene separado de inscripto */
		if (idEvento == null) {
			throw new Exception("El identificador es nulo");
		}
		if (inscripto == null) {
			throw new Exception("Se ha recibido inscripto nulo");
		}
		if (eventoPreInscripcionRepository.findOne(idEvento) == null) {
			throw new Exception("No existe Evento con dicho identificador");
		}
		inscripto.setIdEvento(idEvento);
		inscriptoRepository.save(inscripto);
	}

	@Override
	public List<Inscripto> encontrarTodosInscripto(Long idEvento) throws Exception {
		if (eventoPreInscripcionRepository.findOne(idEvento) == null) {
			throw new Exception("No existe Evento con dicho identificador");
		}
		List<Inscripto> inscriptos = new ArrayList<>();
		Iterator<Inscripto> inscriptosIterator = inscriptoRepository.findAll().iterator();
		Inscripto inscripto;
		while (inscriptosIterator.hasNext()) {
			inscripto = inscriptosIterator.next();
			if (inscripto.getIdEvento() == idEvento) {
				inscriptos.add(inscripto);
			}
		}
		return inscriptos;
	}

	@Override
	public List<Inscripto> listarTodosInscripto() {
		List<Inscripto> inscriptos = new ArrayList<>();
		Iterator<Inscripto> inscriptosIterator = inscriptoRepository.findAll().iterator();
		while (inscriptosIterator.hasNext()) {
			inscriptos.add(inscriptosIterator.next());
		}
		return inscriptos;
	}

}
