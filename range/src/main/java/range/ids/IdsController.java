package range.ids;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IdsController {
    private final IdsService idsService;

    @PostMapping("/range")
    public Long[] range(@RequestBody String serviceName) {
        return idsService.getRange(serviceName);
    }
}
