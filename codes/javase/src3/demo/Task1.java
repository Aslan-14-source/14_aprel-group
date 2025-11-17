package demo;

public class Task1 {

    public static void main(String[] args) {

        // 1-ci
        Book book1 = new Book();
        book1.id = 1;
        book1.name = "Java Basics";
        book1.author = "Author A";
        book1.pageCount = 250;
        book1.description = "Beginner Java guide";

        // 2-ci
        Book book2 = new Book();
        book2.id = 2;
        book2.name = "OOP Concepts";
        book2.author = "Author B";
        book2.pageCount = 320;
        book2.description = "Advanced OOP book";

        System.out.println("Book 1:");
        System.out.println(book1.id);
        System.out.println(book1.name);
        System.out.println(book1.author);
        System.out.println(book1.pageCount);
        System.out.println(book1.description);

        System.out.println("\nBook 2:");
        System.out.println(book2.id);
        System.out.println(book2.name);
        System.out.println(book2.author);
        System.out.println(book2.pageCount);
        System.out.println(book2.description);
    }
}

class Book {
    int id;
    String name;
    String author;
    int pageCount;
    String description;
}
