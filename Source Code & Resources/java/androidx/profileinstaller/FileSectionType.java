package androidx.profileinstaller;

import androidx.appcompat.app.g;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
enum FileSectionType {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);

    private final long mValue;

    FileSectionType(long j) {
        this.mValue = j;
    }

    public static FileSectionType fromValue(long j) {
        FileSectionType[] fileSectionTypeArrValues = values();
        for (int i2 = 0; i2 < fileSectionTypeArrValues.length; i2++) {
            if (fileSectionTypeArrValues[i2].getValue() == j) {
                return fileSectionTypeArrValues[i2];
            }
        }
        throw new IllegalArgumentException(g.f("Unsupported FileSection Type ", j));
    }

    public long getValue() {
        return this.mValue;
    }
}
