package okhttp3.internal;

import kotlin.jvm.internal.j;
import okhttp3.CacheControl;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class _CacheControlCommonKt {
    public static final CacheControl commonBuild(CacheControl.Builder builder) {
        j.e(builder, "<this>");
        return new CacheControl(builder.getNoCache$okhttp(), builder.getNoStore$okhttp(), builder.getMaxAgeSeconds$okhttp(), -1, false, false, false, builder.getMaxStaleSeconds$okhttp(), builder.getMinFreshSeconds$okhttp(), builder.getOnlyIfCached$okhttp(), builder.getNoTransform$okhttp(), builder.getImmutable$okhttp(), null);
    }

    public static final int commonClampToInt(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0061 A[PHI: r3
  0x0061: PHI (r3v4 long) = (r3v2 long), (r3v3 long) binds: [B:11:0x005f, B:14:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final okhttp3.CacheControl commonForceCache(okhttp3.CacheControl.Companion r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.j.e(r10, r0)
            okhttp3.CacheControl$Builder r10 = new okhttp3.CacheControl$Builder
            r10.<init>()
            okhttp3.CacheControl$Builder r10 = r10.onlyIfCached()
            int r0 = g1.a.c
            g1.c r0 = g1.c.d
            java.lang.String r1 = "unit"
            kotlin.jvm.internal.j.e(r0, r1)
            int r1 = r0.compareTo(r0)
            r2 = 1
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r1 > 0) goto L2c
            long r3 = (long) r3
            g1.c r1 = g1.c.f511b
            long r0 = p.a.l(r3, r0, r1)
            long r0 = r0 << r2
            int r2 = g1.b.f510a
            goto L73
        L2c:
            long r3 = (long) r3
            g1.c r1 = g1.c.f511b
            r5 = 4611686018426999999(0x3ffffffffffa14bf, double:1.9999999999138678)
            long r5 = p.a.l(r5, r1, r0)
            long r7 = -r5
            int r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r9 > 0) goto L49
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L49
            long r0 = p.a.l(r3, r0, r1)
            long r0 = r0 << r2
            int r2 = g1.b.f510a
            goto L73
        L49:
            g1.c r1 = g1.c.c
            java.lang.String r5 = "targetUnit"
            kotlin.jvm.internal.j.e(r1, r5)
            java.util.concurrent.TimeUnit r1 = r1.f512a
            java.util.concurrent.TimeUnit r0 = r0.f512a
            long r0 = r1.convert(r3, r0)
            r3 = -4611686018427387903(0xc000000000000001, double:-2.0000000000000004)
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 >= 0) goto L63
        L61:
            r0 = r3
            goto L6d
        L63:
            r3 = 4611686018427387903(0x3fffffffffffffff, double:1.9999999999999998)
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 <= 0) goto L6d
            goto L61
        L6d:
            long r0 = r0 << r2
            r2 = 1
            long r0 = r0 + r2
            int r2 = g1.b.f510a
        L73:
            okhttp3.CacheControl$Builder r10 = r10.m109maxStaleLRDsOJo(r0)
            okhttp3.CacheControl r10 = r10.build()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._CacheControlCommonKt.commonForceCache(okhttp3.CacheControl$Companion):okhttp3.CacheControl");
    }

    public static final CacheControl commonForceNetwork(CacheControl.Companion companion) {
        j.e(companion, "<this>");
        return new CacheControl.Builder().noCache().build();
    }

    public static final CacheControl.Builder commonImmutable(CacheControl.Builder builder) {
        j.e(builder, "<this>");
        builder.setImmutable$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonNoCache(CacheControl.Builder builder) {
        j.e(builder, "<this>");
        builder.setNoCache$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonNoStore(CacheControl.Builder builder) {
        j.e(builder, "<this>");
        builder.setNoStore$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonNoTransform(CacheControl.Builder builder) {
        j.e(builder, "<this>");
        builder.setNoTransform$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonOnlyIfCached(CacheControl.Builder builder) {
        j.e(builder, "<this>");
        builder.setOnlyIfCached$okhttp(true);
        return builder;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00c9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final okhttp3.CacheControl commonParse(okhttp3.CacheControl.Companion r23, okhttp3.Headers r24) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._CacheControlCommonKt.commonParse(okhttp3.CacheControl$Companion, okhttp3.Headers):okhttp3.CacheControl");
    }

    public static final String commonToString(CacheControl cacheControl) {
        j.e(cacheControl, "<this>");
        String headerValue$okhttp = cacheControl.getHeaderValue$okhttp();
        if (headerValue$okhttp != null) {
            return headerValue$okhttp;
        }
        StringBuilder sb = new StringBuilder();
        if (cacheControl.noCache()) {
            sb.append("no-cache, ");
        }
        if (cacheControl.noStore()) {
            sb.append("no-store, ");
        }
        if (cacheControl.maxAgeSeconds() != -1) {
            sb.append("max-age=");
            sb.append(cacheControl.maxAgeSeconds());
            sb.append(", ");
        }
        if (cacheControl.sMaxAgeSeconds() != -1) {
            sb.append("s-maxage=");
            sb.append(cacheControl.sMaxAgeSeconds());
            sb.append(", ");
        }
        if (cacheControl.isPrivate()) {
            sb.append("private, ");
        }
        if (cacheControl.isPublic()) {
            sb.append("public, ");
        }
        if (cacheControl.mustRevalidate()) {
            sb.append("must-revalidate, ");
        }
        if (cacheControl.maxStaleSeconds() != -1) {
            sb.append("max-stale=");
            sb.append(cacheControl.maxStaleSeconds());
            sb.append(", ");
        }
        if (cacheControl.minFreshSeconds() != -1) {
            sb.append("min-fresh=");
            sb.append(cacheControl.minFreshSeconds());
            sb.append(", ");
        }
        if (cacheControl.onlyIfCached()) {
            sb.append("only-if-cached, ");
        }
        if (cacheControl.noTransform()) {
            sb.append("no-transform, ");
        }
        if (cacheControl.immutable()) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        j.d(sb.delete(sb.length() - 2, sb.length()), "delete(...)");
        String string = sb.toString();
        cacheControl.setHeaderValue$okhttp(string);
        return string;
    }

    private static final int indexOfElement(String str, String str2, int i2) {
        int length = str.length();
        while (i2 < length) {
            if (f1.j.q0(str2, str.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfElement$default(String str, String str2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return indexOfElement(str, str2, i2);
    }
}
