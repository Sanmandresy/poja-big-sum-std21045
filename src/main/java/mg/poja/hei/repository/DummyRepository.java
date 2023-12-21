package mg.poja.hei.repository;

import java.util.List;
import mg.poja.hei.PojaGenerated;
import mg.poja.hei.repository.model.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@PojaGenerated
@Repository
public interface DummyRepository extends JpaRepository<Dummy, String> {

  @Override
  List<Dummy> findAll();
}
