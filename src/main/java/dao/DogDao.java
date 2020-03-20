package dao;

import dao.models.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public interface DogDao {
    static Session getSession(){
        Configuration configuration = new  Configuration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
        return sessionFactory.openSession();
    }

    static int save(Dog dogToSave) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        int generatedId = (int) session.save(dogToSave);
        transaction.commit();
        session.close();
        return generatedId;
    }

    static Dog getById(int id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Dog dog = session.get(Dog.class, id);
        transaction.commit();
        session.close();
        return dog;
    }

    static int update(Dog dogToUpdate) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(String.valueOf(dogToUpdate.getId()), dogToUpdate);
        transaction.commit();
        session.close();
        return dogToUpdate.getId();
    }

    static void delete(Dog dogToDelete){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(dogToDelete);
        transaction.commit();
        session.close();
    }
}
