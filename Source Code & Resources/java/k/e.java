package k;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Scope;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class e extends l.a {

    @NonNull
    public static final Parcelable.Creator<e> CREATOR = new e.a(13);
    public static final Scope[] o = new Scope[0];

    /* renamed from: p, reason: collision with root package name */
    public static final g.c[] f720p = new g.c[0];

    /* renamed from: a, reason: collision with root package name */
    public final int f721a;

    /* renamed from: b, reason: collision with root package name */
    public final int f722b;
    public final int c;
    public String d;

    /* renamed from: e, reason: collision with root package name */
    public IBinder f723e;

    /* renamed from: f, reason: collision with root package name */
    public Scope[] f724f;

    /* renamed from: g, reason: collision with root package name */
    public Bundle f725g;

    /* renamed from: h, reason: collision with root package name */
    public Account f726h;

    /* renamed from: i, reason: collision with root package name */
    public g.c[] f727i;
    public g.c[] j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f728k;

    /* renamed from: l, reason: collision with root package name */
    public final int f729l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f730m;

    /* renamed from: n, reason: collision with root package name */
    public final String f731n;

    public e(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, g.c[] cVarArr, g.c[] cVarArr2, boolean z2, int i5, boolean z3, String str2) {
        scopeArr = scopeArr == null ? o : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        g.c[] cVarArr3 = f720p;
        cVarArr = cVarArr == null ? cVarArr3 : cVarArr;
        cVarArr2 = cVarArr2 == null ? cVarArr3 : cVarArr2;
        this.f721a = i2;
        this.f722b = i3;
        this.c = i4;
        if ("com.google.android.gms".equals(str)) {
            this.d = "com.google.android.gms";
        } else {
            this.d = str;
        }
        if (i2 < 2) {
            Account accountA = null;
            if (iBinder != null) {
                int i6 = a.f696b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                f e0Var = iInterfaceQueryLocalInterface instanceof f ? (f) iInterfaceQueryLocalInterface : new e0(iBinder);
                long jClearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    accountA = ((e0) e0Var).a();
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                    throw th;
                }
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
            this.f726h = accountA;
        } else {
            this.f723e = iBinder;
            this.f726h = account;
        }
        this.f724f = scopeArr;
        this.f725g = bundle;
        this.f727i = cVarArr;
        this.j = cVarArr2;
        this.f728k = z2;
        this.f729l = i5;
        this.f730m = z3;
        this.f731n = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        e.a.a(this, parcel, i2);
    }
}
