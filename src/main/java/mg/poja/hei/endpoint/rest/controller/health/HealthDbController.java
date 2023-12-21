package mg.poja.hei.endpoint.rest.controller.health;

import static mg.poja.hei.endpoint.rest.controller.health.PingController.KO;
import static mg.poja.hei.endpoint.rest.controller.health.PingController.OK;

import lombok.AllArgsConstructor;
import mg.poja.hei.PojaGenerated;
import mg.poja.hei.repository.DummyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@PojaGenerated
@RestController
@AllArgsConstructor
public class HealthDbController {

  DummyRepository dummyRepository;

  @GetMapping("/health/db")
  public ResponseEntity<String> dummyTable_should_not_be_empty() {
    return dummyRepository.findAll().isEmpty() ? KO : OK;
  }
}
