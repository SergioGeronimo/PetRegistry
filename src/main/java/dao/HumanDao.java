package dao;

import dao.models.Human;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public interface HumanDao {
    static Session getSession(){
        Configuration configuration = new  Configuration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
        return sessionFactory.openSession();
    }

    static int save(Human humanToSave) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        int generatedId = (int) session.save(humanToSave);
        transaction.commit();
        session.close();
        return generatedId;
    }

    static Human getById(int id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Human human = session.get(Human.class, id);
        transaction.commit();
        session.close();
        return human;
    }

    static int update(Human humanToUpdate) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(String.valueOf(humanToUpdate.getId()), humanToUpdate);
        transaction.commit();
        session.close();
        return humanToUpdate.getId();
    }

    static void delete(Human humanToDelete){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(humanToDelete);
        transaction.commit();
        session.close();
    }
}
