package c0;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class p extends AbstractMap implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public static final l f190i = new l(0);

    /* renamed from: b, reason: collision with root package name */
    public final boolean f192b;
    public o c;

    /* renamed from: f, reason: collision with root package name */
    public final o f194f;

    /* renamed from: g, reason: collision with root package name */
    public n f195g;

    /* renamed from: h, reason: collision with root package name */
    public n f196h;
    public int d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f193e = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Comparator f191a = f190i;

    public p(boolean z2) {
        this.f192b = z2;
        this.f194f = new o(z2);
    }

    public final o a(Object obj, boolean z2) {
        int iCompareTo;
        o oVar;
        o oVar2 = this.c;
        l lVar = f190i;
        Comparator comparator = this.f191a;
        if (oVar2 != null) {
            Comparable comparable = comparator == lVar ? (Comparable) obj : null;
            while (true) {
                Object obj2 = oVar2.f186f;
                iCompareTo = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (iCompareTo == 0) {
                    return oVar2;
                }
                o oVar3 = iCompareTo < 0 ? oVar2.f184b : oVar2.c;
                if (oVar3 == null) {
                    break;
                }
                oVar2 = oVar3;
            }
        } else {
            iCompareTo = 0;
        }
        o oVar4 = oVar2;
        if (!z2) {
            return null;
        }
        o oVar5 = this.f194f;
        if (oVar4 != null) {
            oVar = new o(this.f192b, oVar4, obj, oVar5, oVar5.f185e);
            if (iCompareTo < 0) {
                oVar4.f184b = oVar;
            } else {
                oVar4.c = oVar;
            }
            b(oVar4, true);
        } else {
            if (comparator == lVar && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            oVar = new o(this.f192b, oVar4, obj, oVar5, oVar5.f185e);
            this.c = oVar;
        }
        this.d++;
        this.f193e++;
        return oVar;
    }

    public final void b(o oVar, boolean z2) {
        while (oVar != null) {
            o oVar2 = oVar.f184b;
            o oVar3 = oVar.c;
            int i2 = oVar2 != null ? oVar2.f189i : 0;
            int i3 = oVar3 != null ? oVar3.f189i : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                o oVar4 = oVar3.f184b;
                o oVar5 = oVar3.c;
                int i5 = (oVar4 != null ? oVar4.f189i : 0) - (oVar5 != null ? oVar5.f189i : 0);
                if (i5 == -1 || (i5 == 0 && !z2)) {
                    e(oVar);
                } else {
                    f(oVar3);
                    e(oVar);
                }
                if (z2) {
                    return;
                }
            } else if (i4 == 2) {
                o oVar6 = oVar2.f184b;
                o oVar7 = oVar2.c;
                int i6 = (oVar6 != null ? oVar6.f189i : 0) - (oVar7 != null ? oVar7.f189i : 0);
                if (i6 == 1 || (i6 == 0 && !z2)) {
                    f(oVar);
                } else {
                    e(oVar2);
                    f(oVar);
                }
                if (z2) {
                    return;
                }
            } else if (i4 == 0) {
                oVar.f189i = i2 + 1;
                if (z2) {
                    return;
                }
            } else {
                oVar.f189i = Math.max(i2, i3) + 1;
                if (!z2) {
                    return;
                }
            }
            oVar = oVar.f183a;
        }
    }

    public final void c(o oVar, boolean z2) {
        o oVar2;
        o oVar3;
        int i2;
        if (z2) {
            o oVar4 = oVar.f185e;
            oVar4.d = oVar.d;
            oVar.d.f185e = oVar4;
        }
        o oVar5 = oVar.f184b;
        o oVar6 = oVar.c;
        o oVar7 = oVar.f183a;
        int i3 = 0;
        if (oVar5 == null || oVar6 == null) {
            if (oVar5 != null) {
                d(oVar, oVar5);
                oVar.f184b = null;
            } else if (oVar6 != null) {
                d(oVar, oVar6);
                oVar.c = null;
            } else {
                d(oVar, null);
            }
            b(oVar7, false);
            this.d--;
            this.f193e++;
            return;
        }
        if (oVar5.f189i > oVar6.f189i) {
            o oVar8 = oVar5.c;
            while (true) {
                o oVar9 = oVar8;
                oVar3 = oVar5;
                oVar5 = oVar9;
                if (oVar5 == null) {
                    break;
                } else {
                    oVar8 = oVar5.c;
                }
            }
        } else {
            o oVar10 = oVar6.f184b;
            while (true) {
                oVar2 = oVar6;
                oVar6 = oVar10;
                if (oVar6 == null) {
                    break;
                } else {
                    oVar10 = oVar6.f184b;
                }
            }
            oVar3 = oVar2;
        }
        c(oVar3, false);
        o oVar11 = oVar.f184b;
        if (oVar11 != null) {
            i2 = oVar11.f189i;
            oVar3.f184b = oVar11;
            oVar11.f183a = oVar3;
            oVar.f184b = null;
        } else {
            i2 = 0;
        }
        o oVar12 = oVar.c;
        if (oVar12 != null) {
            i3 = oVar12.f189i;
            oVar3.c = oVar12;
            oVar12.f183a = oVar3;
            oVar.c = null;
        }
        oVar3.f189i = Math.max(i2, i3) + 1;
        d(oVar, oVar3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.c = null;
        this.d = 0;
        this.f193e++;
        o oVar = this.f194f;
        oVar.f185e = oVar;
        oVar.d = oVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        o oVarA = null;
        if (obj != null) {
            try {
                oVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return oVarA != null;
    }

    public final void d(o oVar, o oVar2) {
        o oVar3 = oVar.f183a;
        oVar.f183a = null;
        if (oVar2 != null) {
            oVar2.f183a = oVar3;
        }
        if (oVar3 == null) {
            this.c = oVar2;
        } else if (oVar3.f184b == oVar) {
            oVar3.f184b = oVar2;
        } else {
            oVar3.c = oVar2;
        }
    }

    public final void e(o oVar) {
        o oVar2 = oVar.f184b;
        o oVar3 = oVar.c;
        o oVar4 = oVar3.f184b;
        o oVar5 = oVar3.c;
        oVar.c = oVar4;
        if (oVar4 != null) {
            oVar4.f183a = oVar;
        }
        d(oVar, oVar3);
        oVar3.f184b = oVar;
        oVar.f183a = oVar3;
        int iMax = Math.max(oVar2 != null ? oVar2.f189i : 0, oVar4 != null ? oVar4.f189i : 0) + 1;
        oVar.f189i = iMax;
        oVar3.f189i = Math.max(iMax, oVar5 != null ? oVar5.f189i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        n nVar = this.f195g;
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(this, 0);
        this.f195g = nVar2;
        return nVar2;
    }

    public final void f(o oVar) {
        o oVar2 = oVar.f184b;
        o oVar3 = oVar.c;
        o oVar4 = oVar2.f184b;
        o oVar5 = oVar2.c;
        oVar.f184b = oVar5;
        if (oVar5 != null) {
            oVar5.f183a = oVar;
        }
        d(oVar, oVar2);
        oVar2.c = oVar;
        oVar.f183a = oVar2;
        int iMax = Math.max(oVar3 != null ? oVar3.f189i : 0, oVar5 != null ? oVar5.f189i : 0) + 1;
        oVar.f189i = iMax;
        oVar2.f189i = Math.max(iMax, oVar4 != null ? oVar4.f189i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        o oVarA;
        if (obj != null) {
            try {
                oVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            oVarA = null;
        }
        if (oVarA != null) {
            return oVarA.f188h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        n nVar = this.f196h;
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(this, 1);
        this.f196h = nVar2;
        return nVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.f192b) {
            throw new NullPointerException("value == null");
        }
        o oVarA = a(obj, true);
        Object obj3 = oVarA.f188h;
        oVarA.f188h = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        o oVarA;
        if (obj != null) {
            try {
                oVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            oVarA = null;
        }
        if (oVarA != null) {
            c(oVarA, true);
        }
        if (oVarA != null) {
            return oVarA.f188h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.d;
    }
}
