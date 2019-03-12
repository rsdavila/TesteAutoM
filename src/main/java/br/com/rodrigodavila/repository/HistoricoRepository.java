package br.com.rodrigodavila.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigodavila.entity.Historico;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Integer> {

	public Optional<Historico> findById(Integer id);

	public List<Historico> findByValor(String valor);

}
