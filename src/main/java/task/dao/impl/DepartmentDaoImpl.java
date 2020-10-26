package task.dao.impl;

import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import task.dao.DepartmentDao;
import task.model.Degree;
import task.model.Department;
import task.model.Lecturer;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    private final SessionFactory sessionFactory;

    public DepartmentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Department department) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't add new department " + department, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Lecturer getDepartmentHead(String departmentName) {
        return null;
    }

    @Override
    public Map<Degree, Integer> getDepartmentStatistics(String departmentName) {
        return null;
    }

    @Override
    public Double averageSalary(String departmentName) {
        return null;
    }

    @Override
    public List<Department> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Department> query = session.createQuery("from Department", Department.class);
            return query.getResultList();
        }
    }
}
