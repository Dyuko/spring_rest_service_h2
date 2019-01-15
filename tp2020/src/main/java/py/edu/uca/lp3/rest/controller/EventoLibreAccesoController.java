package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.EventoLibreAcceso;
import py.edu.uca.lp3.service.EventoLibreAccesoService;

@RestController
@RequestMapping("/eventoLibreAcceso")
public class EventoLibreAccesoController {

	@Autowired
	private EventoLibreAccesoService eventoLibreAccesoService;
	
	/*Encontrar todos*/
    @RequestMapping(value = "/encontrarTodos", method = RequestMethod.GET)
    public List<EventoLibreAcceso> encontrarTodos() {
        return eventoLibreAccesoService.encontrarTodos();
    }
    
	/*Encontrar por idEvento*/
	@RequestMapping(value = "/encontrarPorId/{idEvento}", method = RequestMethod.GET)
    public EventoLibreAcceso encontrarPorId(@PathVariable("idEvento") Long idEvento) throws Exception {
        EventoLibreAcceso eventoLibreAcceso = eventoLibreAccesoService.encontrarPorId(idEvento);
        return eventoLibreAcceso;
    }

    /*Eliminar*/
    @RequestMapping(value = "/eliminar/{idEvento}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable("idEvento") Long idEvento) throws Exception {
    	eventoLibreAccesoService.eliminarEventoLibreAcceso(idEvento);
    }
    
    /*Guardar*/
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public void guardar(@RequestBody EventoLibreAcceso eventoLibreAcceso) throws Exception {
    	eventoLibreAccesoService.guardarEventoLibreAcceso(eventoLibreAcceso);;
    }


}
