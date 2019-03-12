package br.com.rodrigodavila.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.rodrigodavila.entity.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

	public List<Cadastro> findByNomeContains(String nome);

	public Optional<Cadastro> findById(Integer id);

	@Query(value = "SELECT C.NOME, H.VALOR FROM CADASTRO AS C LEFT JOIN HISTORICO AS H ON C.ID = H.ID_CADASTRO WHERE C.ID = :id", nativeQuery = true)
	public List<Object[]> findByJoin(@Param("id") Integer id);

}
