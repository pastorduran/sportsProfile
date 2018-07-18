package repositories;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;



import play.db.jpa.JPAApi;

public abstract class AbstractFacade<T> {
	
	@Inject private JPAApi jpaApi; 
    
    private Class<T> entityClass;    
    
    public AbstractFacade(JPAApi api, Class<T> entityClass) {
        this.jpaApi = api;
        this.entityClass = entityClass;
    }
    
    @SuppressWarnings("hiding")
	public <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    public Optional<T> lookup(EntityManager em, Integer id) {
        return Optional.ofNullable(em.find(entityClass, id));
    }
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Stream<T> select(EntityManager em) {
    	CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));        
        return em.createQuery(cq).getResultList().stream();
    }

    public Optional<T> modify(EntityManager em, T entityClass) {            
        return Optional.ofNullable(em.merge(entityClass));
    }
    
    public T insert(EntityManager em, T entityClass) {
         em.persist(entityClass);
         return entityClass;
    }

	public JPAApi getJpaApi() {
		return jpaApi;
	}

}
