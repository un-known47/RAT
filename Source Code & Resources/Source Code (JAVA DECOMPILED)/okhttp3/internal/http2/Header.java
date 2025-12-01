package okhttp3.internal.http2;

import kotlin.jvm.internal.j;
import o1.o;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class Header {
    public static final Companion Companion = new Companion(null);
    public static final o PSEUDO_PREFIX;
    public static final o RESPONSE_STATUS;
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final o TARGET_AUTHORITY;
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final o TARGET_METHOD;
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final o TARGET_PATH;
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final o TARGET_SCHEME;
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public final int hpackSize;
    public final o name;
    public final o value;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        o oVar = o.d;
        PSEUDO_PREFIX = g.g.e(":");
        RESPONSE_STATUS = g.g.e(RESPONSE_STATUS_UTF8);
        TARGET_METHOD = g.g.e(TARGET_METHOD_UTF8);
        TARGET_PATH = g.g.e(TARGET_PATH_UTF8);
        TARGET_SCHEME = g.g.e(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = g.g.e(TARGET_AUTHORITY_UTF8);
    }

    public Header(o name, o value) {
        j.e(name, "name");
        j.e(value, "value");
        this.name = name;
        this.value = value;
        this.hpackSize = value.d() + name.d() + 32;
    }

    public static /* synthetic */ Header copy$default(Header header, o oVar, o oVar2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            oVar = header.name;
        }
        if ((i2 & 2) != 0) {
            oVar2 = header.value;
        }
        return header.copy(oVar, oVar2);
    }

    public final o component1() {
        return this.name;
    }

    public final o component2() {
        return this.value;
    }

    public final Header copy(o name, o value) {
        j.e(name, "name");
        j.e(value, "value");
        return new Header(name, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return j.a(this.name, header.name) && j.a(this.value, header.value);
    }

    public int hashCode() {
        return this.value.hashCode() + (this.name.hashCode() * 31);
    }

    public String toString() {
        return this.name.r() + ": " + this.value.r();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(String name, String value) {
        this(g.g.e(name), g.g.e(value));
        j.e(name, "name");
        j.e(value, "value");
        o oVar = o.d;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(o name, String value) {
        this(name, g.g.e(value));
        j.e(name, "name");
        j.e(value, "value");
        o oVar = o.d;
    }
}
