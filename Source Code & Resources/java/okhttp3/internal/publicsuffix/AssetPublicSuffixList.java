package okhttp3.internal.publicsuffix;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import o1.b;
import o1.p0;
import okhttp3.internal.platform.PlatformRegistry;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class AssetPublicSuffixList extends BasePublicSuffixList {
    public static final Companion Companion = new Companion(null);
    private static final String PUBLIC_SUFFIX_RESOURCE = "PublicSuffixDatabase.list";
    private final String path;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final String getPUBLIC_SUFFIX_RESOURCE() {
            return AssetPublicSuffixList.PUBLIC_SUFFIX_RESOURCE;
        }

        private Companion() {
        }
    }

    public AssetPublicSuffixList() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    public p0 listSource() throws IOException {
        AssetManager assets;
        Context applicationContext = PlatformRegistry.INSTANCE.getApplicationContext();
        if (applicationContext == null || (assets = applicationContext.getAssets()) == null) {
            throw new IOException("Platform applicationContext not initialized");
        }
        InputStream inputStreamOpen = assets.open(getPath());
        j.d(inputStreamOpen, "open(...)");
        return b.i(inputStreamOpen);
    }

    public /* synthetic */ AssetPublicSuffixList(String str, int i2, e eVar) {
        this((i2 & 1) != 0 ? PUBLIC_SUFFIX_RESOURCE : str);
    }

    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    public String getPath() {
        return this.path;
    }

    public AssetPublicSuffixList(String path) {
        j.e(path, "path");
        this.path = path;
    }
}
