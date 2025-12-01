package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f146a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f147b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a(Object obj, int i2, Object obj2, int i3) {
        this.f146a = i3;
        this.f147b = obj;
        this.c = i2;
        this.d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f146a) {
            case 0:
                ((ProfileInstaller.DiagnosticsCallback) this.f147b).onResultReceived(this.c, this.d);
                break;
            case 1:
                ((ProfileInstaller.DiagnosticsCallback) this.f147b).onDiagnosticReceived(this.c, this.d);
                break;
            default:
                ((DeviceProfileWriter) this.f147b).lambda$result$0(this.c, this.d);
                break;
        }
    }
}
