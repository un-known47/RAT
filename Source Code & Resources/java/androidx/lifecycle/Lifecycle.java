package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class Lifecycle {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private AtomicReference<Object> internalScopeRef = new AtomicReference<>();

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static final Companion Companion = new Companion(null);

        /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
        public static final class Companion {

            /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[State.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[State.STARTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[State.RESUMED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[State.DESTROYED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[State.INITIALIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
                this();
            }

            public final Event downFrom(State state) {
                j.e(state, "state");
                int i2 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i2 == 1) {
                    return Event.ON_DESTROY;
                }
                if (i2 == 2) {
                    return Event.ON_STOP;
                }
                if (i2 != 3) {
                    return null;
                }
                return Event.ON_PAUSE;
            }

            public final Event downTo(State state) {
                j.e(state, "state");
                int i2 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i2 == 1) {
                    return Event.ON_STOP;
                }
                if (i2 == 2) {
                    return Event.ON_PAUSE;
                }
                if (i2 != 4) {
                    return null;
                }
                return Event.ON_DESTROY;
            }

            public final Event upFrom(State state) {
                j.e(state, "state");
                int i2 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i2 == 1) {
                    return Event.ON_START;
                }
                if (i2 == 2) {
                    return Event.ON_RESUME;
                }
                if (i2 != 5) {
                    return null;
                }
                return Event.ON_CREATE;
            }

            public final Event upTo(State state) {
                j.e(state, "state");
                int i2 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i2 == 1) {
                    return Event.ON_CREATE;
                }
                if (i2 == 2) {
                    return Event.ON_START;
                }
                if (i2 != 3) {
                    return null;
                }
                return Event.ON_RESUME;
            }

            private Companion() {
            }
        }

        /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Event.values().length];
                try {
                    iArr[Event.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Event.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Event.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Event.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Event.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Event.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Event.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public static final Event downFrom(State state) {
            return Companion.downFrom(state);
        }

        public static final Event downTo(State state) {
            return Companion.downTo(state);
        }

        public static final Event upFrom(State state) {
            return Companion.upFrom(state);
        }

        public static final Event upTo(State state) {
            return Companion.upTo(state);
        }

        public final State getTargetState() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                case 2:
                    return State.CREATED;
                case 3:
                case 4:
                    return State.STARTED;
                case 5:
                    return State.RESUMED;
                case 6:
                    return State.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean isAtLeast(State state) {
            j.e(state, "state");
            return compareTo(state) >= 0;
        }
    }

    @MainThread
    public abstract void addObserver(LifecycleObserver lifecycleObserver);

    @MainThread
    public abstract State getCurrentState();

    public final AtomicReference<Object> getInternalScopeRef() {
        return this.internalScopeRef;
    }

    @MainThread
    public abstract void removeObserver(LifecycleObserver lifecycleObserver);

    public final void setInternalScopeRef(AtomicReference<Object> atomicReference) {
        j.e(atomicReference, "<set-?>");
        this.internalScopeRef = atomicReference;
    }
}
