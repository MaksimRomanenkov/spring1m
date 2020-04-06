package app;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final RestTemplate restTemplate;

    @Value("${range.url}")
    private String rangeUrl;

    private AtomicLong currentId;
    private Long endId;

    @PostConstruct
    void init() {
        long[] newIds = restTemplate.postForEntity(rangeUrl, "name", long[].class)
                .getBody();
        currentId = new AtomicLong(newIds[0]);
        endId = newIds[1];
    }

    @GetMapping("/get")
    public Long getId() {
        long andIncrement = currentId.getAndIncrement();
        if (andIncrement == endId) {
            init();
        }
        return andIncrement;
    }
}
