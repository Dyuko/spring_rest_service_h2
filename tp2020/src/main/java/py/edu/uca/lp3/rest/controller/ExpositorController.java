package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.BaseEvento;
import py.edu.uca.lp3.domain.Charla;
import py.edu.uca.lp3.domain.ExpositorEstudiante;
import py.edu.uca.lp3.domain.ExpositorInvestigador;
import py.edu.uca.lp3.domain.ExpositorProfesionalInvitado;
import py.edu.uca.lp3.domain.ExpositorProfesor;
import py.edu.uca.lp3.domain.Facultad;
import py.edu.uca.lp3.domain.PersonaConId;
import py.edu.uca.lp3.domain.Universidad;
import py.edu.uca.lp3.service.ExpositorService;

@RestController
@RequestMapping("/expositor")
public class ExpositorController {
	@Autowired
	private ExpositorService expositorService;
	
	
	@RequestMapping(value = "/encontrarTodos/{idEvento}", method = RequestMethod.GET)
    public List<PersonaConId> encontrarTodos(@PathVariable("idEvento") Long idEvento) throws Exception {
		return expositorService.encontrarTodos(idEvento);
	}
	
	@RequestMapping(value = "/encontrarTodosEstudiantes/{idEvento}", method = RequestMethod.GET)
    public List<ExpositorEstudiante> encontrarTodosEstudiantes(@PathVariable("idEvento") Long idEvento) throws Exception {
		return expositorService.encontrarTodosEstudiante(idEvento);
	}
    
	@RequestMapping(value = "/encontrarTodosInvestigador/{idEvento}", method = RequestMethod.GET)
    public List<ExpositorInvestigador> encontrarTodosInvestigador(@PathVariable("idEvento") Long idEvento) throws Exception {
		return expositorService.encontrarTodosInvestigador(idEvento);
	}
	
	@RequestMapping(value = "/encontrarTodosProfesionalInvitado/{idEvento}", method = RequestMethod.GET)
    public List<ExpositorProfesionalInvitado> encontrarTodosProfesional(@PathVariable("idEvento") Long idEvento) throws Exception {
		return expositorService.encontrarTodosProfesional(idEvento);
	}
	
	@RequestMapping(value = "/encontrarTodosProfesor/{idEvento}", method = RequestMethod.GET)
    public List<ExpositorProfesor> encontrarTodosProfesor(@PathVariable("idEvento") Long idEvento) throws Exception {
		return expositorService.encontrarTodosProfesor(idEvento);
	}
	
	@RequestMapping(value = "/guardarExpositorEstudianteCharla/{idCharla}", method = RequestMethod.POST)
    public void guardarExpositorEstudianteCharla(@PathVariable("idCharla") Long idCharla, @RequestBody ExpositorEstudiante expositor) throws Exception {
		expositorService.guardarExpositorEstudianteCharla(idCharla, expositor);
    }
	
	@RequestMapping(value = "/guardarExpositorInvestigadorCharla/{idCharla}", method = RequestMethod.POST)
    public void guardarExpositorInvestigadorCharla(@PathVariable("idCharla") Long idCharla, @RequestBody ExpositorInvestigador expositor) throws Exception {
		expositorService.guardarExpositorInvestigadorCharla(idCharla, expositor);
    }
	
	@RequestMapping(value = "/guardarExpositorProfesionalCharla/{idCharla}", method = RequestMethod.POST)
    public void guardarExpositorProfesionalCharla(@PathVariable("idCharla") Long idCharla, @RequestBody ExpositorProfesionalInvitado expositor) throws Exception {
		expositorService.guardarExpositorProfesionalCharla(idCharla, expositor);
    }
	
	@RequestMapping(value = "/guardarExpositorProfesorCharla/{idCharla}", method = RequestMethod.POST)
    public void guardarExpositorProfesorCharla(@PathVariable("idCharla") Long idCharla, @RequestBody ExpositorProfesor expositor) throws Exception {
		expositorService.guardarExpositorProfesorCharla(idCharla, expositor);
    }
	
	@RequestMapping(value = "/encontrarUniversidadEstudiante/{documentoIdentidad}", method = RequestMethod.GET)
    public Universidad encontrarUniversidadEstudiante(@PathVariable("documentoIdentidad") String documentoIdentidad) throws Exception {
		return expositorService.encontrarUniversidadEstudiante(documentoIdentidad);
    }
	
	@RequestMapping(value = "/encontrarFacultadEstudiante/{documentoIdentidad}", method = RequestMethod.GET)
    public Facultad encontrarFacultadEstudiante(@PathVariable("documentoIdentidad") String documentoIdentidad) throws Exception {
		return expositorService.encontrarFacultadEstudiante(documentoIdentidad);
    }

	@RequestMapping(value = "/encontrarCharlaInvestigador/{documentoIdentidad}", method = RequestMethod.GET)
    public List<Charla> encontrarCharlaInvestigador(@PathVariable("documentoIdentidad") String documentoIdentidad) throws Exception {
		return expositorService.encontrarCharlaInvestigador(documentoIdentidad);
	}
	
	@RequestMapping(value = "/encontrarEventoInvestigador/{documentoIdentidad}", method = RequestMethod.GET)
    public List<BaseEvento> encontrarEventoInvestigador(@PathVariable("documentoIdentidad") String documentoIdentidad) throws Exception {
		return expositorService.encontrarEventoInvestigador(documentoIdentidad);
	}
	
	@RequestMapping(value = "/eliminarExpositor/{idExpositor}", method = RequestMethod.DELETE)
    public void eliminarExpositor(@PathVariable("idExpositor") Long idExpositor) throws Exception {
		expositorService.eliminarExpositor(idExpositor);
	}
	
	@RequestMapping(value = "/encontrarExpositorEstudiante/{documentoIdentidad}", method = RequestMethod.GET)
    public ExpositorEstudiante encontrarExpositorEstudiante(@PathVariable("documentoIdentidad") String documentoIdentidad) throws Exception {
		return expositorService.encontrarExpositorEstudiante(documentoIdentidad);
	}
	
	@RequestMapping(value = "/encontrarExpositorInvestigador/{documentoIdentidad}", method = RequestMethod.GET)
    public ExpositorInvestigador encontrarExpositorInvestigador(@PathVariable("documentoIdentidad") String documentoIdentidad) throws Exception {
		return expositorService.encontrarExpositorInvestigador(documentoIdentidad);
	}
	
	@RequestMapping(value = "/encontrarExpositorProfesionalInvitado/{documentoIdentidad}", method = RequestMethod.GET)
    public ExpositorProfesionalInvitado encontrarExpositorProfesionalInvitado(@PathVariable("documentoIdentidad") String documentoIdentidad) throws Exception {
		return expositorService.encontrarExpositorProfesionalInvitado(documentoIdentidad);
	}
	
	@RequestMapping(value = "/encontrarExpositorProfesor/{documentoIdentidad}", method = RequestMethod.GET)
    public ExpositorProfesor encontrarExpositorProfesor(@PathVariable("documentoIdentidad") String documentoIdentidad) throws Exception {
		return expositorService.encontrarExpositorProfesor(documentoIdentidad);
	}
	
	@RequestMapping(value = "/encontrarExpositor/{documentoIdentidad}", method = RequestMethod.GET)
    public PersonaConId encontrarExpositor(@PathVariable("documentoIdentidad") String documentoIdentidad) throws Exception {
		return expositorService.encontrarExpositor(documentoIdentidad);
	}
	
	@RequestMapping(value = "/listarTodosEstudiante", method = RequestMethod.GET)
    public List<ExpositorEstudiante> listarTodosEstudiante() {
		return expositorService.listarTodosEstudiante();
	}
	
	@RequestMapping(value = "/listarTodosInvestigador", method = RequestMethod.GET)
    public List<ExpositorInvestigador> listarTodosInvestigador() {
		return expositorService.listarTodosInvestigador();
	}
	
	@RequestMapping(value = "/listarTodosProfesional", method = RequestMethod.GET)
    public List<ExpositorProfesionalInvitado> listarTodosProfesional() {
		return expositorService.listarTodosProfesional();
	}
	
	@RequestMapping(value = "/listarTodosProfesor", method = RequestMethod.GET)
    public List<ExpositorProfesor> listarTodosProfesor() {
		return expositorService.listarTodosProfesor();
	}
	
}
