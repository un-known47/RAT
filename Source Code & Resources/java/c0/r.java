package c0;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class r implements CharSequence {

    /* renamed from: a, reason: collision with root package name */
    public char[] f197a;

    /* renamed from: b, reason: collision with root package name */
    public String f198b;

    @Override // java.lang.CharSequence
    public final char charAt(int i2) {
        return this.f197a[i2];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f197a.length;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i2, int i3) {
        return new String(this.f197a, i2, i3 - i2);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        if (this.f198b == null) {
            this.f198b = new String(this.f197a);
        }
        return this.f198b;
    }
}
