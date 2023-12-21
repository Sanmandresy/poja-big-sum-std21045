package mg.poja.hei.service;

import java.math.BigInteger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BigSumService {
  public BigInteger sum(String a, String b) {
    return toBigInteger(a).add(toBigInteger(b));
  }

  private static BigInteger toBigInteger(String number) {
    return new BigInteger(number);
  }
}
