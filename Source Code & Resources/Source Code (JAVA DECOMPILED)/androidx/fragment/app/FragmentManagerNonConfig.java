package androidx.fragment.app;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@Deprecated
/* loaded from: classes.dex */
public class FragmentManagerNonConfig {

    @Nullable
    private final Map<String, FragmentManagerNonConfig> mChildNonConfigs;

    @Nullable
    private final Collection<Fragment> mFragments;

    @Nullable
    private final Map<String, ViewModelStore> mViewModelStores;

    public FragmentManagerNonConfig(@Nullable Collection<Fragment> collection, @Nullable Map<String, FragmentManagerNonConfig> map, @Nullable Map<String, ViewModelStore> map2) {
        this.mFragments = collection;
        this.mChildNonConfigs = map;
        this.mViewModelStores = map2;
    }

    @Nullable
    public Map<String, FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    @Nullable
    public Collection<Fragment> getFragments() {
        return this.mFragments;
    }

    @Nullable
    public Map<String, ViewModelStore> getViewModelStores() {
        return this.mViewModelStores;
    }

    public boolean isRetaining(Fragment fragment) {
        Collection<Fragment> collection = this.mFragments;
        if (collection == null) {
            return false;
        }
        return collection.contains(fragment);
    }
}
