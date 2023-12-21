package mg.poja.hei.endpoint.event;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import mg.poja.hei.PojaGenerated;
import mg.poja.hei.conf.FacadeIT;
import mg.poja.hei.endpoint.event.gen.UuidCreated;
import mg.poja.hei.repository.DummyUuidRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@PojaGenerated
class EventConsumerIT extends FacadeIT {

  @Autowired EventConsumer subject;
  @Autowired DummyUuidRepository dummyUuidRepository;
  @Autowired ObjectMapper om;

  @Test
  void uuid_created_is_persisted() throws InterruptedException, JsonProcessingException {
    var uuid = randomUUID().toString();
    var uuidCreated = UuidCreated.builder().uuid(uuid).build();
    var payloadReceived = om.readValue(om.writeValueAsString(uuidCreated), UuidCreated.class);

    subject.accept(
        List.of(
            new EventConsumer.AcknowledgeableTypedEvent(
                new EventConsumer.TypedEvent(
                    "mg.poja.hei.endpoint.event.gen.UuidCreated", payloadReceived),
                () -> {})));

    Thread.sleep(2_000);
    var saved = dummyUuidRepository.findById(uuid).orElseThrow();
    assertEquals(uuid, saved.getId());
  }
}
