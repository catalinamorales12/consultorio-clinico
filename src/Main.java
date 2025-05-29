import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Medico> ListMedico = new ArrayList<>();
    public static void main(String[] args)
    {
            Scanner scanner = new Scanner(System.in);
            String usuario;
            String contra;

            System.out.print("BIENVENIDO AL PROGRAMA DE ALTA DE CITAS");
            System.out.print("\n-----------Iniciar sesion--------------");
            System.out.print("\n Usuario: ");
            usuario = scanner.nextLine();
            System.out.print("\n Contraseña: ");
            contra = scanner.nextLine ();

            if(validarUsuario(usuario, contra)){
                System.out.println("\n Bienvenido: " + usuario);
                {
                    menu();
                    operaciones();
                }
            } else {
                System.out.println("\n Credenciales Invalidas");
            }


        scanner.close();

    }
    static boolean validarUsuario (String usuario, String contra) {
        String usuarioLocal="admin";
        String contraLocal="1234";
        if(usuarioLocal.equals(usuario) && contraLocal.equals(contra)){
            return true;
        }
        return false;
    }
    static void menu() {
        System.out.println("\n----MENU DE OPCIONES-----");
        System.out.println("1.-Dar de alta medico");
        System.out.println("2.-Dar de alta paciente");
        System.out.println("3.-Crear cita");
        System.out.println("4.-Listar medicos");
        System.out.println("5.-Listar pacientes");
        System.out.println("6.-Listar citas");
    }
    static void operaciones(){
        Scanner entrada = new Scanner(System.in);
        Integer opcion;
        System.out.println("\n Ingresa una opción: ");
        opcion=entrada.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Alta de medico");
                altaMedico();
                break;
        }
        entrada.close();
    }
    static void altaMedico(){
        Scanner entrada = new Scanner(System.in);
        Medico medico = new Medico();

        System.out.println("Nombre: ");
        medico.nombre=entrada.nextLine();

        System.out.println("Especialidad: ");
        medico.especialidad=entrada.nextLine();

        ListMedico.add(medico);
        System.out.println("Medico dado de alta correctamente");
    }


}
