package py.edu.uca.lp3.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.Charla;
import py.edu.uca.lp3.domain.ComentarioPregunta;
import py.edu.uca.lp3.domain.EventoLibreAcceso;
import py.edu.uca.lp3.domain.Pregunta;
import py.edu.uca.lp3.repository.EventoLibreAccesoRepository;
import py.edu.uca.lp3.service.CharlaService;
import py.edu.uca.lp3.service.ComentarioPreguntaService;
import py.edu.uca.lp3.service.EventoLibreAccesoService;
import py.edu.uca.lp3.service.PreguntaService;

@Service
public class EventoLibreAccesoServiceImpl implements EventoLibreAccesoService {

	@Autowired
	private EventoLibreAccesoRepository eventoLibreAccesoRepository;
	@Autowired
	private CharlaService charlaService;
	@Autowired
	private PreguntaService preguntaService;
	@Autowired
	private ComentarioPreguntaService comentarioPreguntaService;

	@Override
	public List<EventoLibreAcceso> encontrarTodos() {
		List<EventoLibreAcceso> eventosLibreAcceso = new ArrayList<>();
		Iterator<EventoLibreAcceso> eventosLibreAccesoIterator = eventoLibreAccesoRepository.findAll().iterator();
		while (eventosLibreAccesoIterator.hasNext()) {
			eventosLibreAcceso.add(eventosLibreAccesoIterator.next());
		}
		return eventosLibreAcceso;
	}

	@Override
	public EventoLibreAcceso encontrarPorId(Long idEvento) throws Exception {
		if (idEvento == null) {
			throw new Exception("Se ha recibido idEvento nulo");
		}
		return eventoLibreAccesoRepository.findOne(idEvento);
	}

	@Override
	public void eliminarEventoLibreAcceso(Long idEvento) throws Exception {
		if (idEvento == null) {
			throw new Exception("El identificador es nulo");
		}
		if (eventoLibreAccesoRepository.findOne(idEvento) == null) {
			throw new Exception("No existe Evento con dicho identificador");
		}

		// Traemos todas las charlas del evento
		Iterator<Charla> charlasIterator = charlaService.encontrarTodos(idEvento).iterator();
		ComentarioPregunta comentarioPregunta;
		Iterator<Pregunta> preguntasIterator;
		Iterator<ComentarioPregunta> comentariosPreguntaIterator;
		Charla charla;
		Pregunta pregunta;
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
		eventoLibreAccesoRepository.delete(idEvento);
	}

	@Override
	public void guardarEventoLibreAcceso(EventoLibreAcceso eventoLibreAcceso) throws Exception {
		if (eventoLibreAcceso == null) {
			throw new Exception("Se ha recibido un elemento nulo");
		}
		eventoLibreAccesoRepository.save(eventoLibreAcceso);
	}

}
