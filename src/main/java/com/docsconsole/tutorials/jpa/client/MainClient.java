package com.docsconsole.tutorials.jpa.client;

import com.docsconsole.tutorials.jpa.entity.Author;
import com.docsconsole.tutorials.jpa.entity.Book;
import com.docsconsole.tutorials.jpa.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MainClient {


    public static void main(String[] args) {
        System.out.println("Main method@MainClient");

        try {
            EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            Author author1 = new Author();
            author1.setAuthorName("Author1");

            Book book1 = new Book("Book1", 100.0, author1);
            Book book2 = new Book("Book2", 200.0, author1);
            Book book3 = new Book("Book3", 300.0, author1);

            entityManager.persist(author1);
            entityManager.persist(book1);
            entityManager.persist(book2);
            entityManager.persist(book3);
            transaction.commit();


            /*Book book = entityManager.find(Book.class,1L);
            System.out.println(book.getAuthor().getAuthorName());*/
            System.out.println("Session is closed");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
