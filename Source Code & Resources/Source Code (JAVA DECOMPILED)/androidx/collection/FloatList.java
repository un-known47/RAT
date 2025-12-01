package androidx.collection;

import androidx.annotation.IntRange;
import androidx.appcompat.app.g;
import androidx.recyclerview.widget.RecyclerView;
import c1.d;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import okhttp3.b;
import p.a;
import y0.l;
import y0.p;
import y0.q;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class FloatList {
    public int _size;
    public float[] content;

    public /* synthetic */ FloatList(int i2, e eVar) {
        this(i2);
    }

    public static /* synthetic */ String joinToString$default(FloatList floatList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i3 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i3 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i3 & 8) != 0) {
            i2 = -1;
        }
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return floatList.joinToString(charSequence, charSequence2, charSequence6, i2, charSequence5);
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public final boolean contains(float f2) {
        float[] fArr = this.content;
        int i2 = this._size;
        for (int i3 = 0; i3 < i2; i3++) {
            if (fArr[i3] == f2) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsAll(FloatList elements) {
        j.e(elements, "elements");
        d dVarV = a.V(0, elements._size);
        int i2 = dVarV.f205a;
        int i3 = dVarV.f206b;
        if (i2 > i3) {
            return true;
        }
        while (contains(elements.get(i2))) {
            if (i2 == i3) {
                return true;
            }
            i2++;
        }
        return false;
    }

    public final int count() {
        return this._size;
    }

    public final float elementAt(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i2) {
        if (i2 >= 0 && i2 < this._size) {
            return this.content[i2];
        }
        StringBuilder sbQ = g.q("Index ", i2, " must be in 0..");
        sbQ.append(this._size - 1);
        throw new IndexOutOfBoundsException(sbQ.toString());
    }

    public final float elementAtOrElse(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i2, l defaultValue) {
        j.e(defaultValue, "defaultValue");
        return (i2 < 0 || i2 >= this._size) ? ((Number) defaultValue.invoke(Integer.valueOf(i2))).floatValue() : this.content[i2];
    }

    public boolean equals(Object obj) {
        if (obj instanceof FloatList) {
            FloatList floatList = (FloatList) obj;
            int i2 = floatList._size;
            int i3 = this._size;
            if (i2 == i3) {
                float[] fArr = this.content;
                float[] fArr2 = floatList.content;
                d dVarV = a.V(0, i3);
                int i4 = dVarV.f205a;
                int i5 = dVarV.f206b;
                if (i4 > i5) {
                    return true;
                }
                while (fArr[i4] == fArr2[i4]) {
                    if (i4 == i5) {
                        return true;
                    }
                    i4++;
                }
                return false;
            }
        }
        return false;
    }

    public final float first() {
        if (isEmpty()) {
            throw new NoSuchElementException("FloatList is empty.");
        }
        return this.content[0];
    }

    public final <R> R fold(R r2, p operation) {
        j.e(operation, "operation");
        float[] fArr = this.content;
        int i2 = this._size;
        for (int i3 = 0; i3 < i2; i3++) {
            r2 = (R) operation.invoke(r2, Float.valueOf(fArr[i3]));
        }
        return r2;
    }

    public final <R> R foldIndexed(R r2, q operation) {
        j.e(operation, "operation");
        float[] fArr = this.content;
        int i2 = this._size;
        for (int i3 = 0; i3 < i2; i3++) {
            b bVar = (b) operation;
            R r3 = r2;
            r2 = (R) bVar.a(Integer.valueOf(i3), r3, Float.valueOf(fArr[i3]));
        }
        return r2;
    }

    public final <R> R foldRight(R r2, p operation) {
        j.e(operation, "operation");
        float[] fArr = this.content;
        int i2 = this._size;
        while (true) {
            i2--;
            if (-1 >= i2) {
                return r2;
            }
            r2 = (R) operation.invoke(Float.valueOf(fArr[i2]), r2);
        }
    }

    public final <R> R foldRightIndexed(R r2, q operation) {
        j.e(operation, "operation");
        float[] fArr = this.content;
        int i2 = this._size;
        while (true) {
            i2--;
            if (-1 >= i2) {
                return r2;
            }
            r2 = (R) ((b) operation).a(Integer.valueOf(i2), Float.valueOf(fArr[i2]), r2);
        }
    }

    public final void forEach(l block) {
        j.e(block, "block");
        float[] fArr = this.content;
        int i2 = this._size;
        for (int i3 = 0; i3 < i2; i3++) {
            block.invoke(Float.valueOf(fArr[i3]));
        }
    }

    public final void forEachIndexed(p block) {
        j.e(block, "block");
        float[] fArr = this.content;
        int i2 = this._size;
        for (int i3 = 0; i3 < i2; i3++) {
            block.invoke(Integer.valueOf(i3), Float.valueOf(fArr[i3]));
        }
    }

    public final void forEachReversed(l block) {
        j.e(block, "block");
        float[] fArr = this.content;
        int i2 = this._size;
        while (true) {
            i2--;
            if (-1 >= i2) {
                return;
            } else {
                block.invoke(Float.valueOf(fArr[i2]));
            }
        }
    }

    public final void forEachReversedIndexed(p block) {
        j.e(block, "block");
        float[] fArr = this.content;
        int i2 = this._size;
        while (true) {
            i2--;
            if (-1 >= i2) {
                return;
            } else {
                block.invoke(Integer.valueOf(i2), Float.valueOf(fArr[i2]));
            }
        }
    }

    public final float get(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i2) {
        if (i2 >= 0 && i2 < this._size) {
            return this.content[i2];
        }
        StringBuilder sbQ = g.q("Index ", i2, " must be in 0..");
        sbQ.append(this._size - 1);
        throw new IndexOutOfBoundsException(sbQ.toString());
    }

    public final d getIndices() {
        return a.V(0, this._size);
    }

    @IntRange(from = RecyclerView.NO_ID)
    public final int getLastIndex() {
        return this._size - 1;
    }

    @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        float[] fArr = this.content;
        int i2 = this._size;
        int iFloatToIntBits = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            iFloatToIntBits += Float.floatToIntBits(fArr[i3]) * 31;
        }
        return iFloatToIntBits;
    }

    public final int indexOf(float f2) {
        float[] fArr = this.content;
        int i2 = this._size;
        for (int i3 = 0; i3 < i2; i3++) {
            if (f2 == fArr[i3]) {
                return i3;
            }
        }
        return -1;
    }

    public final int indexOfFirst(l predicate) {
        j.e(predicate, "predicate");
        float[] fArr = this.content;
        int i2 = this._size;
        for (int i3 = 0; i3 < i2; i3++) {
            if (((Boolean) predicate.invoke(Float.valueOf(fArr[i3]))).booleanValue()) {
                return i3;
            }
        }
        return -1;
    }

    public final int indexOfLast(l predicate) {
        j.e(predicate, "predicate");
        float[] fArr = this.content;
        int i2 = this._size;
        do {
            i2--;
            if (-1 >= i2) {
                return -1;
            }
        } while (!((Boolean) predicate.invoke(Float.valueOf(fArr[i2]))).booleanValue());
        return i2;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final float last() {
        if (isEmpty()) {
            throw new NoSuchElementException("FloatList is empty.");
        }
        return this.content[this._size - 1];
    }

    public final int lastIndexOf(float f2) {
        float[] fArr = this.content;
        int i2 = this._size;
        do {
            i2--;
            if (-1 >= i2) {
                return -1;
            }
        } while (fArr[i2] != f2);
        return i2;
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(l predicate) {
        j.e(predicate, "predicate");
        float[] fArr = this.content;
        for (int i2 = this._size - 1; -1 < i2; i2--) {
            if (((Boolean) predicate.invoke(Float.valueOf(fArr[i2]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    private FloatList(int i2) {
        this.content = i2 == 0 ? FloatSetKt.getEmptyFloatArray() : new float[i2];
    }

    public final boolean any(l predicate) {
        j.e(predicate, "predicate");
        float[] fArr = this.content;
        int i2 = this._size;
        for (int i3 = 0; i3 < i2; i3++) {
            if (((Boolean) predicate.invoke(Float.valueOf(fArr[i3]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final int count(l predicate) {
        j.e(predicate, "predicate");
        float[] fArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (((Boolean) predicate.invoke(Float.valueOf(fArr[i4]))).booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    public final String joinToString(CharSequence separator) {
        j.e(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        j.e(separator, "separator");
        j.e(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    public final float first(l predicate) {
        j.e(predicate, "predicate");
        float[] fArr = this.content;
        int i2 = this._size;
        for (int i3 = 0; i3 < i2; i3++) {
            float f2 = fArr[i3];
            if (((Boolean) predicate.invoke(Float.valueOf(f2))).booleanValue()) {
                return f2;
            }
        }
        throw new NoSuchElementException("FloatList contains no element matching the predicate.");
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        j.e(separator, "separator");
        j.e(prefix, "prefix");
        j.e(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public static /* synthetic */ String joinToString$default(FloatList floatList, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence charSequence, l lVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                separator = ", ";
            }
            if ((i3 & 2) != 0) {
                prefix = "";
            }
            if ((i3 & 4) != 0) {
                postfix = "";
            }
            if ((i3 & 8) != 0) {
                i2 = -1;
            }
            if ((i3 & 16) != 0) {
                charSequence = "...";
            }
            j.e(separator, "separator");
            j.e(prefix, "prefix");
            j.e(postfix, "postfix");
            StringBuilder sbN = g.n(charSequence, "truncated", lVar, "transform", prefix);
            float[] fArr = floatList.content;
            int i4 = floatList._size;
            int i5 = 0;
            while (true) {
                if (i5 < i4) {
                    float f2 = fArr[i5];
                    if (i5 == i2) {
                        sbN.append(charSequence);
                        break;
                    }
                    if (i5 != 0) {
                        sbN.append(separator);
                    }
                    sbN.append((CharSequence) lVar.invoke(Float.valueOf(f2)));
                    i5++;
                } else {
                    sbN.append(postfix);
                    break;
                }
            }
            String string = sbN.toString();
            j.d(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i2) {
        j.e(separator, "separator");
        j.e(prefix, "prefix");
        j.e(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i2, null, 16, null);
    }

    public final float last(l predicate) {
        float f2;
        j.e(predicate, "predicate");
        float[] fArr = this.content;
        int i2 = this._size;
        do {
            i2--;
            if (-1 < i2) {
                f2 = fArr[i2];
            } else {
                throw new NoSuchElementException("FloatList contains no element matching the predicate.");
            }
        } while (!((Boolean) predicate.invoke(Float.valueOf(f2))).booleanValue());
        return f2;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i2, CharSequence charSequence2) {
        j.e(separator, "separator");
        j.e(prefix, "prefix");
        StringBuilder sbM = g.m(charSequence, "postfix", charSequence2, "truncated", prefix);
        float[] fArr = this.content;
        int i3 = this._size;
        int i4 = 0;
        while (true) {
            if (i4 < i3) {
                float f2 = fArr[i4];
                if (i4 == i2) {
                    sbM.append(charSequence2);
                    break;
                }
                if (i4 != 0) {
                    sbM.append(separator);
                }
                sbM.append(f2);
                i4++;
            } else {
                sbM.append(charSequence);
                break;
            }
        }
        String string = sbM.toString();
        j.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence charSequence, l lVar) {
        j.e(separator, "separator");
        j.e(prefix, "prefix");
        j.e(postfix, "postfix");
        StringBuilder sbN = g.n(charSequence, "truncated", lVar, "transform", prefix);
        float[] fArr = this.content;
        int i3 = this._size;
        int i4 = 0;
        while (true) {
            if (i4 < i3) {
                float f2 = fArr[i4];
                if (i4 == i2) {
                    sbN.append(charSequence);
                    break;
                }
                if (i4 != 0) {
                    sbN.append(separator);
                }
                sbN.append((CharSequence) lVar.invoke(Float.valueOf(f2)));
                i4++;
            } else {
                sbN.append(postfix);
                break;
            }
        }
        String string = sbN.toString();
        j.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i2, l lVar) {
        j.e(separator, "separator");
        j.e(prefix, "prefix");
        StringBuilder sbN = g.n(charSequence, "postfix", lVar, "transform", prefix);
        float[] fArr = this.content;
        int i3 = this._size;
        int i4 = 0;
        while (true) {
            if (i4 < i3) {
                float f2 = fArr[i4];
                if (i4 == i2) {
                    sbN.append((CharSequence) "...");
                    break;
                }
                if (i4 != 0) {
                    sbN.append(separator);
                }
                sbN.append((CharSequence) lVar.invoke(Float.valueOf(f2)));
                i4++;
            } else {
                sbN.append(charSequence);
                break;
            }
        }
        String string = sbN.toString();
        j.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, l lVar) {
        j.e(separator, "separator");
        j.e(prefix, "prefix");
        StringBuilder sbN = g.n(charSequence, "postfix", lVar, "transform", prefix);
        float[] fArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        while (true) {
            if (i3 < i2) {
                float f2 = fArr[i3];
                if (i3 == -1) {
                    sbN.append((CharSequence) "...");
                    break;
                }
                if (i3 != 0) {
                    sbN.append(separator);
                }
                sbN.append((CharSequence) lVar.invoke(Float.valueOf(f2)));
                i3++;
            } else {
                sbN.append(charSequence);
                break;
            }
        }
        String string = sbN.toString();
        j.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence charSequence, l lVar) {
        j.e(separator, "separator");
        StringBuilder sbN = g.n(charSequence, "prefix", lVar, "transform", charSequence);
        float[] fArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        while (true) {
            if (i3 < i2) {
                float f2 = fArr[i3];
                if (i3 == -1) {
                    sbN.append((CharSequence) "...");
                    break;
                }
                if (i3 != 0) {
                    sbN.append(separator);
                }
                sbN.append((CharSequence) lVar.invoke(Float.valueOf(f2)));
                i3++;
            } else {
                sbN.append((CharSequence) "");
                break;
            }
        }
        String string = sbN.toString();
        j.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence separator, l transform) {
        j.e(separator, "separator");
        j.e(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        float[] fArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        while (true) {
            if (i3 < i2) {
                float f2 = fArr[i3];
                if (i3 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i3 != 0) {
                    sb.append(separator);
                }
                sb.append((CharSequence) transform.invoke(Float.valueOf(f2)));
                i3++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        String string = sb.toString();
        j.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(l transform) {
        j.e(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        float[] fArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        while (true) {
            if (i3 < i2) {
                float f2 = fArr[i3];
                if (i3 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i3 != 0) {
                    sb.append((CharSequence) ", ");
                }
                sb.append((CharSequence) transform.invoke(Float.valueOf(f2)));
                i3++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        String string = sb.toString();
        j.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
