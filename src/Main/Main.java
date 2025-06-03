package Main;

import Medico.Medico;
import Paciente.Paciente;
import Cita.Cita;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    static List<Medico> listaMedicos = new ArrayList<>();
    static List<Paciente> listaPacientes = new ArrayList<>();
    static List<Cita> listaCitas = new ArrayList<>();
    static Scanner entrada = new Scanner(System.in);
    static int idMedico = 1;
    static int idPaciente = 1;
    static int idCita = 1;

    public static void main(String[] args) {
        String usuario;
        String contra;

        System.out.println("BIENVENIDO AL PROGRAMA DE ALTA DE CITAS");
        System.out.println("-----------Iniciar sesión--------------");
        System.out.print("Usuario: ");
        usuario = entrada.nextLine();
        System.out.print("Contraseña: ");
        contra = entrada.nextLine();

        if (validarUsuario(usuario, contra)) {
            System.out.println("\nBienvenido: " + usuario);
            while (true) {
                menu();
                operaciones();
            }
        } else {
            System.out.println("\nCredenciales inválidas");
        }
    }

    static boolean validarUsuario(String usuario, String contra) {
        String usuarioLocal = "admin";
        String contraLocal = "1234";
        return usuarioLocal.equals(usuario) && contraLocal.equals(contra);
    }

    static void menu() {
        System.out.println("\n----MENÚ DE OPCIONES-----");
        System.out.println("1.- Dar de alta médico");
        System.out.println("2.- Dar de alta paciente");
        System.out.println("3.- Crear cita");
        System.out.println("4.- Listar médicos");
        System.out.println("5.- Listar pacientes");
        System.out.println("6.- Listar citas");
        System.out.println("7.- Salir");
    }

    static void operaciones() {
        System.out.print("\nIngresa una opción: ");
        int opcion = entrada.nextInt();
        entrada.nextLine(); // Limpiar buffer

        switch (opcion) {
            case 1:
                altaMedico();
                break;
            case 2:
                altaPaciente();
                break;
            case 3:
                crearCita();
                break;
            case 4:
                listarMedicos();
                break;
            case 5:
                listarPacientes();
                break;
            case 6:
                listarCitas();
                break;
            case 7:
                System.out.println("¡Hasta luego!");
                System.exit(0);
            default:
                System.out.println("Opción no válida");
        }
    }

    static void altaMedico() {
        Medico medico = new Medico();
        medico.id = idMedico++;

        System.out.print("Nombre del médico: ");
        medico.nombre = entrada.nextLine();

        System.out.print("Especialidad: ");
        medico.especialidad = entrada.nextLine();

        listaMedicos.add(medico);
        System.out.println("Médico dado de alta correctamente.");
    }

    static void altaPaciente() {
        Paciente paciente = new Paciente();
        paciente.id = idPaciente++;

        System.out.print("Nombre del paciente: ");
        paciente.nombre = entrada.nextLine();

        listaPacientes.add(paciente);
        System.out.println("Paciente dado de alta correctamente.");
    }

    static void crearCita() {
        if (listaMedicos.isEmpty() || listaPacientes.isEmpty()) {
            System.out.println("Debe haber al menos un médico y un paciente registrados.");
            return;
        }

        Cita cita = new Cita();
        cita.id = idCita++;

        System.out.print("Fecha y hora de la cita (ej. 2025-06-10 10:00 AM): ");
        cita.fechaHora = entrada.nextLine();

        System.out.print("Motivo de la cita: ");
        cita.motivo = entrada.nextLine();

        // Selección de médico
        System.out.println("Seleccione el ID del médico:");
        listarMedicos();
        int idM = entrada.nextInt();
        entrada.nextLine(); // limpiar buffer

        // Buscar médico
        for (Medico m : listaMedicos) {
            if (m.id == idM) {
                cita.medico = m;
                break;
            }
        }

        // Selección de paciente
        System.out.println("Seleccione el ID del paciente:");
        listarPacientes();
        int idP = entrada.nextInt();
        entrada.nextLine(); // limpiar buffer

        // Buscar paciente
        for (Paciente p : listaPacientes) {
            if (p.id == idP) {
                cita.paciente = p;
                break;
            }
        }

        listaCitas.add(cita);
        System.out.println("Cita creada correctamente.");
    }

    static void listarMedicos() {
        if (listaMedicos.isEmpty()) {
            System.out.println("No hay médicos registrados.");
        } else {
            System.out.println("\n---Lista de Médicos---");
            for (Medico m : listaMedicos) {
                System.out.println("ID: " + m.id + " | Nombre: " + m.nombre + " | Especialidad: " + m.especialidad);
            }
        }
    }

    static void listarPacientes() {
        if (listaPacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
        } else {
            System.out.println("\n---Lista de Pacientes---");
            for (Paciente p : listaPacientes) {
                System.out.println("ID: " + p.id + " | Nombre: " + p.nombre);
            }
        }
    }

    static void listarCitas() {
        if (listaCitas.isEmpty()) {
            System.out.println("No hay citas registradas.");
        } else {
            System.out.println("\n---Lista de Citas---");
            for (Cita c : listaCitas) {
                System.out.println("ID: " + c.id + " | Fecha y Hora: " + c.fechaHora +
                        " | Motivo: " + c.motivo +
                        " | Médico: " + c.medico.nombre +
                        " | Paciente: " + c.paciente.nombre);
            }
        }
    }
}
