package py.edu.uca.lp3.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.Charla;
import py.edu.uca.lp3.domain.ComentarioPregunta;
import py.edu.uca.lp3.domain.EventoConCosto;
import py.edu.uca.lp3.domain.Factura;
import py.edu.uca.lp3.domain.Pregunta;
import py.edu.uca.lp3.repository.EventoConCostoRepository;
import py.edu.uca.lp3.repository.FacturaRepository;
import py.edu.uca.lp3.service.CharlaService;
import py.edu.uca.lp3.service.ComentarioPreguntaService;
import py.edu.uca.lp3.service.EventoConCostoService;
import py.edu.uca.lp3.service.PreguntaService;

@Service
public class EventoConCostoServiceImpl implements EventoConCostoService {

	@Autowired
	private EventoConCostoRepository eventoConCostoRepository;
	@Autowired
	private FacturaRepository facturaRepository;
	@Autowired
	private CharlaService charlaService;
	// @Autowired
	// private ExpositorService expositorService;
	@Autowired
	private PreguntaService preguntaService;
	@Autowired
	private ComentarioPreguntaService comentarioPreguntaService;

	@Override
	public List<EventoConCosto> encontrarTodos() {
		List<EventoConCosto> eventosConCosto = new ArrayList<>();
		Iterator<EventoConCosto> eventosConCostoIterator = eventoConCostoRepository.findAll().iterator();
		while (eventosConCostoIterator.hasNext()) {
			eventosConCosto.add(eventosConCostoIterator.next());
		}
		return eventosConCosto;
	}

	@Override
	public EventoConCosto encontrarPorId(Long idEvento) throws Exception {
		if (idEvento == null) {
			throw new Exception("Se ha recibido idEvento nulo");
		}
		return eventoConCostoRepository.findOne(idEvento);
	}

	@Override
	public void eliminarEventoConCosto(Long idEvento) throws Exception {
		if (idEvento == null) {
			throw new Exception("Se ha recibido idEvento nulo");
		}
		if (eventoConCostoRepository.findOne(idEvento) == null) {
			throw new Exception("Identificador no corresponde a ningún Evento existente");
		}

		// Se elimina sus facturas
		Iterator<Factura> facturasIterator = facturaRepository.findAll().iterator();
		Factura factura;
		while (facturasIterator.hasNext()) {
			factura = facturasIterator.next();
			facturaRepository.delete(factura.getIdFactura());
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
		eventoConCostoRepository.delete(idEvento);
	}

	@Override
	public void guardarEventoConCosto(EventoConCosto eventoConCosto) throws Exception {
		if (eventoConCosto == null) {
			throw new Exception("Se ha recibido eventoConCosto nulo");
		}
		eventoConCostoRepository.save(eventoConCosto);

	}

	@Override
	public void realizarPagoEventoConCosto(Long idEvento, Factura factura) throws Exception {
		if (idEvento == null) {
			throw new Exception("Se ha recibido idEvento nulo");
		}
		if (factura == null) {
			throw new Exception("Se ha recibido factura nula");
		}
		if (eventoConCostoRepository.findOne(idEvento) == null) {
			throw new Exception("Identificador no corresponde a ningún Evento existente");
		}
		/* Para no cambiar la interfaz, idEvento viene separado de factura */
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		factura.setFecha(date);
		factura.setIdEvento(idEvento);
		facturaRepository.save(factura);
	}

	@Override
	public List<Factura> listarTodasFactura() {
		List<Factura> facturas = new ArrayList<>();
		Iterator<Factura> facturasIterator = facturaRepository.findAll().iterator();
		while (facturasIterator.hasNext()) {
			facturas.add(facturasIterator.next());
		}
		return facturas;
	}

	@Override
	public List<Factura> encontrarFacturaEvento(Long idEvento) throws Exception {
		if (idEvento == null) {
			throw new Exception("Se ha recibido idEvento nulo");
		}
		if (eventoConCostoRepository.findOne(idEvento) == null) {
			throw new Exception("Identificador no corresponde a ningún Evento existente");
		}
		List<Factura> facturas = new ArrayList<>();
		Iterator<Factura> facturasIterator = facturaRepository.findAll().iterator();
		Factura factura;
		while (facturasIterator.hasNext()) {
			factura=facturasIterator.next();
			if(factura.getIdEvento()==idEvento)
			{
				facturas.add(factura);
			}
		}
		return facturas;
	}

}
