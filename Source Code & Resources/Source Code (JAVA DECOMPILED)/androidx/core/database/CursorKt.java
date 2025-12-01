package androidx.core.database;

import android.database.Cursor;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class CursorKt {
    public static final byte[] getBlobOrNull(Cursor cursor, int i2) {
        if (cursor.isNull(i2)) {
            return null;
        }
        return cursor.getBlob(i2);
    }

    public static final Double getDoubleOrNull(Cursor cursor, int i2) {
        if (cursor.isNull(i2)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i2));
    }

    public static final Float getFloatOrNull(Cursor cursor, int i2) {
        if (cursor.isNull(i2)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i2));
    }

    public static final Integer getIntOrNull(Cursor cursor, int i2) {
        if (cursor.isNull(i2)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i2));
    }

    public static final Long getLongOrNull(Cursor cursor, int i2) {
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    public static final Short getShortOrNull(Cursor cursor, int i2) {
        if (cursor.isNull(i2)) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i2));
    }

    public static final String getStringOrNull(Cursor cursor, int i2) {
        if (cursor.isNull(i2)) {
            return null;
        }
        return cursor.getString(i2);
    }
}
