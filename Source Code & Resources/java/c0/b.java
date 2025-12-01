package c0;

import android.text.Editable;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements q, ShapeAppearanceModel.CornerSizeUnaryOperator, TextInputLayout.LengthCounter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f160a;

    public /* synthetic */ b(int i2) {
        this.f160a = i2;
    }

    @Override // c0.q
    public Object a() {
        switch (this.f160a) {
            case 0:
                return new LinkedHashMap();
            case 1:
                return new TreeMap();
            case 2:
                return new ConcurrentHashMap();
            case 3:
                return new ConcurrentSkipListMap();
            case 4:
                return new ArrayList();
            case 5:
                return new LinkedHashSet();
            case 6:
                return new TreeSet();
            case 7:
                return new ArrayDeque();
            default:
                return new p(true);
        }
    }

    @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
    public CornerSize apply(CornerSize cornerSize) {
        return MaskableFrameLayout.lambda$setShapeAppearanceModel$0(cornerSize);
    }

    @Override // com.google.android.material.textfield.TextInputLayout.LengthCounter
    public int countLength(Editable editable) {
        return TextInputLayout.lambda$new$0(editable);
    }
}
