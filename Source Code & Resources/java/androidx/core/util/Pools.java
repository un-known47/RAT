package androidx.core.util;

import androidx.annotation.IntRange;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class Pools {

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public interface Pool<T> {
        T acquire();

        boolean release(T t2);
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] pool;
        private int poolSize;

        public SimplePool(@IntRange(from = 1) int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.pool = new Object[i2];
        }

        private final boolean isInPool(T t2) {
            int i2 = this.poolSize;
            for (int i3 = 0; i3 < i2; i3++) {
                if (this.pool[i3] == t2) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            int i2 = this.poolSize;
            if (i2 <= 0) {
                return null;
            }
            int i3 = i2 - 1;
            T t2 = (T) this.pool[i3];
            j.c(t2, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
            this.pool[i3] = null;
            this.poolSize--;
            return t2;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(T instance) {
            j.e(instance, "instance");
            if (isInPool(instance)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i2 = this.poolSize;
            Object[] objArr = this.pool;
            if (i2 >= objArr.length) {
                return false;
            }
            objArr[i2] = instance;
            this.poolSize = i2 + 1;
            return true;
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object lock;

        public SynchronizedPool(int i2) {
            super(i2);
            this.lock = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public T acquire() {
            T t2;
            synchronized (this.lock) {
                t2 = (T) super.acquire();
            }
            return t2;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(T instance) {
            boolean zRelease;
            j.e(instance, "instance");
            synchronized (this.lock) {
                zRelease = super.release(instance);
            }
            return zRelease;
        }
    }

    private Pools() {
    }
}
