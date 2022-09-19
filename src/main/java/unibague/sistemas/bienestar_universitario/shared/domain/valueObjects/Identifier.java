package unibague.sistemas.bienestar_universitario.shared.domain.valueObjects;

import lombok.Data;

import java.util.Objects;
import java.util.UUID;

@Data
public abstract class Identifier {
    protected final Long value;
    public Identifier(Long value){
        //ensureValidUuid(value);
        this.value = value;
    }
    private void ensureValidUuid(Long value) throws IllegalArgumentException{
        UUID.fromString(String.valueOf(value));
    }
    public Long value(){
        return value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return Objects.equals(value, that.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
