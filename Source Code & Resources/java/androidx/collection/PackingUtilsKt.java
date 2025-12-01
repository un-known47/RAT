package androidx.collection;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class PackingUtilsKt {
    public static final long packFloats(float f2, float f3) {
        return (Float.floatToRawIntBits(f3) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32);
    }

    public static final long packInts(int i2, int i3) {
        return (i3 & 4294967295L) | (i2 << 32);
    }
}
