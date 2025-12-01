package okhttp3;

import androidx.appcompat.app.g;
import java.nio.charset.Charset;
import kotlin.jvm.internal.j;
import o1.o;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    public static final String basic(String username, String password) {
        j.e(username, "username");
        j.e(password, "password");
        return basic$default(username, password, null, 4, null);
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset charset, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            charset = f1.a.d;
        }
        return basic(str, str2, charset);
    }

    public static final String basic(String username, String password, Charset charset) {
        j.e(username, "username");
        j.e(password, "password");
        j.e(charset, "charset");
        String str = username + ':' + password;
        o oVar = o.d;
        j.e(str, "<this>");
        byte[] bytes = str.getBytes(charset);
        j.d(bytes, "getBytes(...)");
        return g.v("Basic ", new o(bytes).a());
    }
}
