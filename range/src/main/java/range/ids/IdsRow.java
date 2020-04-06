package range.ids;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ids")
@Data
@Accessors(chain = true)
public class IdsRow {
    @Id
    @GeneratedValue
    private Long id;
    private Long startId;
    private Long endId;
    private String serviceName;
}
