package k;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f697a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public int f698b = 2;
    public boolean c;
    public IBinder d;

    /* renamed from: e, reason: collision with root package name */
    public final z f699e;

    /* renamed from: f, reason: collision with root package name */
    public ComponentName f700f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c0 f701g;

    public a0(c0 c0Var, z zVar) {
        this.f701g = c0Var;
        this.f699e = zVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0072 A[Catch: all -> 0x0089, TryCatch #1 {all -> 0x0089, blocks: (B:5:0x001d, B:16:0x0059, B:19:0x0061, B:22:0x006e, B:24:0x0072, B:27:0x008b, B:28:0x008e, B:21:0x0067, B:8:0x0033, B:9:0x003c), top: B:36:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b A[Catch: all -> 0x0089, TRY_LEAVE, TryCatch #1 {all -> 0x0089, blocks: (B:5:0x001d, B:16:0x0059, B:19:0x0061, B:22:0x006e, B:24:0x0072, B:27:0x008b, B:28:0x008e, B:21:0x0067, B:8:0x0033, B:9:0x003c), top: B:36:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r6, java.util.concurrent.Executor r7) {
        /*
            r5 = this;
            r6 = 3
            r5.f698b = r6
            android.os.StrictMode$VmPolicy r6 = android.os.StrictMode.getVmPolicy()
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            if (r0 < r1) goto L1d
            android.os.StrictMode$VmPolicy$Builder r0 = new android.os.StrictMode$VmPolicy$Builder
            r0.<init>(r6)
            android.os.StrictMode$VmPolicy$Builder r0 = androidx.core.app.d.i(r0)
            android.os.StrictMode$VmPolicy r0 = r0.build()
            android.os.StrictMode.setVmPolicy(r0)
        L1d:
            k.c0 r0 = r5.f701g     // Catch: java.lang.Throwable -> L89
            n.a r1 = r0.d     // Catch: java.lang.Throwable -> L89
            android.content.Context r0 = r0.f711b     // Catch: java.lang.Throwable -> L89
            k.z r2 = r5.f699e     // Catch: java.lang.Throwable -> L89
            android.content.Intent r2 = r2.a(r0)     // Catch: java.lang.Throwable -> L89
            r1.getClass()     // Catch: java.lang.Throwable -> L89
            android.content.ComponentName r1 = r2.getComponent()     // Catch: java.lang.Throwable -> L89
            if (r1 != 0) goto L33
            goto L56
        L33:
            java.lang.String r1 = r1.getPackageName()     // Catch: java.lang.Throwable -> L89
            java.lang.String r3 = "com.google.android.gms"
            r3.equals(r1)     // Catch: java.lang.Throwable -> L89
            i.o r3 = p.b.a(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L55 java.lang.Throwable -> L89
            java.lang.Object r3 = r3.f623b     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L55 java.lang.Throwable -> L89
            android.content.Context r3 = (android.content.Context) r3     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L55 java.lang.Throwable -> L89
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L55 java.lang.Throwable -> L89
            r4 = 0
            android.content.pm.ApplicationInfo r1 = r3.getApplicationInfo(r1, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L55 java.lang.Throwable -> L89
            int r1 = r1.flags     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L55 java.lang.Throwable -> L89
            r3 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r3
            if (r1 == 0) goto L56
            goto L6e
        L55:
        L56:
            if (r7 != 0) goto L59
            r7 = 0
        L59:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L89
            r3 = 29
            if (r1 < r3) goto L67
            if (r7 == 0) goto L67
            boolean r7 = androidx.transition.f.n(r0, r2, r7, r5)     // Catch: java.lang.Throwable -> L89
        L65:
            r4 = r7
            goto L6e
        L67:
            r7 = 4225(0x1081, float:5.92E-42)
            boolean r7 = r0.bindService(r2, r5, r7)     // Catch: java.lang.Throwable -> L89
            goto L65
        L6e:
            r5.c = r4     // Catch: java.lang.Throwable -> L89
            if (r4 == 0) goto L8b
            k.c0 r7 = r5.f701g     // Catch: java.lang.Throwable -> L89
            r.e r7 = r7.c     // Catch: java.lang.Throwable -> L89
            k.z r0 = r5.f699e     // Catch: java.lang.Throwable -> L89
            r1 = 1
            android.os.Message r7 = r7.obtainMessage(r1, r0)     // Catch: java.lang.Throwable -> L89
            k.c0 r0 = r5.f701g     // Catch: java.lang.Throwable -> L89
            r.e r0 = r0.c     // Catch: java.lang.Throwable -> L89
            k.c0 r1 = r5.f701g     // Catch: java.lang.Throwable -> L89
            long r1 = r1.f713f     // Catch: java.lang.Throwable -> L89
            r0.sendMessageDelayed(r7, r1)     // Catch: java.lang.Throwable -> L89
            goto L97
        L89:
            r7 = move-exception
            goto L9b
        L8b:
            r7 = 2
            r5.f698b = r7     // Catch: java.lang.Throwable -> L89
            k.c0 r7 = r5.f701g     // Catch: java.lang.Throwable -> L89 java.lang.IllegalArgumentException -> L97
            n.a r0 = r7.d     // Catch: java.lang.Throwable -> L89 java.lang.IllegalArgumentException -> L97
            android.content.Context r7 = r7.f711b     // Catch: java.lang.Throwable -> L89 java.lang.IllegalArgumentException -> L97
            r0.a(r7, r5)     // Catch: java.lang.Throwable -> L89 java.lang.IllegalArgumentException -> L97
        L97:
            android.os.StrictMode.setVmPolicy(r6)
            return
        L9b:
            android.os.StrictMode.setVmPolicy(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a0.a(java.lang.String, java.util.concurrent.Executor):void");
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f701g.f710a) {
            try {
                this.f701g.c.removeMessages(1, this.f699e);
                this.d = iBinder;
                this.f700f = componentName;
                Iterator it = this.f697a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f698b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f701g.f710a) {
            try {
                this.f701g.c.removeMessages(1, this.f699e);
                this.d = null;
                this.f700f = componentName;
                Iterator it = this.f697a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f698b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
