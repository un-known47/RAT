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
public final class MutableLongList extends LongList {
    public MutableLongList() {
        this(0, 1, null);
    }

    public static /* synthetic */ void trim$default(MutableLongList mutableLongList, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = mutableLongList._size;
        }
        mutableLongList.trim(i2);
    }

    public final boolean add(long j) {
        ensureCapacity(this._size + 1);
        long[] jArr = this.content;
        int i2 = this._size;
        jArr[i2] = j;
        this._size = i2 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i2, long[] elements) {
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
        long[] jArr = this.content;
        int i4 = this._size;
        if (i2 != i4) {
            i.k0(jArr, jArr, elements.length + i2, i2, i4);
        }
        i.k0(elements, jArr, i2, 0, elements.length);
        this._size += elements.length;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i2) {
        long[] jArr = this.content;
        if (jArr.length < i2) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, Math.max(i2, (jArr.length * 3) / 2));
            j.d(jArrCopyOf, "copyOf(this, newSize)");
            this.content = jArrCopyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(long j) {
        remove(j);
    }

    public final void plusAssign(LongList elements) {
        j.e(elements, "elements");
        addAll(this._size, elements);
    }

    public final boolean remove(long j) {
        int iIndexOf = indexOf(j);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(long[] elements) {
        j.e(elements, "elements");
        int i2 = this._size;
        for (long j : elements) {
            remove(j);
        }
        return i2 != this._size;
    }

    public final long removeAt(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i2) {
        int i3;
        if (i2 < 0 || i2 >= (i3 = this._size)) {
            StringBuilder sbQ = g.q("Index ", i2, " must be in 0..");
            sbQ.append(this._size - 1);
            throw new IndexOutOfBoundsException(sbQ.toString());
        }
        long[] jArr = this.content;
        long j = jArr[i2];
        if (i2 != i3 - 1) {
            i.k0(jArr, jArr, i2, i2 + 1, i3);
        }
        this._size--;
        return j;
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
                long[] jArr = this.content;
                i.k0(jArr, jArr, i2, i3, i4);
            }
            this._size -= i3 - i2;
        }
    }

    public final boolean retainAll(long[] elements) {
        j.e(elements, "elements");
        int i2 = this._size;
        long[] jArr = this.content;
        int i3 = i2 - 1;
        while (true) {
            int i4 = 0;
            int i5 = -1;
            if (-1 >= i3) {
                break;
            }
            long j = jArr[i3];
            int length = elements.length;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                if (elements[i4] == j) {
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

    public final long set(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i2, long j) {
        if (i2 < 0 || i2 >= this._size) {
            StringBuilder sbQ = g.q("set index ", i2, " must be between 0 .. ");
            sbQ.append(this._size - 1);
            throw new IndexOutOfBoundsException(sbQ.toString());
        }
        long[] jArr = this.content;
        long j2 = jArr[i2];
        jArr[i2] = j;
        return j2;
    }

    public final void sort() {
        long[] jArr = this.content;
        int i2 = this._size;
        j.e(jArr, "<this>");
        Arrays.sort(jArr, 0, i2);
    }

    public final void sortDescending() {
        long[] jArr = this.content;
        int i2 = this._size;
        j.e(jArr, "<this>");
        Arrays.sort(jArr, 0, i2);
        b bVar = e.Companion;
        int length = jArr.length;
        bVar.getClass();
        b.c(0, i2, length);
        int i3 = i2 / 2;
        if (i3 == 0) {
            return;
        }
        int i4 = i2 - 1;
        for (int i5 = 0; i5 < i3; i5++) {
            long j = jArr[i5];
            jArr[i5] = jArr[i4];
            jArr[i4] = j;
            i4--;
        }
    }

    public final void trim(int i2) {
        int iMax = Math.max(i2, this._size);
        long[] jArr = this.content;
        if (jArr.length > iMax) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            j.d(jArrCopyOf, "copyOf(this, newSize)");
            this.content = jArrCopyOf;
        }
    }

    public /* synthetic */ MutableLongList(int i2, int i3, kotlin.jvm.internal.e eVar) {
        this((i3 & 1) != 0 ? 16 : i2);
    }

    public final void minusAssign(long[] elements) {
        j.e(elements, "elements");
        for (long j : elements) {
            remove(j);
        }
    }

    public final void plusAssign(long[] elements) {
        j.e(elements, "elements");
        addAll(this._size, elements);
    }

    public MutableLongList(int i2) {
        super(i2, null);
    }

    public final void plusAssign(long j) {
        add(j);
    }

    public final void add(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i2, long j) {
        int i3;
        if (i2 >= 0 && i2 <= (i3 = this._size)) {
            ensureCapacity(i3 + 1);
            long[] jArr = this.content;
            int i4 = this._size;
            if (i2 != i4) {
                i.k0(jArr, jArr, i2 + 1, i2, i4);
            }
            jArr[i2] = j;
            this._size++;
            return;
        }
        StringBuilder sbQ = g.q("Index ", i2, " must be in 0..");
        sbQ.append(this._size);
        throw new IndexOutOfBoundsException(sbQ.toString());
    }

    public final void minusAssign(LongList elements) {
        j.e(elements, "elements");
        long[] jArr = elements.content;
        int i2 = elements._size;
        for (int i3 = 0; i3 < i2; i3++) {
            remove(jArr[i3]);
        }
    }

    public final boolean removeAll(LongList elements) {
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

    public final boolean retainAll(LongList elements) {
        j.e(elements, "elements");
        int i2 = this._size;
        long[] jArr = this.content;
        for (int i3 = i2 - 1; -1 < i3; i3--) {
            if (!elements.contains(jArr[i3])) {
                removeAt(i3);
            }
        }
        return i2 != this._size;
    }

    public final boolean addAll(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i2, LongList elements) {
        j.e(elements, "elements");
        if (i2 >= 0 && i2 <= this._size) {
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements._size);
            long[] jArr = this.content;
            int i3 = this._size;
            if (i2 != i3) {
                i.k0(jArr, jArr, elements._size + i2, i2, i3);
            }
            i.k0(elements.content, jArr, i2, 0, elements._size);
            this._size += elements._size;
            return true;
        }
        StringBuilder sbQ = g.q("Index ", i2, " must be in 0..");
        sbQ.append(this._size);
        throw new IndexOutOfBoundsException(sbQ.toString());
    }

    public final boolean addAll(LongList elements) {
        j.e(elements, "elements");
        return addAll(this._size, elements);
    }

    public final boolean addAll(long[] elements) {
        j.e(elements, "elements");
        return addAll(this._size, elements);
    }
}
