package androidx.profileinstaller;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
class WritableFileSection {
    final byte[] mContents;
    final int mExpectedInflateSize;
    final boolean mNeedsCompression;
    final FileSectionType mType;

    public WritableFileSection(@NonNull FileSectionType fileSectionType, int i2, @NonNull byte[] bArr, boolean z2) {
        this.mType = fileSectionType;
        this.mExpectedInflateSize = i2;
        this.mContents = bArr;
        this.mNeedsCompression = z2;
    }
}
