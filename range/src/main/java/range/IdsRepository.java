package range;

import org.springframework.data.repository.CrudRepository;

public interface IdsRepository extends CrudRepository<IdsRow, Long> {
    IdsRow findTopByOrderByEndIdDesc();
}
