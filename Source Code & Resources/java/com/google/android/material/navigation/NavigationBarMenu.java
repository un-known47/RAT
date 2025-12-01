package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.g;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class NavigationBarMenu extends MenuBuilder {
    public static final int NO_MAX_ITEM_LIMIT = Integer.MAX_VALUE;
    private final int maxItemCount;
    private final boolean subMenuSupported;

    @NonNull
    private final Class<?> viewClass;

    public NavigationBarMenu(@NonNull Context context, @NonNull Class<?> cls, int i2, boolean z2) {
        super(context);
        this.viewClass = cls;
        this.maxItemCount = i2;
        this.subMenuSupported = z2;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    @NonNull
    public MenuItem addInternal(int i2, int i3, int i4, @NonNull CharSequence charSequence) {
        if (size() + 1 <= this.maxItemCount) {
            stopDispatchingItemsChanged();
            MenuItem menuItemAddInternal = super.addInternal(i2, i3, i4, charSequence);
            startDispatchingItemsChanged();
            return menuItemAddInternal;
        }
        String simpleName = this.viewClass.getSimpleName();
        StringBuilder sbS = g.s("Maximum number of items supported by ", simpleName, " is ");
        sbS.append(this.maxItemCount);
        sbS.append(". Limit can be checked with ");
        sbS.append(simpleName);
        sbS.append("#getMaxItemCount()");
        throw new IllegalArgumentException(sbS.toString());
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    @NonNull
    public SubMenu addSubMenu(int i2, int i3, int i4, @NonNull CharSequence charSequence) {
        if (!this.subMenuSupported) {
            throw new UnsupportedOperationException(this.viewClass.getSimpleName().concat(" does not support submenus"));
        }
        MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal(i2, i3, i4, charSequence);
        NavigationBarSubMenu navigationBarSubMenu = new NavigationBarSubMenu(getContext(), this, menuItemImpl);
        menuItemImpl.setSubMenu(navigationBarSubMenu);
        return navigationBarSubMenu;
    }

    public int getMaxItemCount() {
        return this.maxItemCount;
    }
}
