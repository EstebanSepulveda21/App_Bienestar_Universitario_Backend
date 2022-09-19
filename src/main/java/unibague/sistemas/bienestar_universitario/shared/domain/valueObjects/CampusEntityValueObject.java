package unibague.sistemas.bienestar_universitario.shared.domain.valueObjects;

import lombok.Data;
import unibague.sistemas.bienestar_universitario.campus.infrastructure.entities.CampusEntity;

import java.util.Objects;

@Data
public abstract class CampusEntityValueObject {
    protected final CampusEntity value;

    public CampusEntityValueObject(CampusEntity value) {
        this.value = value;
    }
    public CampusEntity value(){
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampusEntityValueObject that = (CampusEntityValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
