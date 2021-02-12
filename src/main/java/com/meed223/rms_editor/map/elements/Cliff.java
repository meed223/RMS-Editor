package com.meed223.rms_editor.map.elements;

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

    /* Hash Code */
    @Override
    public int hashCode() {
        int hash = 31;
        hash = 7 * hash + minNumberCliffs;
        hash = 7 * hash + maxNumberCliffs;
        hash = 7 * hash + minLengthCliffs;
        hash = 7 * hash + maxLengthCliffs;
        return hash;
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

    /* Getters & Setters */
    public void setMaxLength(int length) {
        maxLengthCliffs = length;
    }

    public void setMinLength(int length) {
        minLengthCliffs = length;
    }

    public void setMaxNumber(int number) {
        maxNumberCliffs = number;
    }

    public void setMinNumber(int number) {
        minNumberCliffs = number;
    }

    public int getMinNumber() {
        return minNumberCliffs;
    }

    public int getMaxNumber() {
        return maxNumberCliffs;
    }

    public int getMinLength() {
        return minLengthCliffs;
    }

    public int getMaxLength() {
        return maxLengthCliffs;
    }
}
