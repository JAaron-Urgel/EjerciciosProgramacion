import java.util.Scanner;

public class Utils
{
    static Scanner sc = new Scanner(System.in);
    public static int validaInt()
    {
        while (!sc.hasNextInt())
        {
            System.out.println("Por favor introduzca un número válido");
            sc.next();
        }

        return sc.nextInt();
    }
}
