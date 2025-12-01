package q1;

import okhttp3.Request;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public interface d<T> extends Cloneable {
    void D(g gVar);

    void cancel();

    /* renamed from: clone */
    d mo240clone();

    s0 execute();

    boolean isCanceled();

    Request request();
}
