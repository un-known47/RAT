package androidx.core.os;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.util.Locale;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
interface LocaleListInterface {
    Locale get(int i2);

    @Nullable
    Locale getFirstMatch(@NonNull String[] strArr);

    Object getLocaleList();

    @IntRange(from = RecyclerView.NO_ID)
    int indexOf(Locale locale);

    boolean isEmpty();

    @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY)
    int size();

    String toLanguageTags();
}
