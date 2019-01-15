package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.EventoPreInscripcion;
import py.edu.uca.lp3.domain.Inscripto;
import py.edu.uca.lp3.service.EventoPreInscripcionService;
@RestController
@RequestMapping("/eventoPreInscripcion")
public class EventoPreInscripcionController {
	@Autowired
	private EventoPreInscripcionService eventoPreInscripcionService;
	
    @RequestMapping(value = "/encontrarTodos", method = RequestMethod.GET)
    public List<EventoPreInscripcion> encontrarTodos() {
        return eventoPreInscripcionService.encontrarTodos();
    }
    
	@RequestMapping(value = "/encontrarPorId/{idEvento}", method = RequestMethod.GET)
    public EventoPreInscripcion encontrarPorId(@PathVariable("idEvento") Long idEvento) throws Exception {
		EventoPreInscripcion eventoPreInscripcion = eventoPreInscripcionService.encontrarPorId(idEvento);
        return eventoPreInscripcion;
    }
	
    @RequestMapping(value = "/eliminar/{idEvento}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable("idEvento") Long idEvento) throws Exception {
    	eventoPreInscripcionService.eliminarEventoPreInscripcion(idEvento);
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public void guardar(@RequestBody EventoPreInscripcion eventoPreInscripcion) throws Exception {
    	eventoPreInscripcionService.guardarEventoPreInscripcion(eventoPreInscripcion);
    }
    
	@RequestMapping(value = "/realizarPago/{idEvento}", method = RequestMethod.POST)
    public void inscribirPersona(@PathVariable("idEvento") Long idEvento, @RequestBody Inscripto inscripto) throws Exception {
		eventoPreInscripcionService.inscribirPersona(idEvento, inscripto);
    }
	
	@RequestMapping(value = "/encontrarTodosInscripto/{idEvento}", method = RequestMethod.GET)
    public List<Inscripto> encontrarTodosInscripto(@PathVariable("idEvento") Long idEvento) throws Exception {
		return eventoPreInscripcionService.encontrarTodosInscripto(idEvento);
    }
	
	@RequestMapping(value = "/listarTodosInscripto", method = RequestMethod.GET)
    public List<Inscripto> listarTodosInscripto() {
		return eventoPreInscripcionService.listarTodosInscripto();
    }
}
