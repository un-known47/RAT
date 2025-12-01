package f1;

import java.nio.charset.Charset;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f458a;

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f459b;
    public static final Charset c;
    public static final Charset d;

    /* renamed from: e, reason: collision with root package name */
    public static volatile Charset f460e;

    /* renamed from: f, reason: collision with root package name */
    public static volatile Charset f461f;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        kotlin.jvm.internal.j.d(charsetForName, "forName(...)");
        f458a = charsetForName;
        kotlin.jvm.internal.j.d(Charset.forName("UTF-16"), "forName(...)");
        Charset charsetForName2 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.j.d(charsetForName2, "forName(...)");
        f459b = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.j.d(charsetForName3, "forName(...)");
        c = charsetForName3;
        kotlin.jvm.internal.j.d(Charset.forName("US-ASCII"), "forName(...)");
        Charset charsetForName4 = Charset.forName("ISO-8859-1");
        kotlin.jvm.internal.j.d(charsetForName4, "forName(...)");
        d = charsetForName4;
    }
}
