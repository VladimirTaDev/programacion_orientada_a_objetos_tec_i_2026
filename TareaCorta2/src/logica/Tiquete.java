package logica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tiquete {
    private int codigo;
    private String idCliente;
    
    private static int consecutivo = 1;

    public Tiquete(String idCliente) throws Exception {
    	// Constructor. Verifica si el ID es válido.
        if (!esIdValido(idCliente)) {
			throw new Exception("ID del cliente no valido");
		}
    	// Asigna número consecutivo al codigo.
    	codigo = consecutivo;
    	consecutivo += 1;
    	
    	// Asigna el idCliente al idCliente de la clase.
    	this.idCliente = idCliente;
    	
    }

    private boolean esIdValido(String id) {
    	// Verifica si el ID es valido.
    	Pattern p = Pattern.compile("^[0-9\\\\-]+$");
	    Matcher m = p.matcher(id);
	    return m.matches();
    }

    public String toString() {
		// Override de toString para mostrar el cliente.
	return "Tiquete(Consecutivo actual=" + consecutivo + ", Codigo=" + codigo + ", ID del Cliente=" + idCliente + ")";
	}
}
