package m0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class v extends p.a {
    public static int g0(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map h0(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return r.f868a;
        }
        if (size == 1) {
            l0.d pair = (l0.d) arrayList.get(0);
            kotlin.jvm.internal.j.e(pair, "pair");
            Map mapSingletonMap = Collections.singletonMap(pair.f850a, pair.f851b);
            kotlin.jvm.internal.j.d(mapSingletonMap, "singletonMap(...)");
            return mapSingletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0(arrayList.size()));
        int size2 = arrayList.size();
        int i2 = 0;
        while (i2 < size2) {
            Object obj = arrayList.get(i2);
            i2++;
            l0.d dVar = (l0.d) obj;
            linkedHashMap.put(dVar.f850a, dVar.f851b);
        }
        return linkedHashMap;
    }

    public static Map i0(Map map) {
        kotlin.jvm.internal.j.e(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return r.f868a;
        }
        if (size != 1) {
            return new LinkedHashMap(map);
        }
        kotlin.jvm.internal.j.e(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        kotlin.jvm.internal.j.d(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }
}
