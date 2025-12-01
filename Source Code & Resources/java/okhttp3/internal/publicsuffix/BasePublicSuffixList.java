package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.j;
import o1.b;
import o1.k0;
import o1.o;
import o1.p0;
import okhttp3.internal.platform.Platform;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class BasePublicSuffixList implements PublicSuffixList {
    public o bytes;
    public o exceptionBytes;
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    private final void readTheList() {
        try {
            k0 k0VarC = b.c(listSource());
            try {
                o oVarH = k0VarC.h(k0VarC.readInt());
                o oVarH2 = k0VarC.h(k0VarC.readInt());
                k0VarC.close();
                synchronized (this) {
                    j.b(oVarH);
                    setBytes(oVarH);
                    j.b(oVarH2);
                    setExceptionBytes(oVarH2);
                }
            } finally {
            }
        } finally {
            this.readCompleteLatch.countDown();
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z2 = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z2 = true;
                } catch (IOException e2) {
                    Platform.Companion.get().log("Failed to read public suffix list", 5, e2);
                    if (!z2) {
                        return;
                    }
                }
            } finally {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @Override // okhttp3.internal.publicsuffix.PublicSuffixList
    public void ensureLoaded() throws InterruptedException {
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (this.bytes != null) {
            return;
        }
        throw new IllegalStateException(("Unable to load " + getPath() + " resource.").toString());
    }

    @Override // okhttp3.internal.publicsuffix.PublicSuffixList
    public o getBytes() {
        o oVar = this.bytes;
        if (oVar != null) {
            return oVar;
        }
        j.i("bytes");
        throw null;
    }

    @Override // okhttp3.internal.publicsuffix.PublicSuffixList
    public o getExceptionBytes() {
        o oVar = this.exceptionBytes;
        if (oVar != null) {
            return oVar;
        }
        j.i("exceptionBytes");
        throw null;
    }

    public abstract Object getPath();

    public abstract p0 listSource();

    public void setBytes(o oVar) {
        j.e(oVar, "<set-?>");
        this.bytes = oVar;
    }

    public void setExceptionBytes(o oVar) {
        j.e(oVar, "<set-?>");
        this.exceptionBytes = oVar;
    }
}
