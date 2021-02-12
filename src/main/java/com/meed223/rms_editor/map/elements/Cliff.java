package com.meed223.rms_editor.map.elements;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Cliff {
    private int minNumberCliffs;
    private int maxNumberCliffs;
    private int minLengthCliffs;
    private int maxLengthCliffs;

    public Cliff() {
        minLengthCliffs = 0;
        maxLengthCliffs = 0;
        minNumberCliffs = 0;
        maxNumberCliffs = 0;
    }

    /* Convert to RMS */
    @Override
    public String toString() {
        return "<CLIFF_GENERATION>\n" +
                "/* Size and number of cliffs */\n" +
                "min_number_of_cliffs " +
                minNumberCliffs +
                "\nmax_number_of_cliffs " +
                maxNumberCliffs +
                "\nmin_length_of_cliffs " +
                minLengthCliffs +
                "\nmax_length_of_cliffs " +
                maxNumberCliffs;
    }
}
