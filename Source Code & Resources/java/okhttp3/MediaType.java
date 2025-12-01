package okhttp3;

import f1.g;
import f1.h;
import f1.i;
import f1.q;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class MediaType {
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private final String mediaType;
    private final String[] parameterNamesAndValues;
    private final String subtype;
    private final String type;
    public static final Companion Companion = new Companion(null);
    private static final i TYPE_SUBTYPE = new i("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final i PARAMETER = new i(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: -deprecated_get, reason: not valid java name */
        public final MediaType m165deprecated_get(String mediaType) {
            j.e(mediaType, "mediaType");
            return get(mediaType);
        }

        /* renamed from: -deprecated_parse, reason: not valid java name */
        public final MediaType m166deprecated_parse(String mediaType) {
            j.e(mediaType, "mediaType");
            return parse(mediaType);
        }

        public final MediaType get(String str) {
            j.e(str, "<this>");
            h hVarA = MediaType.TYPE_SUBTYPE.a(0, str);
            if (hVarA == null) {
                throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
            }
            if (((f1.e) hVarA.c) == null) {
                hVarA.c = new f1.e(hVarA);
            }
            f1.e eVar = (f1.e) hVarA.c;
            j.b(eVar);
            String str2 = (String) eVar.get(1);
            Locale locale = Locale.ROOT;
            String lowerCase = str2.toLowerCase(locale);
            j.d(lowerCase, "toLowerCase(...)");
            if (((f1.e) hVarA.c) == null) {
                hVarA.c = new f1.e(hVarA);
            }
            f1.e eVar2 = (f1.e) hVarA.c;
            j.b(eVar2);
            String lowerCase2 = ((String) eVar2.get(2)).toLowerCase(locale);
            j.d(lowerCase2, "toLowerCase(...)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher = (Matcher) hVarA.f474a;
            int i2 = p.a.V(matcher.start(), matcher.end()).f206b;
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= str.length()) {
                    return new MediaType(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]));
                }
                h hVarA2 = MediaType.PARAMETER.a(i3, str);
                if (hVarA2 == null) {
                    StringBuilder sb = new StringBuilder("Parameter is not formatted correctly: \"");
                    String strSubstring = str.substring(i3);
                    j.d(strSubstring, "substring(...)");
                    sb.append(strSubstring);
                    sb.append("\" for: \"");
                    sb.append(str);
                    sb.append('\"');
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                Matcher matcher2 = (Matcher) hVarA2.f474a;
                g gVar = (g) hVarA2.f475b;
                f1.d dVarA = gVar.a(1);
                String str3 = dVarA != null ? dVarA.f468a : null;
                if (str3 == null) {
                    i2 = p.a.V(matcher2.start(), matcher2.end()).f206b;
                } else {
                    f1.d dVarA2 = gVar.a(2);
                    String strSubstring2 = dVarA2 != null ? dVarA2.f468a : null;
                    if (strSubstring2 == null) {
                        f1.d dVarA3 = gVar.a(3);
                        j.b(dVarA3);
                        strSubstring2 = dVarA3.f468a;
                    } else if (strSubstring2.length() > 0 && p.a.w(strSubstring2.charAt(0), '\'', false) && strSubstring2.length() > 0 && p.a.w(strSubstring2.charAt(f1.j.s0(strSubstring2)), '\'', false) && strSubstring2.length() > 2) {
                        strSubstring2 = strSubstring2.substring(1, strSubstring2.length() - 1);
                        j.d(strSubstring2, "substring(...)");
                    }
                    arrayList.add(str3);
                    arrayList.add(strSubstring2);
                    i2 = p.a.V(matcher2.start(), matcher2.end()).f206b;
                }
            }
        }

        public final MediaType parse(String str) {
            j.e(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private Companion() {
        }
    }

    public MediaType(String mediaType, String type, String subtype, String[] parameterNamesAndValues) {
        j.e(mediaType, "mediaType");
        j.e(type, "type");
        j.e(subtype, "subtype");
        j.e(parameterNamesAndValues, "parameterNamesAndValues");
        this.mediaType = mediaType;
        this.type = type;
        this.subtype = subtype;
        this.parameterNamesAndValues = parameterNamesAndValues;
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = null;
        }
        return mediaType.charset(charset);
    }

    public static final MediaType get(String str) {
        return Companion.get(str);
    }

    public static final MediaType parse(String str) {
        return Companion.parse(str);
    }

    /* renamed from: -deprecated_subtype, reason: not valid java name */
    public final String m163deprecated_subtype() {
        return this.subtype;
    }

    /* renamed from: -deprecated_type, reason: not valid java name */
    public final String m164deprecated_type() {
        return this.type;
    }

    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && j.a(((MediaType) obj).mediaType, this.mediaType);
    }

    public final String getMediaType$okhttp() {
        return this.mediaType;
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public final String parameter(String name) {
        j.e(name, "name");
        int i2 = 0;
        int iA = p.a.A(0, this.parameterNamesAndValues.length - 1, 2);
        if (iA < 0) {
            return null;
        }
        while (!q.i0(this.parameterNamesAndValues[i2], name)) {
            if (i2 == iA) {
                return null;
            }
            i2 += 2;
        }
        return this.parameterNamesAndValues[i2 + 1];
    }

    public final String subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public final String type() {
        return this.type;
    }

    public final Charset charset(Charset charset) {
        String strParameter = parameter("charset");
        if (strParameter == null) {
            return charset;
        }
        try {
            return Charset.forName(strParameter);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
