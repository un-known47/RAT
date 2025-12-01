package m0;

import androidx.graphics.shapes.MeasuredPolygon;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class k extends o {
    public static void m0(Collection collection, Iterable elements) {
        kotlin.jvm.internal.j.e(collection, "<this>");
        kotlin.jvm.internal.j.e(elements, "elements");
        if (elements instanceof Collection) {
            collection.addAll((Collection) elements);
            return;
        }
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }

    public static boolean n0(Iterable iterable, Object obj) {
        int iIndexOf;
        kotlin.jvm.internal.j.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (!(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    iIndexOf = -1;
                    break;
                }
                Object next = it.next();
                if (i2 < 0) {
                    l.j0();
                    throw null;
                }
                if (kotlin.jvm.internal.j.a(obj, next)) {
                    iIndexOf = i2;
                    break;
                }
                i2++;
            }
        } else {
            iIndexOf = ((List) iterable).indexOf(obj);
        }
        return iIndexOf >= 0;
    }

    public static Object o0(List list) {
        kotlin.jvm.internal.j.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object p0(List list) {
        kotlin.jvm.internal.j.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object q0(MeasuredPolygon measuredPolygon, int i2) {
        kotlin.jvm.internal.j.e(measuredPolygon, "<this>");
        if (i2 < 0 || i2 >= measuredPolygon.size()) {
            return null;
        }
        return measuredPolygon.get(i2);
    }

    public static final void r0(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, y0.l lVar) {
        kotlin.jvm.internal.j.e(iterable, "<this>");
        sb.append(charSequence2);
        int i2 = 0;
        for (Object obj : iterable) {
            i2++;
            if (i2 > 1) {
                sb.append(charSequence);
            }
            p.a.d(sb, obj, lVar);
        }
        sb.append(charSequence3);
    }

    public static String s0(Iterable iterable, String str, String str2, f1.f fVar, int i2) {
        String str3 = (i2 & 2) != 0 ? "" : str;
        String str4 = (i2 & 4) != 0 ? "" : str2;
        if ((i2 & 32) != 0) {
            fVar = null;
        }
        kotlin.jvm.internal.j.e(iterable, "<this>");
        StringBuilder sb = new StringBuilder();
        r0(iterable, sb, ", ", str3, str4, "...", fVar);
        return sb.toString();
    }

    public static Object t0(List list) {
        kotlin.jvm.internal.j.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(l.g0(list));
    }

    public static ArrayList u0(Collection collection, Iterable elements) {
        kotlin.jvm.internal.j.e(collection, "<this>");
        kotlin.jvm.internal.j.e(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            m0(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static final void v0(Iterable iterable, AbstractCollection abstractCollection) {
        kotlin.jvm.internal.j.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static List w0(Iterable iterable) {
        ArrayList arrayList;
        kotlin.jvm.internal.j.e(iterable, "<this>");
        boolean z2 = iterable instanceof Collection;
        q qVar = q.f867a;
        if (!z2) {
            if (z2) {
                arrayList = new ArrayList((Collection) iterable);
            } else {
                arrayList = new ArrayList();
                v0(iterable, arrayList);
            }
            int size = arrayList.size();
            return size != 0 ? size != 1 ? arrayList : p.a.G(arrayList.get(0)) : qVar;
        }
        Collection collection = (Collection) iterable;
        int size2 = collection.size();
        if (size2 == 0) {
            return qVar;
        }
        if (size2 != 1) {
            return new ArrayList(collection);
        }
        return p.a.G(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static Set x0(Iterable iterable) {
        kotlin.jvm.internal.j.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(v.g0(collection.size()));
                    v0(iterable, linkedHashSet);
                    return linkedHashSet;
                }
                Set setSingleton = Collections.singleton(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
                kotlin.jvm.internal.j.d(setSingleton, "singleton(...)");
                return setSingleton;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            v0(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                if (size2 != 1) {
                    return linkedHashSet2;
                }
                Set setSingleton2 = Collections.singleton(linkedHashSet2.iterator().next());
                kotlin.jvm.internal.j.d(setSingleton2, "singleton(...)");
                return setSingleton2;
            }
        }
        return s.f869a;
    }
}
