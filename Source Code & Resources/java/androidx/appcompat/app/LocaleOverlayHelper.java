package androidx.appcompat.app;

import android.os.LocaleList;
import androidx.annotation.RequiresApi;
import androidx.core.os.LocaleListCompat;
import java.util.LinkedHashSet;
import java.util.Locale;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RequiresApi(24)
/* loaded from: classes.dex */
final class LocaleOverlayHelper {
    private LocaleOverlayHelper() {
    }

    private static LocaleListCompat combineLocales(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i2 = 0;
        while (i2 < localeListCompat2.size() + localeListCompat.size()) {
            Locale locale = i2 < localeListCompat.size() ? localeListCompat.get(i2) : localeListCompat2.get(i2 - localeListCompat.size());
            if (locale != null) {
                linkedHashSet.add(locale);
            }
            i2++;
        }
        return LocaleListCompat.create((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    public static LocaleListCompat combineLocalesIfOverlayExists(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        return (localeListCompat == null || localeListCompat.isEmpty()) ? LocaleListCompat.getEmptyLocaleList() : combineLocales(localeListCompat, localeListCompat2);
    }

    public static LocaleListCompat combineLocalesIfOverlayExists(LocaleList localeList, LocaleList localeList2) {
        if (localeList != null && !localeList.isEmpty()) {
            return combineLocales(LocaleListCompat.wrap(localeList), LocaleListCompat.wrap(localeList2));
        }
        return LocaleListCompat.getEmptyLocaleList();
    }
}
