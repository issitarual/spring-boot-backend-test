package br.com.heitorflorido.interview.usecase;


import br.com.heitorflorido.interview.gateway.DeletarUsuarioGateway;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class DeletarUsuarioUseCase {

    private final DeletarUsuarioGateway deletarUsuarioGateway;

    public void execute(Long id) {
        deletarUsuarioGateway.execute(id);
    }
}
