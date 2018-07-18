package impl;

import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import entities.Client;
import play.db.jpa.JPAApi;
import repositories.AbstractFacade;
import repositories.ClientExecutionContext;
import repositories.ClientRepository;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@Singleton
public class JPAClientRepository extends AbstractFacade<Client> implements ClientRepository {

	private final ClientExecutionContext ec;

	@Inject
	public JPAClientRepository(JPAApi api, ClientExecutionContext ec) {
		super(api, Client.class);
		this.ec = ec;
	}

	@Override
	public CompletionStage<Stream<Client>> list() {
		return supplyAsync(() -> wrap(em -> select(em)), ec);
	}

	@Override
	public CompletionStage<Client> create(Client client) {
		return supplyAsync(() -> wrap(em -> insert(em, client)), ec);
	}

	@Override
	public CompletionStage<Optional<Client>> get(Integer id) {
		return supplyAsync(() -> wrap(em -> lookup(em, id)), ec);
	}

	@Override
	public CompletionStage<Optional<Client>> update(Client client) {
		return supplyAsync(() -> wrap(em -> modify(em, client)), ec);
	}

	@Override
	public CompletionStage<Stream<Client>> findAll(final Optional<String> nombre, final Optional<String> apellido,
			final Optional<String> telefono, final Optional<String> email) {
		return supplyAsync(() -> wrap(em -> filter(em,nombre,apellido,telefono,email)), ec);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Stream<Client> filter(EntityManager em, final Optional<String> nombre, final Optional<String> apellido,
			final Optional<String> telefono, final Optional<String> email) {
		Session session = em.unwrap(Session.class);    	
        if(nombre.isPresent()) {
        	session.enableFilter("filterName").setParameter("clientName","%"+ nombre.get().toLowerCase()+"%");
        }
        if(apellido.isPresent()) {
        	session.enableFilter("filterLastName").setParameter("clientLastName","%"+ apellido.get().toLowerCase()+"%");
        }
        if(telefono.isPresent()) {
        	session.enableFilter("filterPhone").setParameter("clientPhone","%"+ telefono.get().toLowerCase()+"%");
        }
        if(email.isPresent()) {
        	session.enableFilter("filterEmail").setParameter("clientEmail","%"+ email.get().toLowerCase()+"%");
        }
        return session.createQuery("from Client").getResultList().stream();
        
    }
}
