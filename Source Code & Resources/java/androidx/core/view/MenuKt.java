package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class MenuKt {

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    /* renamed from: androidx.core.view.MenuKt$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<MenuItem>, z0.a {
        final /* synthetic */ Menu $this_iterator;
        private int index;

        public AnonymousClass1(Menu menu) {
            this.$this_iterator = menu;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.size();
        }

        @Override // java.util.Iterator
        public void remove() {
            l0.i iVar;
            Menu menu = this.$this_iterator;
            int i2 = this.index - 1;
            this.index = i2;
            MenuItem item = menu.getItem(i2);
            if (item != null) {
                menu.removeItem(item.getItemId());
                iVar = l0.i.f856a;
            } else {
                iVar = null;
            }
            if (iVar == null) {
                throw new IndexOutOfBoundsException();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public MenuItem next() {
            Menu menu = this.$this_iterator;
            int i2 = this.index;
            this.index = i2 + 1;
            MenuItem item = menu.getItem(i2);
            if (item != null) {
                return item;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(Menu menu, MenuItem menuItem) {
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (kotlin.jvm.internal.j.a(menu.getItem(i2), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(Menu menu, y0.l lVar) {
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            lVar.invoke(menu.getItem(i2));
        }
    }

    public static final void forEachIndexed(Menu menu, y0.p pVar) {
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Integer.valueOf(i2), menu.getItem(i2));
        }
    }

    public static final MenuItem get(Menu menu, int i2) {
        return menu.getItem(i2);
    }

    public static final e1.i getChildren(final Menu menu) {
        return new e1.i() { // from class: androidx.core.view.MenuKt$children$1
            @Override // e1.i
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }

    public static final int getSize(Menu menu) {
        return menu.size();
    }

    public static final boolean isEmpty(Menu menu) {
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(Menu menu) {
        return menu.size() != 0;
    }

    public static final Iterator<MenuItem> iterator(Menu menu) {
        return new AnonymousClass1(menu);
    }

    public static final void minusAssign(Menu menu, MenuItem menuItem) {
        menu.removeItem(menuItem.getItemId());
    }

    public static final void removeItemAt(Menu menu, int i2) {
        l0.i iVar;
        MenuItem item = menu.getItem(i2);
        if (item != null) {
            menu.removeItem(item.getItemId());
            iVar = l0.i.f856a;
        } else {
            iVar = null;
        }
        if (iVar == null) {
            throw new IndexOutOfBoundsException();
        }
    }
}
