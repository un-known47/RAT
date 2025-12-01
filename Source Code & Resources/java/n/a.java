package n;

import android.content.Context;
import java.util.NoSuchElementException;
import k.a0;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f872a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f873b;

    public final void a(Context context, a0 a0Var) {
        try {
            context.unbindService(a0Var);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }
}
