package logica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
    private String id;
    private String nombre;

    public Cliente(String id, String nombre) throws Exception {
        // Constructor. Verifica si el ID es válido y lo asigna.
        if (!esIdValido(id)) {
			throw new Exception("ID no valido");
		}

    	this.id = id;
		this.nombre = nombre;
    }

    private boolean esIdValido(String id) {
    	// Verifica si el ID es valido.
    	Pattern p = Pattern.compile("^[0-9\\\\-]+$");
	    Matcher m = p.matcher(id);
	    return m.matches();
    }

	public String getId() {
		return id;
	}

	public void setId(String id) throws Exception {
		// Verifica si el ID es válido y lo asigna.
		if (!esIdValido(id)) {
			throw new Exception("ID no valido");
		}
		
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    public String toString() {
    		// Override de toString para mostrar el cliente.
		return "Cliente(id=" + id + ", nombre=" + nombre + ")";
	}
    
    
}
