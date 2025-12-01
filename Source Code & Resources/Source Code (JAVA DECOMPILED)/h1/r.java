package h1;

import java.lang.Thread;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    public static final List f563a;

    static {
        try {
            Iterator it = Arrays.asList(new i1.b()).iterator();
            kotlin.jvm.internal.j.e(it, "<this>");
            f563a = e1.l.j0(new e1.a(new e1.m(1, it)));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }

    public static final void a(p0.i iVar, Throwable th) {
        Throwable runtimeException;
        Iterator it = f563a.iterator();
        while (it.hasNext()) {
            try {
                ((i1.b) it.next()).D(th);
            } catch (Throwable th2) {
                Thread threadCurrentThread = Thread.currentThread();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = threadCurrentThread.getUncaughtExceptionHandler();
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    p.a.b(runtimeException, th);
                }
                uncaughtExceptionHandler.uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        try {
            p.a.b(th, new y(iVar));
        } catch (Throwable th3) {
            p.a.p(th3);
        }
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }
}
