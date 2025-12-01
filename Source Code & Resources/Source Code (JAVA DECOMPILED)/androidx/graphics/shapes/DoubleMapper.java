package androidx.graphics.shapes;

import androidx.collection.MutableFloatList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import l0.d;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class DoubleMapper {
    public static final Companion Companion = new Companion(null);
    public static final DoubleMapper Identity;
    private final MutableFloatList sourceValues;
    private final MutableFloatList targetValues;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Float fValueOf = Float.valueOf(0.0f);
        d dVar = new d(fValueOf, fValueOf);
        Float fValueOf2 = Float.valueOf(0.5f);
        Identity = new DoubleMapper(dVar, new d(fValueOf2, fValueOf2));
    }

    public DoubleMapper(d... mappings) {
        j.e(mappings, "mappings");
        this.sourceValues = new MutableFloatList(mappings.length);
        this.targetValues = new MutableFloatList(mappings.length);
        int length = mappings.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.sourceValues.add(((Number) mappings[i2].f850a).floatValue());
            this.targetValues.add(((Number) mappings[i2].f851b).floatValue());
        }
        FloatMappingKt.validateProgress(this.sourceValues);
        FloatMappingKt.validateProgress(this.targetValues);
    }

    public final float map(float f2) {
        return FloatMappingKt.linearMap(this.sourceValues, this.targetValues, f2);
    }

    public final float mapBack(float f2) {
        return FloatMappingKt.linearMap(this.targetValues, this.sourceValues, f2);
    }
}
