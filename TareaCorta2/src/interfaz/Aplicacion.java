package interfaz;

import logica.Cliente;
import logica.Tiquete;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Aplicacion {
	
	public static void main() {
		
		// Crear HashMap para guardar clientes.
		Map<String, Cliente> baseClientes = new HashMap<>();
		// Crear Queue para guardar tiquetes abiertos.
		Queue<Tiquete> tiquetesAbiertos = new LinkedList<>();
		// Crear ArrayList para guardar el historial de los tiquetes atendidos.
		List<Tiquete> historialDeTiquetes = new ArrayList<>();
		
		// Imprimir el menu principal.
		imprimirMenu(baseClientes, tiquetesAbiertos, historialDeTiquetes);
		// Pedir entradas al usuario.
		pedirEntrada(baseClientes, tiquetesAbiertos, historialDeTiquetes);
		
	}
	
	public static void imprimirMenu(Map<String, Cliente> baseClientes, Queue<Tiquete> tiquetesAbiertos, List<Tiquete> historialDeTiquetes) {
		// Imprimir diccionario de clientes, cola de tiquetes abiertos e historial de tiquetes atendidos.
		System.out.println("//////////////////////////////////////////////////////////////////////////");
		System.out.println("//////////////////////////////////////////////////////////////////////////");
		System.out.println("//////////////////////////////////////////////////////////////////////////");
		System.out.println("Base de Clientes: " + baseClientes);
		System.out.println("Tiquetes Abiertos: " + tiquetesAbiertos);
		System.out.println("Historial de Tiquetes Atendidos: " + historialDeTiquetes);
		
		// Imprimir el menu principal.
		System.out.println("");
		System.out.println("Menu: ");
		System.out.println("1. Agregar cliente");
		System.out.println("2. Agregar tiquete a la cola");
		System.out.println("3. Atender el siguiente tiquete de la cola");
		System.out.println("4. Descartar el siguiente tiquete de la cola");
		System.out.println("5. Limpiar historial de tiquetes atendidos");
		System.out.println("6. Salir");
	}
	
	public static void pedirEntrada(Map<String, Cliente> baseClientes, Queue<Tiquete> tiquetesAbiertos, List<Tiquete> historialDeTiquetes) {
		// Pedir entradas al usuario.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String entrada = "0";
		while (entrada.equals("0")) {
			System.out.print("Seleccione una opción: ");
			try {
				entrada = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (entrada.equals("1")) {
				agregarCliente(baseClientes);
				// Imprimir el menu principal.
				imprimirMenu(baseClientes, tiquetesAbiertos, historialDeTiquetes);
				// Pedir entradas al usuario.
				pedirEntrada(baseClientes, tiquetesAbiertos, historialDeTiquetes);
			} else if (entrada.equals("2")) {
				agregarTiquete(baseClientes, tiquetesAbiertos);
                // Imprimir el menu principal.
                imprimirMenu(baseClientes, tiquetesAbiertos, historialDeTiquetes);
                // Pedir entradas al usuario.
                pedirEntrada(baseClientes, tiquetesAbiertos, historialDeTiquetes);
			} else if (entrada.equals("3")) {
                atenderTiquete(tiquetesAbiertos, historialDeTiquetes);
                // Imprimir el menu principal.
                imprimirMenu(baseClientes, tiquetesAbiertos, historialDeTiquetes);
                // Pedir entradas al usuario.
                pedirEntrada(baseClientes, tiquetesAbiertos, historialDeTiquetes);
            } else if (entrada.equals("4")) {
                descartarTiquete(tiquetesAbiertos);
                // Imprimir el menu principal.
                imprimirMenu(baseClientes, tiquetesAbiertos, historialDeTiquetes);
                // Pedir entradas al usuario.
                pedirEntrada(baseClientes, tiquetesAbiertos, historialDeTiquetes);
            } else if (entrada.equals("5")) {
                limpiarHistorial(historialDeTiquetes);
                // Imprimir el menu principal.
                imprimirMenu(baseClientes, tiquetesAbiertos, historialDeTiquetes);
                // Pedir entradas al usuario.
                pedirEntrada(baseClientes, tiquetesAbiertos, historialDeTiquetes);
            } else if (entrada.equals("6")) {
				System.out.print("Saliendo...");
			} else {
				System.out.println("Opción no válida. Intente de nuevo.");
				 entrada = "0";
			}
		}
	}
	
	public static void agregarCliente(Map<String, Cliente> baseClientes) {
		String entradaID = "0";
		String entradaNombre = "0";
		// Leer entrada.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (entradaID.equals("0")) {
			
			try {
				System.out.print("Ingrese el ID del cliente: ");
				entradaID = reader.readLine();
				System.out.print("Ingrese el nombre del cliente: ");
				entradaNombre = reader.readLine();
				
				// Verificar si el ID ya existe en la base de clientes.
				if (baseClientes.containsKey(entradaID)) {
					System.out.println("El ID ya existe. Intente de nuevo.");
					entradaID = "0";
					continue;
				}
				baseClientes.put(entradaID, new Cliente(entradaID, entradaNombre));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void agregarTiquete(Map<String, Cliente> baseClientes, Queue<Tiquete> tiquetesAbiertos) {
        String entradaID = "0";
        // Leer entrada.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        while (entradaID.equals("0")) {
            try {
                System.out.print("Ingrese el ID del cliente para el tiquete: ");
                entradaID = reader.readLine();
                
                // Verificar si el ID existe en la base de clientes.
                if (!baseClientes.containsKey(entradaID)) {
                    System.out.println("Cliente no encontrado.");
                    entradaID = "0";
                    continue;
                }
                
                // Si el cliente existe, crear y agregar el tiquete a la cola.
                Tiquete nuevoTiquete = new Tiquete(entradaID);
                tiquetesAbiertos.offer(nuevoTiquete);
                System.out.println("Tiquete agregado exitosamente.");
                
            } catch (Exception e) {
                e.printStackTrace();
                entradaID = "0";
            }
        }
    }
	
	public static void atenderTiquete(Queue<Tiquete> tiquetesAbiertos, List<Tiquete> historialDeTiquetes) {
        try {
            // Verificar si hay tiquetes en la cola.
            if (tiquetesAbiertos.isEmpty()) {
                System.out.println("No hay más tiquetes.");
            } else {
                // Devolver el primer tiquete de la cola.
                Tiquete tiqueteAMostrar = tiquetesAbiertos.poll();
                System.out.println("Tiquete para atender: " + tiqueteAMostrar.toString());
                
                // Agregar al historial.
                historialDeTiquetes.add(tiqueteAMostrar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void descartarTiquete(Queue<Tiquete> tiquetesAbiertos) {
        try {
            // Verificar si hay tiquetes en la cola.
            if (tiquetesAbiertos.isEmpty()) {
                System.out.println("No hay más tiquetes.");
            } else {
                // Eliminar el tiquete y mostrar información.
                Tiquete tiqueteDescartado = tiquetesAbiertos.poll();
                System.out.println("Tiquete descartado: " + tiqueteDescartado.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void limpiarHistorial(List<Tiquete> historialDeTiquetes) {
        try {
            // Elimina todo de la lista del historial.
            historialDeTiquetes.clear();
            System.out.println("El historial ha sido limpiado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
