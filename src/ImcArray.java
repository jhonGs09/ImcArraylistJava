
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class ImcArray {

	ArrayList<String> nombres = new ArrayList<>();
	ArrayList<String> resultado = new ArrayList<>();

	String nombre = "";
	int telefono = 0;
	Double peso, talla, imc;
	
	public void iniciar() {
		menu();		
	}
	
	public void menu() {

		int opc;
		do {

			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"Seleccione una opcion\n" + "1 - ingresar nueva persona\n" + "2 - buscar Persona \n"
							+ "3 - eliminar Persona \n" + "4 - Actualizar registros\n" + "5 - Imprimir resultados\n"));

			switch (opc) {
			case 1:
				IngresarDatos();
				break;

			case 2:
				buscarPersona();
				break;

			case 3:
				eliminarPersona();
				break;

			case 4:
				actualizarDatos();
				break;

			case 5:
				imprimirDatos();
			default:
				break;
			}

		} while (opc != 6);

	}

	public void IngresarDatos() {

		String proceso = "";

		do {

			nombre = JOptionPane.showInputDialog("Ingrese el nombre :");
			nombres.add(nombre);
			peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese peso :"));
			talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese estatura :"));
			calcular();

			proceso = JOptionPane.showInputDialog("¿Desea agregar una nueva persona?\n " + "Ingrese si para seguir\n");

		} while (proceso.equalsIgnoreCase("si"));

		System.out.println();
		System.out.println(nombres);
		System.out.println(resultado + "\n");
	}

	public void buscarPersona() {

		System.out.println("Usuarios registrado : " + nombres);
		String consulta = JOptionPane.showInputDialog("Ingrese el nombre de la persona a buscar: ");

		if (nombres.contains(consulta)) {

			for (int i = 0; i < nombres.size(); i++) {

				if (nombres.get(i).equalsIgnoreCase(consulta)) {

					System.out.println(consulta + " si existe ");
					System.out.println("Y su IMC es de : " + resultado.get(i));

				}
			}
		} else {
			System.out.println("no existe");
		}
	}

	public void eliminarPersona() {

		System.out.println("personas registradas : " + nombres);
		String consulta = JOptionPane.showInputDialog("Ingrese el nombre de la persona para eliminar : ");

		if (nombres.contains(consulta)) {
			for (int i = 0; i < nombres.size(); i++) {
				if (nombres.get(i).equalsIgnoreCase(consulta)) {
					nombres.remove(consulta);
					System.out.println(" eliminado " + nombres);
				}

			}
		} else {

			System.out.println("no existe");

		}
	}

	public void actualizarDatos() {

		int pregunta = 0;

		do {

			pregunta = Integer.parseInt(JOptionPane.showInputDialog(
					"Que desea actualizar\n" + "1 - Nombre del paciente\n" + "2 - Salir al menú principal"));

			switch (pregunta) {
			case 1:
				actualizarNombre();
				break;
			case 2:
				menu();
				break;

			default:
				System.out.println("Error!");
				break;
			}
		} while (pregunta != 3);
	}

	public void calcular() {

		imc = 0.0;
		imc = peso / (talla * talla);

		String res = "";

		if (imc < 18) {
			res = ("Anorexia");
		} else if (imc >= 18 && imc < 20) {
			res = ("Delgadez");
		} else if (imc >= 20 && imc < 27) {
			res = ("Normalidad");
		} else if (imc >= 27 && imc < 30) {
			res = ("Obesidad 1");
		} else if (imc >= 30 && imc < 35) {
			res = ("Obesidad 2");
		} else if (imc >= 35 && imc < 40) {
			res = ("Obesidad 3");
		} else if (imc >= 40) {
			res = ("Obesidad Morbida");
		}

		resultado.add(res);
		System.out.println("El IMC es de : " + res);
	}

	private void imprimirDatos() {
		System.out.println("------------------------------\n");

		for (int i = 0; i < nombres.size(); i++) {
			System.out.println(nombres.get(i) + ", resultado: " + resultado.get(i));
		}

		System.out.println();
		System.out.println("------------------------------");
	}

	public void actualizarNombre() {

		System.out.println("Persona registrada : " + nombres);

		String persona = JOptionPane.showInputDialog("Ingrese el nombre de la persona para actualizar sus datos : ");

		if (nombres.contains(persona)) {
			for (int i = 0; i < nombres.size(); i++) {
				if (nombres.get(i).equalsIgnoreCase(persona)) {
					nombres.remove(persona);

					nombre = JOptionPane.showInputDialog("Ingrese nuevo nombre");
					nombres.add(nombre);
					System.out.println("Se ha actualizado correctamente");
				}

			}
		} else {
			System.out.println("existe en el sistema");
		}
	}

}