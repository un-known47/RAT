package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselStrategy;
import com.google.android.material.carousel.KeylineState;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class UncontainedCarouselStrategy extends CarouselStrategy {
    private static final float MEDIUM_LARGE_ITEM_PERCENTAGE_THRESHOLD = 0.85f;

    private float calculateMediumChildSize(float f2, float f3, float f4) {
        float fMax = Math.max(1.5f * f4, f2);
        float f5 = MEDIUM_LARGE_ITEM_PERCENTAGE_THRESHOLD * f3;
        if (fMax > f5) {
            fMax = Math.max(f5, f4 * 1.2f);
        }
        return Math.min(f3, fMax);
    }

    private KeylineState createCenterAlignedKeylineState(int i2, float f2, float f3, int i3, float f4, float f5, float f6) {
        float fMin = Math.min(f5, f3);
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(fMin, f3, f2);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(f4, f3, f2);
        float f7 = f4 / 2.0f;
        float f8 = (f6 + 0.0f) - f7;
        float f9 = f8 + f7;
        float f10 = fMin / 2.0f;
        float f11 = (i3 * f3) + f9;
        KeylineState.Builder builderAddKeylineRange = new KeylineState.Builder(f3, i2).addAnchorKeyline((f8 - f7) - f10, childMaskPercentage, fMin).addKeyline(f8, childMaskPercentage2, f4, false).addKeylineRange((f3 / 2.0f) + f9, 0.0f, f3, i3, true);
        builderAddKeylineRange.addKeyline(f7 + f11, childMaskPercentage2, f4, false);
        builderAddKeylineRange.addAnchorKeyline(f11 + f4 + f10, childMaskPercentage, fMin);
        return builderAddKeylineRange.build();
    }

    private KeylineState createLeftAlignedKeylineState(Context context, float f2, int i2, float f3, int i3, float f4, int i4, float f5) {
        float fMin = Math.min(f5, f3);
        float fMax = Math.max(fMin, 0.5f * f4);
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(fMax, f3, f2);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(fMin, f3, f2);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(f4, f3, f2);
        float f6 = (i3 * f3) + 0.0f;
        KeylineState.Builder builderAddKeylineRange = new KeylineState.Builder(f3, i2).addAnchorKeyline(0.0f - (fMax / 2.0f), childMaskPercentage, fMax).addKeylineRange(f3 / 2.0f, 0.0f, f3, i3, true);
        if (i4 > 0) {
            float f7 = (f4 / 2.0f) + f6;
            f6 += f4;
            builderAddKeylineRange.addKeyline(f7, childMaskPercentage3, f4, false);
        }
        builderAddKeylineRange.addAnchorKeyline((CarouselStrategyHelper.getExtraSmallSize(context) / 2.0f) + f6, childMaskPercentage2, fMin);
        return builderAddKeylineRange.build();
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public CarouselStrategy.StrategyType getStrategyType() {
        return CarouselStrategy.StrategyType.UNCONTAINED;
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        int containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f2 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f2 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f3 = measuredHeight;
        float f4 = f2;
        float f5 = f3 + f4;
        float extraSmallSize = CarouselStrategyHelper.getExtraSmallSize(view.getContext()) + f4;
        float extraSmallSize2 = CarouselStrategyHelper.getExtraSmallSize(view.getContext()) + f4;
        int iMax = Math.max(1, (int) Math.floor(r1 / f5));
        float f6 = containerWidth - (iMax * f5);
        if (carousel.getCarouselAlignment() == 1) {
            float f7 = f6 / 2.0f;
            return createCenterAlignedKeylineState(containerWidth, f4, f5, iMax, Math.max(Math.min(3.0f * f7, f5), getSmallItemSizeMin() + f4), extraSmallSize2, f7);
        }
        return createLeftAlignedKeylineState(view.getContext(), f4, containerWidth, f5, iMax, calculateMediumChildSize(extraSmallSize, f5, f6), f6 > 0.0f ? 1 : 0, extraSmallSize2);
    }
}
