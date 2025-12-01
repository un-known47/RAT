package m;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import h.g;
import h.h;
import i.p;
import k.k;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b extends p.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f857g;

    @Override // p.a
    public h.b f(Context context, Looper looper, k.c cVar, Object obj, g gVar, h hVar) {
        switch (this.f857g) {
            case 1:
                if (obj == null) {
                    return new t.a(context, looper, 45, cVar, gVar, hVar, 0);
                }
                throw new ClassCastException();
            case 2:
                cVar.getClass();
                Integer num = cVar.f706f;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", null);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                return new x.a(context, looper, cVar, bundle, gVar, hVar);
            case 3:
                obj.getClass();
                throw new ClassCastException();
            default:
                return super.f(context, looper, cVar, obj, gVar, hVar);
        }
    }

    @Override // p.a
    public /* synthetic */ h.b g(Context context, Looper looper, k.c cVar, Object obj, p pVar, p pVar2) {
        switch (this.f857g) {
            case 0:
                return new d(context, looper, cVar, (k) obj, pVar, pVar2);
            default:
                return super.g(context, looper, cVar, obj, pVar, pVar2);
        }
    }
}
