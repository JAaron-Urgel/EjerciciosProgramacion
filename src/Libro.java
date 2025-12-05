import java.time.LocalDate;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private int anyoPublicacion;

    public Libro(String titulo, String autor, String isbn) {
        setTitulo(titulo);
        setAutor(autor);
        setIsbn(isbn);
        this.anyoPublicacion = LocalDate.now().getYear();
    }

    public Libro(String titulo, String autor, String isbn, int anyoPublicacion) {
        setTitulo(titulo);
        setAutor(autor);
        setIsbn(isbn);
        setAnyoPublicacion(anyoPublicacion);
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnyoPublicacion() {
        return anyoPublicacion;
    }

    public void setAnyoPublicacion(int anyoPublicacion) {
        if (anyoPublicacion> LocalDate.now().getYear()) System.err.println("ERROR AÑO DE PUBLICACIÓN NO VÁLIDO");

        else this.anyoPublicacion = anyoPublicacion;
    }

    public void setTitulo(String titulo) {
        if (titulo.isBlank()) {
            System.out.println("El título del libro está vacío");
            this.titulo = "";
        } else {
            this.titulo = titulo;
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor.isBlank()) {
            System.out.println("El autor del libro está vacío");
            this.autor = "";
        } else {
            this.autor = autor;
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn.length() == 10 && compruebaIsbn10(isbn) ||
                isbn.length() == 13 && compruebaIsbn13(isbn)) {
            this.isbn = isbn;
        } else {
            System.err.println("ISBN no válido");
            this.isbn = "";
        }
    }

    public boolean compruebaIsbn10(String isbn) {
        int suma = 0;
        for (int i = 0; i < isbn.length(); i++) {
            // Para cuando el número final sea una X
            if (i == isbn.length()-1 && isbn.charAt(isbn.length()-1) == 'X') {
                suma += 10 * (i+1);
            } else {
                suma += Character.getNumericValue(isbn.charAt(i)) * (i+1);
            }
        }
        return suma % 11 == 0;
    }

    public boolean compruebaIsbn13(String isbn) {
        int suma = 0;
        for (int i = 0; i < isbn.length()-1; i++) {
            // Si es par
            if ((i+1) % 2 == 0) {
                suma += Character.getNumericValue(isbn.charAt(i)) * 3;
                // Si es impar
            } else {
                suma += Character.getNumericValue(isbn.charAt(i));
            }
        }
        int digitoControl = Character.getNumericValue(isbn.charAt(isbn.length()-1));
        int resultado = 10 - (suma % 10);
        return resultado == digitoControl;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}