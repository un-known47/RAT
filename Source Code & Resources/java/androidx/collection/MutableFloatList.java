package androidx.collection;

import androidx.annotation.IntRange;
import androidx.appcompat.app.g;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.util.Arrays;
import kotlin.jvm.internal.j;
import m0.b;
import m0.e;
import m0.i;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class MutableFloatList extends FloatList {
    public MutableFloatList() {
        this(0, 1, null);
    }

    public static /* synthetic */ void trim$default(MutableFloatList mutableFloatList, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = mutableFloatList._size;
        }
        mutableFloatList.trim(i2);
    }

    public final boolean add(float f2) {
        ensureCapacity(this._size + 1);
        float[] fArr = this.content;
        int i2 = this._size;
        fArr[i2] = f2;
        this._size = i2 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i2, float[] elements) {
        int i3;
        j.e(elements, "elements");
        if (i2 < 0 || i2 > (i3 = this._size)) {
            StringBuilder sbQ = g.q("Index ", i2, " must be in 0..");
            sbQ.append(this._size);
            throw new IndexOutOfBoundsException(sbQ.toString());
        }
        if (elements.length == 0) {
            return false;
        }
        ensureCapacity(i3 + elements.length);
        float[] fArr = this.content;
        int i4 = this._size;
        if (i2 != i4) {
            i.j0(fArr, elements.length + i2, fArr, i2, i4);
        }
        i.j0(elements, i2, fArr, 0, elements.length);
        this._size += elements.length;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i2) {
        float[] fArr = this.content;
        if (fArr.length < i2) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, Math.max(i2, (fArr.length * 3) / 2));
            j.d(fArrCopyOf, "copyOf(this, newSize)");
            this.content = fArrCopyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(float f2) {
        remove(f2);
    }

    public final void plusAssign(FloatList elements) {
        j.e(elements, "elements");
        addAll(this._size, elements);
    }

    public final boolean remove(float f2) {
        int iIndexOf = indexOf(f2);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(float[] elements) {
        j.e(elements, "elements");
        int i2 = this._size;
        for (float f2 : elements) {
            remove(f2);
        }
        return i2 != this._size;
    }

    public final float removeAt(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i2) {
        int i3;
        if (i2 < 0 || i2 >= (i3 = this._size)) {
            StringBuilder sbQ = g.q("Index ", i2, " must be in 0..");
            sbQ.append(this._size - 1);
            throw new IndexOutOfBoundsException(sbQ.toString());
        }
        float[] fArr = this.content;
        float f2 = fArr[i2];
        if (i2 != i3 - 1) {
            i.j0(fArr, i2, fArr, i2 + 1, i3);
        }
        this._size--;
        return f2;
    }

    public final void removeRange(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i2, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i3) {
        int i4;
        if (i2 < 0 || i2 > (i4 = this._size) || i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException("Start (" + i2 + ") and end (" + i3 + ") must be in 0.." + this._size);
        }
        if (i3 < i2) {
            throw new IllegalArgumentException("Start (" + i2 + ") is more than end (" + i3 + ')');
        }
        if (i3 != i2) {
            if (i3 < i4) {
                float[] fArr = this.content;
                i.j0(fArr, i2, fArr, i3, i4);
            }
            this._size -= i3 - i2;
        }
    }

    public final boolean retainAll(float[] elements) {
        j.e(elements, "elements");
        int i2 = this._size;
        float[] fArr = this.content;
        int i3 = i2 - 1;
        while (true) {
            int i4 = 0;
            int i5 = -1;
            if (-1 >= i3) {
                break;
            }
            float f2 = fArr[i3];
            int length = elements.length;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                if (elements[i4] == f2) {
                    i5 = i4;
                    break;
                }
                i4++;
            }
            if (i5 < 0) {
                removeAt(i3);
            }
            i3--;
        }
        return i2 != this._size;
    }

    public final float set(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i2, float f2) {
        if (i2 < 0 || i2 >= this._size) {
            StringBuilder sbQ = g.q("set index ", i2, " must be between 0 .. ");
            sbQ.append(this._size - 1);
            throw new IndexOutOfBoundsException(sbQ.toString());
        }
        float[] fArr = this.content;
        float f3 = fArr[i2];
        fArr[i2] = f2;
        return f3;
    }

    public final void sort() {
        float[] fArr = this.content;
        int i2 = this._size;
        j.e(fArr, "<this>");
        Arrays.sort(fArr, 0, i2);
    }

    public final void sortDescending() {
        float[] fArr = this.content;
        int i2 = this._size;
        j.e(fArr, "<this>");
        Arrays.sort(fArr, 0, i2);
        b bVar = e.Companion;
        int length = fArr.length;
        bVar.getClass();
        b.c(0, i2, length);
        int i3 = i2 / 2;
        if (i3 == 0) {
            return;
        }
        int i4 = i2 - 1;
        for (int i5 = 0; i5 < i3; i5++) {
            float f2 = fArr[i5];
            fArr[i5] = fArr[i4];
            fArr[i4] = f2;
            i4--;
        }
    }

    public final void trim(int i2) {
        int iMax = Math.max(i2, this._size);
        float[] fArr = this.content;
        if (fArr.length > iMax) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, iMax);
            j.d(fArrCopyOf, "copyOf(this, newSize)");
            this.content = fArrCopyOf;
        }
    }

    public /* synthetic */ MutableFloatList(int i2, int i3, kotlin.jvm.internal.e eVar) {
        this((i3 & 1) != 0 ? 16 : i2);
    }

    public final void minusAssign(float[] elements) {
        j.e(elements, "elements");
        for (float f2 : elements) {
            remove(f2);
        }
    }

    public final void plusAssign(float[] elements) {
        j.e(elements, "elements");
        addAll(this._size, elements);
    }

    public MutableFloatList(int i2) {
        super(i2, null);
    }

    public final void plusAssign(float f2) {
        add(f2);
    }

    public final void add(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i2, float f2) {
        int i3;
        if (i2 >= 0 && i2 <= (i3 = this._size)) {
            ensureCapacity(i3 + 1);
            float[] fArr = this.content;
            int i4 = this._size;
            if (i2 != i4) {
                i.j0(fArr, i2 + 1, fArr, i2, i4);
            }
            fArr[i2] = f2;
            this._size++;
            return;
        }
        StringBuilder sbQ = g.q("Index ", i2, " must be in 0..");
        sbQ.append(this._size);
        throw new IndexOutOfBoundsException(sbQ.toString());
    }

    public final void minusAssign(FloatList elements) {
        j.e(elements, "elements");
        float[] fArr = elements.content;
        int i2 = elements._size;
        for (int i3 = 0; i3 < i2; i3++) {
            remove(fArr[i3]);
        }
    }

    public final boolean removeAll(FloatList elements) {
        j.e(elements, "elements");
        int i2 = this._size;
        int i3 = elements._size - 1;
        if (i3 >= 0) {
            int i4 = 0;
            while (true) {
                remove(elements.get(i4));
                if (i4 == i3) {
                    break;
                }
                i4++;
            }
        }
        return i2 != this._size;
    }

    public final boolean retainAll(FloatList elements) {
        j.e(elements, "elements");
        int i2 = this._size;
        float[] fArr = this.content;
        for (int i3 = i2 - 1; -1 < i3; i3--) {
            if (!elements.contains(fArr[i3])) {
                removeAt(i3);
            }
        }
        return i2 != this._size;
    }

    public final boolean addAll(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i2, FloatList elements) {
        j.e(elements, "elements");
        if (i2 >= 0 && i2 <= this._size) {
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements._size);
            float[] fArr = this.content;
            int i3 = this._size;
            if (i2 != i3) {
                i.j0(fArr, elements._size + i2, fArr, i2, i3);
            }
            i.j0(elements.content, i2, fArr, 0, elements._size);
            this._size += elements._size;
            return true;
        }
        StringBuilder sbQ = g.q("Index ", i2, " must be in 0..");
        sbQ.append(this._size);
        throw new IndexOutOfBoundsException(sbQ.toString());
    }

    public final boolean addAll(FloatList elements) {
        j.e(elements, "elements");
        return addAll(this._size, elements);
    }

    public final boolean addAll(float[] elements) {
        j.e(elements, "elements");
        return addAll(this._size, elements);
    }
}
