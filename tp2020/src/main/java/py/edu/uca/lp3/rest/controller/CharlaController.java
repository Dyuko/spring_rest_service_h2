package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.Charla;
import py.edu.uca.lp3.service.CharlaService;

@RestController
@RequestMapping("/charla")
public class CharlaController {
	
	@Autowired
	private CharlaService charlaService;
	
	@RequestMapping(value = "/guardarCharla/{idEvento}", method = RequestMethod.POST)
    public void guardarCharla(@PathVariable("idEvento") Long idEvento, @RequestBody Charla charla) throws Exception {
		charlaService.guardarCharla(idEvento, charla);
    }
	
	@RequestMapping(value = "/encontrarTodos/{idEvento}", method = RequestMethod.GET)
    public List<Charla> encontrarTodos(@PathVariable("idEvento") Long idEvento) throws Exception {
		return charlaService.encontrarTodos(idEvento);
    }
	
	@RequestMapping(value = "/encontrarPorId/{idCharla}", method = RequestMethod.GET)
    public Charla encontrarPorId(@PathVariable("idCharla") Long idCharla) throws Exception {
		return charlaService.encontrarPorId(idCharla);
    }
	
	@RequestMapping(value = "/eliminarCharla/{idCharla}", method = RequestMethod.DELETE)
    public void eliminarCharla(@PathVariable("idCharla") Long idCharla) throws Exception {
		charlaService.eliminarCharla(idCharla);
    }
	
	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
    public List<Charla> listarTodos() {
		return charlaService.listarTodos();
    }
}
