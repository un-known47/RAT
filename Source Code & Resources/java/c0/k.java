package c0;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class k extends Number {

    /* renamed from: a, reason: collision with root package name */
    public final String f176a;

    public k(String str) {
        this.f176a = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f176a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            return this.f176a.equals(((k) obj).f176a);
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f176a);
    }

    public final int hashCode() {
        return this.f176a.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String str = this.f176a;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return i.i(str).intValue();
            }
        } catch (NumberFormatException unused2) {
            return (int) Long.parseLong(str);
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        String str = this.f176a;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return i.i(str).longValue();
        }
    }

    public final String toString() {
        return this.f176a;
    }
}
