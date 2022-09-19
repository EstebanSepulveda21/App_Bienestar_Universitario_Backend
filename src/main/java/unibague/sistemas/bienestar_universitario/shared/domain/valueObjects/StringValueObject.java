package unibague.sistemas.bienestar_universitario.shared.domain.valueObjects;

import lombok.Data;

import java.util.Objects;

@Data
public abstract class StringValueObject {
    protected final String value;
    public StringValueObject(String value) {
        this.value = value;
    }
    public String value(){
        return this.value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringValueObject that = (StringValueObject) o;
        return Objects.equals(value, that.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
