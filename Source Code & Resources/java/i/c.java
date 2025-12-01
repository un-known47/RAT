package i;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseIntArray;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c implements Handler.Callback {

    /* renamed from: p, reason: collision with root package name */
    public static final Status f590p = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);

    /* renamed from: q, reason: collision with root package name */
    public static final Status f591q = new Status(4, "The user must be signed in to make this API call.", null, null);

    /* renamed from: r, reason: collision with root package name */
    public static final Object f592r = new Object();

    /* renamed from: s, reason: collision with root package name */
    public static c f593s;

    /* renamed from: a, reason: collision with root package name */
    public long f594a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f595b;
    public k.j c;
    public m.c d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f596e;

    /* renamed from: f, reason: collision with root package name */
    public final g.d f597f;

    /* renamed from: g, reason: collision with root package name */
    public final h.c f598g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicInteger f599h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f600i;
    public final ConcurrentHashMap j;

    /* renamed from: k, reason: collision with root package name */
    public j f601k;

    /* renamed from: l, reason: collision with root package name */
    public final ArraySet f602l;

    /* renamed from: m, reason: collision with root package name */
    public final ArraySet f603m;

    /* renamed from: n, reason: collision with root package name */
    public final r.e f604n;
    public volatile boolean o;

    public c(Context context, Looper looper) {
        g.d dVar = g.d.c;
        this.f594a = 10000L;
        this.f595b = false;
        this.f599h = new AtomicInteger(1);
        this.f600i = new AtomicInteger(0);
        this.j = new ConcurrentHashMap(5, 0.75f, 1);
        this.f601k = null;
        this.f602l = new ArraySet();
        this.f603m = new ArraySet();
        this.o = true;
        this.f596e = context;
        r.e eVar = new r.e(looper, this);
        Looper.getMainLooper();
        this.f604n = eVar;
        this.f597f = dVar;
        this.f598g = new h.c(5);
        PackageManager packageManager = context.getPackageManager();
        if (p.a.f982f == null) {
            p.a.f982f = Boolean.valueOf(Build.VERSION.SDK_INT >= 26 && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (p.a.f982f.booleanValue()) {
            this.o = false;
        }
        eVar.sendMessage(eVar.obtainMessage(6));
    }

    public static Status d(a aVar, g.a aVar2) {
        return new Status(17, "API: " + ((String) aVar.f584b.c) + " is not available on this device. Connection failed with: " + String.valueOf(aVar2), aVar2.c, aVar2);
    }

    public static c f(Context context) {
        c cVar;
        synchronized (f592r) {
            try {
                if (f593s == null) {
                    Looper looper = k.c0.a().getLooper();
                    Context applicationContext = context.getApplicationContext();
                    Object obj = g.d.f485b;
                    f593s = new c(applicationContext, looper);
                }
                cVar = f593s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public final void a(j jVar) {
        synchronized (f592r) {
            try {
                if (this.f601k != jVar) {
                    this.f601k = jVar;
                    this.f602l.clear();
                }
                this.f602l.addAll((Collection) jVar.f613f);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b() {
        if (this.f595b) {
            return false;
        }
        k.i iVar = (k.i) k.h.b().f741a;
        if (iVar != null && !iVar.f743b) {
            return false;
        }
        int i2 = ((SparseIntArray) this.f598g.f514b).get(203400000, -1);
        return i2 == -1 || i2 == 0;
    }

    public final boolean c(g.a aVar, int i2) throws Resources.NotFoundException {
        boolean zBooleanValue;
        PendingIntent activity;
        Boolean bool;
        g.d dVar = this.f597f;
        Context context = this.f596e;
        dVar.getClass();
        synchronized (p.a.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = p.a.f979a;
            if (context2 == null || (bool = p.a.f980b) == null || context2 != applicationContext) {
                p.a.f980b = null;
                if (Build.VERSION.SDK_INT >= 26) {
                    p.a.f980b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        p.a.f980b = Boolean.TRUE;
                    } catch (ClassNotFoundException unused) {
                        p.a.f980b = Boolean.FALSE;
                    }
                }
                p.a.f979a = applicationContext;
                zBooleanValue = p.a.f980b.booleanValue();
            } else {
                zBooleanValue = bool.booleanValue();
            }
        }
        if (!zBooleanValue) {
            int i3 = aVar.f480b;
            if ((i3 == 0 || aVar.c == null) ? false : true) {
                activity = aVar.c;
            } else {
                Intent intentA = dVar.a(context, i3, null);
                activity = intentA != null ? PendingIntent.getActivity(context, 0, intentA, s.c.f1179a | 134217728) : null;
            }
            if (activity != null) {
                int i4 = aVar.f480b;
                int i5 = GoogleApiActivity.f219b;
                Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
                intent.putExtra("pending_intent", activity);
                intent.putExtra("failing_client_id", i2);
                intent.putExtra("notify_manager", true);
                dVar.f(context, i4, PendingIntent.getActivity(context, 0, intent, r.d.f1170a | 134217728));
                return true;
            }
        }
        return false;
    }

    public final p e(h.f fVar) {
        a aVar = fVar.f520e;
        ConcurrentHashMap concurrentHashMap = this.j;
        p pVar = (p) concurrentHashMap.get(aVar);
        if (pVar == null) {
            pVar = new p(this, fVar);
            concurrentHashMap.put(aVar, pVar);
        }
        if (pVar.f625b.m()) {
            this.f603m.add(aVar);
        }
        pVar.m();
        return pVar;
    }

    public final void g(g.a aVar, int i2) {
        if (c(aVar, i2)) {
            return;
        }
        r.e eVar = this.f604n;
        eVar.sendMessage(eVar.obtainMessage(5, i2, 0, aVar));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        p pVar;
        g.c[] cVarArrB;
        int i2 = 3;
        switch (message.what) {
            case 1:
                this.f594a = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f604n.removeMessages(12);
                for (a aVar : this.j.keySet()) {
                    r.e eVar = this.f604n;
                    eVar.sendMessageDelayed(eVar.obtainMessage(12, aVar), this.f594a);
                }
                return true;
            case 2:
                message.obj.getClass();
                throw new ClassCastException();
            case 3:
                for (p pVar2 : this.j.values()) {
                    k.s.a(pVar2.f633m.f604n);
                    pVar2.f631k = null;
                    pVar2.m();
                }
                return true;
            case 4:
            case 8:
            case 13:
                y yVar = (y) message.obj;
                p pVarE = (p) this.j.get(yVar.c.f520e);
                if (pVarE == null) {
                    pVarE = e(yVar.c);
                }
                if (!pVarE.f625b.m() || this.f600i.get() == yVar.f651b) {
                    pVarE.n(yVar.f650a);
                    return true;
                }
                yVar.f650a.c(f590p);
                pVarE.q();
                return true;
            case 5:
                int i3 = message.arg1;
                g.a aVar2 = (g.a) message.obj;
                Iterator it = this.j.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        pVar = (p) it.next();
                        if (pVar.f628g == i3) {
                        }
                    } else {
                        pVar = null;
                    }
                }
                if (pVar == null) {
                    new Exception();
                    return true;
                }
                int i4 = aVar2.f480b;
                if (i4 != 13) {
                    pVar.e(d(pVar.c, aVar2));
                    return true;
                }
                this.f597f.getClass();
                AtomicBoolean atomicBoolean = g.f.f487a;
                pVar.e(new Status(17, "Error resolution was canceled by the user, original error message: " + g.a.a(i4) + ": " + aVar2.d, null, null));
                return true;
            case 6:
                if (this.f596e.getApplicationContext() instanceof Application) {
                    Application application = (Application) this.f596e.getApplicationContext();
                    b bVar = b.f586e;
                    synchronized (bVar) {
                        try {
                            if (!bVar.d) {
                                application.registerActivityLifecycleCallbacks(bVar);
                                application.registerComponentCallbacks(bVar);
                                bVar.d = true;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    bVar.a(new l(this));
                    AtomicBoolean atomicBoolean2 = bVar.f587a;
                    AtomicBoolean atomicBoolean3 = bVar.f588b;
                    if (!atomicBoolean3.get()) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        if (!atomicBoolean3.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                            atomicBoolean2.set(true);
                        }
                    }
                    if (!atomicBoolean2.get()) {
                        this.f594a = 300000L;
                        return true;
                    }
                }
                return true;
            case 7:
                e((h.f) message.obj);
                return true;
            case 9:
                if (this.j.containsKey(message.obj)) {
                    p pVar3 = (p) this.j.get(message.obj);
                    k.s.a(pVar3.f633m.f604n);
                    if (pVar3.f630i) {
                        pVar3.m();
                        return true;
                    }
                }
                return true;
            case 10:
                Iterator<E> it2 = this.f603m.iterator();
                while (it2.hasNext()) {
                    p pVar4 = (p) this.j.remove((a) it2.next());
                    if (pVar4 != null) {
                        pVar4.q();
                    }
                }
                this.f603m.clear();
                return true;
            case 11:
                if (this.j.containsKey(message.obj)) {
                    p pVar5 = (p) this.j.get(message.obj);
                    c cVar = pVar5.f633m;
                    k.s.a(cVar.f604n);
                    boolean z2 = pVar5.f630i;
                    if (z2) {
                        a aVar3 = pVar5.c;
                        r.e eVar2 = pVar5.f633m.f604n;
                        if (z2) {
                            eVar2.removeMessages(11, aVar3);
                            eVar2.removeMessages(9, aVar3);
                            pVar5.f630i = false;
                        }
                        pVar5.e(cVar.f597f.b(cVar.f596e, g.e.f486a) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.", null, null) : new Status(22, "API failed to connect while resuming due to an unknown error.", null, null));
                        pVar5.f625b.e("Timing out connection while resuming.");
                        return true;
                    }
                }
                return true;
            case 12:
                if (this.j.containsKey(message.obj)) {
                    p pVar6 = (p) this.j.get(message.obj);
                    k.s.a(pVar6.f633m.f604n);
                    h.b bVar2 = pVar6.f625b;
                    if (bVar2.a() && pVar6.f627f.isEmpty()) {
                        h.c cVar2 = pVar6.d;
                        if (((Map) cVar2.f514b).isEmpty() && ((Map) cVar2.c).isEmpty()) {
                            bVar2.e("Timing out service connection.");
                            return true;
                        }
                        pVar6.j();
                    }
                    return true;
                }
                return true;
            case 14:
                message.obj.getClass();
                throw new ClassCastException();
            case 15:
                q qVar = (q) message.obj;
                if (this.j.containsKey(qVar.f634a)) {
                    p pVar7 = (p) this.j.get(qVar.f634a);
                    if (pVar7.j.contains(qVar) && !pVar7.f630i) {
                        if (pVar7.f625b.a()) {
                            pVar7.g();
                            return true;
                        }
                        pVar7.m();
                        return true;
                    }
                }
                return true;
            case 16:
                q qVar2 = (q) message.obj;
                if (this.j.containsKey(qVar2.f634a)) {
                    p pVar8 = (p) this.j.get(qVar2.f634a);
                    ArrayList arrayList = pVar8.j;
                    c cVar3 = pVar8.f633m;
                    LinkedList<v> linkedList = pVar8.f624a;
                    if (arrayList.remove(qVar2)) {
                        cVar3.f604n.removeMessages(15, qVar2);
                        cVar3.f604n.removeMessages(16, qVar2);
                        g.c cVar4 = qVar2.f635b;
                        ArrayList arrayList2 = new ArrayList(linkedList.size());
                        for (v vVar : linkedList) {
                            if (vVar != null && (cVarArrB = vVar.b(pVar8)) != null) {
                                int length = cVarArrB.length;
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= length) {
                                        break;
                                    }
                                    if (!k.s.d(cVarArrB[i5], cVar4)) {
                                        i5++;
                                    } else if (i5 >= 0) {
                                        arrayList2.add(vVar);
                                    }
                                }
                            }
                        }
                        int size = arrayList2.size();
                        for (int i6 = 0; i6 < size; i6++) {
                            v vVar2 = (v) arrayList2.get(i6);
                            linkedList.remove(vVar2);
                            vVar2.d(new h.k(cVar4));
                        }
                    }
                }
                return true;
            case 17:
                k.j jVar = this.c;
                if (jVar != null) {
                    if (jVar.f745a > 0 || b()) {
                        if (this.d == null) {
                            this.d = new m.c(this.f596e, null, m.c.f858i, k.k.f747a, h.e.f516b);
                        }
                        m.c cVar5 = this.d;
                        cVar5.getClass();
                        i iVar = new i();
                        iVar.c = 0;
                        iVar.f609a = new g.c[]{r.c.f1168a};
                        iVar.f610b = false;
                        iVar.d = new o(i2, jVar);
                        cVar5.b(2, iVar.a());
                    }
                    this.c = null;
                    return true;
                }
                return true;
            case 18:
                x xVar = (x) message.obj;
                if (xVar.c == 0) {
                    k.j jVar2 = new k.j(xVar.f649b, Arrays.asList(xVar.f648a));
                    if (this.d == null) {
                        this.d = new m.c(this.f596e, null, m.c.f858i, k.k.f747a, h.e.f516b);
                    }
                    m.c cVar6 = this.d;
                    cVar6.getClass();
                    i iVar2 = new i();
                    iVar2.c = 0;
                    iVar2.f609a = new g.c[]{r.c.f1168a};
                    iVar2.f610b = false;
                    iVar2.d = new o(i2, jVar2);
                    cVar6.b(2, iVar2.a());
                    return true;
                }
                k.j jVar3 = this.c;
                if (jVar3 != null) {
                    List list = jVar3.f746b;
                    if (jVar3.f745a != xVar.f649b || (list != null && list.size() >= xVar.d)) {
                        this.f604n.removeMessages(17);
                        k.j jVar4 = this.c;
                        if (jVar4 != null) {
                            if (jVar4.f745a > 0 || b()) {
                                if (this.d == null) {
                                    this.d = new m.c(this.f596e, null, m.c.f858i, k.k.f747a, h.e.f516b);
                                }
                                m.c cVar7 = this.d;
                                cVar7.getClass();
                                i iVar3 = new i();
                                iVar3.c = 0;
                                iVar3.f609a = new g.c[]{r.c.f1168a};
                                iVar3.f610b = false;
                                iVar3.d = new o(i2, jVar4);
                                cVar7.b(2, iVar3.a());
                            }
                            this.c = null;
                        }
                    } else {
                        k.j jVar5 = this.c;
                        k.g gVar = xVar.f648a;
                        if (jVar5.f746b == null) {
                            jVar5.f746b = new ArrayList();
                        }
                        jVar5.f746b.add(gVar);
                    }
                }
                if (this.c == null) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(xVar.f648a);
                    this.c = new k.j(xVar.f649b, arrayList3);
                    r.e eVar3 = this.f604n;
                    eVar3.sendMessageDelayed(eVar3.obtainMessage(17), xVar.c);
                    return true;
                }
                return true;
            case 19:
                this.f595b = false;
                return true;
            default:
                return false;
        }
    }
}
