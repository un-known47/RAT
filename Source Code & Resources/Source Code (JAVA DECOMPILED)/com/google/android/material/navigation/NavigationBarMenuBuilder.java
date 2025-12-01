package com.google.android.material.navigation;

import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class NavigationBarMenuBuilder {
    private final MenuBuilder menuBuilder;
    private int contentItemCount = 0;
    private int visibleContentItemCount = 0;
    private int visibleMainItemCount = 0;
    private final List<MenuItem> items = new ArrayList();

    public NavigationBarMenuBuilder(MenuBuilder menuBuilder) {
        this.menuBuilder = menuBuilder;
        refreshItems();
    }

    public int getContentItemCount() {
        return this.contentItemCount;
    }

    @NonNull
    public MenuItem getItemAt(int i2) {
        return this.items.get(i2);
    }

    public int getVisibleContentItemCount() {
        return this.visibleContentItemCount;
    }

    public int getVisibleMainContentItemCount() {
        return this.visibleMainItemCount;
    }

    public boolean performItemAction(@NonNull MenuItem menuItem, @NonNull MenuPresenter menuPresenter, int i2) {
        return this.menuBuilder.performItemAction(menuItem, menuPresenter, i2);
    }

    public void refreshItems() {
        this.items.clear();
        this.contentItemCount = 0;
        this.visibleContentItemCount = 0;
        this.visibleMainItemCount = 0;
        for (int i2 = 0; i2 < this.menuBuilder.size(); i2++) {
            MenuItem item = this.menuBuilder.getItem(i2);
            if (item.hasSubMenu()) {
                if (!this.items.isEmpty()) {
                    if (!(this.items.get(r3.size() - 1) instanceof DividerMenuItem) && item.isVisible()) {
                        this.items.add(new DividerMenuItem());
                    }
                }
                this.items.add(item);
                SubMenu subMenu = item.getSubMenu();
                for (int i3 = 0; i3 < subMenu.size(); i3++) {
                    MenuItem item2 = subMenu.getItem(i3);
                    if (!item.isVisible()) {
                        item2.setVisible(false);
                    }
                    this.items.add(item2);
                    this.contentItemCount++;
                    if (item2.isVisible()) {
                        this.visibleContentItemCount++;
                    }
                }
                this.items.add(new DividerMenuItem());
            } else {
                this.items.add(item);
                this.contentItemCount++;
                if (item.isVisible()) {
                    this.visibleContentItemCount++;
                    this.visibleMainItemCount++;
                }
            }
        }
        if (this.items.isEmpty()) {
            return;
        }
        if (this.items.get(r0.size() - 1) instanceof DividerMenuItem) {
            this.items.remove(r0.size() - 1);
        }
    }

    public int size() {
        return this.items.size();
    }
}
