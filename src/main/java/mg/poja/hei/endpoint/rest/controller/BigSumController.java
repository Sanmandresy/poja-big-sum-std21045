package mg.poja.hei.endpoint.rest.controller;

import java.math.BigInteger;
import lombok.AllArgsConstructor;
import mg.poja.hei.service.BigSumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BigSumController {
  private final BigSumService service;

  @GetMapping("/big-sum")
  public BigInteger sum(@RequestParam("a") String a, @RequestParam("b") String b) {
    return service.sum(a, b);
  }
}
