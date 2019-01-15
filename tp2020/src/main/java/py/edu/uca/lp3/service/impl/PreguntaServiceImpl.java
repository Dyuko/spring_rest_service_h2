package py.edu.uca.lp3.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.Pregunta;
import py.edu.uca.lp3.repository.PreguntaRepository;
import py.edu.uca.lp3.service.CharlaService;
import py.edu.uca.lp3.service.PreguntaService;
@Service
public class PreguntaServiceImpl implements PreguntaService {

	@Autowired
	PreguntaRepository preguntaRepository;
	@Autowired
	CharlaService charlaService;
	@Override
	public void guardarPregunta(Long idCharla, Pregunta pregunta) throws Exception {
		if(idCharla==null)
		{
			throw new Exception("El idCharla recibido es nulo");
		}
		if(pregunta==null)
		{
			throw new Exception("La pregunta recibida es nula");
		}
		if(charlaService.encontrarPorId(idCharla)==null)
		{
			throw new Exception("El identificador no corresponde a ninguna Charla existente");
		}
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		pregunta.setFechaEnvio(date);
		pregunta.setIdCharla(idCharla);
		pregunta.setVotosPositivos(0);
		pregunta.setVotosNegativos(0);
		preguntaRepository.save(pregunta);
	}

	@Override
	public void eliminarPregunta(Long idPregunta) throws Exception {
		if(idPregunta==null)
		{
			throw new Exception("El idPregunta recibido es nulo");
		}
		if(preguntaRepository.findOne(idPregunta)==null)
		{
			throw new Exception("El identificador no corresponde a ninguna Pregunta existente");
		}
		preguntaRepository.delete(idPregunta);
	}

	@Override
	public Pregunta encontrarPorId(Long idPregunta) throws Exception {
		if(idPregunta==null)
		{
			throw new Exception("El idPregunta recibido es nulo");
		}
		return preguntaRepository.findOne(idPregunta);
	}

	@Override
	public List<Pregunta> encontrarPorFecha(String fecha) throws Exception {
		if(fecha==null)
		{
			throw new Exception("La fecha recibida es nula");
		}
		Iterator<Pregunta> preguntasIterator = preguntaRepository.findAll().iterator();
		Pregunta pregunta;
		List<Pregunta> preguntas = new ArrayList<>();
		//System.out.println(fecha);
		while(preguntasIterator.hasNext()) {
			pregunta=preguntasIterator.next();
			if(pregunta.getFechaEnvio().compareTo(fecha)==0)
			{
				preguntas.add(pregunta);
			}
		}
		return preguntas;
	}

	@Override
	public List<Pregunta> encontrarTodos(Long idCharla) throws Exception {
		if(idCharla==null)
		{
			throw new Exception("El idCharla recibido es nulo");
		}
		if(charlaService.encontrarPorId(idCharla)==null)
		{
			throw new Exception("El identificador no corresponde a ninguna Charla existente");
		}
		List<Pregunta> preguntas = new ArrayList<>();
		Iterator<Pregunta> preguntasIterator = preguntaRepository.findAll().iterator();
		Pregunta pregunta;
		while(preguntasIterator.hasNext()) {
			pregunta=preguntasIterator.next();
			if(pregunta.getIdCharla()==idCharla)
			{
				preguntas.add(pregunta);	
			}
		}
		return preguntas ;
	}

	@Override
	public Integer consultarVotosPositivos(Long idPregunta) throws Exception {
		if(idPregunta==null)
		{
			throw new Exception("El idPregunta recibido es nulo");
		}
		Pregunta pregunta;
		pregunta = preguntaRepository.findOne(idPregunta);
		if(pregunta==null)
		{
			throw new Exception("El identificador no corresponde a ninguna Pregunta existente");
		}
		return pregunta.getVotosPositivos();
	}

	@Override
	public Integer consultarVotosNegativos(Long idPregunta) throws Exception {
		if(idPregunta==null)
		{
			throw new Exception("El idPregunta recibido es nulo");
		}
		Pregunta pregunta;
		pregunta= preguntaRepository.findOne(idPregunta);
		if(pregunta==null)
		{
			throw new Exception("El identificador no corresponde a ninguna Pregunta existente");
		}
		return pregunta.getVotosNegativos();
	}

	@Override
	public void asignarVotoPositivo(Long idPregunta) throws Exception {
		if(idPregunta==null)
		{
			throw new Exception("El idPregunta recibido es nulo");
		}
		if(preguntaRepository.findOne(idPregunta)==null)
		{
			throw new Exception("El identificador no corresponde a ninguna Pregunta existente");
		}
		Pregunta pregunta;
		pregunta= preguntaRepository.findOne(idPregunta);
		pregunta.asignarVotoPositivo();
		preguntaRepository.save(pregunta);
	}

	@Override
	public void asignarVotoNegativo(Long idPregunta) throws Exception {
		if(idPregunta==null)
		{
			throw new Exception("El idPregunta recibido es nulo");
		}
		if(preguntaRepository.findOne(idPregunta)==null)
		{
			throw new Exception("El identificador no corresponde a ninguna Pregunta existente");
		}
		Pregunta pregunta;
		pregunta= preguntaRepository.findOne(idPregunta);
		pregunta.asignarVotoNegativo();
		preguntaRepository.save(pregunta);
	}

	@Override
	public List<Pregunta> listarTodos() {
		List<Pregunta> preguntas = new ArrayList<>();
		Iterator<Pregunta> preguntasIterator = preguntaRepository.findAll().iterator();
		while(preguntasIterator.hasNext()) {
			preguntas.add(preguntasIterator.next());
		}
		return preguntas ;
	}

	@Override
	public List<Pregunta> listarPorFecha(String fecha) throws Exception {
		if(fecha==null)
		{
			throw new Exception("La fecha recibida es nula");
		}
		List<Pregunta> preguntas = new ArrayList<>();
		Iterator<Pregunta> preguntasIterator = preguntaRepository.findAll().iterator();
		Pregunta pregunta;
		while(preguntasIterator.hasNext()) {
			pregunta=preguntasIterator.next();
			if(pregunta.getFechaEnvio().compareTo(fecha)==0)
			{
				preguntas.add(pregunta);
			}
		}
		return preguntas ;
	}

	@Override
	public List<Pregunta> listarPorFechayCharla(String fecha, Long idCharla) throws Exception {
		if(fecha==null)
		{
			throw new Exception("La fecha recibida es nula");
		}
		if(idCharla==null)
		{
			throw new Exception("La idCharla recibida es nulo");
		}
		if(charlaService.encontrarPorId(idCharla)==null)
		{
			throw new Exception("El identificador no corresponde a ninguna Charla existente");
		}
		List<Pregunta> preguntas = new ArrayList<>();
		Iterator<Pregunta> preguntasIterator = preguntaRepository.findAll().iterator();
		Pregunta pregunta;
		while(preguntasIterator.hasNext()) {
			pregunta=preguntasIterator.next();
			if(pregunta.getFechaEnvio().compareTo(fecha)==0 && pregunta.getIdCharla()==idCharla)
			{
				preguntas.add(pregunta);
			}
		}
		return preguntas ;
	}

}
