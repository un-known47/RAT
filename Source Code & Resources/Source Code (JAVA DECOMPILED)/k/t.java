package k;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class t extends r.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f764a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(com.google.android.gms.common.internal.a aVar, Looper looper) {
        super(looper, 1);
        this.f764a = aVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) throws ClassNotFoundException {
        Boolean bool;
        if (this.f764a.f249v.get() != message.arg1) {
            int i2 = message.what;
            if (i2 == 2 || i2 == 1 || i2 == 7) {
                p pVar = (p) message.obj;
                pVar.getClass();
                pVar.d();
                return;
            }
            return;
        }
        int i3 = message.what;
        if ((i3 == 1 || i3 == 7 || i3 == 4 || i3 == 5) && !this.f764a.g()) {
            p pVar2 = (p) message.obj;
            pVar2.getClass();
            pVar2.d();
            return;
        }
        int i4 = message.what;
        if (i4 == 4) {
            com.google.android.gms.common.internal.a aVar = this.f764a;
            aVar.f247s = new g.a(message.arg2);
            if (!aVar.f248t && !TextUtils.isEmpty(aVar.r()) && !TextUtils.isEmpty(null)) {
                try {
                    Class.forName(aVar.r());
                    com.google.android.gms.common.internal.a aVar2 = this.f764a;
                    if (!aVar2.f248t) {
                        aVar2.w(null, 3);
                        return;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            com.google.android.gms.common.internal.a aVar3 = this.f764a;
            g.a aVar4 = aVar3.f247s;
            if (aVar4 == null) {
                aVar4 = new g.a(8);
            }
            aVar3.f239i.a(aVar4);
            System.currentTimeMillis();
            return;
        }
        if (i4 == 5) {
            com.google.android.gms.common.internal.a aVar5 = this.f764a;
            g.a aVar6 = aVar5.f247s;
            if (aVar6 == null) {
                aVar6 = new g.a(8);
            }
            aVar5.f239i.a(aVar6);
            System.currentTimeMillis();
            return;
        }
        if (i4 == 3) {
            Object obj = message.obj;
            this.f764a.f239i.a(new g.a(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null));
            System.currentTimeMillis();
            return;
        }
        if (i4 == 6) {
            this.f764a.w(null, 5);
            h hVar = this.f764a.f243n;
            if (hVar != null) {
                ((h.g) hVar.f741a).a(message.arg2);
            }
            System.currentTimeMillis();
            com.google.android.gms.common.internal.a.v(this.f764a, 5, 1, null);
            return;
        }
        if (i4 == 2 && !this.f764a.a()) {
            p pVar3 = (p) message.obj;
            pVar3.getClass();
            pVar3.d();
            return;
        }
        int i5 = message.what;
        if (i5 != 2 && i5 != 1 && i5 != 7) {
            new Exception();
            return;
        }
        p pVar4 = (p) message.obj;
        synchronized (pVar4) {
            try {
                bool = pVar4.f757a;
                if (pVar4.f758b) {
                    pVar4.toString();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            com.google.android.gms.common.internal.a aVar7 = pVar4.f760f;
            int i6 = pVar4.d;
            if (i6 != 0) {
                aVar7.w(null, 1);
                Bundle bundle = pVar4.f759e;
                pVar4.a(new g.a(i6, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
            } else if (!pVar4.b()) {
                aVar7.w(null, 1);
                pVar4.a(new g.a(8, null));
            }
        }
        synchronized (pVar4) {
            pVar4.f758b = true;
        }
        pVar4.d();
    }
}
