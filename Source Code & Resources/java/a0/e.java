package a0;

import java.lang.reflect.Field;
import java.util.Locale;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public enum e extends h {
    public e() {
        super("LOWER_CASE_WITH_UNDERSCORES", 4);
    }

    @Override // a0.h
    public final String b(Field field) {
        return h.a(field.getName(), '_').toLowerCase(Locale.ENGLISH);
    }
}
