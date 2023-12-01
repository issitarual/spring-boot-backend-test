package br.com.heitorflorido.interview.gateway;

import br.com.heitorflorido.interview.model.Usuario;
import reactor.core.publisher.Mono;

public interface EditarUsuarioGateway {
    Mono<Object> execute(Usuario req, Long id);
}
