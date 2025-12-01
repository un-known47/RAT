package androidx.graphics.shapes;

import androidx.collection.FloatList;
import c1.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.j;
import m0.t;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class FloatMappingKt {
    public static final float linearMap(FloatList xValues, FloatList yValues, float f2) {
        j.e(xValues, "xValues");
        j.e(yValues, "yValues");
        if (0.0f > f2 || f2 > 1.0f) {
            throw new IllegalArgumentException(("Invalid progress: " + f2).toString());
        }
        Iterator it = p.a.V(0, xValues._size).iterator();
        while (it.hasNext()) {
            int iNextInt = ((t) it).nextInt();
            int i2 = iNextInt + 1;
            if (progressInRange(f2, xValues.get(iNextInt), xValues.get(i2 % xValues.getSize()))) {
                int size = i2 % xValues.getSize();
                float fPositiveModulo = Utils.positiveModulo(xValues.get(size) - xValues.get(iNextInt), 1.0f);
                return Utils.positiveModulo((Utils.positiveModulo(yValues.get(size) - yValues.get(iNextInt), 1.0f) * (fPositiveModulo < 0.001f ? 0.5f : Utils.positiveModulo(f2 - xValues.get(iNextInt), 1.0f) / fPositiveModulo)) + yValues.get(iNextInt), 1.0f);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final boolean progressInRange(float f2, float f3, float f4) {
        return f4 >= f3 ? f3 <= f2 && f2 <= f4 : f2 >= f3 || f2 <= f4;
    }

    public static final void validateProgress(FloatList p2) {
        int i2;
        j.e(p2, "p");
        Boolean boolValueOf = Boolean.TRUE;
        float[] fArr = p2.content;
        int i3 = p2._size;
        int i4 = 0;
        while (true) {
            boolean z2 = true;
            if (i4 >= i3) {
                break;
            }
            float f2 = fArr[i4];
            if (!boolValueOf.booleanValue() || 0.0f > f2 || f2 > 1.0f) {
                z2 = false;
            }
            boolValueOf = Boolean.valueOf(z2);
            i4++;
        }
        if (!boolValueOf.booleanValue()) {
            throw new IllegalArgumentException(("FloatMapping - Progress outside of range: " + FloatList.joinToString$default(p2, null, null, null, 0, null, 31, null)).toString());
        }
        Iterable iterableV = p.a.V(1, p2.getSize());
        if ((iterableV instanceof Collection) && ((Collection) iterableV).isEmpty()) {
            i2 = 0;
        } else {
            Iterator it = iterableV.iterator();
            i2 = 0;
            while (((c) it).c) {
                int iNextInt = ((t) it).nextInt();
                if (p2.get(iNextInt) < p2.get(iNextInt - 1) && (i2 = i2 + 1) < 0) {
                    throw new ArithmeticException("Count overflow has happened.");
                }
            }
        }
        if (i2 <= 1) {
            return;
        }
        throw new IllegalArgumentException(("FloatMapping - Progress wraps more than once: " + FloatList.joinToString$default(p2, null, null, null, 0, null, 31, null)).toString());
    }
}
