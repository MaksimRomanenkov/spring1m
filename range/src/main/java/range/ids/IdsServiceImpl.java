package range.ids;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.stream.LongStream;

@Service
@RequiredArgsConstructor
public class IdsServiceImpl implements IdsService {
    @Value("${range.range}")
    private long range;
    private final IdsRepository idsRepository;

    @Override
    public synchronized Long[] getRange(String serviceName) {
        IdsRow topByEndId = idsRepository.findTopByOrderByEndIdDesc();
        Long startId = topByEndId == null ? 0L : topByEndId.getEndId() + 1;
        IdsRow save = idsRepository.save(new IdsRow()
                .setServiceName(serviceName)
                .setStartId(startId)
                .setEndId(startId + range));
        long[] data = {save.getStartId(), save.getEndId()};
        return LongStream.of(data).boxed().toArray(Long[]::new);
    }
}
