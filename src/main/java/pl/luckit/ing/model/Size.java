package pl.luckit.ing.model;

import liquibase.repackaged.org.apache.commons.lang3.StringUtils;
import lombok.Getter;
import pl.luckit.ing.exception.InvalidInputValueException;

@Getter
public enum Size {

    S(18, 45),
    M(46, 80),
    L(81, 400);

    private final long minArea;
    private final long maxArea;

    Size(long minArea, long maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    private static boolean isSizeS(double area) {
        return S.getMinArea() <= Math.floor(area) && S.getMaxArea() >= Math.floor(area);
    }

    private static boolean isSizeM(double area) {
        return M.getMinArea() <= Math.floor(area) && M.getMaxArea() >= Math.floor(area);
    }

    private static boolean isSizeL(double area) {
        return L.getMinArea() <= Math.floor(area) && L.getMaxArea() >= Math.floor(area);
    }

    public static Size findBySize(String size) throws InvalidInputValueException {
        if (StringUtils.isBlank(size)) {
            return null;
        }
        for (Size realEstateSize : Size.values()) {
            if (realEstateSize.name().equals(size)) {
                return realEstateSize;
            }
        }
        throw new InvalidInputValueException();
    }

    public static Size findByArea(String area) throws InvalidInputValueException {
        if (area == null || area.isEmpty()) {
            throw new InvalidInputValueException();
        }
        double areaDouble;

        try {
            areaDouble = Double.parseDouble(area);
        } catch (NumberFormatException e) {
            throw new InvalidInputValueException();
        }

        if (isSizeS(areaDouble)) {
            return Size.S;
        } else if (isSizeM(areaDouble)) {
            return Size.M;
        } else if (isSizeL(areaDouble)) {
            return Size.L;
        }
        throw new InvalidInputValueException();
    }
}
