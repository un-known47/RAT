package g;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class i extends r.e {

    /* renamed from: a, reason: collision with root package name */
    public final Context f493a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f494b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d dVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper(), 0);
        this.f494b = dVar;
        this.f493a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) throws Resources.NotFoundException {
        if (message.what != 1) {
            return;
        }
        int i2 = e.f486a;
        d dVar = this.f494b;
        Context context = this.f493a;
        int iB = dVar.b(context, i2);
        AtomicBoolean atomicBoolean = f.f487a;
        if (iB == 1 || iB == 2 || iB == 3 || iB == 9) {
            Intent intentA = dVar.a(context, iB, "n");
            dVar.f(context, iB, intentA == null ? null : PendingIntent.getActivity(context, 0, intentA, s.c.f1179a | 134217728));
        }
    }
}
