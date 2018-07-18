package controllers;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import javax.inject.Inject;
import models.Cliente;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import repositories.ClienteHandler;

public class ClientController extends Controller {

	private HttpExecutionContext ec;
	private ClienteHandler handler;

	@Inject
    public ClientController(HttpExecutionContext ec, ClienteHandler handler) {
        this.ec = ec;
        this.handler = handler;
    }

	public CompletionStage<Result> findAll(final Optional<String> nombre, final Optional<String> apellido
			, final Optional<String> telefono, final Optional<String> email) {
		return handler.findAll(nombre, apellido, telefono, email).thenApplyAsync(clients -> {
			final List<Cliente> clientes = clients.collect(Collectors.toList());
			return ok(Json.toJson(clientes));
		}, ec.current());
	}

	public CompletionStage<Result> findById(Integer id) {
		return handler.lookup(id).thenApplyAsync(optionalResource -> {
			return optionalResource.map(resource -> ok(Json.toJson(resource))).orElseGet(() -> notFound());
		}, ec.current());
	}

	public CompletionStage<Result> update() {
		JsonNode json = request().body().asJson();
		Cliente resource = Json.fromJson(json, Cliente.class);
		return handler.update(resource).thenApplyAsync(optionalResource -> {
			return optionalResource.map(r -> ok(Json.toJson(r))).orElseGet(() -> notFound());
		}, ec.current());
	}

	public CompletionStage<Result> create() {
		JsonNode json = request().body().asJson();
		final Cliente resource = Json.fromJson(json, Cliente.class);
		return handler.create(resource).thenApplyAsync(savedResource -> {
			return created(Json.toJson(savedResource));
		}, ec.current());
	}

}
