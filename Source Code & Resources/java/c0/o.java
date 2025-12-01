package c0;

import java.util.Map;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class o implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public o f183a;

    /* renamed from: b, reason: collision with root package name */
    public o f184b;
    public o c;
    public o d;

    /* renamed from: e, reason: collision with root package name */
    public o f185e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f186f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f187g;

    /* renamed from: h, reason: collision with root package name */
    public Object f188h;

    /* renamed from: i, reason: collision with root package name */
    public int f189i;

    public o(boolean z2) {
        this.f186f = null;
        this.f187g = z2;
        this.f185e = this;
        this.d = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.f186f;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.f188h;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj3.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f186f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f188h;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f186f;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f188h;
        return (obj2 != null ? obj2.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.f187g) {
            throw new NullPointerException("value == null");
        }
        Object obj2 = this.f188h;
        this.f188h = obj;
        return obj2;
    }

    public final String toString() {
        return this.f186f + "=" + this.f188h;
    }

    public o(boolean z2, o oVar, Object obj, o oVar2, o oVar3) {
        this.f183a = oVar;
        this.f186f = obj;
        this.f187g = z2;
        this.f189i = 1;
        this.d = oVar2;
        this.f185e = oVar3;
        oVar3.d = this;
        oVar2.f185e = this;
    }
}
