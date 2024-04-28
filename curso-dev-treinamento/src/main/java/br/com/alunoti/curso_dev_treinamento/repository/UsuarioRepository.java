package br.com.alunoti.curso_dev_treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alunoti.curso_dev_treinamento.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

}
