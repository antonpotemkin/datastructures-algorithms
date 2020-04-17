package ru.potemkin.dsa.join;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of join two lists using hashMap
 */
public class HashJoin implements Join {
    @Override
    public <K extends Comparable<K>, V1, V2> List<Triple<K, V1, V2>> join(List<Pair<K, V1>> left, List<Pair<K, V2>> right) {
        List<Triple<K, V1, V2>> result = new ArrayList<>();
        Map<K, V2> hash = new HashMap<>(right.size());
        for (Pair<K, V2> pair : right)
            hash.put(pair.getK(), pair.getV());
        for (Pair<K, V1> pair : left)
            if (hash.containsKey(pair.getK()))
                result.add(new Triple<>(pair.getK(), pair.getV(), hash.get(pair.getK())));
        return result;
    }
}
