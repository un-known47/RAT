package d0;

import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class p0 extends a0.b0 {
    @Override // a0.b0
    public final Object b(i0.a aVar) {
        if (aVar.X() == 9) {
            aVar.T();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(aVar.V(), "_");
        String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        Locale locale = (Locale) obj;
        bVar.R(locale == null ? null : locale.toString());
    }
}
