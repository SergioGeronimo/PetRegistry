package dao;

import dao.models.Animal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public interface AnimalDao {
    static Session getSession(){
        Configuration configuration = new  Configuration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
        return sessionFactory.openSession();
    }

    static int save(Animal animalToSave) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        int generatedId = (int) session.save(animalToSave);
        transaction.commit();
        session.close();
        return generatedId;
    }

    static Animal getById(int id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Animal animal = session.get(Animal.class, id);
        transaction.commit();
        session.close();
        return animal;
    }

    static int update(Animal animalToUpdate) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(String.valueOf(animalToUpdate.getId()), animalToUpdate);
        transaction.commit();
        session.close();
        return animalToUpdate.getId();
    }

    static void delete(Animal animalToDelete){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(animalToDelete);
        transaction.commit();
        session.close();
    }
}
