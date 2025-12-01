package f;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a {
    public static final ReentrantLock c = new ReentrantLock();
    public static a d;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantLock f452a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f453b;

    public a(Context context) {
        this.f453b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public final String a(String str) {
        ReentrantLock reentrantLock = this.f452a;
        reentrantLock.lock();
        try {
            return this.f453b.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }
}
