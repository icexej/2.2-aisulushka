
class LibraryBook {
    private String title;
    private String author;
    private String isbn;
    private int pages;
    private boolean isAvailable;


    // 2. Конструктор по умолчанию
    public LibraryBook() {
        this.title = "Untitled";
        this.author = "Unknown Author";
        this.isbn = "000-0-00-000000-0";
        this.pages = 100;
        this.isAvailable = true;
    }

    // Параметризированный конструктор
    public LibraryBook(String title, String author, String isbn, int pages, boolean isAvailable) {
        setTitle(title);
        setAuthor(author);
        setIsbn(isbn);
        setPages(pages);
        this.isAvailable = isAvailable;
    }

    // 3. Геттеры и сеттеры с валидацией
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
            this.pages = 100; // значение по умолчанию при некорректном вводe
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // 4. Методы класса
    public void displayInfo() {
        System.out.println("Book: " + title + " | Author: " + author +
                " | ISBN: " + isbn + " | Pages: " + pages +
                " | Available: " + (isAvailable ? "Yes" : "No"));
    }

    // Дополнительный метод 1: взять книгу
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("-> Book '" + title + "' has been successfully borrowed.");
        } else {
            System.out.println("-> Sorry, '" + title + "' is currently not available.");
        }
    }

    // Дополнительный метод 2: вернуть книгу
    public void returnBook() {
        isAvailable = true;
        System.out.println("-> Book '" + title + "' has been returned to the library.");
    }
}


public class Main {
    public static void main(String[] args) {
        // Создаем объекты (минимум 4: 1 по умолчанию, 3 параметризированных)
        LibraryBook book1 = new LibraryBook(); // Конструктор по умолчанию
        LibraryBook book2 = new LibraryBook("Clean Code", "Robert C. Martin", "978-0132350884", 464, true);
        LibraryBook book3 = new LibraryBook("The Pragmatic Programmer", "Andrew Hunt", "978-0201616224", 352, true);
        LibraryBook book4 = new LibraryBook("Java: The Complete Reference", "Herbert Schildt", "978-1260440232", 1248, false);

        System.out.println("=== INITIAL BOOK LIST ===");
        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();
        book4.displayInfo();

        // Доступ к атрибутам через геттеры
        System.out.println("\n[Testing Getters] Checking author of book2: " + book2.getAuthor());

        // Модификация атрибутов через сеттеры (с проверкой валидации)
        System.out.println("\n[Testing Setters] Updating book1 details...");
        book1.setTitle("Effective Java");
        book1.setAuthor("Joshua Bloch");
        book1.setPages(-50); // Проверка валидации (страницы не изменятся на отрицательное число)
        book1.setPages(412); // Корректное значение
        book1.displayInfo();

        // Вызов дополнительных методов
        System.out.println("\n[Testing Methods]");
        book2.borrowBook(); // Должна выдать
        book2.borrowBook(); // Попытка взять уже выданную
        book4.returnBook(); // Возврат книги

        // Вывод обновленной информации
        System.out.println("\n=== UPDATED BOOK LIST ===");
        book2.displayInfo();
        book4.displayInfo();
    }
}