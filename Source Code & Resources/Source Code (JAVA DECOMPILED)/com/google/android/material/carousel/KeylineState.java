package com.google.android.material.carousel;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.utilities.Contrast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class KeylineState {
    private final int carouselSize;
    private final int firstFocalKeylineIndex;
    private final float itemSize;
    private final List<Keyline> keylines;
    private final int lastFocalKeylineIndex;
    private int totalVisibleFocalItems;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Builder {
        private static final int NO_INDEX = -1;
        private static final float UNKNOWN_LOC = Float.MIN_VALUE;
        private final int carouselSize;
        private final float itemSize;
        private Keyline tmpFirstFocalKeyline;
        private Keyline tmpLastFocalKeyline;
        private final List<Keyline> tmpKeylines = new ArrayList();
        private int firstFocalKeylineIndex = -1;
        private int lastFocalKeylineIndex = -1;
        private float lastKeylineMaskedSize = 0.0f;
        private int latestAnchorKeylineIndex = -1;

        public Builder(float f2, int i2) {
            this.itemSize = f2;
            this.carouselSize = i2;
        }

        private static float calculateKeylineLocationForItemPosition(float f2, float f3, int i2, int i3) {
            return (i3 * f3) + (f2 - (i2 * f3));
        }

        @NonNull
        public Builder addAnchorKeyline(float f2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f3, float f4) {
            return addKeyline(f2, f3, f4, false, true);
        }

        @NonNull
        public Builder addKeyline(float f2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f3, float f4, boolean z2) {
            return addKeyline(f2, f3, f4, z2, false);
        }

        @NonNull
        public Builder addKeylineRange(float f2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f3, float f4, int i2) {
            return addKeylineRange(f2, f3, f4, i2, false);
        }

        @NonNull
        public KeylineState build() {
            if (this.tmpFirstFocalKeyline == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.tmpKeylines.size(); i2++) {
                Keyline keyline = this.tmpKeylines.get(i2);
                arrayList.add(new Keyline(calculateKeylineLocationForItemPosition(this.tmpFirstFocalKeyline.locOffset, this.itemSize, this.firstFocalKeylineIndex, i2), keyline.locOffset, keyline.mask, keyline.maskedItemSize, keyline.isAnchor, keyline.cutoff, keyline.leftOrTopPaddingShift, keyline.rightOrBottomPaddingShift));
            }
            return new KeylineState(this.itemSize, arrayList, this.firstFocalKeylineIndex, this.lastFocalKeylineIndex, this.carouselSize);
        }

        @NonNull
        public Builder addKeyline(float f2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f3, float f4) {
            return addKeyline(f2, f3, f4, false);
        }

        @NonNull
        public Builder addKeylineRange(float f2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f3, float f4, int i2, boolean z2) {
            if (i2 > 0 && f4 > 0.0f) {
                for (int i3 = 0; i3 < i2; i3++) {
                    addKeyline((i3 * f4) + f2, f3, f4, z2);
                }
            }
            return this;
        }

        @NonNull
        public Builder addKeyline(float f2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f3, float f4, boolean z2, boolean z3, float f5, float f6, float f7) {
            if (f4 <= 0.0f) {
                return this;
            }
            if (z3) {
                if (!z2) {
                    int i2 = this.latestAnchorKeylineIndex;
                    if (i2 != -1 && i2 != 0) {
                        throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                    }
                    this.latestAnchorKeylineIndex = this.tmpKeylines.size();
                } else {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
            }
            Keyline keyline = new Keyline(UNKNOWN_LOC, f2, f3, f4, z3, f5, f6, f7);
            if (z2) {
                if (this.tmpFirstFocalKeyline == null) {
                    this.tmpFirstFocalKeyline = keyline;
                    this.firstFocalKeylineIndex = this.tmpKeylines.size();
                }
                if (this.lastFocalKeylineIndex != -1 && this.tmpKeylines.size() - this.lastFocalKeylineIndex > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f4 == this.tmpFirstFocalKeyline.maskedItemSize) {
                    this.tmpLastFocalKeyline = keyline;
                    this.lastFocalKeylineIndex = this.tmpKeylines.size();
                } else {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
            } else {
                if (this.tmpFirstFocalKeyline == null && keyline.maskedItemSize < this.lastKeylineMaskedSize) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.tmpLastFocalKeyline != null && keyline.maskedItemSize > this.lastKeylineMaskedSize) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.lastKeylineMaskedSize = keyline.maskedItemSize;
            this.tmpKeylines.add(keyline);
            return this;
        }

        @NonNull
        public Builder addKeyline(float f2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f3, float f4, boolean z2, boolean z3, float f5) {
            return addKeyline(f2, f3, f4, z2, z3, f5, 0.0f, 0.0f);
        }

        @NonNull
        public Builder addKeyline(float f2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f3, float f4, boolean z2, boolean z3) {
            Builder builder;
            float f5;
            float f6;
            float f7;
            boolean z4;
            boolean z5;
            float f8;
            float fAbs;
            float f9 = f4 / 2.0f;
            float f10 = f2 - f9;
            float f11 = f9 + f2;
            int i2 = this.carouselSize;
            if (f11 > i2) {
                fAbs = Math.abs(f11 - Math.max(f11 - f4, i2));
            } else if (f10 < 0.0f) {
                fAbs = Math.abs(f10 - Math.min(f10 + f4, 0.0f));
            } else {
                builder = this;
                f5 = f2;
                f6 = f3;
                f7 = f4;
                z4 = z2;
                z5 = z3;
                f8 = 0.0f;
                return builder.addKeyline(f5, f6, f7, z4, z5, f8);
            }
            builder = this;
            f5 = f2;
            f6 = f3;
            f7 = f4;
            z4 = z2;
            z5 = z3;
            f8 = fAbs;
            return builder.addKeyline(f5, f6, f7, z4, z5, f8);
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Keyline {
        final float cutoff;
        final boolean isAnchor;
        final float leftOrTopPaddingShift;
        final float loc;
        final float locOffset;
        final float mask;
        final float maskedItemSize;
        final float rightOrBottomPaddingShift;

        public Keyline(float f2, float f3, float f4, float f5) {
            this(f2, f3, f4, f5, false, 0.0f, 0.0f, 0.0f);
        }

        public static Keyline lerp(Keyline keyline, Keyline keyline2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f2) {
            return new Keyline(AnimationUtils.lerp(keyline.loc, keyline2.loc, f2), AnimationUtils.lerp(keyline.locOffset, keyline2.locOffset, f2), AnimationUtils.lerp(keyline.mask, keyline2.mask, f2), AnimationUtils.lerp(keyline.maskedItemSize, keyline2.maskedItemSize, f2));
        }

        public Keyline(float f2, float f3, float f4, float f5, boolean z2, float f6, float f7, float f8) {
            this.loc = f2;
            this.locOffset = f3;
            this.mask = f4;
            this.maskedItemSize = f5;
            this.isAnchor = z2;
            this.cutoff = f6;
            this.leftOrTopPaddingShift = f7;
            this.rightOrBottomPaddingShift = f8;
        }
    }

    public static KeylineState lerp(KeylineState keylineState, KeylineState keylineState2, float f2) {
        if (keylineState.getItemSize() != keylineState2.getItemSize()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List<Keyline> keylines = keylineState.getKeylines();
        List<Keyline> keylines2 = keylineState2.getKeylines();
        if (keylines.size() != keylines2.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < keylineState.getKeylines().size(); i2++) {
            arrayList.add(Keyline.lerp(keylines.get(i2), keylines2.get(i2), f2));
        }
        return new KeylineState(keylineState.getItemSize(), arrayList, AnimationUtils.lerp(keylineState.getFirstFocalKeylineIndex(), keylineState2.getFirstFocalKeylineIndex(), f2), AnimationUtils.lerp(keylineState.getLastFocalKeylineIndex(), keylineState2.getLastFocalKeylineIndex(), f2), keylineState.carouselSize);
    }

    public static KeylineState reverse(KeylineState keylineState, int i2) {
        Builder builder = new Builder(keylineState.getItemSize(), i2);
        float f2 = (i2 - keylineState.getLastKeyline().locOffset) - (keylineState.getLastKeyline().maskedItemSize / 2.0f);
        int size = keylineState.getKeylines().size() - 1;
        while (size >= 0) {
            Keyline keyline = keylineState.getKeylines().get(size);
            builder.addKeyline((keyline.maskedItemSize / 2.0f) + f2, keyline.mask, keyline.maskedItemSize, size >= keylineState.getFirstFocalKeylineIndex() && size <= keylineState.getLastFocalKeylineIndex(), keyline.isAnchor);
            f2 += keyline.maskedItemSize;
            size--;
        }
        return builder.build();
    }

    public int getCarouselSize() {
        return this.carouselSize;
    }

    public Keyline getFirstFocalKeyline() {
        return this.keylines.get(this.firstFocalKeylineIndex);
    }

    public int getFirstFocalKeylineIndex() {
        return this.firstFocalKeylineIndex;
    }

    public Keyline getFirstKeyline() {
        return this.keylines.get(0);
    }

    @Nullable
    public Keyline getFirstNonAnchorKeyline() {
        for (int i2 = 0; i2 < this.keylines.size(); i2++) {
            Keyline keyline = this.keylines.get(i2);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    public List<Keyline> getFocalKeylines() {
        return this.keylines.subList(this.firstFocalKeylineIndex, this.lastFocalKeylineIndex + 1);
    }

    public float getItemSize() {
        return this.itemSize;
    }

    public List<Keyline> getKeylines() {
        return this.keylines;
    }

    public Keyline getLastFocalKeyline() {
        return this.keylines.get(this.lastFocalKeylineIndex);
    }

    public int getLastFocalKeylineIndex() {
        return this.lastFocalKeylineIndex;
    }

    public Keyline getLastKeyline() {
        return this.keylines.get(r0.size() - 1);
    }

    @Nullable
    public Keyline getLastNonAnchorKeyline() {
        for (int size = this.keylines.size() - 1; size >= 0; size--) {
            Keyline keyline = this.keylines.get(size);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    public int getNumberOfNonAnchorKeylines() {
        Iterator<Keyline> it = this.keylines.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next().isAnchor) {
                i2++;
            }
        }
        return this.keylines.size() - i2;
    }

    public int getTotalVisibleFocalItems() {
        return this.totalVisibleFocalItems;
    }

    private KeylineState(float f2, List<Keyline> list, int i2, int i3, int i4) {
        this.itemSize = f2;
        this.keylines = Collections.unmodifiableList(list);
        this.firstFocalKeylineIndex = i2;
        this.lastFocalKeylineIndex = i3;
        while (i2 <= i3) {
            if (list.get(i2).cutoff == 0.0f) {
                this.totalVisibleFocalItems++;
            }
            i2++;
        }
        this.carouselSize = i4;
    }
}
