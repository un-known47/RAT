package okhttp3.internal.publicsuffix;

import g.g;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import o1.h0;
import o1.p0;
import o1.u;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class ResourcePublicSuffixList extends BasePublicSuffixList {
    public static final Companion Companion = new Companion(null);
    public static final h0 PUBLIC_SUFFIX_RESOURCE;
    private final u fileSystem;
    private final h0 path;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String str = h0.f899b;
        PUBLIC_SUFFIX_RESOURCE = g.g("okhttp3/internal/publicsuffix/PublicSuffixDatabase.list");
    }

    public ResourcePublicSuffixList() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final u getFileSystem() {
        return this.fileSystem;
    }

    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    public p0 listSource() {
        return this.fileSystem.source(getPath());
    }

    public /* synthetic */ ResourcePublicSuffixList(h0 h0Var, u uVar, int i2, e eVar) {
        this((i2 & 1) != 0 ? PUBLIC_SUFFIX_RESOURCE : h0Var, (i2 & 2) != 0 ? u.RESOURCES : uVar);
    }

    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    public h0 getPath() {
        return this.path;
    }

    public ResourcePublicSuffixList(h0 path, u fileSystem) {
        j.e(path, "path");
        j.e(fileSystem, "fileSystem");
        this.path = path;
        this.fileSystem = fileSystem;
    }
}
