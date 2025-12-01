package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {

    @Px
    private int itemMinimumHeight;

    @Px
    private int itemSpacing;
    private final FrameLayout.LayoutParams layoutParams;

    public NavigationRailMenuView(@NonNull Context context) {
        super(context);
        this.itemMinimumHeight = -1;
        this.itemSpacing = 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.layoutParams = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setItemActiveIndicatorResizeable(true);
    }

    private int makeSharedHeightSpec(int i2, int i3, int i4) {
        int iMax = i3 / Math.max(1, i4);
        int size = this.itemMinimumHeight;
        if (size == -1) {
            size = View.MeasureSpec.getSize(i2);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, iMax), 0);
    }

    private int measureChildHeight(View view, int i2, int i3) {
        view.measure(i2, i3);
        if (view.getVisibility() != 8) {
            return view.getMeasuredHeight();
        }
        return 0;
    }

    private int measureSharedChildHeights(int i2, int i3, int i4, View view) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 0);
        int childCount = getChildCount();
        int iMeasureChildHeight = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (!(childAt instanceof NavigationBarItemView)) {
                int iMeasureChildHeight2 = measureChildHeight(childAt, i2, iMakeMeasureSpec);
                i3 -= iMeasureChildHeight2;
                iMeasureChildHeight += iMeasureChildHeight2;
            }
        }
        int iMakeSharedHeightSpec = view == null ? makeSharedHeightSpec(i2, Math.max(i3, 0), i4) : View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt2 = getChildAt(i7);
            if (childAt2.getVisibility() == 0) {
                i6++;
            }
            if ((childAt2 instanceof NavigationBarItemView) && childAt2 != view) {
                iMeasureChildHeight += measureChildHeight(childAt2, i2, iMakeSharedHeightSpec);
            }
        }
        return (Math.max(0, i6 - 1) * this.itemSpacing) + iMeasureChildHeight;
    }

    private int measureShiftingChildHeights(int i2, int i3, int i4) {
        int iMeasureChildHeight;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            iMeasureChildHeight = measureChildHeight(childAt, i2, makeSharedHeightSpec(i2, i3, i4));
            i3 -= iMeasureChildHeight;
            i4--;
        } else {
            iMeasureChildHeight = 0;
        }
        return iMeasureChildHeight + measureSharedChildHeights(i2, i3, i4, childAt);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    public NavigationBarItemView createNavigationBarItemView(@NonNull Context context) {
        return new NavigationRailItemView(context);
    }

    @Px
    public int getItemMinimumHeight() {
        return this.itemMinimumHeight;
    }

    @Px
    public int getItemSpacing() {
        return this.itemSpacing;
    }

    public int getMenuGravity() {
        return this.layoutParams.gravity;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = 0;
        int measuredHeight = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                measuredHeight += childAt.getMeasuredHeight();
                i7++;
            }
        }
        int iMax = i7 <= 1 ? 0 : Math.max(0, Math.min((getMeasuredHeight() - measuredHeight) / (i7 - 1), this.itemSpacing));
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt2 = getChildAt(i10);
            if (childAt2.getVisibility() != 8) {
                int measuredHeight2 = childAt2.getMeasuredHeight();
                childAt2.layout(0, i9, i6, measuredHeight2 + i9);
                i9 += measuredHeight2 + iMax;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        int currentVisibleContentItemCount = getCurrentVisibleContentItemCount();
        setMeasuredDimension(View.MeasureSpec.getSize(i2), View.resolveSizeAndState((currentVisibleContentItemCount <= 1 || !isShifting(getLabelVisibilityMode(), currentVisibleContentItemCount)) ? measureSharedChildHeights(i2, size, currentVisibleContentItemCount, null) : measureShiftingChildHeights(i2, size, currentVisibleContentItemCount), i3, 0));
    }

    public void setItemMinimumHeight(@Px int i2) {
        if (this.itemMinimumHeight != i2) {
            this.itemMinimumHeight = i2;
            requestLayout();
        }
    }

    public void setItemSpacing(@Px int i2) {
        if (this.itemSpacing != i2) {
            this.itemSpacing = i2;
            requestLayout();
        }
    }

    public void setMenuGravity(int i2) {
        FrameLayout.LayoutParams layoutParams = this.layoutParams;
        if (layoutParams.gravity != i2) {
            layoutParams.gravity = i2;
            setLayoutParams(layoutParams);
        }
    }
}
