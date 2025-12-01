package f1;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class i implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Pattern f476a;

    public i(String str) {
        Pattern patternCompile = Pattern.compile(str);
        kotlin.jvm.internal.j.d(patternCompile, "compile(...)");
        this.f476a = patternCompile;
    }

    public final h a(int i2, String input) {
        kotlin.jvm.internal.j.e(input, "input");
        Matcher matcherRegion = this.f476a.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i2, input.length());
        if (!matcherRegion.lookingAt()) {
            return null;
        }
        kotlin.jvm.internal.j.e(input, "input");
        h hVar = new h();
        hVar.f474a = matcherRegion;
        hVar.f475b = new g(hVar);
        return hVar;
    }

    public final String toString() {
        String string = this.f476a.toString();
        kotlin.jvm.internal.j.d(string, "toString(...)");
        return string;
    }
}
