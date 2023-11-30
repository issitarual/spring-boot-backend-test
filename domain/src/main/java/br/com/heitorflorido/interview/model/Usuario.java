package br.com.heitorflorido.interview.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Usuario {

    Long id;
    String nome;
    String cidade;
    String uf;
    String cep;
    LocalDate dataNascimento;
}
