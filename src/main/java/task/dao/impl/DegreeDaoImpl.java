package task.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import task.dao.DegreeDao;
import task.model.Degree;

@Repository
public class DegreeDaoImpl implements DegreeDao {
    private final SessionFactory sessionFactory;

    public DegreeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Degree degree) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(degree);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't add new degree " + degree, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Degree> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Degree> query = session.createQuery("from Degree ", Degree.class);
            return query.getResultList();
        }
    }
}
