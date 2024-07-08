package alura.com.api.services;

import alura.com.api.domain.curso.Curso;
import alura.com.api.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
  @Autowired
  private CursoRepository cursoRepository;

  public Curso save(Curso curso){
    return cursoRepository.save(curso);
  }
}
