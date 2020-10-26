package task.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import task.dao.LecturerDao;
import task.model.Lecturer;

@Repository
public class LecturerDaoImpl implements LecturerDao {
    private final SessionFactory sessionFactory;

    public LecturerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Lecturer lecturer) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(lecturer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't add new lecturer " + lecturer, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Lecturer> getByTemplate(String template) {
        try (Session session = sessionFactory.openSession()) {
            Query<Lecturer> query = session.createQuery("from Lecturer "
                    + "where name like :template", Lecturer.class);
            query.setParameter("template", "%" + template + "%");
            return query.getResultList();
        }
    }

    @Override
    public List<Lecturer> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Lecturer> query = session.createQuery("from Lecturer ", Lecturer.class);
            return query.getResultList();
        }
    }
}
