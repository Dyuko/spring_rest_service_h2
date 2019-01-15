package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.Pregunta;
import py.edu.uca.lp3.service.PreguntaService;

@RestController
@RequestMapping("/pregunta")
public class PreguntaController {
	@Autowired
	PreguntaService preguntaService;
	
	@RequestMapping(value = "/guardarPregunta/{idCharla}", method = RequestMethod.POST)
    public void guardarPregunta(@PathVariable("idCharla") Long idCharla, @RequestBody Pregunta pregunta) throws Exception {
		preguntaService.guardarPregunta(idCharla, pregunta);
    }
	
    @RequestMapping(value = "/eliminarPregunta/{idPregunta}", method = RequestMethod.DELETE)
    public void eliminarPregunta(@PathVariable("idPregunta") Long idPregunta) throws Exception {
    	preguntaService.eliminarPregunta(idPregunta);
    }
    
	@RequestMapping(value = "/encontrarPorId/{idPregunta}", method = RequestMethod.GET)
    public Pregunta encontrarPorId(@PathVariable("idPregunta") Long idPregunta) throws Exception {
		Pregunta pregunta = preguntaService.encontrarPorId(idPregunta);
        return pregunta;
    }
	
	@RequestMapping(value = "/encontrarPorFecha/{fecha}", method = RequestMethod.GET)
    public List<Pregunta> encontrarPorFecha(@PathVariable("fecha") String fecha) throws Exception {
		List<Pregunta> preguntas = preguntaService.encontrarPorFecha(fecha);
        return preguntas;
    }
	
	@RequestMapping(value = "/encontrarTodos/{idCharla}", method = RequestMethod.GET)
    public List<Pregunta> encontrarTodos(@PathVariable("idCharla") Long idCharla) throws Exception {
		List<Pregunta> preguntas = preguntaService.encontrarTodos(idCharla);
        return preguntas;
    }	
	
	@RequestMapping(value = "/consultarVotosPositivos/{idPregunta}", method = RequestMethod.GET)
    public Integer consultarVotosPositivos(@PathVariable("idPregunta") Long idPregunta) throws Exception {
		return preguntaService.consultarVotosPositivos(idPregunta);
    }
	
	@RequestMapping(value = "/consultarVotosNegativos/{idPregunta}", method = RequestMethod.GET)
    public Integer consultarVotosNegativos(@PathVariable("idPregunta") Long idPregunta) throws Exception {
		return preguntaService.consultarVotosNegativos(idPregunta);
    }
	
	@RequestMapping(value = "/asignarVotoPositivo/{idPregunta}", method = RequestMethod.POST)
    public void asignarVotoPositivo(@PathVariable("idPregunta") Long idPregunta) throws Exception {
		preguntaService.asignarVotoPositivo(idPregunta);
    }
	
	@RequestMapping(value = "/asignarVotoNegativo/{idPregunta}", method = RequestMethod.POST)
    public void asignarVotoNegativo(@PathVariable("idPregunta") Long idPregunta) throws Exception {
		preguntaService.asignarVotoNegativo(idPregunta);
    }
	
	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
    public List<Pregunta> listarTodos() throws Exception {
		return preguntaService.listarTodos();
    }
	
	@RequestMapping(value = "/listarPorFecha/{fecha}", method = RequestMethod.GET)
    public List<Pregunta> listarPorFecha(@PathVariable("fecha") String fecha) throws Exception {
		return preguntaService.listarPorFecha(fecha);
    }
	
	@RequestMapping(value = "/listarPorFechayCharla/{fecha}/{idCharla}", method = RequestMethod.GET)
    public List<Pregunta> listarPorFechayCharla(@PathVariable("fecha") String fecha, @PathVariable("idCharla") Long idCharla) throws Exception {
		return preguntaService.listarPorFechayCharla(fecha,idCharla);
    }
}
