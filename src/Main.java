class LibraryBook {
    private String title;
    private String author;
    private String isbn;
    private int pages;
    private boolean isAvailable;


    public LibraryBook() {
        this.title = "Untitled";
        this.author = "Unknown Author";
        this.isbn = "000-0-00-000000-0";
        this.pages = 100;
        this.isAvailable = true;
    }


    public LibraryBook(String title, String author, String isbn, int pages, boolean isAvailable) {
        setTitle(title);
        setAuthor(author);
        setIsbn(isbn);
        setPages(pages);
        this.isAvailable = isAvailable;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            this.title = "Untitled";
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) {
            this.author = author;
        } else {
            this.author = "Unknown Author";
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if (pages > 0) {
            this.pages = pages;
        } else {
            this.pages = 100;
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    public void displayInfo() {
        System.out.println("Book: " + title + " | Author: " + author +
                " | ISBN: " + isbn + " | Pages: " + pages +
                " | Available: " + (isAvailable ? "Yes" : "No"));
    }


    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("-> Book '" + title + "' has been successfully borrowed.");
        } else {
            System.out.println("-> Sorry, '" + title + "' is currently not available.");
        }
    }


    public void returnBook() {
        isAvailable = true;
        System.out.println("-> Book '" + title + "' has been returned to the library.");
    }
}

public class Main {
    public static void main(String[] args) {

        LibraryBook book1 = new LibraryBook();
        LibraryBook book2 = new LibraryBook("Master and Margarita", "Mikhail Bulgakov", "978-5-699-12345-1", 480, true);
        LibraryBook book3 = new LibraryBook("Crime and Punishment", "Fyodor Dostoevsky", "978-5-17-098765-2", 672, true);
        LibraryBook book4 = new LibraryBook("Eugene Onegin", "Alexander Pushkin", "978-5-04-111111-3", 224, false);

        System.out.println("=== INITIAL BOOK LIST ===");
        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();
        book4.displayInfo();


        System.out.println("\n[Testing Getters] Author of book2: " + book2.getAuthor());


        System.out.println("\n[Testing Setters] Updating book1 details...");
        book1.setTitle("War and Peace");
        book1.setAuthor("Leo Tolstoy");
        book1.setPages(-150);
        book1.setPages(1225);
        book1.displayInfo();


        System.out.println("\n[Testing Methods]");
        book2.borrowBook();
        book4.returnBook();


        System.out.println("\n=== UPDATED BOOK LIST ===");
        book2.displayInfo();
        book4.displayInfo();


        System.out.println(book2.getTitle());
        System.out.println(book2.getIsbn());
        System.out.println(book3.getPages());
        System.out.println(book4.isAvailable());
        book4.setAvailable(true);
    }
}


