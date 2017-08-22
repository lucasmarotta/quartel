package br.ufba.dcc.quartel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.dcc.quartel.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>
{
	Reserva findBySigla(String sigla);

	Reserva findById(Integer id);
}
