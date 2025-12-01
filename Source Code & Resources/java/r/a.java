package r;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f1165a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1166b;

    public a(IBinder iBinder, String str) {
        this.f1165a = iBinder;
        this.f1166b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1165a;
    }
}
