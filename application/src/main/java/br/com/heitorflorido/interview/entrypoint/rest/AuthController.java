package br.com.heitorflorido.interview.entrypoint.rest;

import br.com.heitorflorido.interview.model.Usuario;
import br.com.heitorflorido.interview.usecase.CriarUsuarioUseCase;
import br.com.heitorflorido.interview.usecase.ObterUsuarioUseCase;
import br.com.heitorflorido.interview.usecase.ObterUsuariosUseCase;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.http.HttpStatus;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController {

    private final ObterUsuarioUseCase obterUsuarioUseCase;
    private final ObterUsuariosUseCase obterUsuariosUseCase;
    private final CriarUsuarioUseCase criarUsuarioUseCase;

    @GetMapping("/usuario/{id}")
    public Mono<Usuario> validar(final @PathVariable Long id) {
        return obterUsuarioUseCase.execute(id);
    }

    @PostMapping("/usuario")
    public Mono<Usuario> create(@RequestBody Usuario req) {
        return criarUsuarioUseCase.execute(req);
    }

    @GetMapping("/usuario")
    public Flux<Usuario> all() {
        return obterUsuariosUseCase.execute();
    }
/*
     @PutMapping("/usuario/{id}")
     Mono<Usuario> validar(@RequestBody Usuario newUsuario, @PathVariable Long id) {

        return service.execute(id)
        .map(usuario -> {
            usuario.setNome(newUsuario.getNome());
            usuario.setCidade(newUsuario.getCidade());
            usuario.setUf(newUsuario.getUf());
            usuario.setDataNascimento(newUsuario.getDataNascimento());
            usuario.setCep(newUsuario.getCep());
            return service.save(usuario);
        })
        .orElseGet(() -> {
            newUsuario.setId(id);
            return service.save(newUsuario);
        });
        return obterUsuarioUseCase.execute(id);
    }*/
    /* 
    @DeleteMapping("/usuario/{id}")
    void deleteUsuario(@PathVariable Long id) {
        service.deleteById(id);
    }*/
}
