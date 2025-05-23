package br.com.primeshoes.api.dtos;

import java.time.Instant;

import br.com.primeshoes.api.enuns.Role;

public record UserResponseDTO(
	long id,
	String name,
	String email,
	Role role,
	Instant created_at,
	Instant updated_at) {

}
