package br.com.heitorflorido.interview.gateway.database;

import br.com.heitorflorido.interview.gateway.EditarUsuarioGateway;
import br.com.heitorflorido.interview.gateway.database.repository.UsuarioRepository;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class EditarUsuarioDatabaseGateway implements EditarUsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Mono<Object> execute(Usuario req, Long id) {
        return (usuarioRepository.findById(id)
        .map(usuario -> {
            Usuario.builder()
            .nome(req.getNome())
            .cidade(req.getCidade())
            .uf(req.getUf())
            .dataNascimento(req.getDataNascimento())
            .cep(req.getCep())
            .build();
            return usuarioRepository.save(usuario);
        }));
    }
}
