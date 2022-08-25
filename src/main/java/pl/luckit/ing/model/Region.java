package pl.luckit.ing.model;

import lombok.Getter;
import pl.luckit.ing.exception.InvalidInputValueException;

public enum Region {

    DLN_WROC_PC("Dolnośląskie - Wrocław centrum"),
    DLN_POZA_WROC("Dolnośląskie - Wrocław poza centrum"),
    SL_POL("Dolnośląskie - poza Wrocławiem"),
    SL_KATO("Śląskie - południe"),
    SL_PN("Śląskie - Katowice"),
    M_WAW_CE("Śląskie - północ"),
    M_WAW_W("Mazowieckie - Warszawa Centrum"),
    M_WAW_Z("Mazowieckie - Warszawa wschód"),
    LUBL("Mazowieckie - Warszaawa - zachód"),
    LUBL_INNE("Lubelskie - Lublin");

    @Getter
    private final String description;

    Region(String description) {
        this.description = description;
    }

    public static Region findByRegionId(String regionId) throws InvalidInputValueException {
        for (Region region : Region.values()) {
            if (region.name().equals(regionId)) {
                return region;
            }
        }
        throw new InvalidInputValueException();
    }

}
