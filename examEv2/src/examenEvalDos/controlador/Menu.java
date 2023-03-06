package examenEvalDos.controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import examenEvalDos.examen.modelo.Libro;



/**
 * Clase de menus.
 */
public class Menu {
	private static final String PATH_FICHERO = "Archivos";
	private static final String NOMBRE_FICHERO = "examen.txt";
	public static final String URL = "jdbc:mysql://localhost:3306/exameneval2";
	public static final String USER = "root";
	public static final String PASS = "";
	
	


	private Scanner teclado = null;

	public Menu() {
		teclado = new Scanner(System.in);
	}

	// --------------------------
	// No tocar - Menus
	// --------------------------

	public void iniciar() {
		int opcion = 0;
		do {
			opcion = opcionMenuInicial();
			if (opcion != 0) {
				ejecutarOpcionMenuInicial(opcion);
			}
		} while (opcion != 0);
	}

	private int opcionMenuInicial() {
		int ret = 0;
		do {
			try {
				escribirMenuInicial();
				System.out.print("Elija una opcion: ");
				ret = teclado.nextInt();
				teclado.nextLine();
			} catch (Exception e) {
				teclado.nextLine();
				ret = -1;
			}
		} while ((ret < 0) && (ret > 8));
		return ret;
	}

	private void escribirMenuInicial() {
		System.out.println(" ");
		System.out.println("---- MENU ----");
		System.out.println("---- 0 - SALIR ");
		System.out.println("---- 1 - Buscar todos los libros ");
		System.out.println("---- 2 - Buscar libro por ID ");
		System.out.println("---- 3 - Buscar todos los libros de un autor ");
		System.out.println("---- 4 - Buscar todos los libros publicados antes de 2020-01-01 ");
		System.out.println("---- 5 - Añadir libro ");
		System.out.println("---- 6 - Guardar todos los libros en un fichero ");
		System.out.println("---- 7 - Mostrar todos los libros del fichero ");
		System.out.println("---- 8 - Insertar todos los libros del fichero en BBDD");
		System.out.println("--------------");
	}

	// --------------------------
	// A modificar por el alumno
	// --------------------------

	private void ejecutarOpcionMenuInicial(int opcion) {
		System.out.println(" ");
		switch (opcion) {
		case 1: 
			System.out.println("Saliendo del programa");
			teclado.nextLine();
			
			break;
		case 2: 
			 System.out.println("Buscando libros...");
			break;
		case 3: // TODO A responder por el alumno
			break;
		case 4: // TODO A responder por el alumno
			break;
		case 5: // TODO A responder por el alumno
			break;
		case 6: // TODO A responder por el alumno
			break;
		case 7: // TODO A responder por el alumno
			break;
		case 8: // TODO A responder por el alumno
			break;
		default:
			System.out.println("Esta opcion no deberia salir...");
		}
	}

	// --------------------------
	// No tocar - Pinta datos
	// --------------------------

	/**
	 * Muestra los datos del alumno pasado por parametro
	 */
	private void mostrarLibro(Libro libro) {
		if (null != libro) {
			System.out.println("-------------------------------------");
			System.out.println("Id - " + libro.getId());
			System.out.println("Titulo - " + libro.getTitulo());
			System.out.println("Autor - " + libro.getAutor());
			System.out.println("Editorial - " + libro.getEditorial());
			System.out.println("Fecha Publicacion - " + dateToString(libro.getFechaPublicacion()));
			System.out.println("-------------------------------------");
		} else {
			System.out.println("No hay informacion que mostrar");
		}
	}

	/**
	 * Convierte la fecha en String en fecha Date. Las fechas estan en formato
	 * MM/dd/yyyy
	 * 
	 * @param fecha
	 * @return la fecha en String
	 */
	private String dateToString(Date fecha) {
		String ret = null;
		String pattern = "yyyy/MM/dd";
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		ret = dateFormat.format(fecha);
		return ret;
	}

	// --------------------------
	// No tocar - Pide datos
	// --------------------------

	/**
	 * Solicita por teclado el id de un libro
	 * 
	 * @return el id
	 */
	private int pedirId() {
		// TODO A responder por el alumno
		String ID = new String();
		
		System.out.println("Introduzca un ID para porfavor: ");
		ID = teclado.next();
		
		return 0;
	}

	/**
	 * Solicita por teclado el autor de un libro
	 * 
	 * @return el autor
	 */
	private String pedirAutor() {
		System.out.print("Autor: ");
		return teclado.nextLine().trim();
	}

	/**
	 * Convierte la fecha en String en fecha Date. Si hay cualquier problema, en
	 * lugar de eso, devuelve la fecha del sistema. Las fechas estan en formato
	 * MM/dd/yyyy
	 * 
	 * @param fecha
	 * @return Date
	 */
	private Date stringToDate(String fecha) {
		Date ret = null;
		try {
			String pattern = "yyyy/MM/dd";
			SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.ENGLISH);
			ret = formatter.parse(fecha);
		} catch (Exception e) {
			// Algo ha ido mal, devolvemos la fecha del sistema
			ret = new Date();
		}
		return ret;
	}
}
