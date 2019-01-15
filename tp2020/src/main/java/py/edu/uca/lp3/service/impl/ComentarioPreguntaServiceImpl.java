package py.edu.uca.lp3.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.ComentarioPregunta;
import py.edu.uca.lp3.repository.ComentarioPreguntaRepository;
import py.edu.uca.lp3.service.ComentarioPreguntaService;
import py.edu.uca.lp3.service.PreguntaService;
@Service
public class ComentarioPreguntaServiceImpl implements ComentarioPreguntaService {

	@Autowired
	ComentarioPreguntaRepository comentarioPreguntaRepository;
	@Autowired
	PreguntaService preguntaService;
	
	@Override
	public void guardarComentario(Long idPregunta, ComentarioPregunta comentarioPregunta) throws Exception {
		if(idPregunta==null)
		{
			throw new Exception("Se ha recibido idPregunta nulo");
		}
		if(comentarioPregunta==null)
		{
			throw new Exception("Se ha recibido comentarioPregunta nulo");
		}
		if(preguntaService.encontrarPorId(idPregunta)==null)
		{
			throw new Exception("Identificador no corresponde a ninguna Pregunta existente");
		}
		if(preguntaService.encontrarPorId(idPregunta).getBanderaComentario()==false)
		{
			throw new Exception("La pregunta no admite comentarios");
		}
		comentarioPregunta.setIdPregunta(idPregunta);
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		comentarioPregunta.setFechaEnvio(date);
		comentarioPreguntaRepository.save(comentarioPregunta);
	}

	@Override
	public void eliminarComentario(Long idComentario) throws Exception {
		if(idComentario==null)
		{
			throw new Exception("Se ha recibido idComentario nulo"); 
		}
		if(comentarioPreguntaRepository.findOne(idComentario)==null)
		{
			throw new Exception("Identificador no corresponde a ningún Comentario existente");
		}
		comentarioPreguntaRepository.delete(idComentario);
		
	}

	@Override
	public List<ComentarioPregunta> encontrarTodos(Long idPregunta) throws Exception {
		if(idPregunta==null)
		{
			throw new Exception("Se ha recibido idPregunta nulo");
		}
		if(preguntaService.encontrarPorId(idPregunta)==null)
		{
			throw new Exception("Identificador no corresponde a ninguna Pregunta existente");
		}
		List<ComentarioPregunta> comentariosPregunta = new ArrayList<>();
		Iterator<ComentarioPregunta> ComentarioPreguntaIterator = comentarioPreguntaRepository.findAll().iterator();
		ComentarioPregunta comentarioPregunta;
		while(ComentarioPreguntaIterator.hasNext()) {
			comentarioPregunta=ComentarioPreguntaIterator.next();
			if(comentarioPregunta.getIdPregunta()==idPregunta)
			{
				comentariosPregunta.add(comentarioPregunta);
			}
		}
		return comentariosPregunta ;
	}

	@Override
	public List<ComentarioPregunta> listarTodos() {
		List<ComentarioPregunta> comentarios = new ArrayList<>();
		Iterator<ComentarioPregunta> comentariosIterator = comentarioPreguntaRepository.findAll().iterator();
		while(comentariosIterator.hasNext()) {
			comentarios.add(comentariosIterator.next());
		}
		return comentarios ;
	}

}
