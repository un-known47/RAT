package s0;

import java.io.Serializable;
import kotlin.jvm.internal.j;
import m0.e;
import m0.i;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b extends e implements a, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Enum[] f1180a;

    public b(Enum[] entries) {
        j.e(entries, "entries");
        this.f1180a = entries;
    }

    @Override // m0.a, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r4 = (Enum) obj;
        return ((Enum) i.t0(this.f1180a, r4.ordinal())) == r4;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        m0.b bVar = e.Companion;
        Enum[] enumArr = this.f1180a;
        int length = enumArr.length;
        bVar.getClass();
        m0.b.a(i2, length);
        return enumArr[i2];
    }

    @Override // m0.a
    public final int getSize() {
        return this.f1180a.length;
    }

    @Override // m0.e, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r4 = (Enum) obj;
        int iOrdinal = r4.ordinal();
        if (((Enum) i.t0(this.f1180a, iOrdinal)) == r4) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // m0.e, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r4 = (Enum) obj;
        int iOrdinal = r4.ordinal();
        if (((Enum) i.t0(this.f1180a, iOrdinal)) == r4) {
            return iOrdinal;
        }
        return -1;
    }
}
