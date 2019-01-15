package py.edu.uca.lp3.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.BaseEvento;
import py.edu.uca.lp3.service.EventoConCostoService;
import py.edu.uca.lp3.service.EventoLibreAccesoService;
import py.edu.uca.lp3.service.EventoPreInscripcionService;
import py.edu.uca.lp3.service.EventoService;
@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	EventoConCostoService eventoConCostoService;
	@Autowired
	EventoLibreAccesoService eventoLibreAccesoService;
	@Autowired
	EventoPreInscripcionService eventoPreInscripcionService;
	
	@Override
	public List<BaseEvento> encontrarTodos() {
		List<BaseEvento> eventos = new ArrayList<>();
		eventos.addAll(eventoConCostoService.encontrarTodos());
		eventos.addAll(eventoLibreAccesoService.encontrarTodos());
		eventos.addAll(eventoPreInscripcionService.encontrarTodos());
		return eventos;
	}

	@Override
	public BaseEvento encontrarPorId(Long idEvento) throws Exception {
		BaseEvento evento;
		evento=eventoConCostoService.encontrarPorId(idEvento);
		if(evento==null)
		{
			evento=eventoLibreAccesoService.encontrarPorId(idEvento);
			if(evento==null)
			{
				evento=eventoPreInscripcionService.encontrarPorId(idEvento);
			}
		}
		return evento;
	}

	@Override
	public void eliminarEvento(Long idEvento) throws Exception {
		if(eventoConCostoService.encontrarPorId(idEvento)!=null)
		{
			eventoConCostoService.eliminarEventoConCosto(idEvento);
		}else if(eventoLibreAccesoService.encontrarPorId(idEvento)!=null)
		{
			eventoLibreAccesoService.eliminarEventoLibreAcceso(idEvento);
		}else if(eventoPreInscripcionService.encontrarPorId(idEvento)!=null)
		{
			eventoPreInscripcionService.eliminarEventoPreInscripcion(idEvento);
		}else
		{
			throw new Exception("No existe Evento con dicho identificador");
		}
		
	}
}
