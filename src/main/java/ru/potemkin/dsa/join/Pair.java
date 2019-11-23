package ru.potemkin.dsa.join;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Pair<K, V> {
    private K k;
    private V v;
}
