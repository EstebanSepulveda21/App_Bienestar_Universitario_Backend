package unibague.sistemas.bienestar_universitario.shared.domain.valueObjects;

import lombok.Data;

import java.util.Calendar;
import java.util.Objects;

@Data
public abstract class CalendarValueObject {
    protected final Calendar value;

    public CalendarValueObject(Calendar value) {
        this.value = value;
    }

    public Calendar value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarValueObject that = (CalendarValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
