package interfaz;

import java.util.ArrayList;
import logica.Cuenta;

public class Aplicacion {

	public static void main(String[] args) {
		try {
			// 1) Declarar colección de cuentas
			ArrayList<Cuenta> cuentas = new ArrayList<>();

			// 2) Crear y agregar diferentes instancias (mínimo 8)
			cuentas.add(new Cuenta("Ana Lopez", 15000));
			cuentas.add(new Cuenta("Carlos Mora", 23000));
			cuentas.add(new Cuenta("Daniela Rojas", 8000));
			cuentas.add(new Cuenta("Esteban Solano", 12000));
			cuentas.add(new Cuenta("Fabiana Vargas", 5000));
			cuentas.add(new Cuenta("Gabriel Castro", 45000));
			cuentas.add(new Cuenta("Helena Jimenez", 30000));
			cuentas.add(new Cuenta("Ivan Alvarado", 9500));

			// 3) Imprimir toString de cada cuenta
			System.out.println("=== CUENTAS INICIALES ===");
			for (Cuenta c : cuentas) {
				System.out.println(c);
				System.out.println();
			}

			// 4) Alterar nombre y saldo, imprimir en pantalla
			System.out.println("=== CAMBIOS CON SET ===");

			Cuenta c1 = cuentas.get(0);
			System.out.println("Cuenta " + c1.getNumero() + " - cliente anterior: " + c1.getCliente());
			c1.setCliente("Ana Maria Lopez");
			System.out.println("Cuenta " + c1.getNumero() + " - cliente nuevo: " + c1.getCliente());

			System.out.println("Cuenta " + c1.getNumero() + " - saldo anterior: " + c1.getSaldo());
			c1.setSaldo(20000);
			System.out.println("Cuenta " + c1.getNumero() + " - saldo nuevo: " + c1.getSaldo());

			Cuenta c2 = cuentas.get(3);
			System.out.println("Cuenta " + c2.getNumero() + " - cliente anterior: " + c2.getCliente());
			c2.setCliente("Esteban Solis");
			System.out.println("Cuenta " + c2.getNumero() + " - cliente nuevo: " + c2.getCliente());

			System.out.println("Cuenta " + c2.getNumero() + " - saldo anterior: " + c2.getSaldo());
			c2.setSaldo(14000);
			System.out.println("Cuenta " + c2.getNumero() + " - saldo nuevo: " + c2.getSaldo());

			// 5) Imprimir nuevamente las cuentas
			System.out.println("\n=== CUENTAS DESPUES DE SET ===");
			for (Cuenta c : cuentas) {
				System.out.println(c);
				System.out.println();
			}

			// 6) Realizar cuatro depositos
			System.out.println("=== DEPOSITOS ===");
			cuentas.get(1).depositar(1000);
			System.out.println("Deposito de 1000 en cuenta #" + cuentas.get(1).getNumero());

			cuentas.get(4).depositar(2500);
			System.out.println("Deposito de 2500 en cuenta #" + cuentas.get(4).getNumero());

			cuentas.get(6).depositar(3000);
			System.out.println("Deposito de 3000 en cuenta #" + cuentas.get(6).getNumero());

			cuentas.get(7).depositar(1500);
			System.out.println("Deposito de 1500 en cuenta #" + cuentas.get(7).getNumero());

			// 7) Realizar cuatro retiros
			System.out.println("=== RETIROS ===");
			cuentas.get(0).retirar(500);
			System.out.println("Retiro de 500 en cuenta #" + cuentas.get(0).getNumero());

			cuentas.get(2).retirar(1000);
			System.out.println("Retiro de 1000 en cuenta #" + cuentas.get(2).getNumero());

			cuentas.get(5).retirar(3500);
			System.out.println("Retiro de 3500 en cuenta #" + cuentas.get(5).getNumero());

			cuentas.get(6).retirar(1200);
			System.out.println("Retiro de 1200 en cuenta #" + cuentas.get(6).getNumero());

			// 8) Imprimir nuevamente las cuentas
			System.out.println("\n=== CUENTAS FINALES ===");
			for (Cuenta c : cuentas) {
				System.out.println(c);
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("Ocurrio un error: " + e.getMessage());
		}

		System.out.println("Fin del programa.");
	}
}
