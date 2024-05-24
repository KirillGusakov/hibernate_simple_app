package org.example;

import org.example.entity.Director;
import org.example.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Movie.class)
                                                         .addAnnotatedClass(Director.class);


        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session currentSession = sessionFactory.getCurrentSession();

            currentSession.beginTransaction();

           /* //Task 2
            Director director = currentSession.get(Director.class, 1);
            List<Movie> movieList = director.getMovieList();

            System.out.println(movieList);*/

            /*//Task 3
            Movie movie = currentSession.get(Movie.class, 5);
            Director director = movie.getDirector();
            System.out.println(director);*/

            /*//Task 4
            Director director = currentSession.get(Director.class, 1);
            Movie movie = new Movie("My film", 2024, director);

            director.getMovieList().add(movie); //является best pract
            currentSession.merge(movie); // вставить или обновит*/

            /* //не обновится если нету cascade
            director.getMovieList().add(movie);
            currentSession.merge(director);*/

            // task 5
           /* Movie movie = new Movie("Good film", 2012);
            Director director = new Director("Oleg", 20, new ArrayList<>(List.of(movie)));
            //currentSession.persist(director); // если сделать так, то вставится только директор опять же нет cascade

            movie.setDirector(director);
            currentSession.persist(director);
            currentSession.persist(movie);*/

            // task 6
            /*Movie movie = currentSession.get(Movie.class, 1);
            Director director = currentSession.get(Director.class, 6);

            movie.getDirector().getMovieList().remove(movie);
            movie.setDirector(director);                //best pract
            director.getMovieList().add(movie);

            currentSession.merge(movie);*/

            //task 7
            Movie movie = currentSession.get(Movie.class, 1);
            Director director = currentSession.get(Director.class, 6);
            director.getMovieList().remove(movie);
            currentSession.remove(movie);

            currentSession.getTransaction().commit();

        }
    }
}
