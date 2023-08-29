package com.regions.simpleregions.dtos;

import java.util.Arrays;


public record CredentialsDto(String login, char[] password) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CredentialsDto that = (CredentialsDto) o;

        if (!login.equals(that.login)) return false;
        return Arrays.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + Arrays.hashCode(password);
        return result;
    }

    @Override
    public String toString() {
        return "CredentialsDto{" +
                "login='" + login + '\'' +
                ", password=" + Arrays.toString(password) +
                '}';
    }
}
