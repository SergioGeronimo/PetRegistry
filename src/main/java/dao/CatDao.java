package dao;

import dao.models.Animal;
import dao.models.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public interface CatDao {
    static Session getSession(){
        Configuration configuration = new  Configuration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
        return sessionFactory.openSession();
    }

    static int save(Cat catToSave) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        int generatedId = (int) session.save(catToSave);
        transaction.commit();
        session.close();
        return generatedId;
    }

    static Cat getById(int id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Cat cat = session.get(Cat.class, id);
        transaction.commit();
        session.close();
        return cat;
    }

    static int update(Cat catToUpdate) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(String.valueOf(catToUpdate.getId()), catToUpdate);
        transaction.commit();
        session.close();
        return catToUpdate.getId();
    }

    static void delete(Cat catToDelete){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(catToDelete);
        transaction.commit();
        session.close();
    }
}
