package ru.potemkin.dsa.join;

import java.util.List;

public interface Join {
    <K extends Comparable<K>, V1, V2> List<Triple<K, V1, V2>> join(List<Pair<K, V1>> left, List<Pair<K, V2>> right);
}
