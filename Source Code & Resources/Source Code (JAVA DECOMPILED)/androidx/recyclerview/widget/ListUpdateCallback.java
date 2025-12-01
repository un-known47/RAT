package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public interface ListUpdateCallback {
    void onChanged(int i2, int i3, @Nullable Object obj);

    void onInserted(int i2, int i3);

    void onMoved(int i2, int i3);

    void onRemoved(int i2, int i3);
}
