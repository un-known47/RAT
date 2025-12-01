package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.CarouselStrategy;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class KeylineStateList {
    private static final int NO_INDEX = -1;
    private final KeylineState defaultState;
    private final float endShiftRange;
    private final List<KeylineState> endStateSteps;
    private final float[] endStateStepsInterpolationPoints;
    private final float startShiftRange;
    private final List<KeylineState> startStateSteps;
    private final float[] startStateStepsInterpolationPoints;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    /* renamed from: com.google.android.material.carousel.KeylineStateList$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$material$carousel$CarouselStrategy$StrategyType;

        static {
            int[] iArr = new int[CarouselStrategy.StrategyType.values().length];
            $SwitchMap$com$google$android$material$carousel$CarouselStrategy$StrategyType = iArr;
            try {
                iArr[CarouselStrategy.StrategyType.CONTAINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private KeylineStateList(@NonNull KeylineState keylineState, List<KeylineState> list, List<KeylineState> list2) {
        this.defaultState = keylineState;
        this.startStateSteps = Collections.unmodifiableList(list);
        this.endStateSteps = Collections.unmodifiableList(list2);
        float f2 = list.get(list.size() - 1).getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
        this.startShiftRange = f2;
        float f3 = keylineState.getLastKeyline().loc - list2.get(list2.size() - 1).getLastKeyline().loc;
        this.endShiftRange = f3;
        this.startStateStepsInterpolationPoints = getStateStepInterpolationPoints(f2, list, true);
        this.endStateStepsInterpolationPoints = getStateStepInterpolationPoints(f3, list2, false);
    }

    private KeylineState closestStateStepFromInterpolation(List<KeylineState> list, float f2, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f2, fArr);
        return stateStepsRange[0] >= 0.5f ? list.get((int) stateStepsRange[2]) : list.get((int) stateStepsRange[1]);
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState keylineState, float f2) {
        for (int lastFocalKeylineIndex = keylineState.getLastFocalKeylineIndex(); lastFocalKeylineIndex < keylineState.getKeylines().size(); lastFocalKeylineIndex++) {
            if (f2 == keylineState.getKeylines().get(lastFocalKeylineIndex).mask) {
                return lastFocalKeylineIndex;
            }
        }
        return keylineState.getKeylines().size() - 1;
    }

    private static int findFirstNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int i2 = 0; i2 < keylineState.getKeylines().size(); i2++) {
            if (!keylineState.getKeylines().get(i2).isAnchor) {
                return i2;
            }
        }
        return -1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState keylineState, float f2) {
        for (int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - 1; firstFocalKeylineIndex >= 0; firstFocalKeylineIndex--) {
            if (f2 == keylineState.getKeylines().get(firstFocalKeylineIndex).mask) {
                return firstFocalKeylineIndex;
            }
        }
        return 0;
    }

    private static int findLastNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int size = keylineState.getKeylines().size() - 1; size >= 0; size--) {
            if (!keylineState.getKeylines().get(size).isAnchor) {
                return size;
            }
        }
        return -1;
    }

    public static KeylineStateList from(Carousel carousel, KeylineState keylineState, float f2, float f3, float f4, CarouselStrategy.StrategyType strategyType) {
        return new KeylineStateList(keylineState, getStateStepsStart(carousel, keylineState, f2, f3, strategyType), getStateStepsEnd(carousel, keylineState, f2, f4, strategyType));
    }

    private static float[] getStateStepInterpolationPoints(float f2, List<KeylineState> list, boolean z2) {
        int size = list.size();
        float[] fArr = new float[size];
        int i2 = 1;
        while (i2 < size) {
            int i3 = i2 - 1;
            KeylineState keylineState = list.get(i3);
            KeylineState keylineState2 = list.get(i2);
            fArr[i2] = i2 == size + (-1) ? 1.0f : fArr[i3] + ((z2 ? keylineState2.getFirstKeyline().loc - keylineState.getFirstKeyline().loc : keylineState.getLastKeyline().loc - keylineState2.getLastKeyline().loc) / f2);
            i2++;
        }
        return fArr;
    }

    private static List<KeylineState> getStateStepsEnd(Carousel carousel, KeylineState keylineState, float f2, float f3, CarouselStrategy.StrategyType strategyType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int iFindLastNonAnchorKeylineIndex = findLastNonAnchorKeylineIndex(keylineState);
        int containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        if (!isLastFocalItemVisibleAtRightOfContainer(carousel, keylineState) && iFindLastNonAnchorKeylineIndex != -1) {
            int lastFocalKeylineIndex = iFindLastNonAnchorKeylineIndex - keylineState.getLastFocalKeylineIndex();
            float f4 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            if (lastFocalKeylineIndex <= 0 && keylineState.getLastFocalKeyline().cutoff > 0.0f) {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, (f4 - keylineState.getLastFocalKeyline().cutoff) - f3, containerWidth));
                return arrayList;
            }
            int i2 = 0;
            float f5 = 0.0f;
            while (i2 < lastFocalKeylineIndex) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int i3 = iFindLastNonAnchorKeylineIndex - i2;
                float f6 = f5 + keylineState.getKeylines().get(i3).cutoff;
                int i4 = i3 + 1;
                int i5 = containerWidth;
                KeylineState keylineStateMoveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState2, iFindLastNonAnchorKeylineIndex, i4 < keylineState.getKeylines().size() ? findLastIndexBeforeFirstFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i4).mask) + 1 : 0, f4 - f6, keylineState.getFirstFocalKeylineIndex() + i2 + 1, keylineState.getLastFocalKeylineIndex() + i2 + 1, i5);
                if (i2 == lastFocalKeylineIndex - 1 && f3 > 0.0f) {
                    keylineStateMoveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(keylineStateMoveKeylineAndCreateKeylineState, f3, i5, false, f2, strategyType);
                    i5 = i5;
                }
                arrayList.add(keylineStateMoveKeylineAndCreateKeylineState);
                i2++;
                containerWidth = i5;
                f5 = f6;
            }
        } else if (f3 > 0.0f) {
            arrayList.add(shiftKeylineStateForPadding(keylineState, f3, containerWidth, false, f2, strategyType));
        }
        return arrayList;
    }

    private static float[] getStateStepsRange(List<KeylineState> list, float f2, float[] fArr) {
        int size = list.size();
        float f3 = fArr[0];
        int i2 = 1;
        while (i2 < size) {
            float f4 = fArr[i2];
            if (f2 <= f4) {
                return new float[]{AnimationUtils.lerp(0.0f, 1.0f, f3, f4, f2), i2 - 1, i2};
            }
            i2++;
            f3 = f4;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List<KeylineState> getStateStepsStart(Carousel carousel, KeylineState keylineState, float f2, float f3, CarouselStrategy.StrategyType strategyType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int iFindFirstNonAnchorKeylineIndex = findFirstNonAnchorKeylineIndex(keylineState);
        int containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        if (!isFirstFocalItemAtLeftOfContainer(keylineState) && iFindFirstNonAnchorKeylineIndex != -1) {
            int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - iFindFirstNonAnchorKeylineIndex;
            float f4 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            if (firstFocalKeylineIndex <= 0 && keylineState.getFirstFocalKeyline().cutoff > 0.0f) {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, f4 + keylineState.getFirstFocalKeyline().cutoff + f3, containerWidth));
                return arrayList;
            }
            float f5 = 0.0f;
            for (int i2 = 0; i2 < firstFocalKeylineIndex; i2++) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int i3 = iFindFirstNonAnchorKeylineIndex + i2;
                int size = keylineState.getKeylines().size() - 1;
                f5 += keylineState.getKeylines().get(i3).cutoff;
                int i4 = i3 - 1;
                if (i4 >= 0) {
                    size = findFirstIndexAfterLastFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i4).mask) - 1;
                }
                int i5 = containerWidth;
                KeylineState keylineStateMoveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState2, iFindFirstNonAnchorKeylineIndex, size, f4 + f5, (keylineState.getFirstFocalKeylineIndex() - i2) - 1, (keylineState.getLastFocalKeylineIndex() - i2) - 1, i5);
                containerWidth = i5;
                if (i2 == firstFocalKeylineIndex - 1 && f3 > 0.0f) {
                    keylineStateMoveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(keylineStateMoveKeylineAndCreateKeylineState, f3, containerWidth, true, f2, strategyType);
                }
                arrayList.add(keylineStateMoveKeylineAndCreateKeylineState);
            }
        } else if (f3 > 0.0f) {
            arrayList.add(shiftKeylineStateForPadding(keylineState, f3, containerWidth, true, f2, strategyType));
        }
        return arrayList;
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState keylineState) {
        return keylineState.getFirstFocalKeyline().locOffset - (keylineState.getFirstFocalKeyline().maskedItemSize / 2.0f) >= 0.0f && keylineState.getFirstFocalKeyline() == keylineState.getFirstNonAnchorKeyline();
    }

    private static boolean isLastFocalItemVisibleAtRightOfContainer(Carousel carousel, KeylineState keylineState) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        return (keylineState.getLastFocalKeyline().maskedItemSize / 2.0f) + keylineState.getLastFocalKeyline().locOffset <= ((float) containerHeight) && keylineState.getLastFocalKeyline() == keylineState.getLastNonAnchorKeyline();
    }

    private static KeylineState lerp(List<KeylineState> list, float f2, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f2, fArr);
        return KeylineState.lerp(list.get((int) stateStepsRange[1]), list.get((int) stateStepsRange[2]), stateStepsRange[0]);
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState keylineState, int i2, int i3, float f2, int i4, int i5, int i6) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        arrayList.add(i3, (KeylineState.Keyline) arrayList.remove(i2));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i6);
        int i7 = 0;
        while (i7 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i7);
            float f3 = keyline.maskedItemSize;
            builder.addKeyline((f3 / 2.0f) + f2, keyline.mask, f3, i7 >= i4 && i7 <= i5, keyline.isAnchor, keyline.cutoff);
            f2 += keyline.maskedItemSize;
            i7++;
        }
        return builder.build();
    }

    @NonNull
    private static KeylineState shiftKeylineStateForPadding(@NonNull KeylineState keylineState, float f2, int i2, boolean z2, float f3, CarouselStrategy.StrategyType strategyType) {
        return AnonymousClass1.$SwitchMap$com$google$android$material$carousel$CarouselStrategy$StrategyType[strategyType.ordinal()] != 1 ? shiftKeylineStateForPaddingUncontained(keylineState, f2, i2, z2) : shiftKeylineStateForPaddingContained(keylineState, f2, i2, z2, f3);
    }

    private static KeylineState shiftKeylineStateForPaddingContained(KeylineState keylineState, float f2, int i2, boolean z2, float f3) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i2);
        float numberOfNonAnchorKeylines = f2 / keylineState.getNumberOfNonAnchorKeylines();
        float f4 = z2 ? f2 : 0.0f;
        int i3 = 0;
        while (i3 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i3);
            if (keyline.isAnchor) {
                builder.addKeyline(keyline.locOffset, keyline.mask, keyline.maskedItemSize, false, true, keyline.cutoff);
            } else {
                boolean z3 = i3 >= keylineState.getFirstFocalKeylineIndex() && i3 <= keylineState.getLastFocalKeylineIndex();
                float f5 = keyline.maskedItemSize - numberOfNonAnchorKeylines;
                float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(f5, keylineState.getItemSize(), f3);
                float f6 = (f5 / 2.0f) + f4;
                float fAbs = Math.abs(f6 - keyline.locOffset);
                builder.addKeyline(f6, childMaskPercentage, f5, z3, false, keyline.cutoff, z2 ? fAbs : 0.0f, z2 ? 0.0f : fAbs);
                f4 += f5;
            }
            i3++;
        }
        return builder.build();
    }

    @NonNull
    private static KeylineState shiftKeylineStateForPaddingUncontained(@NonNull KeylineState keylineState, float f2, int i2, boolean z2) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i2);
        int size = z2 ? 0 : arrayList.size() - 1;
        int i3 = 0;
        while (i3 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i3);
            if (keyline.isAnchor && i3 == size) {
                builder.addKeyline(keyline.locOffset, keyline.mask, keyline.maskedItemSize, false, true, keyline.cutoff);
            } else {
                float f3 = keyline.locOffset;
                float f4 = z2 ? f3 + f2 : f3 - f2;
                float f5 = z2 ? f2 : 0.0f;
                float f6 = z2 ? 0.0f : f2;
                boolean z3 = i3 >= keylineState.getFirstFocalKeylineIndex() && i3 <= keylineState.getLastFocalKeylineIndex();
                float f7 = f4;
                float f8 = keyline.mask;
                float f9 = keyline.maskedItemSize;
                builder.addKeyline(f7, f8, f9, z3, keyline.isAnchor, Math.abs(z2 ? Math.max(0.0f, ((f9 / 2.0f) + f7) - i2) : Math.min(0.0f, f7 - (f9 / 2.0f))), f5, f6);
            }
            i3++;
        }
        return builder.build();
    }

    private static KeylineState shiftKeylinesAndCreateKeylineState(KeylineState keylineState, float f2, int i2) {
        return moveKeylineAndCreateKeylineState(keylineState, 0, 0, f2, keylineState.getFirstFocalKeylineIndex(), keylineState.getLastFocalKeylineIndex(), i2);
    }

    public KeylineState getDefaultState() {
        return this.defaultState;
    }

    public KeylineState getEndState() {
        return this.endStateSteps.get(r0.size() - 1);
    }

    public Map<Integer, KeylineState> getKeylineStateForPositionMap(int i2, int i3, int i4, boolean z2) {
        float itemSize = this.defaultState.getItemSize();
        HashMap map = new HashMap();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= i2) {
                break;
            }
            int i7 = z2 ? (i2 - i5) - 1 : i5;
            if (i7 * itemSize * (z2 ? -1 : 1) > i4 - this.endShiftRange || i5 >= i2 - this.endStateSteps.size()) {
                Integer numValueOf = Integer.valueOf(i7);
                List<KeylineState> list = this.endStateSteps;
                map.put(numValueOf, list.get(MathUtils.clamp(i6, 0, list.size() - 1)));
                i6++;
            }
            i5++;
        }
        int i8 = 0;
        for (int i9 = i2 - 1; i9 >= 0; i9--) {
            int i10 = z2 ? (i2 - i9) - 1 : i9;
            if (i10 * itemSize * (z2 ? -1 : 1) < i3 + this.startShiftRange || i9 < this.startStateSteps.size()) {
                Integer numValueOf2 = Integer.valueOf(i10);
                List<KeylineState> list2 = this.startStateSteps;
                map.put(numValueOf2, list2.get(MathUtils.clamp(i8, 0, list2.size() - 1)));
                i8++;
            }
        }
        return map;
    }

    @NonNull
    public KeylineState getShiftedState(float f2, float f3, float f4) {
        return getShiftedState(f2, f3, f4, false);
    }

    public KeylineState getStartState() {
        return this.startStateSteps.get(r0.size() - 1);
    }

    public KeylineState getShiftedState(float f2, float f3, float f4, boolean z2) {
        float fLerp;
        List<KeylineState> list;
        float[] fArr;
        float f5 = this.startShiftRange + f3;
        float f6 = f4 - this.endShiftRange;
        float f7 = getStartState().getFirstFocalKeyline().leftOrTopPaddingShift;
        float f8 = getEndState().getFirstFocalKeyline().rightOrBottomPaddingShift;
        if (this.startShiftRange == f7) {
            f5 += f7;
        }
        if (this.endShiftRange == f8) {
            f6 -= f8;
        }
        if (f2 < f5) {
            fLerp = AnimationUtils.lerp(1.0f, 0.0f, f3, f5, f2);
            list = this.startStateSteps;
            fArr = this.startStateStepsInterpolationPoints;
        } else {
            if (f2 <= f6) {
                return this.defaultState;
            }
            fLerp = AnimationUtils.lerp(0.0f, 1.0f, f6, f4, f2);
            list = this.endStateSteps;
            fArr = this.endStateStepsInterpolationPoints;
        }
        return z2 ? closestStateStepFromInterpolation(list, fLerp, fArr) : lerp(list, fLerp, fArr);
    }
}
