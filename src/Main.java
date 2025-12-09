import java.util.Scanner;

public class Main
{
    static String message = "Elige una opción";
    static Libro libro;
    static void main() {
        System.out.print("Introduce el título del libro ");
        String title = Utils.sc.nextLine();
        System.out.print("\nDime el autor del libro: ");
        String autor = Utils.sc.nextLine();

        System.out.print("\nIntroduce el ISBN del libro: ");
        String isbn = Utils.sc.nextLine();

        libro  = new Libro(title, autor, isbn);

        menu();
    }

    private static void menu()
    {
        int opcion;

        do {
            System.out.println("--Menú--");
            System.out.println("Ver información del libro");
            System.out.println("Modificar título");
            System.out.println("Modificar autor");
            System.out.println("Modificar ISBN");
            System.out.println("Salida");

            opcion = Utils.validaInt(message);
            Utils.sc.nextLine();

            switch (opcion)
            {
                case 1:
                    System.out.println("\n" + libro);
                    break;

                case 2:
                    System.out.print("Nuevo título: ");
                    libro.setTitulo(Utils.sc.nextLine());
                    break;

                case 3:
                    System.out.print("Nuevo autor: ");
                    libro.setAutor(Utils.sc.nextLine());
                    break;

                case 4:
                    System.out.println("Nuevo ISBN: ");
                    libro.setIsbn(Utils.sc.nextLine());
                    break;

                case 5:
                    System.out.println("Hasta otra...");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }while (opcion!=5);
    }
}