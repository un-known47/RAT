package com.google.android.material.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.transition.f;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class DrawableUtils {
    public static final int INTRINSIC_SIZE = -1;
    private static final int UNSPECIFIED_HEIGHT = -1;
    private static final int UNSPECIFIED_WIDTH = -1;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static class OutlineCompatL {
        private OutlineCompatL() {
        }

        @DoNotInline
        public static void setConvexPath(@NonNull Outline outline, @NonNull Path path) {
            outline.setConvexPath(path);
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    @RequiresApi(30)
    public static class OutlineCompatR {
        private OutlineCompatR() {
        }

        @DoNotInline
        public static void setPath(@NonNull Outline outline, @NonNull Path path) {
            outline.setPath(path);
        }
    }

    private DrawableUtils() {
    }

    @Nullable
    public static Drawable compositeTwoLayeredDrawable(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        return compositeTwoLayeredDrawable(drawable, drawable2, -1, -1);
    }

    @Nullable
    public static Drawable createTintableDrawableIfNeeded(@Nullable Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        return createTintableMutatedDrawableIfNeeded(drawable, colorStateList, mode, false);
    }

    @Nullable
    public static Drawable createTintableMutatedDrawableIfNeeded(@Nullable Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        return createTintableMutatedDrawableIfNeeded(drawable, colorStateList, mode, Build.VERSION.SDK_INT < 23);
    }

    @NonNull
    public static int[] getCheckedState(@NonNull int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 == 16842912) {
                return iArr;
            }
            if (i3 == 0) {
                int[] iArr2 = (int[]) iArr.clone();
                iArr2[i2] = 16842912;
                return iArr2;
            }
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length + 1);
        iArrCopyOf[iArr.length] = 16842912;
        return iArrCopyOf;
    }

    @Nullable
    public static ColorStateList getColorStateListOrNull(@Nullable Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !f.o(drawable)) {
            return null;
        }
        return f.e(drawable).getColorStateList();
    }

    private static int getTopLayerIntrinsicHeight(@NonNull Drawable drawable, @NonNull Drawable drawable2) {
        int intrinsicHeight = drawable2.getIntrinsicHeight();
        return intrinsicHeight != -1 ? intrinsicHeight : drawable.getIntrinsicHeight();
    }

    private static int getTopLayerIntrinsicWidth(@NonNull Drawable drawable, @NonNull Drawable drawable2) {
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        return intrinsicWidth != -1 ? intrinsicWidth : drawable.getIntrinsicWidth();
    }

    @NonNull
    public static int[] getUncheckedState(@NonNull int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        int i2 = 0;
        for (int i3 : iArr) {
            if (i3 != 16842912) {
                iArr2[i2] = i3;
                i2++;
            }
        }
        return iArr2;
    }

    @NonNull
    public static AttributeSet parseDrawableXml(@NonNull Context context, @XmlRes int i2, @NonNull CharSequence charSequence) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        try {
            XmlResourceParser xml = context.getResources().getXml(i2);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            if (TextUtils.equals(xml.getName(), charSequence)) {
                return Xml.asAttributeSet(xml);
            }
            throw new XmlPullParserException("Must have a <" + ((Object) charSequence) + "> start tag");
        } catch (IOException e2) {
            e = e2;
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i2));
            notFoundException.initCause(e);
            throw notFoundException;
        } catch (XmlPullParserException e3) {
            e = e3;
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i2));
            notFoundException2.initCause(e);
            throw notFoundException2;
        }
    }

    public static void setOutlineToPath(@NonNull Outline outline, @NonNull Path path) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            OutlineCompatR.setPath(outline, path);
            return;
        }
        if (i2 >= 29) {
            try {
                OutlineCompatL.setConvexPath(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            OutlineCompatL.setConvexPath(outline, path);
        }
    }

    public static void setRippleDrawableRadius(@Nullable RippleDrawable rippleDrawable, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 23) {
            rippleDrawable.setRadius(i2);
            return;
        }
        try {
            try {
                RippleDrawable.class.getDeclaredMethod("setMaxRadius", Integer.TYPE).invoke(rippleDrawable, Integer.valueOf(i2));
            } catch (IllegalAccessException e2) {
                e = e2;
                throw new IllegalStateException("Couldn't set RippleDrawable radius", e);
            } catch (InvocationTargetException e3) {
                e = e3;
                throw new IllegalStateException("Couldn't set RippleDrawable radius", e);
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e4) {
            e = e4;
            throw new IllegalStateException("Couldn't set RippleDrawable radius", e);
        }
    }

    public static void setTint(@NonNull Drawable drawable, @ColorInt int i2) {
        boolean z2 = i2 != 0;
        if (Build.VERSION.SDK_INT == 21) {
            if (z2) {
                drawable.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
                return;
            } else {
                drawable.setColorFilter(null);
                return;
            }
        }
        if (z2) {
            drawable.setTint(i2);
        } else {
            drawable.setTintList(null);
        }
    }

    @Nullable
    public static PorterDuffColorFilter updateTintFilter(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    @Nullable
    public static Drawable compositeTwoLayeredDrawable(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Px int i2, @Px int i3) {
        Drawable scaledDrawableWrapper = drawable2;
        int topLayerIntrinsicWidth = i2;
        int intrinsicHeight = i3;
        if (drawable == null) {
            return scaledDrawableWrapper;
        }
        if (scaledDrawableWrapper == null) {
            return drawable;
        }
        boolean z2 = (topLayerIntrinsicWidth == -1 || intrinsicHeight == -1) ? false : true;
        if (topLayerIntrinsicWidth == -1) {
            topLayerIntrinsicWidth = getTopLayerIntrinsicWidth(drawable, drawable2);
        }
        if (intrinsicHeight == -1) {
            intrinsicHeight = getTopLayerIntrinsicHeight(drawable, drawable2);
        }
        if (topLayerIntrinsicWidth > drawable.getIntrinsicWidth() || intrinsicHeight > drawable.getIntrinsicHeight()) {
            float f2 = topLayerIntrinsicWidth / intrinsicHeight;
            if (f2 >= drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                intrinsicHeight = (int) (intrinsicWidth / f2);
                topLayerIntrinsicWidth = intrinsicWidth;
            } else {
                intrinsicHeight = drawable.getIntrinsicHeight();
                topLayerIntrinsicWidth = (int) (f2 * intrinsicHeight);
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, scaledDrawableWrapper});
            layerDrawable.setLayerSize(1, topLayerIntrinsicWidth, intrinsicHeight);
            layerDrawable.setLayerGravity(1, 17);
            return layerDrawable;
        }
        if (z2) {
            scaledDrawableWrapper = new ScaledDrawableWrapper(scaledDrawableWrapper, topLayerIntrinsicWidth, intrinsicHeight);
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{drawable, scaledDrawableWrapper});
        int iMax = Math.max((drawable.getIntrinsicWidth() - topLayerIntrinsicWidth) / 2, 0);
        int iMax2 = Math.max((drawable.getIntrinsicHeight() - intrinsicHeight) / 2, 0);
        layerDrawable2.setLayerInset(1, iMax, iMax2, iMax, iMax2);
        return layerDrawable2;
    }

    @Nullable
    private static Drawable createTintableMutatedDrawableIfNeeded(@Nullable Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, boolean z2) {
        if (drawable == null) {
            return null;
        }
        if (colorStateList == null) {
            if (z2) {
                drawable.mutate();
            }
            return drawable;
        }
        Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
        if (mode != null) {
            drawableMutate.setTintMode(mode);
        }
        return drawableMutate;
    }
}
