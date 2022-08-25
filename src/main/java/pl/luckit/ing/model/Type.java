package pl.luckit.ing.model;

import lombok.Getter;
import pl.luckit.ing.exception.InvalidInputValueException;

public enum Type {

    DETACHED_HOUSE("detached_house"),
    FLAT("flat"),
    SEMI_DETACHED_HOUSE("semi_detached_house"),
    TERRACED_HOUSE("terraced_house");

    @Getter
    private final String value;

    Type(String value) {
        this.value = value;
    }

    public static Type findByType(String value) throws InvalidInputValueException {
        for (Type realEstateType : Type.values()) {
            if (realEstateType.value.equals(value)) {
                return realEstateType;
            }
        }
        throw new InvalidInputValueException();
    }

}
