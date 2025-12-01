package androidx.graphics.shapes;

import android.graphics.Matrix;
import android.graphics.Path;
import androidx.collection.FloatFloatPair;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class Shapes_androidKt {
    private static final void pathFromCubics(Path path, List<? extends Cubic> list) {
        path.rewind();
        int size = list.size();
        boolean z2 = true;
        for (int i2 = 0; i2 < size; i2++) {
            Cubic cubic = list.get(i2);
            if (z2) {
                path.moveTo(cubic.getAnchor0X(), cubic.getAnchor0Y());
                z2 = false;
            }
            path.cubicTo(cubic.getControl0X(), cubic.getControl0Y(), cubic.getControl1X(), cubic.getControl1Y(), cubic.getAnchor1X(), cubic.getAnchor1Y());
        }
        path.close();
    }

    public static final Path toPath(RoundedPolygon roundedPolygon) {
        j.e(roundedPolygon, "<this>");
        return toPath$default(roundedPolygon, null, 1, null);
    }

    public static /* synthetic */ Path toPath$default(RoundedPolygon roundedPolygon, Path path, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            path = new Path();
        }
        return toPath(roundedPolygon, path);
    }

    public static final RoundedPolygon transformed(RoundedPolygon roundedPolygon, final Matrix matrix) {
        j.e(roundedPolygon, "<this>");
        j.e(matrix, "matrix");
        final float[] fArr = new float[2];
        return roundedPolygon.transformed(new PointTransformer() { // from class: androidx.graphics.shapes.Shapes_androidKt.transformed.1
            @Override // androidx.graphics.shapes.PointTransformer
            /* renamed from: transform-XgqJiTY */
            public final long mo60transformXgqJiTY(float f2, float f3) {
                float[] fArr2 = fArr;
                fArr2[0] = f2;
                fArr2[1] = f3;
                matrix.mapPoints(fArr2);
                float[] fArr3 = fArr;
                return FloatFloatPair.m8constructorimpl(fArr3[0], fArr3[1]);
            }
        });
    }

    public static final Path toPath(RoundedPolygon roundedPolygon, Path path) {
        j.e(roundedPolygon, "<this>");
        j.e(path, "path");
        pathFromCubics(path, roundedPolygon.getCubics());
        return path;
    }

    public static /* synthetic */ Path toPath$default(Morph morph, float f2, Path path, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            path = new Path();
        }
        return toPath(morph, f2, path);
    }

    public static final Path toPath(Morph morph, float f2, Path path) {
        j.e(morph, "<this>");
        j.e(path, "path");
        pathFromCubics(path, morph.asCubics(f2));
        return path;
    }
}
