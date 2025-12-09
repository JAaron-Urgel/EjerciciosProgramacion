import java.util.Scanner;
public class Utils {
    static Scanner sc = new Scanner(System.in);
    public static int validaInt(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.println("Numero Invalido");
            sc.next();
        }
        return sc.nextInt();
    }
    public static double validaDouble(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            System.out.println("Numero Invalido");
            sc.next();
        }
        return sc.nextDouble();
    }

    public static String validaString(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextLine()) {
            System.out.println("Texto invalido");
            sc.next();
        }
        return sc.nextLine();
    }

}