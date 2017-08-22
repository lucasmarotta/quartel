package br.ufba.dcc.quartel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufba.dcc.quartel.models.Reserva;
import br.ufba.dcc.quartel.repositories.ReservaRepository;

@Service
public class ReservaService 
{
	@Autowired
	private ReservaRepository reservaRepo;
	
	public Reserva findBySigla(String sigla)
	{
		return reservaRepo.findBySigla(sigla);
	}
	
	public Reserva findById(Integer id)
	{
		return reservaRepo.findById(id);
	}
	
	public List<Reserva> findAll()
	{
		return reservaRepo.findAll();
	}
	
	public boolean reservaExists(String sigla)
	{
		return (reservaRepo.findBySigla(sigla) != null) ? true:false;
	}
	
	public boolean reservaExists(Integer id)
	{
		return (reservaRepo.findById(id) != null) ? true:false;
	}
	
	public void save(Reserva reserva)
	{
		reservaRepo.save(reserva);
	}
}
