package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Scope;
import g.c;
import g.d;
import g.e;
import h.b;
import h.g;
import i.m;
import i.o;
import i.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import k.c0;
import k.d0;
import k.e0;
import k.f;
import k.h;
import k.r;
import k.s;
import k.t;
import k.u;
import k.v;
import k.w;
import k.x;
import k.y;
import k.z;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class a implements b {

    /* renamed from: x, reason: collision with root package name */
    public static final c[] f232x = new c[0];

    /* renamed from: a, reason: collision with root package name */
    public volatile String f233a;

    /* renamed from: b, reason: collision with root package name */
    public d0 f234b;
    public final Context c;
    public final c0 d;

    /* renamed from: e, reason: collision with root package name */
    public final t f235e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f236f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f237g;

    /* renamed from: h, reason: collision with root package name */
    public r f238h;

    /* renamed from: i, reason: collision with root package name */
    public k.b f239i;
    public IInterface j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f240k;

    /* renamed from: l, reason: collision with root package name */
    public v f241l;

    /* renamed from: m, reason: collision with root package name */
    public int f242m;

    /* renamed from: n, reason: collision with root package name */
    public final h f243n;
    public final h o;

    /* renamed from: p, reason: collision with root package name */
    public final int f244p;

    /* renamed from: q, reason: collision with root package name */
    public final String f245q;

    /* renamed from: r, reason: collision with root package name */
    public volatile String f246r;

    /* renamed from: s, reason: collision with root package name */
    public g.a f247s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f248t;
    public volatile y u;

    /* renamed from: v, reason: collision with root package name */
    public final AtomicInteger f249v;

    /* renamed from: w, reason: collision with root package name */
    public final Set f250w;

    public a(Context context, Looper looper, int i2, k.c cVar, g gVar, h.h hVar, int i3) {
        synchronized (c0.f707g) {
            try {
                if (c0.f708h == null) {
                    c0.f708h = new c0(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        c0 c0Var = c0.f708h;
        Object obj = d.f485b;
        s.b(gVar);
        s.b(hVar);
        h hVar2 = new h(gVar);
        h hVar3 = new h(hVar);
        String str = cVar.d;
        this.f233a = null;
        this.f236f = new Object();
        this.f237g = new Object();
        this.f240k = new ArrayList();
        this.f242m = 1;
        this.f247s = null;
        this.f248t = false;
        this.u = null;
        this.f249v = new AtomicInteger(0);
        s.c(context, "Context must not be null");
        this.c = context;
        s.c(looper, "Looper must not be null");
        s.c(c0Var, "Supervisor must not be null");
        this.d = c0Var;
        this.f235e = new t(this, looper);
        this.f244p = i2;
        this.f243n = hVar2;
        this.o = hVar3;
        this.f245q = str;
        Set set = cVar.f704b;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.f250w = set;
    }

    public static /* bridge */ /* synthetic */ void u(a aVar) {
        int i2;
        int i3;
        synchronized (aVar.f236f) {
            i2 = aVar.f242m;
        }
        if (i2 == 3) {
            aVar.f248t = true;
            i3 = 5;
        } else {
            i3 = 4;
        }
        t tVar = aVar.f235e;
        tVar.sendMessage(tVar.obtainMessage(i3, aVar.f249v.get(), 16));
    }

    public static /* bridge */ /* synthetic */ boolean v(a aVar, int i2, int i3, IInterface iInterface) {
        synchronized (aVar.f236f) {
            try {
                if (aVar.f242m != i2) {
                    return false;
                }
                aVar.w(iInterface, i3);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // h.b
    public final boolean a() {
        boolean z2;
        synchronized (this.f236f) {
            z2 = this.f242m == 4;
        }
        return z2;
    }

    @Override // h.b
    public final void b(f fVar, Set set) {
        Bundle bundleP = p();
        String str = this.f246r;
        int i2 = e.f486a;
        Scope[] scopeArr = k.e.o;
        Bundle bundle = new Bundle();
        int i3 = this.f244p;
        c[] cVarArr = k.e.f720p;
        k.e eVar = new k.e(6, i3, i2, null, null, scopeArr, bundle, null, cVarArr, cVarArr, true, 0, false, str);
        eVar.d = this.c.getPackageName();
        eVar.f725g = bundleP;
        if (set != null) {
            eVar.f724f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (m()) {
            eVar.f726h = new Account("<<default account>>", "com.google");
            if (fVar != null) {
                eVar.f723e = ((e0) fVar).f732a;
            }
        }
        eVar.f727i = f232x;
        eVar.j = o();
        if (this instanceof t.a) {
            eVar.f730m = true;
        }
        try {
            try {
                synchronized (this.f237g) {
                    try {
                        r rVar = this.f238h;
                        if (rVar != null) {
                            rVar.a(new u(this, this.f249v.get()), eVar);
                        }
                    } finally {
                    }
                }
            } catch (DeadObjectException unused) {
                int i4 = this.f249v.get();
                t tVar = this.f235e;
                tVar.sendMessage(tVar.obtainMessage(6, i4, 3));
            } catch (SecurityException e2) {
                throw e2;
            }
        } catch (RemoteException | RuntimeException unused2) {
            int i5 = this.f249v.get();
            w wVar = new w(this, 8, null, null);
            t tVar2 = this.f235e;
            tVar2.sendMessage(tVar2.obtainMessage(1, i5, -1, wVar));
        }
    }

    @Override // h.b
    public final Set c() {
        return m() ? this.f250w : Collections.EMPTY_SET;
    }

    @Override // h.b
    public final void d(k.b bVar) {
        this.f239i = bVar;
        w(null, 2);
    }

    @Override // h.b
    public final void e(String str) {
        this.f233a = str;
        l();
    }

    @Override // h.b
    public final boolean g() {
        boolean z2;
        synchronized (this.f236f) {
            int i2 = this.f242m;
            z2 = true;
            if (i2 != 2 && i2 != 3) {
                z2 = false;
            }
        }
        return z2;
    }

    @Override // h.b
    public final c[] h() {
        y yVar = this.u;
        if (yVar == null) {
            return null;
        }
        return yVar.f772b;
    }

    @Override // h.b
    public final void i() {
        if (!a() || this.f234b == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
    }

    @Override // h.b
    public final String j() {
        return this.f233a;
    }

    @Override // h.b
    public final void k(o oVar) {
        ((p) oVar.f623b).f633m.f604n.post(new m(1, oVar));
    }

    @Override // h.b
    public final void l() {
        this.f249v.incrementAndGet();
        synchronized (this.f240k) {
            try {
                int size = this.f240k.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((k.p) this.f240k.get(i2)).c();
                }
                this.f240k.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f237g) {
            this.f238h = null;
        }
        w(null, 1);
    }

    @Override // h.b
    public boolean m() {
        return false;
    }

    public abstract IInterface n(IBinder iBinder);

    public c[] o() {
        return f232x;
    }

    public Bundle p() {
        return new Bundle();
    }

    public final IInterface q() {
        IInterface iInterface;
        synchronized (this.f236f) {
            try {
                if (this.f242m == 5) {
                    throw new DeadObjectException();
                }
                if (!a()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                iInterface = this.j;
                s.c(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public abstract String r();

    public abstract String s();

    public boolean t() {
        return f() >= 211700000;
    }

    public final void w(IInterface iInterface, int i2) {
        d0 d0Var;
        if ((i2 == 4) != (iInterface != null)) {
            throw new IllegalArgumentException();
        }
        synchronized (this.f236f) {
            try {
                this.f242m = i2;
                this.j = iInterface;
                if (i2 == 1) {
                    v vVar = this.f241l;
                    if (vVar != null) {
                        c0 c0Var = this.d;
                        String str = (String) this.f234b.f719b;
                        s.b(str);
                        this.f234b.getClass();
                        if (this.f245q == null) {
                            this.c.getClass();
                        }
                        c0Var.b(str, vVar, this.f234b.f718a);
                        this.f241l = null;
                    }
                } else if (i2 == 2 || i2 == 3) {
                    v vVar2 = this.f241l;
                    if (vVar2 != null && (d0Var = this.f234b) != null) {
                        String str2 = (String) d0Var.f719b;
                        c0 c0Var2 = this.d;
                        s.b(str2);
                        this.f234b.getClass();
                        if (this.f245q == null) {
                            this.c.getClass();
                        }
                        c0Var2.b(str2, vVar2, this.f234b.f718a);
                        this.f249v.incrementAndGet();
                    }
                    v vVar3 = new v(this, this.f249v.get());
                    this.f241l = vVar3;
                    String strS = s();
                    boolean zT = t();
                    d0 d0Var2 = new d0();
                    d0Var2.f719b = strS;
                    d0Var2.f718a = zT;
                    this.f234b = d0Var2;
                    if (zT && f() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf((String) this.f234b.f719b)));
                    }
                    c0 c0Var3 = this.d;
                    String str3 = (String) this.f234b.f719b;
                    s.b(str3);
                    this.f234b.getClass();
                    String name = this.f245q;
                    if (name == null) {
                        name = this.c.getClass().getName();
                    }
                    if (!c0Var3.c(new z(str3, this.f234b.f718a), vVar3, name)) {
                        Object obj = this.f234b.f719b;
                        int i3 = this.f249v.get();
                        x xVar = new x(this, 16);
                        t tVar = this.f235e;
                        tVar.sendMessage(tVar.obtainMessage(7, i3, -1, xVar));
                    }
                } else if (i2 == 4) {
                    s.b(iInterface);
                    System.currentTimeMillis();
                }
            } finally {
            }
        }
    }
}
