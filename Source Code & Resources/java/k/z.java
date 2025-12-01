package k;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Arrays;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class z {
    public static final Uri d = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: a, reason: collision with root package name */
    public final String f773a;

    /* renamed from: b, reason: collision with root package name */
    public final String f774b;
    public final boolean c;

    public z(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        this.f773a = str;
        if (TextUtils.isEmpty("com.google.android.gms")) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        this.f774b = "com.google.android.gms";
        this.c = z2;
    }

    public final Intent a(Context context) {
        Bundle bundleCall;
        String str = this.f773a;
        if (str == null) {
            return new Intent().setComponent(null);
        }
        if (this.c) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", str);
            try {
                bundleCall = context.getContentResolver().call(d, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e2) {
                "Dynamic intent resolution failed: ".concat(e2.toString());
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                "Dynamic lookup for intent failed for action: ".concat(String.valueOf(str));
            }
        }
        return intent == null ? new Intent(str).setPackage(this.f774b) : intent;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return s.d(this.f773a, zVar.f773a) && s.d(this.f774b, zVar.f774b) && s.d(null, null) && this.c == zVar.c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f773a, this.f774b, null, 4225, Boolean.valueOf(this.c)});
    }

    public final String toString() {
        String str = this.f773a;
        if (str != null) {
            return str;
        }
        s.b(null);
        throw null;
    }
}
