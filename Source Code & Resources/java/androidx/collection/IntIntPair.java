package androidx.collection;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class IntIntPair {
    public final long packedValue;

    private /* synthetic */ IntIntPair(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntIntPair m17boximpl(long j) {
        return new IntIntPair(j);
    }

    /* renamed from: component1-impl, reason: not valid java name */
    public static final int m18component1impl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: component2-impl, reason: not valid java name */
    public static final int m19component2impl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m21constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m22equalsimpl(long j, Object obj) {
        return (obj instanceof IntIntPair) && j == ((IntIntPair) obj).m28unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m23equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getFirst-impl, reason: not valid java name */
    public static final int m24getFirstimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: getSecond-impl, reason: not valid java name */
    public static final int m25getSecondimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m26hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m27toStringimpl(long j) {
        return "(" + m24getFirstimpl(j) + ", " + m25getSecondimpl(j) + ')';
    }

    public boolean equals(Object obj) {
        return m22equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m26hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m27toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m28unboximpl() {
        return this.packedValue;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m20constructorimpl(int i2, int i3) {
        return m21constructorimpl((i3 & 4294967295L) | (i2 << 32));
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }
}
