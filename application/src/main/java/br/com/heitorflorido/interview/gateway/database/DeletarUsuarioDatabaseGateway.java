package br.com.heitorflorido.interview.gateway.database;

import br.com.heitorflorido.interview.gateway.DeletarUsuarioGateway;
import br.com.heitorflorido.interview.gateway.database.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class DeletarUsuarioDatabaseGateway implements DeletarUsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    @Override
    public void execute(Long id) {
        usuarioRepository.deleteById(id);
    }
}
