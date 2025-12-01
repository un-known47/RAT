package com.google.android.material.navigation;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class NavigationBarSubMenu extends SubMenuBuilder {
    public NavigationBarSubMenu(@NonNull Context context, @NonNull NavigationBarMenu navigationBarMenu, @NonNull MenuItemImpl menuItemImpl) {
        super(context, navigationBarMenu, menuItemImpl);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void onItemsChanged(boolean z2) {
        super.onItemsChanged(z2);
        ((MenuBuilder) getParentMenu()).onItemsChanged(z2);
    }
}
