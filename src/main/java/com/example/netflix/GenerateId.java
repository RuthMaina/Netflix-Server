package com.example.netflix;

import java.time.Year;

public class GenerateId {
    public static String generateMovieId(String s, Year year) {
        String name = s
                    .toLowerCase()
                    .replaceAll(" +", "-")
                    .replaceAll("&+", "and")
                    .replaceAll("[&:_~.'\"]", "-");
        return name.concat("-")
                .concat(String.valueOf(year));
    }
}
