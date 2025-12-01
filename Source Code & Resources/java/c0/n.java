package c0;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class n extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f181a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f182b;

    public /* synthetic */ n(p pVar, int i2) {
        this.f181a = i2;
        this.f182b = pVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f181a) {
            case 0:
                this.f182b.clear();
                break;
            default:
                this.f182b.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        o oVarA;
        switch (this.f181a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                p pVar = this.f182b;
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                o oVar = null;
                if (key != null) {
                    try {
                        oVarA = pVar.a(key, false);
                    } catch (ClassCastException unused) {
                    }
                } else {
                    oVarA = null;
                }
                if (oVarA != null && Objects.equals(oVarA.f188h, entry.getValue())) {
                    oVar = oVarA;
                }
                return oVar != null;
            default:
                return this.f182b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f181a) {
            case 0:
                return new m(this.f182b, 0);
            default:
                return new m(this.f182b, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        o oVarA;
        switch (this.f181a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                p pVar = this.f182b;
                o oVar = null;
                if (key != null) {
                    try {
                        oVarA = pVar.a(key, false);
                    } catch (ClassCastException unused) {
                    }
                } else {
                    oVarA = null;
                }
                if (oVarA != null && Objects.equals(oVarA.f188h, entry.getValue())) {
                    oVar = oVarA;
                }
                if (oVar == null) {
                    return false;
                }
                pVar.c(oVar, true);
                return true;
            default:
                p pVar2 = this.f182b;
                o oVarA2 = null;
                if (obj != null) {
                    try {
                        oVarA2 = pVar2.a(obj, false);
                    } catch (ClassCastException unused2) {
                    }
                }
                if (oVarA2 != null) {
                    pVar2.c(oVarA2, true);
                }
                return oVarA2 != null;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f181a) {
        }
        return this.f182b.d;
    }
}
