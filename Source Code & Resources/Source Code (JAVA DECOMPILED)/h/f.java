package h;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import androidx.collection.ArraySet;
import com.service.downloadapp.AppMainActivity;
import i.d0;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import k.s;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f518a;

    /* renamed from: b, reason: collision with root package name */
    public final String f519b;
    public final c c;
    public final a d;

    /* renamed from: e, reason: collision with root package name */
    public final i.a f520e;

    /* renamed from: f, reason: collision with root package name */
    public final int f521f;

    /* renamed from: g, reason: collision with root package name */
    public final g.g f522g;

    /* renamed from: h, reason: collision with root package name */
    public final i.c f523h;

    public f(Context context, AppMainActivity appMainActivity, c cVar, k.k kVar, e eVar) {
        d0 d0Var;
        s.c(context, "Null context is not permitted.");
        s.c(cVar, "Api must not be null.");
        s.c(eVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        s.c(applicationContext, "The provided context did not have an application context.");
        this.f518a = applicationContext;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : null;
        this.f519b = attributionTag;
        this.c = cVar;
        this.d = kVar;
        i.a aVar = new i.a(cVar, kVar, attributionTag);
        this.f520e = aVar;
        i.c cVarF = i.c.f(applicationContext);
        this.f523h = cVarF;
        this.f521f = cVarF.f599h.getAndIncrement();
        this.f522g = eVar.f517a;
        if (appMainActivity != null && Looper.myLooper() == Looper.getMainLooper()) {
            WeakHashMap weakHashMap = d0.d;
            WeakReference weakReference = (WeakReference) weakHashMap.get(appMainActivity);
            if (weakReference == null || (d0Var = (d0) weakReference.get()) == null) {
                try {
                    d0Var = (d0) appMainActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
                    if (d0Var == null || d0Var.isRemoving()) {
                        d0Var = new d0();
                        appMainActivity.getSupportFragmentManager().beginTransaction().add(d0Var, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
                    }
                    weakHashMap.put(appMainActivity, new WeakReference(d0Var));
                } catch (ClassCastException e2) {
                    throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e2);
                }
            }
            i.j jVar = (i.j) d0Var.a();
            if (jVar == null) {
                Object obj = g.d.f485b;
                jVar = new i.j(d0Var, cVarF);
            }
            jVar.f613f.add(aVar);
            cVarF.a(jVar);
        }
        r.e eVar2 = cVarF.f604n;
        eVar2.sendMessage(eVar2.obtainMessage(7, this));
    }

    public final f1.h a() {
        f1.h hVar = new f1.h();
        Set set = Collections.EMPTY_SET;
        if (((ArraySet) hVar.f474a) == null) {
            hVar.f474a = new ArraySet();
        }
        ((ArraySet) hVar.f474a).addAll(set);
        Context context = this.f518a;
        hVar.c = context.getClass().getName();
        hVar.f475b = context.getPackageName();
        return hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final y.g b(int r17, i.i r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            y.c r2 = new y.c
            r2.<init>()
            y.g r3 = r2.f1211a
            g.g r4 = r1.f522g
            i.c r6 = r1.f523h
            r.e r13 = r6.f604n
            int r7 = r0.c
            if (r7 == 0) goto L9f
            i.a r8 = r1.f520e
            boolean r5 = r6.b()
            if (r5 != 0) goto L1e
            goto L5b
        L1e:
            k.h r5 = k.h.b()
            java.lang.Object r5 = r5.f741a
            k.i r5 = (k.i) r5
            r9 = 1
            if (r5 == 0) goto L5d
            boolean r10 = r5.f743b
            if (r10 == 0) goto L5b
            boolean r5 = r5.c
            java.util.concurrent.ConcurrentHashMap r10 = r6.j
            java.lang.Object r10 = r10.get(r8)
            i.p r10 = (i.p) r10
            if (r10 == 0) goto L59
            h.b r11 = r10.f625b
            boolean r12 = r11 instanceof com.google.android.gms.common.internal.a
            if (r12 == 0) goto L5b
            com.google.android.gms.common.internal.a r11 = (com.google.android.gms.common.internal.a) r11
            k.y r12 = r11.u
            if (r12 == 0) goto L59
            boolean r12 = r11.g()
            if (r12 != 0) goto L59
            k.d r5 = i.w.b(r10, r11, r7)
            if (r5 == 0) goto L5b
            int r11 = r10.f632l
            int r11 = r11 + r9
            r10.f632l = r11
            boolean r9 = r5.c
            goto L5d
        L59:
            r9 = r5
            goto L5d
        L5b:
            r5 = 0
            goto L74
        L5d:
            i.w r5 = new i.w
            r10 = 0
            if (r9 == 0) goto L68
            long r14 = java.lang.System.currentTimeMillis()
            goto L69
        L68:
            r14 = r10
        L69:
            if (r9 == 0) goto L6f
            long r10 = android.os.SystemClock.elapsedRealtime()
        L6f:
            r11 = r10
            r9 = r14
            r5.<init>(r6, r7, r8, r9, r11)
        L74:
            if (r5 == 0) goto L9f
            r13.getClass()
            i.k r7 = new i.k
            r7.<init>(r13)
            r3.getClass()
            y.e r8 = new y.e
            r8.<init>(r7, r5)
            y.f r5 = r3.f1218b
            r5.a(r8)
            java.lang.Object r5 = r3.f1217a
            monitor-enter(r5)
            boolean r7 = r3.c     // Catch: java.lang.Throwable -> L94
            if (r7 != 0) goto L96
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L94
            goto L9f
        L94:
            r0 = move-exception
            goto L9d
        L96:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L94
            y.f r5 = r3.f1218b
            r5.b(r3)
            goto L9f
        L9d:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L94
            throw r0
        L9f:
            i.a0 r5 = new i.a0
            r7 = r17
            r5.<init>(r7, r0, r2, r4)
            java.util.concurrent.atomic.AtomicInteger r0 = r6.f600i
            i.y r2 = new i.y
            int r0 = r0.get()
            r2.<init>(r5, r0, r1)
            r0 = 4
            android.os.Message r0 = r13.obtainMessage(r0, r2)
            r13.sendMessage(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: h.f.b(int, i.i):y.g");
    }
}
