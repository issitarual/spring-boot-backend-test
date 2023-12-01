package br.com.heitorflorido.interview.usecase;


import br.com.heitorflorido.interview.gateway.EditarUsuarioGateway;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class EditarUsuarioUseCase {

    private final EditarUsuarioGateway editarUsuarioGateway;

    public Mono<Object> execute(Usuario req, Long id) {
        return editarUsuarioGateway.execute(req, id);
    }
}
