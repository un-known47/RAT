package okhttp3.internal.ws;

import g.g;
import o1.o;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class MessageDeflaterKt {
    private static final o EMPTY_DEFLATE_BLOCK;
    private static final int LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION = 4;

    static {
        o oVar = o.d;
        EMPTY_DEFLATE_BLOCK = g.d("000000ffff");
    }
}
