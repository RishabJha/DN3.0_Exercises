import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book("1", "To Kill a Mockingbird", "Harper Lee"));
        list.add(new Book("2", "1984", "George Orwell"));
        list.add(new Book("3", "The Great Gatsby", "F. Scott Fitzgerald"));
        list.add(new Book("4", "Moby Dick", "Herman Melville"));
        list.add(new Book("5", "Pride and Prejudice", "Jane Austen"));
        list.add(new Book("6", "The Catcher in the Rye", "J.D. Salinger"));
        list.add(new Book("7", "The Hobbit", "J.R.R. Tolkien"));
        list.add(new Book("8", "Brave New World", "Aldous Huxley"));
        list.add(new Book("9", "The Lord of the Rings", "J.R.R. Tolkien"));
        list.add(new Book("10", "Fahrenheit 451", "Ray Bradbury"));

        System.out.println(LinearSearch.linearSearchByTitle(list, "1984"));

        list.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
        System.out.println(BinarySearch.binarySearchByTitle(list, "Fahrenheit 451"));
    }
}
