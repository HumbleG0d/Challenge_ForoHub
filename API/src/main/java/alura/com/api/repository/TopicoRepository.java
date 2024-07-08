package alura.com.api.repository;
import alura.com.api.domain.topico.Topico;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
  @Query("SELECT t FROM Topico t")
  Page<Topico> getTopicos(Pageable pageable);

  @Modifying
  @Transactional
  @Query("DELETE FROM Topico t WHERE t.id = :id")
  void deleteTopicoByid(Long id);
}
