package py.edu.uca.lp3.service;

import java.util.List;

import py.edu.uca.lp3.domain.EventoConCosto;
import py.edu.uca.lp3.domain.Factura;

public interface EventoConCostoService {
	/**
	 * Encuentra todos los eventos con costo realizados
	 * Parametros:
	 * 		Ninguno
	 * Retorno:
	 * 		Lista de todos los eventos
	 * Posibles Excepciones:
	 * 		Ninguno
	 */
	List<EventoConCosto> encontrarTodos();

	/**
	 * Encuentra el evento correspondiente a dicho idEvento
	 * Parametros:
	 * 		idEvento, identificador del evento a ser encontrado
	 * Retorno:
	 * 		evento encontrado
	 * Posibles Excepciones:
	 * 		idEvento null
	 * 		idEvento no existente
	 * @throws Exception 
	 */
	EventoConCosto encontrarPorId(Long idEvento) throws Exception;
				
	/**
	 * Elimina el evento correspondiente a dicho idEvento
	 * Parametros:
	 * 		idEvento, identificador del evento a ser eliminado
	 * Retorno:
	 * 		Ninguno
	 * Posibles Excepciones:
	 * 		idEvento null
	 * 		idEvento no existente
	 * @throws Exception 
	 */
	void eliminarEventoConCosto(Long idEvento) throws Exception;
	
	/**
	 * Guardar evento con Costo
	 * Parametros: 
	 * 		eventoConCosto, evento a ser guardado
	 * Retorno: 
	 * 		Ninguno
	 * Posibles Excepciones:
	 * 		eventoConCosto NULL
	 * @throws Exception 
	 **/
	void guardarEventoConCosto(EventoConCosto eventoConCosto) throws Exception;
	
	/**
	 * Realizar pago para Evento con Costo, en la factura se incluyen todos los datos del pago
	 * Se pretende que encontrado el evento con idEvento, se introduzca la factura en su lista de facturas.
	 * Parametros:
	 * 		idEvento, id del evento sobre el cual se realiza un pago
	 * 		factura, incluye todos los datos sobre el pago, como la persona que lo realiza, su metodo de pago, el costo, la fecha del dia generada automaticamente
	 * Retorno:
	 * 		Ninguno
	 * Posibles Excepciones:
	 * 		idEvento null
	 * 		idEvento no existente
	 * 		factura NULL
	 * @throws Exception 
	 */
	void realizarPagoEventoConCosto(Long idEvento, Factura factura) throws Exception;
	
	/**
	 * Listar todas las facturas
	 * Parametros:
	 * 		Ninguno
	 * Retorno:
	 * 		Lista de todas las facturas
	 * Posibles Excepciones:
	 * 		Ninguno
	 */
	List<Factura> listarTodasFactura();
	
	/**
	 * Encontrar todas las facturas de un Evento
	 * Parametros:
	 * 		idEvento, identificador del evento sobre el cual consultar las facturas
	 * Retorno:
	 * 		Lista de todas las facturas del evento
	 * Posibles excepciones:
	 * 		idEvento null
	 * 		idEvento inexistente
	 * @throws Exception 
	 */
	List<Factura> encontrarFacturaEvento(Long idEvento) throws Exception;
}
