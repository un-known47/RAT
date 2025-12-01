package androidx.collection;

import java.lang.reflect.Array;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
class ArraySetJvmUtil {
    private ArraySetJvmUtil() {
    }

    public static <T> T[] resizeForToArray(T[] tArr, int i2) {
        if (tArr.length < i2) {
            return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2));
        }
        if (tArr.length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }
}
