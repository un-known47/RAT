package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private int keylineCount = 0;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {1, 0};

    public boolean ensureArrangementFitsItemCount(Arrangement arrangement, int i2) {
        int itemCount = arrangement.getItemCount() - i2;
        boolean z2 = itemCount > 0 && (arrangement.smallCount > 0 || arrangement.mediumCount > 1);
        while (itemCount > 0) {
            int i3 = arrangement.smallCount;
            if (i3 > 0) {
                arrangement.smallCount = i3 - 1;
            } else {
                int i4 = arrangement.mediumCount;
                if (i4 > 1) {
                    arrangement.mediumCount = i4 - 1;
                }
            }
            itemCount--;
        }
        return z2;
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        boolean z2;
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f2 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f2 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f2;
        float fMax = Math.max(getSmallItemSizeMax() + f2, smallItemSizeMin);
        float f3 = containerHeight;
        float fMin = Math.min(measuredHeight + f2, f3);
        float fClamp = MathUtils.clamp((measuredHeight / 3.0f) + f2, smallItemSizeMin + f2, fMax + f2);
        float f4 = (fMin + fClamp) / 2.0f;
        int[] iArrDoubleCounts = SMALL_COUNTS;
        float f5 = 2.0f * smallItemSizeMin;
        if (f3 <= f5) {
            iArrDoubleCounts = new int[]{0};
        }
        int[] iArrDoubleCounts2 = MEDIUM_COUNTS;
        if (carousel.getCarouselAlignment() == 1) {
            iArrDoubleCounts = CarouselStrategy.doubleCounts(iArrDoubleCounts);
            iArrDoubleCounts2 = CarouselStrategy.doubleCounts(iArrDoubleCounts2);
        }
        int iMax = (int) Math.max(1.0d, Math.floor(((f3 - (CarouselStrategyHelper.maxValue(iArrDoubleCounts2) * f4)) - (CarouselStrategyHelper.maxValue(iArrDoubleCounts) * fMax)) / fMin));
        int iCeil = (int) Math.ceil(f3 / fMin);
        int i2 = (iCeil - iMax) + 1;
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = iCeil - i3;
        }
        Arrangement arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(f3, fClamp, smallItemSizeMin, fMax, iArrDoubleCounts, f4, iArrDoubleCounts2, fMin, iArr);
        this.keylineCount = arrangementFindLowestCostArrangement.getItemCount();
        boolean zEnsureArrangementFitsItemCount = ensureArrangementFitsItemCount(arrangementFindLowestCostArrangement, carousel.getItemCount());
        int i4 = arrangementFindLowestCostArrangement.mediumCount;
        if (i4 == 0 && arrangementFindLowestCostArrangement.smallCount == 0 && f3 > f5) {
            arrangementFindLowestCostArrangement.smallCount = 1;
            z2 = true;
        } else {
            z2 = zEnsureArrangementFitsItemCount;
        }
        if (z2) {
            arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(f3, fClamp, smallItemSizeMin, fMax, new int[]{arrangementFindLowestCostArrangement.smallCount}, f4, new int[]{i4}, fMin, new int[]{arrangementFindLowestCostArrangement.largeCount});
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f2, containerHeight, arrangementFindLowestCostArrangement, carousel.getCarouselAlignment());
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean shouldRefreshKeylineState(@NonNull Carousel carousel, int i2) {
        if (i2 >= this.keylineCount || carousel.getItemCount() < this.keylineCount) {
            return i2 >= this.keylineCount && carousel.getItemCount() < this.keylineCount;
        }
        return true;
    }
}
