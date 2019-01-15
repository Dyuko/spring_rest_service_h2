package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.BaseEvento;
import py.edu.uca.lp3.service.EventoService;

@RestController
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoService eventoService;
	
	/*Encontrar todos*/
    @RequestMapping(value = "/encontrarTodos", method = RequestMethod.GET)
    public List<BaseEvento> encontrarTodos() {
        return eventoService.encontrarTodos();
    }
    
	/*Encontrar por idEvento*/
	@RequestMapping(value = "/encontrarPorId/{idEvento}", method = RequestMethod.GET)
    public BaseEvento encontrarPorId(@PathVariable("idEvento") Long idEvento) throws Exception {
		BaseEvento evento = eventoService.encontrarPorId(idEvento);
        return evento;
    }

    /*Eliminar*/
    @RequestMapping(value = "/eliminar/{idEvento}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable("idEvento") Long idEvento) throws Exception {
    	eventoService.eliminarEvento(idEvento);
    }

}
