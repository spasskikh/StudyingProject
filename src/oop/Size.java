package oop;

public enum Size {

    /*constants by default, all capital letters*/

      VERY_SMALL ("XS"), SMALL ("S"), AVERAGE ("M"), BIG ("L"), VERY_BIG ("XL"), UNDEFINED("");

    private String abbreaviation;

    Size(String abbreviation) {
        this.abbreaviation = abbreviation;
    }

    public String getAbbreaviation() {
        return abbreaviation;
    }
}
