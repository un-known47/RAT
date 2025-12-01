package x;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import h.g;
import h.h;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a extends com.google.android.gms.common.internal.a implements h.b {
    public final Bundle A;
    public final Integer B;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f1202y;

    /* renamed from: z, reason: collision with root package name */
    public final k.c f1203z;

    public a(Context context, Looper looper, k.c cVar, Bundle bundle, g gVar, h hVar) {
        super(context, looper, 44, cVar, gVar, hVar, 0);
        this.f1202y = true;
        this.f1203z = cVar;
        this.A = bundle;
        this.B = cVar.f706f;
    }

    @Override // h.b
    public final int f() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.a, h.b
    public final boolean m() {
        return this.f1202y;
    }

    @Override // com.google.android.gms.common.internal.a
    public final IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof c ? (c) iInterfaceQueryLocalInterface : new c(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.common.internal.a
    public final Bundle p() {
        k.c cVar = this.f1203z;
        boolean zEquals = this.c.getPackageName().equals(cVar.c);
        Bundle bundle = this.A;
        if (!zEquals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", cVar.c);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.a
    public final String r() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String s() {
        return "com.google.android.gms.signin.service.START";
    }
}
