package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.EventoConCosto;
import py.edu.uca.lp3.domain.Factura;
import py.edu.uca.lp3.service.EventoConCostoService;
@RestController
@RequestMapping("/eventoConCosto")
public class EventoConCostoController {
	@Autowired
	private EventoConCostoService eventoConCostoService;
	
    @RequestMapping(value = "/encontrarTodos", method = RequestMethod.GET)
    public List<EventoConCosto> encontrarTodos() {
        return eventoConCostoService.encontrarTodos();
    }
    
	@RequestMapping(value = "/encontrarPorId/{idEvento}", method = RequestMethod.GET)
    public EventoConCosto encontrarPorId(@PathVariable("idEvento") Long idEvento) throws Exception {
		EventoConCosto eventoConCosto = eventoConCostoService.encontrarPorId(idEvento);
        return eventoConCosto;
    }
	
    @RequestMapping(value = "/eliminar/{idEvento}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable("idEvento") Long idEvento) throws Exception {
    	eventoConCostoService.eliminarEventoConCosto(idEvento);
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public void guardar(@RequestBody EventoConCosto eventoConCosto) throws Exception {
    	eventoConCostoService.guardarEventoConCosto(eventoConCosto);
    }
    
	@RequestMapping(value = "/realizarPago/{idEvento}", method = RequestMethod.POST)
    public void realizarPago(@PathVariable("idEvento") Long idEvento, @RequestBody Factura factura) throws Exception {
		eventoConCostoService.realizarPagoEventoConCosto(idEvento, factura);
    }
	
	@RequestMapping(value = "/listarTodasFactura", method = RequestMethod.GET)
    public List<Factura> listarTodasFactura() {
		return eventoConCostoService.listarTodasFactura();
    }
	
	@RequestMapping(value = "/encontrarFacturaEvento/{idEvento}", method = RequestMethod.GET)
    public List<Factura> encontrarFacturaEvento(@PathVariable("idEvento") Long idEvento) throws Exception {
		return eventoConCostoService.encontrarFacturaEvento(idEvento);
    }
	
}
