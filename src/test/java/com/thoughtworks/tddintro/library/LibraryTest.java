package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verifyZeroInteractions;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */
    public PrintStream printStream;
    DateTimeFormatter dateTimeFormatter;
    List<String> books;
    DateTime time;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
        books = new ArrayList<String>();
        time = new DateTime();
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        String title = "Book Title";
        books.add(title);
        Library library = new Library(books, printStream, dateTimeFormatter);

        library.listBooks();
        verify(printStream).println("Book Title" );
     }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        Library library = new Library(books, printStream, dateTimeFormatter);
        library.listBooks();
        verifyZeroInteractions(printStream);
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        books.add("1");
        books.add("2");
        Library library = new Library(books, printStream, dateTimeFormatter);

        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("1", "2");
        library.listBooks();
        verify(printStream).println(reader.readLine());
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */


    @Test
    public void shouldWelcomeUser() {

        Library library = new Library(books, printStream, dateTimeFormatter);
        library.welcome(time);
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
        when(dateTimeFormatter.print(time)).thenReturn("");
        Library library = new Library(books, printStream, dateTimeFormatter);
        library.welcome(time);
        verify(printStream).println("Welcome to the library! The current time is " );
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {
        when(dateTimeFormatter.print(time)).thenReturn("1:01 PM");
        Library library = new Library(books, printStream, dateTimeFormatter);
        library.welcome(time);
        verify(printStream).println(contains("Welcome to the library! The current time is 1:01 PM"));
    }
}