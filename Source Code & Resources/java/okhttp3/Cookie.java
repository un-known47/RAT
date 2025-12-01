package okhttp3;

import androidx.appcompat.app.g;
import androidx.core.location.LocationRequestCompat;
import f1.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http.DateFormattingKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final String sameSite;
    private final boolean secure;
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Builder {
        private String domain;
        private long expiresAt;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private String path;
        private boolean persistent;
        private String sameSite;
        private boolean secure;
        private String value;

        public Builder() {
            this.expiresAt = DateFormattingKt.MAX_DATE;
            this.path = "/";
        }

        public final Cookie build() {
            String str = this.name;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.value;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long j = this.expiresAt;
            String str3 = this.domain;
            if (str3 != null) {
                return new Cookie(str, str2, j, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, this.sameSite, null);
            }
            throw new NullPointerException("builder.domain == null");
        }

        public final Builder domain(String domain) {
            j.e(domain, "domain");
            return domain(domain, false);
        }

        public final Builder expiresAt(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > DateFormattingKt.MAX_DATE) {
                j = 253402300799999L;
            }
            this.expiresAt = j;
            this.persistent = true;
            return this;
        }

        public final Builder hostOnlyDomain(String domain) {
            j.e(domain, "domain");
            return domain(domain, true);
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Builder name(String name) {
            j.e(name, "name");
            if (!j.a(f1.j.D0(name).toString(), name)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.name = name;
            return this;
        }

        public final Builder path(String path) {
            j.e(path, "path");
            if (!q.o0(path, "/", false)) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.path = path;
            return this;
        }

        public final Builder sameSite(String sameSite) {
            j.e(sameSite, "sameSite");
            if (!j.a(f1.j.D0(sameSite).toString(), sameSite)) {
                throw new IllegalArgumentException("sameSite is not trimmed");
            }
            this.sameSite = sameSite;
            return this;
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder value(String value) {
            j.e(value, "value");
            if (!j.a(f1.j.D0(value).toString(), value)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.value = value;
            return this;
        }

        private final Builder domain(String str, boolean z2) {
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                throw new IllegalArgumentException(g.v("unexpected domain: ", str));
            }
            this.domain = canonicalHost;
            this.hostOnly = z2;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Cookie cookie) {
            this();
            j.e(cookie, "cookie");
            this.name = cookie.name();
            this.value = cookie.value();
            this.expiresAt = cookie.expiresAt();
            this.domain = cookie.domain();
            this.path = cookie.path();
            this.secure = cookie.secure();
            this.httpOnly = cookie.httpOnly();
            this.persistent = cookie.persistent();
            this.hostOnly = cookie.hostOnly();
            this.sameSite = cookie.sameSite();
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private final int dateCharacterOffset(String str, int i2, int i3, boolean z2) {
            while (i2 < i3) {
                char cCharAt = str.charAt(i2);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z2)) {
                    return i2;
                }
                i2++;
            }
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            return j.a(str, str2) || (q.h0(str, str2, false) && str.charAt((str.length() - str2.length()) - 1) == '.' && !_HostnamesCommonKt.canParseAsIpAddress(str));
        }

        private final String parseDomain(String str) {
            if (q.h0(str, ".", false)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(f1.j.z0(str, "."));
            if (canonicalHost != null) {
                return canonicalHost;
            }
            throw new IllegalArgumentException();
        }

        private final long parseExpires(String str, int i2, int i3) throws NumberFormatException {
            int iDateCharacterOffset = dateCharacterOffset(str, i2, i3, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int iV0 = -1;
            int i7 = -1;
            int i8 = -1;
            while (iDateCharacterOffset < i3) {
                int iDateCharacterOffset2 = dateCharacterOffset(str, iDateCharacterOffset + 1, i3, true);
                matcher.region(iDateCharacterOffset, iDateCharacterOffset2);
                if (i5 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String strGroup = matcher.group(1);
                    j.d(strGroup, "group(...)");
                    i5 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    j.d(strGroup2, "group(...)");
                    i7 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    j.d(strGroup3, "group(...)");
                    i8 = Integer.parseInt(strGroup3);
                } else if (i6 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String strGroup4 = matcher.group(1);
                    j.d(strGroup4, "group(...)");
                    i6 = Integer.parseInt(strGroup4);
                } else if (iV0 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String strGroup5 = matcher.group(1);
                    j.d(strGroup5, "group(...)");
                    Locale US = Locale.US;
                    j.d(US, "US");
                    String lowerCase = strGroup5.toLowerCase(US);
                    j.d(lowerCase, "toLowerCase(...)");
                    String strPattern = Cookie.MONTH_PATTERN.pattern();
                    j.d(strPattern, "pattern(...)");
                    iV0 = f1.j.v0(strPattern, lowerCase, 0, 6) / 4;
                } else if (i4 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String strGroup6 = matcher.group(1);
                    j.d(strGroup6, "group(...)");
                    i4 = Integer.parseInt(strGroup6);
                }
                iDateCharacterOffset = dateCharacterOffset(str, iDateCharacterOffset2 + 1, i3, false);
            }
            if (70 <= i4 && i4 < 100) {
                i4 += 1900;
            }
            if (i4 >= 0 && i4 < 70) {
                i4 += 2000;
            }
            if (i4 < 1601) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (iV0 == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (1 > i6 || i6 >= 32) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i5 < 0 || i5 >= 24) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i7 < 0 || i7 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i8 < 0 || i8 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(_UtilJvmKt.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, iV0 - 1);
            gregorianCalendar.set(5, i6);
            gregorianCalendar.set(11, i5);
            gregorianCalendar.set(12, i7);
            gregorianCalendar.set(13, i8);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long parseMaxAge(String input) throws NumberFormatException {
            try {
                long j = Long.parseLong(input);
                if (j <= 0) {
                    return Long.MIN_VALUE;
                }
                return j;
            } catch (NumberFormatException e2) {
                Pattern patternCompile = Pattern.compile("-?\\d+");
                j.d(patternCompile, "compile(...)");
                j.e(input, "input");
                if (!patternCompile.matcher(input).matches()) {
                    throw e2;
                }
                if (q.o0(input, "-", false)) {
                    return Long.MIN_VALUE;
                }
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String strEncodedPath = httpUrl.encodedPath();
            if (j.a(strEncodedPath, str)) {
                return true;
            }
            return q.o0(strEncodedPath, str, false) && (q.h0(str, "/", false) || strEncodedPath.charAt(str.length()) == '/');
        }

        public final Cookie parse(HttpUrl url, String setCookie) {
            j.e(url, "url");
            j.e(setCookie, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), url, setCookie);
        }

        public final Cookie parse$okhttp(long j, HttpUrl url, String setCookie) throws NumberFormatException {
            long j2;
            String str;
            j.e(url, "url");
            j.e(setCookie, "setCookie");
            int iDelimiterOffset$default = _UtilCommonKt.delimiterOffset$default(setCookie, ';', 0, 0, 6, (Object) null);
            int iDelimiterOffset$default2 = _UtilCommonKt.delimiterOffset$default(setCookie, '=', 0, iDelimiterOffset$default, 2, (Object) null);
            String domain = null;
            if (iDelimiterOffset$default2 != iDelimiterOffset$default) {
                String strTrimSubstring$default = _UtilCommonKt.trimSubstring$default(setCookie, 0, iDelimiterOffset$default2, 1, null);
                if (strTrimSubstring$default.length() != 0 && _UtilCommonKt.indexOfControlOrNonAscii(strTrimSubstring$default) == -1) {
                    String strTrimSubstring = _UtilCommonKt.trimSubstring(setCookie, iDelimiterOffset$default2 + 1, iDelimiterOffset$default);
                    if (_UtilCommonKt.indexOfControlOrNonAscii(strTrimSubstring) == -1) {
                        int i2 = iDelimiterOffset$default + 1;
                        int length = setCookie.length();
                        String str2 = null;
                        String str3 = null;
                        long maxAge = -1;
                        boolean z2 = false;
                        boolean z3 = true;
                        boolean z4 = false;
                        long expires = DateFormattingKt.MAX_DATE;
                        boolean z5 = false;
                        while (i2 < length) {
                            int iDelimiterOffset = _UtilCommonKt.delimiterOffset(setCookie, ';', i2, length);
                            int iDelimiterOffset2 = _UtilCommonKt.delimiterOffset(setCookie, '=', i2, iDelimiterOffset);
                            String strTrimSubstring2 = _UtilCommonKt.trimSubstring(setCookie, i2, iDelimiterOffset2);
                            String strTrimSubstring3 = iDelimiterOffset2 < iDelimiterOffset ? _UtilCommonKt.trimSubstring(setCookie, iDelimiterOffset2 + 1, iDelimiterOffset) : "";
                            if (q.i0(strTrimSubstring2, "expires")) {
                                try {
                                    expires = parseExpires(strTrimSubstring3, 0, strTrimSubstring3.length());
                                    z4 = true;
                                } catch (NumberFormatException | IllegalArgumentException unused) {
                                }
                            } else if (q.i0(strTrimSubstring2, "max-age")) {
                                maxAge = parseMaxAge(strTrimSubstring3);
                                z4 = true;
                            } else if (q.i0(strTrimSubstring2, "domain")) {
                                domain = parseDomain(strTrimSubstring3);
                                z3 = false;
                            } else if (q.i0(strTrimSubstring2, "path")) {
                                str2 = strTrimSubstring3;
                            } else if (q.i0(strTrimSubstring2, "secure")) {
                                z5 = true;
                            } else if (q.i0(strTrimSubstring2, "httponly")) {
                                z2 = true;
                            } else if (q.i0(strTrimSubstring2, "samesite")) {
                                str3 = strTrimSubstring3;
                            }
                            i2 = iDelimiterOffset + 1;
                        }
                        if (maxAge == Long.MIN_VALUE) {
                            j2 = Long.MIN_VALUE;
                        } else if (maxAge != -1) {
                            long j3 = j + (maxAge <= 9223372036854775L ? maxAge * 1000 : LocationRequestCompat.PASSIVE_INTERVAL);
                            j2 = (j3 < j || j3 > DateFormattingKt.MAX_DATE) ? 253402300799999L : j3;
                        } else {
                            j2 = expires;
                        }
                        String strHost = url.host();
                        if (domain == null) {
                            str = strHost;
                        } else {
                            if (!domainMatch(strHost, domain)) {
                                return null;
                            }
                            str = domain;
                        }
                        if (strHost.length() != str.length() && PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(str) == null) {
                            return null;
                        }
                        String strSubstring = "/";
                        if (str2 == null || !q.o0(str2, "/", false)) {
                            String strEncodedPath = url.encodedPath();
                            int iX0 = f1.j.x0(strEncodedPath, '/', 0, 6);
                            if (iX0 != 0) {
                                strSubstring = strEncodedPath.substring(0, iX0);
                                j.d(strSubstring, "substring(...)");
                            }
                            str2 = strSubstring;
                        }
                        return new Cookie(strTrimSubstring$default, strTrimSubstring, j2, str, str2, z5, z2, z4, z3, str3, null);
                    }
                }
            }
            return null;
        }

        public final List<Cookie> parseAll(HttpUrl url, Headers headers) {
            j.e(url, "url");
            j.e(headers, "headers");
            List<String> listValues = headers.values("Set-Cookie");
            int size = listValues.size();
            List<Cookie> listUnmodifiableList = null;
            ArrayList arrayList = null;
            for (int i2 = 0; i2 < size; i2++) {
                Cookie cookie = parse(url, listValues.get(i2));
                if (cookie != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(cookie);
                }
            }
            if (arrayList != null) {
                listUnmodifiableList = Collections.unmodifiableList(arrayList);
                j.d(listUnmodifiableList, "unmodifiableList(...)");
            }
            return listUnmodifiableList == null ? m0.q.f867a : listUnmodifiableList;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Cookie(String str, String str2, long j, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5, String str5, e eVar) {
        this(str, str2, j, str3, str4, z2, z3, z4, z5, str5);
    }

    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    /* renamed from: -deprecated_domain, reason: not valid java name */
    public final String m119deprecated_domain() {
        return this.domain;
    }

    /* renamed from: -deprecated_expiresAt, reason: not valid java name */
    public final long m120deprecated_expiresAt() {
        return this.expiresAt;
    }

    /* renamed from: -deprecated_hostOnly, reason: not valid java name */
    public final boolean m121deprecated_hostOnly() {
        return this.hostOnly;
    }

    /* renamed from: -deprecated_httpOnly, reason: not valid java name */
    public final boolean m122deprecated_httpOnly() {
        return this.httpOnly;
    }

    /* renamed from: -deprecated_name, reason: not valid java name */
    public final String m123deprecated_name() {
        return this.name;
    }

    /* renamed from: -deprecated_path, reason: not valid java name */
    public final String m124deprecated_path() {
        return this.path;
    }

    /* renamed from: -deprecated_persistent, reason: not valid java name */
    public final boolean m125deprecated_persistent() {
        return this.persistent;
    }

    /* renamed from: -deprecated_secure, reason: not valid java name */
    public final boolean m126deprecated_secure() {
        return this.secure;
    }

    /* renamed from: -deprecated_value, reason: not valid java name */
    public final String m127deprecated_value() {
        return this.value;
    }

    public final String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return j.a(cookie.name, this.name) && j.a(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && j.a(cookie.domain, this.domain) && j.a(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly && j.a(cookie.sameSite, this.sameSite);
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        int iHashCode = (this.value.hashCode() + ((this.name.hashCode() + 527) * 31)) * 31;
        long j = this.expiresAt;
        int iHashCode2 = (((((((((this.path.hashCode() + ((this.domain.hashCode() + ((iHashCode + ((int) (j ^ (j >>> 32)))) * 31)) * 31)) * 31) + (this.secure ? 1231 : 1237)) * 31) + (this.httpOnly ? 1231 : 1237)) * 31) + (this.persistent ? 1231 : 1237)) * 31) + (this.hostOnly ? 1231 : 1237)) * 31;
        String str = this.sameSite;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(HttpUrl url) {
        j.e(url, "url");
        if ((this.hostOnly ? j.a(url.host(), this.domain) : Companion.domainMatch(url.host(), this.domain)) && Companion.pathMatch(url, this.path)) {
            return !this.secure || url.isHttps();
        }
        return false;
    }

    public final String name() {
        return this.name;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final String sameSite() {
        return this.sameSite;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(DateFormattingKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z2) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        if (this.sameSite != null) {
            sb.append("; samesite=");
            sb.append(this.sameSite);
        }
        String string = sb.toString();
        j.d(string, "toString(...)");
        return string;
    }

    public final String value() {
        return this.value;
    }

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5, String str5) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z2;
        this.httpOnly = z3;
        this.persistent = z4;
        this.hostOnly = z5;
        this.sameSite = str5;
    }
}
