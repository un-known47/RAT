package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class Score {
    private static final int BLUE_500 = -12417548;
    private static final double CUTOFF_CHROMA = 5.0d;
    private static final double CUTOFF_EXCITED_PROPORTION = 0.01d;
    private static final int MAX_COLOR_COUNT = 4;
    private static final double TARGET_CHROMA = 48.0d;
    private static final double WEIGHT_CHROMA_ABOVE = 0.3d;
    private static final double WEIGHT_CHROMA_BELOW = 0.1d;
    private static final double WEIGHT_PROPORTION = 0.7d;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static class ScoredComparator implements Comparator<ScoredHCT> {
        @Override // java.util.Comparator
        public int compare(ScoredHCT scoredHCT, ScoredHCT scoredHCT2) {
            return Double.compare(scoredHCT2.score, scoredHCT.score);
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static class ScoredHCT {
        public final Hct hct;
        public final double score;

        public ScoredHCT(Hct hct, double d) {
            this.hct = hct;
            this.score = d;
        }
    }

    private Score() {
    }

    public static List<Integer> score(Map<Integer, Integer> map) {
        return score(map, 4, BLUE_500, true);
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i2) {
        return score(map, i2, BLUE_500, true);
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i2, int i3) {
        return score(map, i2, i3, true);
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i2, int i3, boolean z2) {
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[360];
        double d = 0.0d;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Hct hctFromInt = Hct.fromInt(entry.getKey().intValue());
            arrayList.add(hctFromInt);
            int iFloor = (int) Math.floor(hctFromInt.getHue());
            int iIntValue = entry.getValue().intValue();
            iArr[iFloor] = iArr[iFloor] + iIntValue;
            d += iIntValue;
        }
        double[] dArr = new double[360];
        int i4 = 0;
        for (int i5 = 0; i5 < 360; i5++) {
            double d2 = iArr[i5] / d;
            for (int i6 = i5 - 14; i6 < i5 + 16; i6++) {
                int iSanitizeDegreesInt = MathUtils.sanitizeDegreesInt(i6);
                dArr[iSanitizeDegreesInt] = dArr[iSanitizeDegreesInt] + d2;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj = arrayList.get(i7);
            i7++;
            Hct hct = (Hct) obj;
            double d3 = dArr[MathUtils.sanitizeDegreesInt((int) Math.round(hct.getHue()))];
            if (!z2 || (hct.getChroma() >= CUTOFF_CHROMA && d3 > CUTOFF_EXCITED_PROPORTION)) {
                arrayList2.add(new ScoredHCT(hct, ((hct.getChroma() - TARGET_CHROMA) * (hct.getChroma() < TARGET_CHROMA ? WEIGHT_CHROMA_BELOW : WEIGHT_CHROMA_ABOVE)) + (d3 * 100.0d * WEIGHT_PROPORTION)));
            }
        }
        Collections.sort(arrayList2, new ScoredComparator());
        ArrayList arrayList3 = new ArrayList();
        for (int i8 = 90; i8 >= 15; i8--) {
            arrayList3.clear();
            int size2 = arrayList2.size();
            int i9 = 0;
            while (i9 < size2) {
                Object obj2 = arrayList2.get(i9);
                i9++;
                Hct hct2 = ((ScoredHCT) obj2).hct;
                int size3 = arrayList3.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size3) {
                        arrayList3.add(hct2);
                        break;
                    }
                    Object obj3 = arrayList3.get(i10);
                    i10++;
                    if (MathUtils.differenceDegrees(hct2.getHue(), ((Hct) obj3).getHue()) < i8) {
                        break;
                    }
                }
                if (arrayList3.size() >= i2) {
                    break;
                }
            }
            if (arrayList3.size() >= i2) {
                break;
            }
        }
        ArrayList arrayList4 = new ArrayList();
        if (arrayList3.isEmpty()) {
            arrayList4.add(Integer.valueOf(i3));
            return arrayList4;
        }
        int size4 = arrayList3.size();
        while (i4 < size4) {
            Object obj4 = arrayList3.get(i4);
            i4++;
            arrayList4.add(Integer.valueOf(((Hct) obj4).toInt()));
        }
        return arrayList4;
    }
}
