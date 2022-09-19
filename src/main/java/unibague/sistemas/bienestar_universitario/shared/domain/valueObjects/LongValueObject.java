package unibague.sistemas.bienestar_universitario.shared.domain.valueObjects;

import lombok.Data;

import java.util.Objects;

@Data
public abstract class LongValueObject {

    protected final Long value;

    public LongValueObject(Long value) {
        this.value = value;
    }
    public Long value(){
        return this.value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LongValueObject that = (LongValueObject) o;
        return Objects.equals(value, that.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
