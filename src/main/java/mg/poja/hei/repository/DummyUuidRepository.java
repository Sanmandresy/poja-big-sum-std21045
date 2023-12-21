package mg.poja.hei.repository;

import java.util.Optional;
import mg.poja.hei.PojaGenerated;
import mg.poja.hei.repository.model.DummyUuid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@PojaGenerated
@Repository
public interface DummyUuidRepository extends JpaRepository<DummyUuid, String> {

  @Override
  Optional<DummyUuid> findById(String id);
}
