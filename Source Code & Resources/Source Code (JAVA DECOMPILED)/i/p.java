package i;

import android.content.Context;
import android.content.res.Resources;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class p implements h.g, h.h {

    /* renamed from: b, reason: collision with root package name */
    public final h.b f625b;
    public final a c;
    public final h.c d;

    /* renamed from: g, reason: collision with root package name */
    public final int f628g;

    /* renamed from: h, reason: collision with root package name */
    public final z f629h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f630i;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c f633m;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f624a = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f626e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f627f = new HashMap();
    public final ArrayList j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public g.a f631k = null;

    /* renamed from: l, reason: collision with root package name */
    public int f632l = 0;

    public p(c cVar, h.f fVar) {
        this.f633m = cVar;
        Looper looper = cVar.f604n.getLooper();
        f1.h hVarA = fVar.a();
        k.c cVar2 = new k.c((ArraySet) hVarA.f474a, (String) hVarA.f475b, (String) hVarA.c);
        p.a aVar = (p.a) fVar.c.f514b;
        k.s.b(aVar);
        h.b bVarF = aVar.f(fVar.f518a, looper, cVar2, fVar.d, this, this);
        String str = fVar.f519b;
        if (str != null && (bVarF instanceof com.google.android.gms.common.internal.a)) {
            ((com.google.android.gms.common.internal.a) bVarF).f246r = str;
        }
        if (str != null && (bVarF instanceof g)) {
            androidx.appcompat.app.g.u(bVarF);
            throw null;
        }
        this.f625b = bVarF;
        this.c = fVar.f520e;
        this.d = new h.c(2);
        this.f628g = fVar.f521f;
        if (!bVarF.m()) {
            this.f629h = null;
            return;
        }
        Context context = cVar.f596e;
        r.e eVar = cVar.f604n;
        f1.h hVarA2 = fVar.a();
        this.f629h = new z(context, eVar, new k.c((ArraySet) hVarA2.f474a, (String) hVarA2.f475b, (String) hVarA2.c));
    }

    @Override // h.g
    public final void a(int i2) {
        Looper looperMyLooper = Looper.myLooper();
        r.e eVar = this.f633m.f604n;
        if (looperMyLooper == eVar.getLooper()) {
            i(i2);
        } else {
            eVar.post(new n(this, i2, 0));
        }
    }

    @Override // h.g
    public final void b() {
        Looper looperMyLooper = Looper.myLooper();
        r.e eVar = this.f633m.f604n;
        if (looperMyLooper == eVar.getLooper()) {
            h();
        } else {
            eVar.post(new m(0, this));
        }
    }

    @Override // h.h
    public final void c(g.a aVar) {
        o(aVar, null);
    }

    public final void d(g.a aVar) {
        HashSet hashSet = this.f626e;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
        } else {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (k.s.d(aVar, g.a.f478e)) {
                this.f625b.i();
            }
            throw null;
        }
    }

    public final void e(Status status) {
        k.s.a(this.f633m.f604n);
        f(status, null, false);
    }

    public final void f(Status status, Exception exc, boolean z2) {
        k.s.a(this.f633m.f604n);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f624a.iterator();
        while (it.hasNext()) {
            v vVar = (v) it.next();
            if (!z2 || vVar.f644a == 2) {
                if (status != null) {
                    vVar.c(status);
                } else {
                    vVar.d(exc);
                }
                it.remove();
            }
        }
    }

    public final void g() {
        LinkedList linkedList = this.f624a;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            v vVar = (v) arrayList.get(i2);
            if (!this.f625b.a()) {
                return;
            }
            if (k(vVar)) {
                linkedList.remove(vVar);
            }
        }
    }

    public final void h() {
        c cVar = this.f633m;
        k.s.a(cVar.f604n);
        this.f631k = null;
        d(g.a.f478e);
        r.e eVar = cVar.f604n;
        if (this.f630i) {
            a aVar = this.c;
            eVar.removeMessages(11, aVar);
            eVar.removeMessages(9, aVar);
            this.f630i = false;
        }
        Iterator it = this.f627f.values().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        g();
        j();
    }

    public final void i(int i2) {
        c cVar = this.f633m;
        r.e eVar = cVar.f604n;
        k.s.a(cVar.f604n);
        this.f631k = null;
        this.f630i = true;
        String strJ = this.f625b.j();
        h.c cVar2 = this.d;
        cVar2.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i2 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i2 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (strJ != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(strJ);
        }
        cVar2.g(true, new Status(20, sb.toString(), null, null));
        a aVar = this.c;
        eVar.sendMessageDelayed(Message.obtain(eVar, 9, aVar), 5000L);
        eVar.sendMessageDelayed(Message.obtain(eVar, 11, aVar), 120000L);
        ((SparseIntArray) cVar.f598g.f514b).clear();
        Iterator it = this.f627f.values().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    public final void j() {
        c cVar = this.f633m;
        r.e eVar = cVar.f604n;
        a aVar = this.c;
        eVar.removeMessages(12, aVar);
        eVar.sendMessageDelayed(eVar.obtainMessage(12, aVar), cVar.f594a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean k(v vVar) throws Resources.NotFoundException {
        g.c cVar;
        if (vVar == null) {
            h.c cVar2 = this.d;
            h.b bVar = this.f625b;
            vVar.f(cVar2, bVar.m());
            try {
                vVar.e(this);
                return true;
            } catch (DeadObjectException unused) {
                a(1);
                bVar.e("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        g.c[] cVarArrB = vVar.b(this);
        if (cVarArrB == null || cVarArrB.length == 0) {
            cVar = null;
        } else {
            g.c[] cVarArrH = this.f625b.h();
            if (cVarArrH == null) {
                cVarArrH = new g.c[0];
            }
            ArrayMap arrayMap = new ArrayMap(cVarArrH.length);
            for (g.c cVar3 : cVarArrH) {
                arrayMap.put(cVar3.f483a, Long.valueOf(cVar3.a()));
            }
            int length = cVarArrB.length;
            for (int i2 = 0; i2 < length; i2++) {
                cVar = cVarArrB[i2];
                Long l2 = (Long) arrayMap.get(cVar.f483a);
                if (l2 == null || l2.longValue() < cVar.a()) {
                    break;
                }
            }
            cVar = null;
        }
        if (cVar == null) {
            h.c cVar4 = this.d;
            h.b bVar2 = this.f625b;
            vVar.f(cVar4, bVar2.m());
            try {
                vVar.e(this);
                return true;
            } catch (DeadObjectException unused2) {
                a(1);
                bVar2.e("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        this.f625b.getClass();
        if (!this.f633m.o || !vVar.a(this)) {
            vVar.d(new h.k(cVar));
            return true;
        }
        q qVar = new q(this.c, cVar);
        int iIndexOf = this.j.indexOf(qVar);
        if (iIndexOf >= 0) {
            q qVar2 = (q) this.j.get(iIndexOf);
            this.f633m.f604n.removeMessages(15, qVar2);
            r.e eVar = this.f633m.f604n;
            eVar.sendMessageDelayed(Message.obtain(eVar, 15, qVar2), 5000L);
        } else {
            this.j.add(qVar);
            r.e eVar2 = this.f633m.f604n;
            eVar2.sendMessageDelayed(Message.obtain(eVar2, 15, qVar), 5000L);
            r.e eVar3 = this.f633m.f604n;
            eVar3.sendMessageDelayed(Message.obtain(eVar3, 16, qVar), 120000L);
            g.a aVar = new g.a(2, null);
            if (!l(aVar)) {
                this.f633m.c(aVar, this.f628g);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        if (r6.get() == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean l(g.a r6) {
        /*
            r5 = this;
            java.lang.Object r0 = i.c.f592r
            monitor-enter(r0)
            i.c r1 = r5.f633m     // Catch: java.lang.Throwable -> L45
            i.j r2 = r1.f601k     // Catch: java.lang.Throwable -> L45
            if (r2 == 0) goto L47
            androidx.collection.ArraySet r1 = r1.f602l     // Catch: java.lang.Throwable -> L45
            i.a r2 = r5.c     // Catch: java.lang.Throwable -> L45
            boolean r1 = r1.contains(r2)     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto L47
            i.c r1 = r5.f633m     // Catch: java.lang.Throwable -> L45
            i.j r1 = r1.f601k     // Catch: java.lang.Throwable -> L45
            int r2 = r5.f628g     // Catch: java.lang.Throwable -> L45
            r1.getClass()     // Catch: java.lang.Throwable -> L45
            i.c0 r3 = new i.c0     // Catch: java.lang.Throwable -> L45
            r3.<init>(r6, r2)     // Catch: java.lang.Throwable -> L45
        L21:
            java.util.concurrent.atomic.AtomicReference r6 = r1.c     // Catch: java.lang.Throwable -> L45
        L23:
            r2 = 0
            boolean r2 = r6.compareAndSet(r2, r3)     // Catch: java.lang.Throwable -> L45
            if (r2 == 0) goto L36
            r.e r6 = r1.d     // Catch: java.lang.Throwable -> L45
            i.r r2 = new i.r     // Catch: java.lang.Throwable -> L45
            r4 = 2
            r2.<init>(r4, r1, r3)     // Catch: java.lang.Throwable -> L45
            r6.post(r2)     // Catch: java.lang.Throwable -> L45
            goto L42
        L36:
            java.lang.Object r2 = r6.get()     // Catch: java.lang.Throwable -> L45
            if (r2 == 0) goto L23
            java.lang.Object r6 = r6.get()     // Catch: java.lang.Throwable -> L45
            if (r6 == 0) goto L21
        L42:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L45
            r6 = 1
            return r6
        L45:
            r6 = move-exception
            goto L4a
        L47:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L45
            r6 = 0
            return r6
        L4a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L45
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: i.p.l(g.a):boolean");
    }

    public final void m() {
        c cVar = this.f633m;
        k.s.a(cVar.f604n);
        h.b bVar = this.f625b;
        if (bVar.a() || bVar.g()) {
            return;
        }
        try {
            h.c cVar2 = cVar.f598g;
            Context context = cVar.f596e;
            SparseIntArray sparseIntArray = (SparseIntArray) cVar2.f514b;
            k.s.b(context);
            int iF = bVar.f();
            int iB = ((SparseIntArray) cVar2.f514b).get(iF, -1);
            if (iB == -1) {
                iB = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= sparseIntArray.size()) {
                        iB = -1;
                        break;
                    }
                    int iKeyAt = sparseIntArray.keyAt(i2);
                    if (iKeyAt > iF && sparseIntArray.get(iKeyAt) == 0) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (iB == -1) {
                    iB = ((g.d) cVar2.c).b(context, iF);
                }
                sparseIntArray.put(iF, iB);
            }
            if (iB != 0) {
                g.a aVar = new g.a(iB, null);
                aVar.toString();
                o(aVar, null);
                return;
            }
            s sVar = new s(cVar, bVar, this.c);
            if (bVar.m()) {
                z zVar = this.f629h;
                k.s.b(zVar);
                Handler handler = zVar.c;
                k.c cVar3 = zVar.f655f;
                x.a aVar2 = zVar.f656g;
                if (aVar2 != null) {
                    aVar2.l();
                }
                cVar3.f706f = Integer.valueOf(System.identityHashCode(zVar));
                zVar.f656g = (x.a) zVar.d.f(zVar.f653b, handler.getLooper(), cVar3, cVar3.f705e, zVar, zVar);
                zVar.f657h = sVar;
                Set set = zVar.f654e;
                if (set == null || set.isEmpty()) {
                    handler.post(new m(2, zVar));
                } else {
                    x.a aVar3 = zVar.f656g;
                    aVar3.getClass();
                    aVar3.d(new k.h(aVar3));
                }
            }
            try {
                bVar.d(sVar);
            } catch (SecurityException e2) {
                o(new g.a(10), e2);
            }
        } catch (IllegalStateException e3) {
            o(new g.a(10), e3);
        }
    }

    public final void n(v vVar) {
        k.s.a(this.f633m.f604n);
        boolean zA = this.f625b.a();
        LinkedList linkedList = this.f624a;
        if (zA) {
            if (k(vVar)) {
                j();
                return;
            } else {
                linkedList.add(vVar);
                return;
            }
        }
        linkedList.add(vVar);
        g.a aVar = this.f631k;
        if (aVar == null || aVar.f480b == 0 || aVar.c == null) {
            m();
        } else {
            o(aVar, null);
        }
    }

    public final void o(g.a aVar, RuntimeException runtimeException) {
        x.a aVar2;
        k.s.a(this.f633m.f604n);
        z zVar = this.f629h;
        if (zVar != null && (aVar2 = zVar.f656g) != null) {
            aVar2.l();
        }
        k.s.a(this.f633m.f604n);
        this.f631k = null;
        ((SparseIntArray) this.f633m.f598g.f514b).clear();
        d(aVar);
        if ((this.f625b instanceof m.d) && aVar.f480b != 24) {
            c cVar = this.f633m;
            cVar.f595b = true;
            r.e eVar = cVar.f604n;
            eVar.sendMessageDelayed(eVar.obtainMessage(19), 300000L);
        }
        if (aVar.f480b == 4) {
            e(c.f591q);
            return;
        }
        if (this.f624a.isEmpty()) {
            this.f631k = aVar;
            return;
        }
        if (runtimeException != null) {
            k.s.a(this.f633m.f604n);
            f(null, runtimeException, false);
            return;
        }
        if (!this.f633m.o) {
            e(c.d(this.c, aVar));
            return;
        }
        f(c.d(this.c, aVar), null, true);
        if (this.f624a.isEmpty() || l(aVar) || this.f633m.c(aVar, this.f628g)) {
            return;
        }
        if (aVar.f480b == 18) {
            this.f630i = true;
        }
        if (!this.f630i) {
            e(c.d(this.c, aVar));
            return;
        }
        c cVar2 = this.f633m;
        a aVar3 = this.c;
        r.e eVar2 = cVar2.f604n;
        eVar2.sendMessageDelayed(Message.obtain(eVar2, 9, aVar3), 5000L);
    }

    public final void p(g.a aVar) {
        k.s.a(this.f633m.f604n);
        h.b bVar = this.f625b;
        bVar.e("onSignInFailed for " + bVar.getClass().getName() + " with " + String.valueOf(aVar));
        o(aVar, null);
    }

    public final void q() {
        k.s.a(this.f633m.f604n);
        Status status = c.f590p;
        e(status);
        this.d.g(false, status);
        for (f fVar : (f[]) this.f627f.keySet().toArray(new f[0])) {
            n(new b0(new y.c()));
        }
        d(new g.a(4));
        h.b bVar = this.f625b;
        if (bVar.a()) {
            bVar.k(new o(0, this));
        }
    }
}
