package k;

import android.os.Bundle;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public Boolean f757a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f758b;
    public final /* synthetic */ com.google.android.gms.common.internal.a c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f759e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f760f;

    public p(com.google.android.gms.common.internal.a aVar, int i2, Bundle bundle) {
        this.f760f = aVar;
        Boolean bool = Boolean.TRUE;
        this.c = aVar;
        this.f757a = bool;
        this.f758b = false;
        this.d = i2;
        this.f759e = bundle;
    }

    public abstract void a(g.a aVar);

    public abstract boolean b();

    public final void c() {
        synchronized (this) {
            this.f757a = null;
        }
    }

    public final void d() {
        c();
        synchronized (this.c.f240k) {
            this.c.f240k.remove(this);
        }
    }
}
