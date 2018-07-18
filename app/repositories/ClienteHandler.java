package repositories;

import models.Cliente;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;
import javax.inject.Inject;
import entities.Client;
import play.libs.concurrent.HttpExecutionContext;

public class ClienteHandler {
	
	private final ClientRepository repository;
    private final HttpExecutionContext ec;

    @Inject
    public ClienteHandler(ClientRepository repository, HttpExecutionContext ec) {
        this.repository = repository;
        this.ec = ec;
    }

    public CompletionStage<Stream<Cliente>> find() {
        return repository.list().thenApplyAsync(clienteDataStream -> {
            return clienteDataStream.map(data -> new Cliente(data));
        }, ec.current());
    }
    
    public CompletionStage<Stream<Cliente>> findAll(final Optional<String> nombre, final Optional<String> apellido,
    		final Optional<String> telefono, final Optional<String> email) {
        return repository.findAll(nombre, apellido, telefono, email).thenApplyAsync(clienteDataStream -> {
            return clienteDataStream.map(data -> new Cliente(data));
        }, ec.current());
    }

    public CompletionStage<Cliente> create(Cliente resource) {
        final Client data = new Client(resource);
        return repository.create(data).thenApplyAsync(savedData -> {
            return new Cliente(savedData);
        }, ec.current());
    }

    public CompletionStage<Optional<Cliente>> lookup(Integer id) {
        return repository.get(id).thenApplyAsync(optionalData -> {
            return optionalData.map(data -> new Cliente(data));
        }, ec.current());
    }

    public CompletionStage<Optional<Cliente>> update(Cliente resource) {
        final Client data = new Client(resource);
        return repository.update(data).thenApplyAsync(optionalData -> {
            return optionalData.map(op -> new Cliente(op));
        }, ec.current());
    }

}
