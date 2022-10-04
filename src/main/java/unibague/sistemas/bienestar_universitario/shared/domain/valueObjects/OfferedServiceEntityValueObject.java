package unibague.sistemas.bienestar_universitario.shared.domain.valueObjects;

import lombok.Data;
import unibague.sistemas.bienestar_universitario.offeredService.infrastructure.entities.OfferedServiceEntity;

import java.util.Objects;

@Data
public abstract class OfferedServiceEntityValueObject {
    protected final OfferedServiceEntity value;

    public OfferedServiceEntityValueObject(OfferedServiceEntity value) {
        this.value = value;
    }

    public OfferedServiceEntity value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferedServiceEntityValueObject that = (OfferedServiceEntityValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
