package org.smurfs.utils;

public enum ErrorMessages {
    FILE_WRITING_ERROR("Error has occurred with writing to file: "),
    FILE_READING_ERROR("Error has occurred with reading to file: ");


    private final String error;

    ErrorMessages(String error) {
        this.error = error;
    }

    public String getError() {
        return error;

    }
}
