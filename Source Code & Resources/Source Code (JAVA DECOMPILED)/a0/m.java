package a0;

import d0.a1;
import d0.q0;
import d0.s0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: h, reason: collision with root package name */
    public static final i f8h = i.d;

    /* renamed from: i, reason: collision with root package name */
    public static final a f9i = h.f1a;
    public static final v j = z.f20a;

    /* renamed from: k, reason: collision with root package name */
    public static final w f10k = z.f21b;

    /* renamed from: a, reason: collision with root package name */
    public final ThreadLocal f11a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f12b;
    public final g.g c;
    public final d0.k d;

    /* renamed from: e, reason: collision with root package name */
    public final List f13e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f14f;

    /* renamed from: g, reason: collision with root package name */
    public final i f15g;

    public m() {
        c0.e eVar = c0.e.c;
        Map map = Collections.EMPTY_MAP;
        List list = Collections.EMPTY_LIST;
        this.f11a = new ThreadLocal();
        this.f12b = new ConcurrentHashMap();
        g.g gVar = new g.g(1);
        this.c = gVar;
        this.f14f = true;
        this.f15g = f8h;
        ArrayList arrayList = new ArrayList();
        arrayList.add(a1.A);
        v vVar = z.f20a;
        v vVar2 = j;
        arrayList.add(vVar2 == vVar ? d0.p.c : new d0.n(1, vVar2));
        arrayList.add(eVar);
        arrayList.addAll(list);
        arrayList.add(a1.f379p);
        arrayList.add(a1.f372g);
        arrayList.add(a1.d);
        arrayList.add(a1.f370e);
        arrayList.add(a1.f371f);
        d0.y yVar = a1.f375k;
        arrayList.add(new s0(Long.TYPE, Long.class, yVar));
        arrayList.add(new s0(Double.TYPE, Double.class, new j(0)));
        arrayList.add(new s0(Float.TYPE, Float.class, new j(1)));
        w wVar = z.f21b;
        w wVar2 = f10k;
        arrayList.add(wVar2 == wVar ? d0.o.f407b : new d0.n(0, new d0.o(wVar2)));
        arrayList.add(a1.f373h);
        arrayList.add(a1.f374i);
        arrayList.add(new q0(AtomicLong.class, new k(yVar, 0).a(), 0));
        int i2 = 0;
        arrayList.add(new q0(AtomicLongArray.class, new k(yVar, 1).a(), i2));
        arrayList.add(a1.j);
        arrayList.add(a1.f376l);
        arrayList.add(a1.f380q);
        arrayList.add(a1.f381r);
        arrayList.add(new q0(BigDecimal.class, a1.f377m, i2));
        arrayList.add(new q0(BigInteger.class, a1.f378n, i2));
        arrayList.add(new q0(c0.k.class, a1.o, i2));
        arrayList.add(a1.f382s);
        arrayList.add(a1.f383t);
        arrayList.add(a1.f384v);
        arrayList.add(a1.f385w);
        arrayList.add(a1.f387y);
        arrayList.add(a1.u);
        arrayList.add(a1.f369b);
        arrayList.add(d0.g.c);
        arrayList.add(a1.f386x);
        if (g0.e.f506a) {
            arrayList.add(g0.e.c);
            arrayList.add(g0.e.f507b);
            arrayList.add(g0.e.d);
        }
        arrayList.add(d0.b.c);
        arrayList.add(a1.f368a);
        arrayList.add(new d0.d(gVar, 0));
        arrayList.add(new d0.d(gVar, 1));
        d0.k kVar = new d0.k(gVar);
        this.d = kVar;
        arrayList.add(kVar);
        arrayList.add(a1.B);
        arrayList.add(new d0.v(gVar, f9i, eVar, kVar));
        this.f13e = Collections.unmodifiableList(arrayList);
    }

    public static void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final b0 b(h0.a aVar) {
        boolean z2;
        ConcurrentHashMap concurrentHashMap = this.f12b;
        b0 b0Var = (b0) concurrentHashMap.get(aVar);
        if (b0Var != null) {
            return b0Var;
        }
        ThreadLocal threadLocal = this.f11a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z2 = true;
        } else {
            b0 b0Var2 = (b0) map.get(aVar);
            if (b0Var2 != null) {
                return b0Var2;
            }
            z2 = false;
        }
        try {
            l lVar = new l();
            map.put(aVar, lVar);
            Iterator it = this.f13e.iterator();
            b0 b0VarA = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b0VarA = ((c0) it.next()).a(this, aVar);
                if (b0VarA != null) {
                    if (lVar.f7a != null) {
                        throw new AssertionError("Delegate is already set");
                    }
                    lVar.f7a = b0VarA;
                    map.put(aVar, b0VarA);
                }
            }
            if (z2) {
                threadLocal.remove();
            }
            if (b0VarA != null) {
                if (z2) {
                    concurrentHashMap.putAll(map);
                }
                return b0VarA;
            }
            throw new IllegalArgumentException("GSON (2.13.2) cannot handle " + aVar);
        } catch (Throwable th) {
            if (z2) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.f13e + ",instanceCreators:" + this.c + "}";
    }
}
