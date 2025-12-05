import java.util.Scanner;
import java.util.ArrayList;

public class Principal
{
    static Libro libro;
    static Libro[] biblioteca;
    static int nLibros = 0;
    static final int KMaxBiblio = 10;
    static void main()
    {

        biblioteca = new Libro[KMaxBiblio];
        menu();

    }

    private static void menu()
    {
        int opcion;

        do {

            System.out.println("1. Añadir libro");
            System.out.println("2. Visualizar");
            System.out.println("3. Cambiar título");
            System.out.println("4. Cambiar Autor");
            System.out.println("5. Cambiar ISBN");
            System.out.println("Saliendo...");

            opcion = Utils.validaInt();
            Utils.sc.nextLine();

            switch (opcion)
            {
                case 1:
                    NuevoLibro();
                    break;

                case 2:
                    Visualiza();
                    break;

                case 3:
                    CambiaTitulo();
                    break;

                case 4:
                    CambiaAutor();
                    break;

                case 5:
                    CambiaIsbn();
                    break;

                default:
                    System.err.println("OPCIÓN NO VÁLIDA");
                    break;

            }
        }while (opcion!=6);

    }

    private static void NuevoLibro()
    {
        if (nLibros < biblioteca.length)
        {
            System.out.println("Introduce el título del libro: ");
            String titulo = Utils.sc.nextLine();

            System.out.println("Introduce el nombre del autor: ");
            String autor =Utils.sc.nextLine();

            System.out.println("Introduce el ISBN: ");
            String isbn = Utils.sc.nextLine();

            biblioteca[nLibros] = new Libro(titulo, autor, isbn);

            nLibros++;
        }
    }

    private static void Visualiza()
    {
        for (int i = 0; i < nLibros; i++)
        {
            System.out.println(biblioteca[i]);
        }
    }

    private static void CambiaTitulo()
    {
        System.out.print("Dime el nuevo título para el libro: ");
        String tituloNuevo = Utils.sc.nextLine();

        System.out.print("Dime en qué posición está en la biblioteca: ");
        int posicion = Utils.validaInt();

        if (posicion>=0 && posicion<nLibros)
        {
            biblioteca[posicion].setTitulo(tituloNuevo);
        }

        else System.out.println("No hay libros registrados en esa posición");
    }

    private static void CambiaAutor()
    {
        System.out.print("Dime quién es el nuevo autor del libro: ");
        String autorNuevo = Utils.sc.nextLine();

        System.out.print("Dime en qué posición está en la biblioteca: ");
        int posicion = Utils.validaInt();

        if (posicion>=0 && posicion<nLibros) biblioteca[posicion].setAutor(autorNuevo);

        else System.out.println("No hay autor registrado en esa posición");
    }

    private static void CambiaIsbn()
    {
        System.out.print("Dime en qué posición está en la biblioteca");
        int posicion = Utils.validaInt();

        Utils.sc.nextLine();

        System.out.print("Dime el nuevo ISBN del libro: ");
        String newIsbn = Utils.sc.nextLine();


        if (posicion>=0 && posicion<nLibros) biblioteca[posicion].setIsbn(newIsbn);
    }

}
