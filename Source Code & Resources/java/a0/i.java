package a0;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class i {
    public static final i d = new i("", "", false);

    /* renamed from: a, reason: collision with root package name */
    public final String f2a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3b;
    public final boolean c;

    static {
        new i("\n", "  ", true);
    }

    public i(String str, String str2, boolean z2) {
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!str2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.f2a = str;
        this.f3b = str2;
        this.c = z2;
    }
}
