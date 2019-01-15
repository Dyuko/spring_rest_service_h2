package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.ComentarioPregunta;
import py.edu.uca.lp3.service.ComentarioPreguntaService;

@RestController
@RequestMapping("/comentarioPregunta")
public class ComentarioPreguntaController {
	@Autowired
	private ComentarioPreguntaService comentarioPreguntaService;
	
	@RequestMapping(value = "/guardarComentario/{idPregunta}", method = RequestMethod.POST)
    public void guardarComentario(@PathVariable("idPregunta") Long idPregunta, @RequestBody ComentarioPregunta comentarioPregunta) throws Exception {
		comentarioPreguntaService.guardarComentario(idPregunta, comentarioPregunta);
    }
	
	@RequestMapping(value = "/eliminarComentario/{idComentario}", method = RequestMethod.DELETE)
    public void eliminarComentario(@PathVariable("idComentario") Long idComentario) throws Exception {
		comentarioPreguntaService.eliminarComentario(idComentario);
    }
	
	@RequestMapping(value = "/encontrarTodos/{idPregunta}", method = RequestMethod.GET)
    public List<ComentarioPregunta> encontrarTodos(@PathVariable("idPregunta") Long idPregunta) throws Exception {
		return comentarioPreguntaService.encontrarTodos(idPregunta);
    }
	
	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
    public List<ComentarioPregunta> listarTodos() {
		return comentarioPreguntaService.listarTodos();
    }
}
