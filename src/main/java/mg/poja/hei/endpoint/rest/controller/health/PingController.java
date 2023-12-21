package mg.poja.hei.endpoint.rest.controller.health;

import lombok.AllArgsConstructor;
import mg.poja.hei.PojaGenerated;
import mg.poja.hei.repository.DummyRepository;
import mg.poja.hei.repository.DummyUuidRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@PojaGenerated
@RestController
@AllArgsConstructor
public class PingController {

  DummyRepository dummyRepository;
  DummyUuidRepository dummyUuidRepository;

  public static final ResponseEntity<String> OK = new ResponseEntity<>("OK", HttpStatus.OK);
  public static final ResponseEntity<String> KO =
      new ResponseEntity<>("KO", HttpStatus.INTERNAL_SERVER_ERROR);

  @GetMapping("/ping")
  public String ping() {
    return "pong";
  }
}
