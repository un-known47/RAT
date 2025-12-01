package okhttp3;

import androidx.appcompat.app.g;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import okhttp3.internal._CacheControlCommonKt;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class CacheControl {
    public static final Companion Companion;
    public static final CacheControl FORCE_CACHE;
    public static final CacheControl FORCE_NETWORK;
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        public final CacheControl build() {
            return _CacheControlCommonKt.commonBuild(this);
        }

        public final boolean getImmutable$okhttp() {
            return this.immutable;
        }

        public final int getMaxAgeSeconds$okhttp() {
            return this.maxAgeSeconds;
        }

        public final int getMaxStaleSeconds$okhttp() {
            return this.maxStaleSeconds;
        }

        public final int getMinFreshSeconds$okhttp() {
            return this.minFreshSeconds;
        }

        public final boolean getNoCache$okhttp() {
            return this.noCache;
        }

        public final boolean getNoStore$okhttp() {
            return this.noStore;
        }

        public final boolean getNoTransform$okhttp() {
            return this.noTransform;
        }

        public final boolean getOnlyIfCached$okhttp() {
            return this.onlyIfCached;
        }

        public final Builder immutable() {
            return _CacheControlCommonKt.commonImmutable(this);
        }

        public final Builder maxAge(int i2, TimeUnit timeUnit) {
            j.e(timeUnit, "timeUnit");
            if (i2 < 0) {
                throw new IllegalArgumentException(g.c(i2, "maxAge < 0: ").toString());
            }
            this.maxAgeSeconds = _CacheControlCommonKt.commonClampToInt(timeUnit.toSeconds(i2));
            return this;
        }

        /* renamed from: maxAge-LRDsOJo, reason: not valid java name */
        public final Builder m108maxAgeLRDsOJo(long j) {
            int i2 = g1.a.c;
            long jA = g1.a.a(j, g1.c.d);
            if (jA < 0) {
                throw new IllegalArgumentException(g.f("maxAge < 0: ", jA).toString());
            }
            this.maxAgeSeconds = _CacheControlCommonKt.commonClampToInt(jA);
            return this;
        }

        public final Builder maxStale(int i2, TimeUnit timeUnit) {
            j.e(timeUnit, "timeUnit");
            if (i2 < 0) {
                throw new IllegalArgumentException(g.c(i2, "maxStale < 0: ").toString());
            }
            this.maxStaleSeconds = _CacheControlCommonKt.commonClampToInt(timeUnit.toSeconds(i2));
            return this;
        }

        /* renamed from: maxStale-LRDsOJo, reason: not valid java name */
        public final Builder m109maxStaleLRDsOJo(long j) {
            int i2 = g1.a.c;
            long jA = g1.a.a(j, g1.c.d);
            if (jA < 0) {
                throw new IllegalArgumentException(g.f("maxStale < 0: ", jA).toString());
            }
            this.maxStaleSeconds = _CacheControlCommonKt.commonClampToInt(jA);
            return this;
        }

        public final Builder minFresh(int i2, TimeUnit timeUnit) {
            j.e(timeUnit, "timeUnit");
            if (i2 < 0) {
                throw new IllegalArgumentException(g.c(i2, "minFresh < 0: ").toString());
            }
            this.minFreshSeconds = _CacheControlCommonKt.commonClampToInt(timeUnit.toSeconds(i2));
            return this;
        }

        /* renamed from: minFresh-LRDsOJo, reason: not valid java name */
        public final Builder m110minFreshLRDsOJo(long j) {
            int i2 = g1.a.c;
            long jA = g1.a.a(j, g1.c.d);
            if (jA < 0) {
                throw new IllegalArgumentException(g.f("minFresh < 0: ", jA).toString());
            }
            this.minFreshSeconds = _CacheControlCommonKt.commonClampToInt(jA);
            return this;
        }

        public final Builder noCache() {
            return _CacheControlCommonKt.commonNoCache(this);
        }

        public final Builder noStore() {
            return _CacheControlCommonKt.commonNoStore(this);
        }

        public final Builder noTransform() {
            return _CacheControlCommonKt.commonNoTransform(this);
        }

        public final Builder onlyIfCached() {
            return _CacheControlCommonKt.commonOnlyIfCached(this);
        }

        public final void setImmutable$okhttp(boolean z2) {
            this.immutable = z2;
        }

        public final void setMaxAgeSeconds$okhttp(int i2) {
            this.maxAgeSeconds = i2;
        }

        public final void setMaxStaleSeconds$okhttp(int i2) {
            this.maxStaleSeconds = i2;
        }

        public final void setMinFreshSeconds$okhttp(int i2) {
            this.minFreshSeconds = i2;
        }

        public final void setNoCache$okhttp(boolean z2) {
            this.noCache = z2;
        }

        public final void setNoStore$okhttp(boolean z2) {
            this.noStore = z2;
        }

        public final void setNoTransform$okhttp(boolean z2) {
            this.noTransform = z2;
        }

        public final void setOnlyIfCached$okhttp(boolean z2) {
            this.onlyIfCached = z2;
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final CacheControl parse(Headers headers) {
            j.e(headers, "headers");
            return _CacheControlCommonKt.commonParse(this, headers);
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        FORCE_NETWORK = _CacheControlCommonKt.commonForceNetwork(companion);
        FORCE_CACHE = _CacheControlCommonKt.commonForceCache(companion);
    }

    public CacheControl(boolean z2, boolean z3, int i2, int i3, boolean z4, boolean z5, boolean z6, int i4, int i5, boolean z7, boolean z8, boolean z9, String str) {
        this.noCache = z2;
        this.noStore = z3;
        this.maxAgeSeconds = i2;
        this.sMaxAgeSeconds = i3;
        this.isPrivate = z4;
        this.isPublic = z5;
        this.mustRevalidate = z6;
        this.maxStaleSeconds = i4;
        this.minFreshSeconds = i5;
        this.onlyIfCached = z7;
        this.noTransform = z8;
        this.immutable = z9;
        this.headerValue = str;
    }

    public static final CacheControl parse(Headers headers) {
        return Companion.parse(headers);
    }

    /* renamed from: -deprecated_immutable, reason: not valid java name */
    public final boolean m98deprecated_immutable() {
        return this.immutable;
    }

    /* renamed from: -deprecated_maxAgeSeconds, reason: not valid java name */
    public final int m99deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    /* renamed from: -deprecated_maxStaleSeconds, reason: not valid java name */
    public final int m100deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    /* renamed from: -deprecated_minFreshSeconds, reason: not valid java name */
    public final int m101deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    /* renamed from: -deprecated_mustRevalidate, reason: not valid java name */
    public final boolean m102deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    /* renamed from: -deprecated_noCache, reason: not valid java name */
    public final boolean m103deprecated_noCache() {
        return this.noCache;
    }

    /* renamed from: -deprecated_noStore, reason: not valid java name */
    public final boolean m104deprecated_noStore() {
        return this.noStore;
    }

    /* renamed from: -deprecated_noTransform, reason: not valid java name */
    public final boolean m105deprecated_noTransform() {
        return this.noTransform;
    }

    /* renamed from: -deprecated_onlyIfCached, reason: not valid java name */
    public final boolean m106deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    /* renamed from: -deprecated_sMaxAgeSeconds, reason: not valid java name */
    public final int m107deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final String getHeaderValue$okhttp() {
        return this.headerValue;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final void setHeaderValue$okhttp(String str) {
        this.headerValue = str;
    }

    public String toString() {
        return _CacheControlCommonKt.commonToString(this);
    }
}
