package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class QuantizerWu implements Quantizer {
    private static final int INDEX_BITS = 5;
    private static final int INDEX_COUNT = 33;
    private static final int TOTAL_SIZE = 35937;
    Box[] cubes;
    double[] moments;
    int[] momentsB;
    int[] momentsG;
    int[] momentsR;
    int[] weights;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Box {

        /* renamed from: b0, reason: collision with root package name */
        int f269b0;

        /* renamed from: b1, reason: collision with root package name */
        int f270b1;

        /* renamed from: g0, reason: collision with root package name */
        int f271g0;

        /* renamed from: g1, reason: collision with root package name */
        int f272g1;

        /* renamed from: r0, reason: collision with root package name */
        int f273r0;

        /* renamed from: r1, reason: collision with root package name */
        int f274r1;
        int vol;

        private Box() {
            this.f273r0 = 0;
            this.f274r1 = 0;
            this.f271g0 = 0;
            this.f272g1 = 0;
            this.f269b0 = 0;
            this.f270b1 = 0;
            this.vol = 0;
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class CreateBoxesResult {
        int resultCount;

        public CreateBoxesResult(int i2, int i3) {
            this.resultCount = i3;
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public enum Direction {
        RED,
        GREEN,
        BLUE
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class MaximizeResult {
        int cutLocation;
        double maximum;

        public MaximizeResult(int i2, double d) {
            this.cutLocation = i2;
            this.maximum = d;
        }
    }

    public static int bottom(Box box, Direction direction, int[] iArr) {
        int i2;
        int i3;
        int iOrdinal = direction.ordinal();
        if (iOrdinal == 0) {
            i2 = (-iArr[getIndex(box.f273r0, box.f272g1, box.f270b1)]) + iArr[getIndex(box.f273r0, box.f272g1, box.f269b0)] + iArr[getIndex(box.f273r0, box.f271g0, box.f270b1)];
            i3 = iArr[getIndex(box.f273r0, box.f271g0, box.f269b0)];
        } else if (iOrdinal == 1) {
            i2 = (-iArr[getIndex(box.f274r1, box.f271g0, box.f270b1)]) + iArr[getIndex(box.f274r1, box.f271g0, box.f269b0)] + iArr[getIndex(box.f273r0, box.f271g0, box.f270b1)];
            i3 = iArr[getIndex(box.f273r0, box.f271g0, box.f269b0)];
        } else {
            if (iOrdinal != 2) {
                throw new IllegalArgumentException("unexpected direction " + direction);
            }
            i2 = (-iArr[getIndex(box.f274r1, box.f272g1, box.f269b0)]) + iArr[getIndex(box.f274r1, box.f271g0, box.f269b0)] + iArr[getIndex(box.f273r0, box.f272g1, box.f269b0)];
            i3 = iArr[getIndex(box.f273r0, box.f271g0, box.f269b0)];
        }
        return i2 - i3;
    }

    public static int getIndex(int i2, int i3, int i4) {
        return (i2 << 10) + (i2 << 6) + i2 + (i3 << 5) + i3 + i4;
    }

    public static int top(Box box, Direction direction, int i2, int[] iArr) {
        int i3;
        int i4;
        int iOrdinal = direction.ordinal();
        if (iOrdinal == 0) {
            i3 = (iArr[getIndex(i2, box.f272g1, box.f270b1)] - iArr[getIndex(i2, box.f272g1, box.f269b0)]) - iArr[getIndex(i2, box.f271g0, box.f270b1)];
            i4 = iArr[getIndex(i2, box.f271g0, box.f269b0)];
        } else if (iOrdinal == 1) {
            i3 = (iArr[getIndex(box.f274r1, i2, box.f270b1)] - iArr[getIndex(box.f274r1, i2, box.f269b0)]) - iArr[getIndex(box.f273r0, i2, box.f270b1)];
            i4 = iArr[getIndex(box.f273r0, i2, box.f269b0)];
        } else {
            if (iOrdinal != 2) {
                throw new IllegalArgumentException("unexpected direction " + direction);
            }
            i3 = (iArr[getIndex(box.f274r1, box.f272g1, i2)] - iArr[getIndex(box.f274r1, box.f271g0, i2)]) - iArr[getIndex(box.f273r0, box.f272g1, i2)];
            i4 = iArr[getIndex(box.f273r0, box.f271g0, i2)];
        }
        return i3 + i4;
    }

    public static int volume(Box box, int[] iArr) {
        return ((((((iArr[getIndex(box.f274r1, box.f272g1, box.f270b1)] - iArr[getIndex(box.f274r1, box.f272g1, box.f269b0)]) - iArr[getIndex(box.f274r1, box.f271g0, box.f270b1)]) + iArr[getIndex(box.f274r1, box.f271g0, box.f269b0)]) - iArr[getIndex(box.f273r0, box.f272g1, box.f270b1)]) + iArr[getIndex(box.f273r0, box.f272g1, box.f269b0)]) + iArr[getIndex(box.f273r0, box.f271g0, box.f270b1)]) - iArr[getIndex(box.f273r0, box.f271g0, box.f269b0)];
    }

    public void constructHistogram(Map<Integer, Integer> map) {
        this.weights = new int[TOTAL_SIZE];
        this.momentsR = new int[TOTAL_SIZE];
        this.momentsG = new int[TOTAL_SIZE];
        this.momentsB = new int[TOTAL_SIZE];
        this.moments = new double[TOTAL_SIZE];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            int iRedFromArgb = ColorUtils.redFromArgb(iIntValue);
            int iGreenFromArgb = ColorUtils.greenFromArgb(iIntValue);
            int iBlueFromArgb = ColorUtils.blueFromArgb(iIntValue);
            int index = getIndex((iRedFromArgb >> 3) + 1, (iGreenFromArgb >> 3) + 1, (iBlueFromArgb >> 3) + 1);
            int[] iArr = this.weights;
            iArr[index] = iArr[index] + iIntValue2;
            int[] iArr2 = this.momentsR;
            iArr2[index] = (iRedFromArgb * iIntValue2) + iArr2[index];
            int[] iArr3 = this.momentsG;
            iArr3[index] = (iGreenFromArgb * iIntValue2) + iArr3[index];
            int[] iArr4 = this.momentsB;
            iArr4[index] = (iBlueFromArgb * iIntValue2) + iArr4[index];
            double[] dArr = this.moments;
            int i2 = iBlueFromArgb * iBlueFromArgb;
            dArr[index] = dArr[index] + ((i2 + (iGreenFromArgb * iGreenFromArgb) + (iRedFromArgb * iRedFromArgb)) * iIntValue2);
        }
    }

    public CreateBoxesResult createBoxes(int i2) {
        int i3;
        this.cubes = new Box[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            this.cubes[i4] = new Box();
        }
        double[] dArr = new double[i2];
        Box box = this.cubes[0];
        box.f274r1 = 32;
        box.f272g1 = 32;
        box.f270b1 = 32;
        int i5 = 1;
        int i6 = 0;
        while (true) {
            if (i5 >= i2) {
                i3 = i2;
                break;
            }
            Box[] boxArr = this.cubes;
            if (cut(boxArr[i6], boxArr[i5]).booleanValue()) {
                Box box2 = this.cubes[i6];
                dArr[i6] = box2.vol > 1 ? variance(box2) : 0.0d;
                Box box3 = this.cubes[i5];
                dArr[i5] = box3.vol > 1 ? variance(box3) : 0.0d;
            } else {
                dArr[i6] = 0.0d;
                i5--;
            }
            double d = dArr[0];
            int i7 = 0;
            for (int i8 = 1; i8 <= i5; i8++) {
                double d2 = dArr[i8];
                if (d2 > d) {
                    i7 = i8;
                    d = d2;
                }
            }
            if (d <= 0.0d) {
                i3 = i5 + 1;
                break;
            }
            i5++;
            i6 = i7;
        }
        return new CreateBoxesResult(i2, i3);
    }

    public void createMoments() {
        int i2 = 1;
        while (true) {
            int i3 = 33;
            if (i2 >= 33) {
                return;
            }
            int[] iArr = new int[33];
            int[] iArr2 = new int[33];
            int[] iArr3 = new int[33];
            int[] iArr4 = new int[33];
            double[] dArr = new double[33];
            int i4 = 1;
            while (i4 < i3) {
                int i5 = 0;
                double d = 0.0d;
                int i6 = 1;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                while (i6 < i3) {
                    int index = getIndex(i2, i4, i6);
                    i5 += this.weights[index];
                    i7 += this.momentsR[index];
                    i8 += this.momentsG[index];
                    i9 += this.momentsB[index];
                    d += this.moments[index];
                    iArr[i6] = iArr[i6] + i5;
                    iArr2[i6] = iArr2[i6] + i7;
                    iArr3[i6] = iArr3[i6] + i8;
                    iArr4[i6] = iArr4[i6] + i9;
                    dArr[i6] = dArr[i6] + d;
                    int index2 = getIndex(i2 - 1, i4, i6);
                    int i10 = i6;
                    int[] iArr5 = this.weights;
                    iArr5[index] = iArr5[index2] + iArr[i10];
                    int[] iArr6 = this.momentsR;
                    iArr6[index] = iArr6[index2] + iArr2[i10];
                    int[] iArr7 = this.momentsG;
                    iArr7[index] = iArr7[index2] + iArr3[i10];
                    int[] iArr8 = this.momentsB;
                    iArr8[index] = iArr8[index2] + iArr4[i10];
                    double[] dArr2 = this.moments;
                    dArr2[index] = dArr2[index2] + dArr[i10];
                    i6 = i10 + 1;
                    i3 = 33;
                }
                i4++;
                i3 = 33;
            }
            i2++;
        }
    }

    public List<Integer> createResult(int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            Box box = this.cubes[i3];
            int iVolume = volume(box, this.weights);
            if (iVolume > 0) {
                int iVolume2 = volume(box, this.momentsR) / iVolume;
                int iVolume3 = volume(box, this.momentsG) / iVolume;
                arrayList.add(Integer.valueOf(((volume(box, this.momentsB) / iVolume) & 255) | ((iVolume2 & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((iVolume3 & 255) << 8)));
            }
        }
        return arrayList;
    }

    public Boolean cut(Box box, Box box2) {
        int iVolume = volume(box, this.momentsR);
        int iVolume2 = volume(box, this.momentsG);
        int iVolume3 = volume(box, this.momentsB);
        int iVolume4 = volume(box, this.weights);
        Direction direction = Direction.RED;
        MaximizeResult maximizeResultMaximize = maximize(box, direction, box.f273r0 + 1, box.f274r1, iVolume, iVolume2, iVolume3, iVolume4);
        Direction direction2 = Direction.GREEN;
        MaximizeResult maximizeResultMaximize2 = maximize(box, direction2, box.f271g0 + 1, box.f272g1, iVolume, iVolume2, iVolume3, iVolume4);
        Direction direction3 = Direction.BLUE;
        MaximizeResult maximizeResultMaximize3 = maximize(box, direction3, box.f269b0 + 1, box.f270b1, iVolume, iVolume2, iVolume3, iVolume4);
        double d = maximizeResultMaximize.maximum;
        double d2 = maximizeResultMaximize2.maximum;
        double d3 = maximizeResultMaximize3.maximum;
        if (d < d2 || d < d3) {
            if (d2 >= d && d2 >= d3) {
                direction3 = direction2;
            }
        } else {
            if (maximizeResultMaximize.cutLocation < 0) {
                return Boolean.FALSE;
            }
            direction3 = direction;
        }
        box2.f274r1 = box.f274r1;
        box2.f272g1 = box.f272g1;
        box2.f270b1 = box.f270b1;
        int iOrdinal = direction3.ordinal();
        if (iOrdinal == 0) {
            int i2 = maximizeResultMaximize.cutLocation;
            box.f274r1 = i2;
            box2.f273r0 = i2;
            box2.f271g0 = box.f271g0;
            box2.f269b0 = box.f269b0;
        } else if (iOrdinal == 1) {
            int i3 = maximizeResultMaximize2.cutLocation;
            box.f272g1 = i3;
            box2.f273r0 = box.f273r0;
            box2.f271g0 = i3;
            box2.f269b0 = box.f269b0;
        } else if (iOrdinal == 2) {
            int i4 = maximizeResultMaximize3.cutLocation;
            box.f270b1 = i4;
            box2.f273r0 = box.f273r0;
            box2.f271g0 = box.f271g0;
            box2.f269b0 = i4;
        }
        box.vol = (box.f270b1 - box.f269b0) * (box.f272g1 - box.f271g0) * (box.f274r1 - box.f273r0);
        box2.vol = (box2.f270b1 - box2.f269b0) * (box2.f272g1 - box2.f271g0) * (box2.f274r1 - box2.f273r0);
        return Boolean.TRUE;
    }

    public MaximizeResult maximize(Box box, Direction direction, int i2, int i3, int i4, int i5, int i6, int i7) {
        QuantizerWu quantizerWu = this;
        Box box2 = box;
        int iBottom = bottom(box2, direction, quantizerWu.momentsR);
        int iBottom2 = bottom(box2, direction, quantizerWu.momentsG);
        int iBottom3 = bottom(box2, direction, quantizerWu.momentsB);
        int iBottom4 = bottom(box2, direction, quantizerWu.weights);
        double d = 0.0d;
        int i8 = -1;
        int i9 = i2;
        while (i9 < i3) {
            int pVar = top(box2, direction, i9, quantizerWu.momentsR) + iBottom;
            int pVar2 = top(box2, direction, i9, quantizerWu.momentsG) + iBottom2;
            int pVar3 = top(box2, direction, i9, quantizerWu.momentsB) + iBottom3;
            int pVar4 = top(box2, direction, i9, quantizerWu.weights) + iBottom4;
            if (pVar4 != 0) {
                double d2 = ((pVar3 * pVar3) + ((pVar2 * pVar2) + (pVar * pVar))) / pVar4;
                int i10 = i4 - pVar;
                int i11 = i5 - pVar2;
                int i12 = i6 - pVar3;
                int i13 = i7 - pVar4;
                if (i13 != 0) {
                    int i14 = i12 * i12;
                    double d3 = ((i14 + ((i11 * i11) + (i10 * i10))) / i13) + d2;
                    if (d3 > d) {
                        i8 = i9;
                        d = d3;
                    }
                }
            }
            i9++;
            quantizerWu = this;
            box2 = box;
        }
        return new MaximizeResult(i8, d);
    }

    @Override // com.google.android.material.color.utilities.Quantizer
    public QuantizerResult quantize(int[] iArr, int i2) {
        constructHistogram(new QuantizerMap().quantize(iArr, i2).colorToCount);
        createMoments();
        List<Integer> listCreateResult = createResult(createBoxes(i2).resultCount);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Integer num : listCreateResult) {
            num.intValue();
            linkedHashMap.put(num, 0);
        }
        return new QuantizerResult(linkedHashMap);
    }

    public double variance(Box box) {
        int iVolume = volume(box, this.momentsR);
        int iVolume2 = volume(box, this.momentsG);
        int iVolume3 = volume(box, this.momentsB);
        int i2 = iVolume3 * iVolume3;
        return (((((((this.moments[getIndex(box.f274r1, box.f272g1, box.f270b1)] - this.moments[getIndex(box.f274r1, box.f272g1, box.f269b0)]) - this.moments[getIndex(box.f274r1, box.f271g0, box.f270b1)]) + this.moments[getIndex(box.f274r1, box.f271g0, box.f269b0)]) - this.moments[getIndex(box.f273r0, box.f272g1, box.f270b1)]) + this.moments[getIndex(box.f273r0, box.f272g1, box.f269b0)]) + this.moments[getIndex(box.f273r0, box.f271g0, box.f270b1)]) - this.moments[getIndex(box.f273r0, box.f271g0, box.f269b0)]) - ((i2 + ((iVolume2 * iVolume2) + (iVolume * iVolume))) / volume(box, this.weights));
    }
}
