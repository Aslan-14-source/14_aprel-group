package accessModifiers.other;

import accessModifiers.Book;

public class MainClass {
    public static void main(String[] args) {
        Book book = new Book();
                book.title = "Java";

                System.out.println(book.title);
            }
        }