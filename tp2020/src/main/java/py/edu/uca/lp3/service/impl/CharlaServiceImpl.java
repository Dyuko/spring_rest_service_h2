package py.edu.uca.lp3.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.Charla;
import py.edu.uca.lp3.repository.CharlaRepository;
import py.edu.uca.lp3.repository.ExpositorEstudianteRepository;
import py.edu.uca.lp3.repository.ExpositorInvestigadorRepository;
import py.edu.uca.lp3.repository.ExpositorProfesionalInvitadoRepository;
import py.edu.uca.lp3.repository.ExpositorProfesorRepository;
import py.edu.uca.lp3.service.CharlaService;
import py.edu.uca.lp3.service.EventoService;
@Service
public class CharlaServiceImpl implements CharlaService {

	@Autowired
	private CharlaRepository charlaRepository;
	@Autowired
	private EventoService eventoService;
	@Autowired
	private ExpositorEstudianteRepository expositorEstudianteRepository;
	@Autowired
	private ExpositorInvestigadorRepository expositorInvestigadorRepository;
	@Autowired
	private ExpositorProfesionalInvitadoRepository expositorProfesionalInvitadoRepository;
	@Autowired
	private ExpositorProfesorRepository expositorProfesorRepository ;
	
	@Override
	public void guardarCharla(Long idEvento, Charla charla) throws Exception {
		if(charla==null)
		{
			throw new Exception("Se ha recibido charla nula");
		}
		if(idEvento==null)
		{
			throw new Exception("Se ha recibido idEvento nulo");
		}
		if(eventoService.encontrarPorId(idEvento)==null)
		{
			throw new Exception("El identificador recibido no corresponde a ningún Evento existente");
		}
		if(charla.getIdExpositor()!=null)
		{
			if(expositorEstudianteRepository.findOne(charla.getIdExpositor())==null
					&&expositorInvestigadorRepository.findOne(charla.getIdExpositor())==null
					&&expositorProfesionalInvitadoRepository.findOne(charla.getIdExpositor())==null
					&&expositorProfesorRepository.findOne(charla.getIdExpositor())==null)
			{
				throw new Exception("El identificador recibido no corresponde a ningún Expositor existente");
			}
		}
		charla.setIdEvento(idEvento);
		charlaRepository.save(charla);
	}

	@Override
	public List<Charla> encontrarTodos(Long idEvento) throws Exception {
		if(idEvento==null)
		{
			throw new Exception("Se ha recibido idEvento nulo");
		}
		if(eventoService.encontrarPorId(idEvento)==null)
		{
			throw new Exception("El identificador recibido no corresponde a ningún Evento existente");
		}
		List<Charla> charlas = new ArrayList<>();
		Iterator<Charla> charlasIterator = charlaRepository.findAll().iterator();
		Charla charla;
		while(charlasIterator.hasNext()) {
			charla=charlasIterator.next();
			if(charla.getIdEvento()==idEvento)
			{
				charlas.add(charla);
			}
		}
		return charlas ;
	}

	@Override
	public Charla encontrarPorId(Long idCharla) throws Exception {
		if(idCharla==null)
		{
			throw new Exception("Se ha recibido idEvento nulo");
		}
		return charlaRepository.findOne(idCharla);
	}

	@Override
	public void eliminarCharla(Long idCharla) throws Exception {
		if(idCharla==null)
		{
			throw new Exception("Se ha recibido idEvento nulo");
		}
		if(charlaRepository.findOne(idCharla)==null)
		{
			throw new Exception("El identificador recibido no corresponde a ninguna Charla existente");
		}
		charlaRepository.delete(idCharla);
	}

	@Override
	public List<Charla> listarTodos() {
		List<Charla> charlas = new ArrayList<>();
		Iterator<Charla> charlasIterator = charlaRepository.findAll().iterator();
		while(charlasIterator.hasNext()) {
			charlas.add(charlasIterator.next());
		}
		return charlas ;
	}
}
