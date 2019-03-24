package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.model.Profesores;

public class TestProfesoresDAOImpl implements TestProfesoresDAO {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public List<Profesores> listProfesores() {
		List<Profesores> profesores = null;
		try {
			Session session = this.sessionFactory.openSession();
			profesores = session.createQuery("FROM hibernate.model.Profesores").list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profesores;
	}

	@Override
	public boolean addProfesor(Profesores profesor) {
		boolean result;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(profesor);
			tx.commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			session.close();
		}
		return result;
	}

}
