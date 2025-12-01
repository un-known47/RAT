package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class IntVector extends BaseVector {
    public IntVector __assign(int i2, ByteBuffer byteBuffer) {
        __reset(i2, 4, byteBuffer);
        return this;
    }

    public int get(int i2) {
        return this.bb.getInt(__element(i2));
    }

    public long getAsUnsigned(int i2) {
        return get(i2) & 4294967295L;
    }
}
