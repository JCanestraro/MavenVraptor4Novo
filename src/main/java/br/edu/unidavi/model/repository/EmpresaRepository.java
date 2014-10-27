package br.edu.unidavi.model.repository;

import br.edu.unidavi.model.entity.Empresa;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@RequestScoped
public class EmpresaRepository {

	@Inject
	private Session session;
	@Inject
	private SessionFactory factory;

	private Criteria createCriteria() {
    	return session.createCriteria(Empresa.class);
	}

	@SuppressWarnings("unchecked")
	public List<Empresa> list() {
    	return createCriteria().list();
	}

	public void gravar(Empresa e) {
    	session.persist(e);
	}

	public Empresa findById(Long id) {
    	return (Empresa) session.get(Empresa.class, id);
	}

	public void deletar(Empresa e) {
//    	Session ss = factory.openSession();
//    	Transaction t = ss.beginTransaction();
//
//    	t.begin();
//    	session.delete(e);
//    	t.commit();

    	AnnotationConfiguration configuration = new AnnotationConfiguration();
    	configuration.configure();

    	SessionFactory factory = configuration.buildSessionFactory();
    	Session session = factory.openSession();


    	Transaction tx = session.beginTransaction();
    	session.delete(e);
    	tx.commit();
	}

}