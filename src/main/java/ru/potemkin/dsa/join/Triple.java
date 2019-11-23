package ru.potemkin.dsa.join;

import lombok.*;

@Data
public class Triple <K, V1, V2> {
    private final K k;
    private final V1 v1;
    private final V2 v2;
}
