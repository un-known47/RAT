package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class HeroCarouselStrategy extends CarouselStrategy {
    private int keylineCount = 0;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {0, 1};

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f2 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredWidth = view.getMeasuredWidth() * 2;
        if (carousel.isHorizontal()) {
            f2 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredWidth = view.getMeasuredHeight() * 2;
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f2;
        float fMax = Math.max(getSmallItemSizeMax() + f2, smallItemSizeMin);
        float f3 = containerHeight;
        float fMin = Math.min(measuredWidth + f2, f3);
        float fClamp = MathUtils.clamp((measuredWidth / 3.0f) + f2, smallItemSizeMin + f2, fMax + f2);
        float f4 = (fMin + fClamp) / 2.0f;
        int i2 = 0;
        int[] iArr = f3 < 2.0f * smallItemSizeMin ? new int[]{0} : SMALL_COUNTS;
        int iMax = (int) Math.max(1.0d, Math.floor((f3 - (CarouselStrategyHelper.maxValue(r1) * fMax)) / fMin));
        int iCeil = (((int) Math.ceil(f3 / fMin)) - iMax) + 1;
        int[] iArr2 = new int[iCeil];
        for (int i3 = 0; i3 < iCeil; i3++) {
            iArr2[i3] = iMax + i3;
        }
        int i4 = carousel.getCarouselAlignment() == 1 ? 1 : 0;
        Arrangement arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(f3, fClamp, smallItemSizeMin, fMax, i4 != 0 ? CarouselStrategy.doubleCounts(iArr) : iArr, f4, i4 != 0 ? CarouselStrategy.doubleCounts(MEDIUM_COUNTS) : MEDIUM_COUNTS, fMin, iArr2);
        this.keylineCount = arrangementFindLowestCostArrangement.getItemCount();
        if (arrangementFindLowestCostArrangement.getItemCount() > carousel.getItemCount()) {
            arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(f3, fClamp, smallItemSizeMin, fMax, iArr, f4, MEDIUM_COUNTS, fMin, iArr2);
        } else {
            i2 = i4;
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f2, containerHeight, arrangementFindLowestCostArrangement, i2);
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean shouldRefreshKeylineState(@NonNull Carousel carousel, int i2) {
        if (carousel.getCarouselAlignment() == 1) {
            return (i2 < this.keylineCount && carousel.getItemCount() >= this.keylineCount) || (i2 >= this.keylineCount && carousel.getItemCount() < this.keylineCount);
        }
        return false;
    }
}
