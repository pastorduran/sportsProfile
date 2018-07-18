package repositories;

import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

import entities.Client;

public interface ClientRepository {
	
    CompletionStage<Stream<Client>> list();
    
    CompletionStage<Stream<Client>> findAll(final Optional<String> nombre, final Optional<String> apellido
			, final Optional<String> telefono, final Optional<String> email);

    CompletionStage<Client> create(Client client);

    CompletionStage<Optional<Client>> get(Integer id);

    CompletionStage<Optional<Client>> update(Client client);

}
