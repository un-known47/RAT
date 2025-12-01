package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import java.util.List;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import n0.c;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class Feature {
    private final List<Cubic> cubics;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Corner extends Feature {
        private final boolean convex;
        private final long roundedCenter;
        private final long vertex;

        public /* synthetic */ Corner(List list, long j, long j2, boolean z2, e eVar) {
            this(list, j, j2, z2);
        }

        public final boolean getConvex() {
            return this.convex;
        }

        /* renamed from: getRoundedCenter-1ufDz9w, reason: not valid java name */
        public final long m40getRoundedCenter1ufDz9w() {
            return this.roundedCenter;
        }

        /* renamed from: getVertex-1ufDz9w, reason: not valid java name */
        public final long m41getVertex1ufDz9w() {
            return this.vertex;
        }

        public String toString() {
            return "Corner: vertex=" + ((Object) FloatFloatPair.m15toStringimpl(this.vertex)) + ", center=" + ((Object) FloatFloatPair.m15toStringimpl(this.roundedCenter)) + ", convex=" + this.convex;
        }

        @Override // androidx.graphics.shapes.Feature
        public Feature transformed$graphics_shapes_release(PointTransformer f2) {
            j.e(f2, "f");
            c cVarQ = p.a.q();
            int size = getCubics().size();
            for (int i2 = 0; i2 < size; i2++) {
                cVarQ.add(getCubics().get(i2).transformed(f2));
            }
            return new Corner(p.a.e(cVarQ), PointKt.m58transformedso9K2fw(this.vertex, f2), PointKt.m58transformedso9K2fw(this.roundedCenter, f2), this.convex, null);
        }

        public /* synthetic */ Corner(List list, long j, long j2, boolean z2, int i2, e eVar) {
            this(list, j, j2, (i2 & 8) != 0 ? true : z2, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Corner(List<? extends Cubic> cubics, long j, long j2, boolean z2) {
            super(cubics);
            j.e(cubics, "cubics");
            this.vertex = j;
            this.roundedCenter = j2;
            this.convex = z2;
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Edge extends Feature {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Edge(List<? extends Cubic> cubics) {
            super(cubics);
            j.e(cubics, "cubics");
        }

        public String toString() {
            return "Edge";
        }

        @Override // androidx.graphics.shapes.Feature
        public Edge transformed$graphics_shapes_release(PointTransformer f2) {
            j.e(f2, "f");
            c cVarQ = p.a.q();
            int size = getCubics().size();
            for (int i2 = 0; i2 < size; i2++) {
                cVarQ.add(getCubics().get(i2).transformed(f2));
            }
            return new Edge(p.a.e(cVarQ));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Feature(List<? extends Cubic> cubics) {
        j.e(cubics, "cubics");
        this.cubics = cubics;
    }

    public final List<Cubic> getCubics() {
        return this.cubics;
    }

    public abstract Feature transformed$graphics_shapes_release(PointTransformer pointTransformer);
}
