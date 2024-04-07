import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static class Datos {
        public String nombreCliente = "Johnny Arroyo";
        public String tipoDeCuenta = "Corriente";
        public double saldoInicial = 1600;
        public double saldoCuenta = 0;
        public String moneda = "¢";
        @Override
        public String toString() {
            return "Nombre del cliente: " + nombreCliente + "\n" +
                    "Tipo de cuenta: " + tipoDeCuenta + "\n" +
                    "Saldo de la cuenta: " + moneda + saldoInicial;
        }
    }
    public static void main(String[] args) {
        double saldoNuevo;
        Datos datosClientes = new Datos();
        String revisionFondos;

        saldoNuevo = datosClientes.saldoInicial - datosClientes.saldoCuenta;
        System.out.println("*******************");
        System.out.println("\n" + datosClientes);
        System.out.println("\n*********************");

//Impresion de Mensajes iniciales
        Scanner menuOpciones = new Scanner(System.in);
        int opcion;
//Se crean las variables para realizar en el menu de opciones
    do {
        String menu = """
                
                ¡Digite el numero de transaccion a realiza!
                
                1 - Consulta de Saldo:
                2 - Retiro de Dinero:
                3 - Deposito de Dinero:
                9 - Salir del Menu
                """;
        System.out.println(menu);
        opcion = menuOpciones.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Su saldo es de: " + datosClientes.moneda + saldoNuevo);
                break;
            case 2:
                System.out.println("¿Cuánto monto desea retirar?");
                double montoRetiro = menuOpciones.nextDouble();
                revisionFondos = (montoRetiro > saldoNuevo) ? "\nFondos insuficientes" : "Retiro exitoso. Su nuevo saldo es: " + datosClientes.moneda + (saldoNuevo -= montoRetiro);
                System.out.println(revisionFondos);
                break;
            case 3:
                System.out.println("¿Cuánto monto desea depositar?");
                double montoDeposito = menuOpciones.nextDouble();
                revisionFondos = (montoDeposito <= 0) ? "\nFondos deben ser mayor a 0" : "Deposito exitoso. Su nuevo saldo es: " + datosClientes.moneda + (saldoNuevo += montoDeposito);
                System.out.println(revisionFondos);
                break;
            default:
                System.out.println("¡Opcion no valida!");
                break;
        }
    } while (opcion != 9);
    }
}