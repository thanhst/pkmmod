package kotlin.collections.builders;

import com.facebook.share.internal.ShareConstants;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.i;
import kotlin.collections.m;
import kotlin.jvm.internal.s;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ListBuilder.kt */
@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0012\n\u0002\u0010)\n\u0000\n\u0002\u0010+\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0001ZBO\b\u0002\u0012\f\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000=\u0012\u0006\u0010H\u001a\u00020\n\u0012\u0006\u0010J\u001a\u00020\n\u0012\u0006\u0010K\u001a\u00020\u0013\u0012\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010O\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0004\bU\u0010VB\t\b\u0016¢\u0006\u0004\bU\u0010WB\u0011\b\u0016\u0012\u0006\u0010X\u001a\u00020\n¢\u0006\u0004\bU\u0010YJ\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0014\u0010\u0014\u001a\u00020\u00132\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u001f\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0017\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0002J.\u0010#\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\u0006\u0010\"\u001a\u00020\u0013H\u0002J\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\b\u0010%\u001a\u00020\u0013H\u0016J\u0018\u0010'\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\nH\u0096\u0002¢\u0006\u0004\b'\u0010\u001eJ \u0010(\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0004\b,\u0010+J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0096\u0002J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0016J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/2\u0006\u0010&\u001a\u00020\nH\u0016J\u0017\u00101\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0004\b1\u00102J\u001f\u00101\u001a\u00020\f2\u0006\u0010&\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0004\b1\u0010\u0019J\u0016\u00103\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u001e\u00103\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\b\u00104\u001a\u00020\fH\u0016J\u0017\u00105\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\nH\u0016¢\u0006\u0004\b5\u0010\u001eJ\u0017\u00106\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0004\b6\u00102J\u0016\u00107\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0016\u00108\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u001e\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nH\u0016J)\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00010=\"\u0004\b\u0001\u0010<2\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00010=H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0=H\u0016¢\u0006\u0004\b?\u0010AJ\u0013\u0010B\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010C\u001a\u00020\nH\u0016J\b\u0010E\u001a\u00020DH\u0016R\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010IR\u0016\u0010K\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u001c\u0010M\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u001c\u0010O\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010NR\u0014\u0010P\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0014\u0010T\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010S¨\u0006["}, d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/e;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "", "minCapacity", "Lkotlin/t;", "ensureCapacity", "checkIsMutable", "n", "ensureExtraCapacity", "", "other", "", "contentEquals", "i", "insertAtInternal", "element", "addAtInternal", "(ILjava/lang/Object;)V", "", "elements", "addAllInternal", "removeAtInternal", "(I)Ljava/lang/Object;", "rangeOffset", "rangeLength", "removeRangeInternal", "retain", "retainOrRemoveAllInternal", "build", "isEmpty", "index", "get", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "iterator", "", "listIterator", "add", "(Ljava/lang/Object;)Z", "addAll", "clear", "removeAt", "remove", "removeAll", "retainAll", "fromIndex", "toIndex", "subList", "T", "", ShareConstants.DESTINATION, "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "equals", "hashCode", "", "toString", "array", "[Ljava/lang/Object;", "offset", "I", "length", "isReadOnly", "Z", "backing", "Lkotlin/collections/builders/ListBuilder;", "root", "isEffectivelyReadOnly", "()Z", "getSize", "()I", "size", "<init>", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "()V", "initialCapacity", "(I)V", "a", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class ListBuilder<E> extends kotlin.collections.e<E> implements RandomAccess, Serializable {

    @NotNull
    private E[] array;

    @Nullable
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    private int length;
    private int offset;

    @Nullable
    private final ListBuilder<E> root;

    /* compiled from: ListBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001f\b\u0016\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\t\u0010\u0005\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u000f\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\b\u0010\u0011\u001a\u00020\rH\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001d"}, d2 = {"Lkotlin/collections/builders/ListBuilder$a;", "E", "", "", "hasPrevious", "hasNext", "", "previousIndex", "nextIndex", "previous", "()Ljava/lang/Object;", "next", "element", "Lkotlin/t;", "set", "(Ljava/lang/Object;)V", "add", "remove", "Lkotlin/collections/builders/ListBuilder;", "e", "Lkotlin/collections/builders/ListBuilder;", "list", "f", "I", "index", "g", "lastIndex", "<init>", "(Lkotlin/collections/builders/ListBuilder;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    private static final class a_q0<E> implements ListIterator<E>, q0.a_q0 {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ListBuilder<E> list;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int index;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int lastIndex;

        public a_q0(@NotNull ListBuilder<E> list, int i2) {
            s.e(list, "list");
            this.list = list;
            this.index = i2;
            this.lastIndex = -1;
        }

        @Override // java.util.ListIterator
        public void add(E element) {
            ListBuilder<E> listBuilder = this.list;
            int i2 = this.index;
            this.index = i2 + 1;
            listBuilder.add(i2, element);
            this.lastIndex = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < ((ListBuilder) this.list).length;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.index >= ((ListBuilder) this.list).length) {
                throw new NoSuchElementException();
            }
            int i2 = this.index;
            this.index = i2 + 1;
            this.lastIndex = i2;
            return (E) ((ListBuilder) this.list).array[((ListBuilder) this.list).offset + this.lastIndex];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i2 = this.index;
            if (i2 <= 0) {
                throw new NoSuchElementException();
            }
            int i3 = i2 - 1;
            this.index = i3;
            this.lastIndex = i3;
            return (E) ((ListBuilder) this.list).array[((ListBuilder) this.list).offset + this.lastIndex];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i2 = this.lastIndex;
            if (!(i2 != -1)) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.list.remove(i2);
            this.index = this.lastIndex;
            this.lastIndex = -1;
        }

        @Override // java.util.ListIterator
        public void set(E element) {
            int i2 = this.lastIndex;
            if (!(i2 != -1)) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.list.set(i2, element);
        }
    }

    private ListBuilder(E[] eArr, int i2, int i3, boolean z2, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = i2;
        this.length = i3;
        this.isReadOnly = z2;
        this.backing = listBuilder;
        this.root = listBuilder2;
    }

    private final void addAllInternal(int i2, Collection<? extends E> collection, int i3) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAllInternal(i2, collection, i3);
            this.array = this.backing.array;
            this.length += i3;
        } else {
            insertAtInternal(i2, i3);
            Iterator<? extends E> it = collection.iterator();
            for (int i4 = 0; i4 < i3; i4++) {
                this.array[i2 + i4] = it.next();
            }
        }
    }

    private final void addAtInternal(int i2, E element) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder == null) {
            insertAtInternal(i2, 1);
            this.array[i2] = element;
        } else {
            listBuilder.addAtInternal(i2, element);
            this.array = this.backing.array;
            this.length++;
        }
    }

    private final void checkIsMutable() {
        if (isEffectivelyReadOnly()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean contentEquals(List<?> other) {
        return b.h(this.array, this.offset, this.length, other);
    }

    private final void ensureCapacity(int i2) {
        if (this.backing != null) {
            throw new IllegalStateException();
        }
        if (i2 < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.array;
        if (i2 > eArr.length) {
            this.array = (E[]) b.e(this.array, i.INSTANCE.a(eArr.length, i2));
        }
    }

    private final void ensureExtraCapacity(int i2) {
        ensureCapacity(this.length + i2);
    }

    private final void insertAtInternal(int i2, int i3) {
        ensureExtraCapacity(i3);
        E[] eArr = this.array;
        m.c(eArr, eArr, i2 + i3, i2, this.offset + this.length);
        this.length += i3;
    }

    private final boolean isEffectivelyReadOnly() {
        ListBuilder<E> listBuilder;
        return this.isReadOnly || ((listBuilder = this.root) != null && listBuilder.isReadOnly);
    }

    private final E removeAtInternal(int i2) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            this.length--;
            return listBuilder.removeAtInternal(i2);
        }
        E[] eArr = this.array;
        E e2 = eArr[i2];
        m.c(eArr, eArr, i2, i2 + 1, this.offset + this.length);
        b.f(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e2;
    }

    private final void removeRangeInternal(int i2, int i3) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.removeRangeInternal(i2, i3);
        } else {
            E[] eArr = this.array;
            m.c(eArr, eArr, i2, i2 + i3, this.length);
            E[] eArr2 = this.array;
            int i4 = this.length;
            b.g(eArr2, i4 - i3, i4);
        }
        this.length -= i3;
    }

    private final int retainOrRemoveAllInternal(int rangeOffset, int rangeLength, Collection<? extends E> elements, boolean retain) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            int iRetainOrRemoveAllInternal = listBuilder.retainOrRemoveAllInternal(rangeOffset, rangeLength, elements, retain);
            this.length -= iRetainOrRemoveAllInternal;
            return iRetainOrRemoveAllInternal;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < rangeLength) {
            int i4 = rangeOffset + i2;
            if (elements.contains(this.array[i4]) == retain) {
                E[] eArr = this.array;
                i2++;
                eArr[i3 + rangeOffset] = eArr[i4];
                i3++;
            } else {
                i2++;
            }
        }
        int i5 = rangeLength - i3;
        E[] eArr2 = this.array;
        m.c(eArr2, eArr2, rangeOffset + i3, rangeLength + rangeOffset, this.length);
        E[] eArr3 = this.array;
        int i6 = this.length;
        b.g(eArr3, i6 - i5, i6);
        this.length -= i5;
        return i5;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (isEffectivelyReadOnly()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        checkIsMutable();
        addAtInternal(this.offset + this.length, element);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        s.e(elements, "elements");
        checkIsMutable();
        int size = elements.size();
        addAllInternal(this.offset + this.length, elements, size);
        return size > 0;
    }

    @NotNull
    public final List<E> build() {
        if (this.backing != null) {
            throw new IllegalStateException();
        }
        checkIsMutable();
        this.isReadOnly = true;
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        removeRangeInternal(this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(@Nullable Object other) {
        return other == this || ((other instanceof List) && contentEquals((List) other));
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        kotlin.collections.b.INSTANCE.a(index, this.length);
        return this.array[this.offset + index];
    }

    @Override // kotlin.collections.e
    /* renamed from: getSize, reason: from getter */
    public int getLength() {
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return b.i(this.array, this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (s.a(this.array[this.offset + i2], element)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        return new a_q0(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object element) {
        for (int i2 = this.length - 1; i2 >= 0; i2--) {
            if (s.a(this.array[this.offset + i2], element)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return new a_q0(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object element) {
        checkIsMutable();
        int iIndexOf = indexOf(element);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        s.e(elements, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, elements, false) > 0;
    }

    @Override // kotlin.collections.e
    public E removeAt(int index) {
        checkIsMutable();
        kotlin.collections.b.INSTANCE.a(index, this.length);
        return removeAtInternal(this.offset + index);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        s.e(elements, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0;
    }

    @Override // kotlin.collections.e, java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        checkIsMutable();
        kotlin.collections.b.INSTANCE.a(index, this.length);
        E[] eArr = this.array;
        int i2 = this.offset;
        E e2 = eArr[i2 + index];
        eArr[i2 + index] = element;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public List<E> subList(int fromIndex, int toIndex) {
        kotlin.collections.b.INSTANCE.c(fromIndex, toIndex, this.length);
        E[] eArr = this.array;
        int i2 = this.offset + fromIndex;
        int i3 = toIndex - fromIndex;
        boolean z2 = this.isReadOnly;
        ListBuilder<E> listBuilder = this.root;
        return new ListBuilder(eArr, i2, i3, z2, this, listBuilder == null ? this : listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public <T> T[] toArray(@NotNull T[] destination) {
        s.e(destination, "destination");
        int length = destination.length;
        int i2 = this.length;
        if (length < i2) {
            E[] eArr = this.array;
            int i3 = this.offset;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i3, i2 + i3, destination.getClass());
            s.d(tArr, "copyOfRange(array, offse…h, destination.javaClass)");
            return tArr;
        }
        E[] eArr2 = this.array;
        s.c(eArr2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilder.toArray>");
        int i4 = this.offset;
        m.c(eArr2, destination, 0, i4, this.length + i4);
        int length2 = destination.length;
        int i5 = this.length;
        if (length2 > i5) {
            destination[i5] = null;
        }
        return destination;
    }

    @Override // java.util.AbstractCollection
    @NotNull
    public String toString() {
        return b.j(this.array, this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator(int index) {
        kotlin.collections.b.INSTANCE.b(index, this.length);
        return new a_q0(this, index);
    }

    @Override // kotlin.collections.e, java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        checkIsMutable();
        kotlin.collections.b.INSTANCE.b(index, this.length);
        addAtInternal(this.offset + index, element);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, @NotNull Collection<? extends E> elements) {
        s.e(elements, "elements");
        checkIsMutable();
        kotlin.collections.b.INSTANCE.b(index, this.length);
        int size = elements.size();
        addAllInternal(this.offset + index, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public Object[] toArray() {
        E[] eArr = this.array;
        int i2 = this.offset;
        Object[] objArrE = m.e(eArr, i2, this.length + i2);
        s.c(objArrE, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return objArrE;
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i2) {
        this(b.d(i2), 0, 0, false, null, null);
    }
}
