package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.g0;
import kotlin.collections.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import q0.a_q0;
import s0.f_s0;
import s0.l_s0;

/* compiled from: MapBuilder.kt */
@Metadata(bv = {}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u000e\b\u0000\u0018\u0000 \u0087\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u00060\u0004j\u0002`\u0005:\f\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001BI\b\u0002\u0012\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e\u0012\u0006\u0010]\u001a\u00020\\\u0012\u0006\u0010_\u001a\u00020\\\u0012\u0006\u0010`\u001a\u00020\b\u0012\u0006\u0010b\u001a\u00020\b¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001B\n\b\u0016¢\u0006\u0005\b\u0083\u0001\u0010;B\u0014\b\u0016\u0012\u0007\u0010\u0085\u0001\u001a\u00020\b¢\u0006\u0006\b\u0083\u0001\u0010\u0086\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0002J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u001a\u0010\u0013J\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u001c\u0010\u0013J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0018\u0010#\u001a\u00020\u00182\u000e\u0010\"\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030!H\u0002J\u001c\u0010&\u001a\u00020\u00182\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010$H\u0002J\"\u0010)\u001a\u00020\u00182\u0018\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010$0'H\u0002J\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!J\b\u0010+\u001a\u00020\u0018H\u0016J\u0017\u0010,\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b.\u0010-J\u001a\u0010/\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b/\u00100J!\u00101\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b1\u00102J\u001e\u00103\u001a\u00020\n2\u0014\u0010(\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!H\u0016J\u0019\u00104\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b4\u00100J\b\u00105\u001a\u00020\nH\u0016J\u0013\u00106\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u00107\u001a\u00020\bH\u0016J\b\u00109\u001a\u000208H\u0016J\u000f\u0010<\u001a\u00020\nH\u0000¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0000¢\u0006\u0004\b=\u0010\u0013J\u0017\u0010@\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0000¢\u0006\u0004\b?\u0010\u0013J#\u0010C\u001a\u00020\u00182\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010$H\u0000¢\u0006\u0004\bA\u0010BJ\u001b\u0010G\u001a\u00020\u00182\n\u0010D\u001a\u0006\u0012\u0002\b\u00030'H\u0000¢\u0006\u0004\bE\u0010FJ#\u0010I\u001a\u00020\u00182\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010$H\u0000¢\u0006\u0004\bH\u0010BJ\u0017\u0010L\u001a\u00020\u00182\u0006\u0010J\u001a\u00028\u0001H\u0000¢\u0006\u0004\bK\u0010-J\u001b\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010MH\u0000¢\u0006\u0004\bN\u0010OJ\u001b\u0010T\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010QH\u0000¢\u0006\u0004\bR\u0010SJ\u001b\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010UH\u0000¢\u0006\u0004\bV\u0010WR\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u001e\u0010[\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010ZR\u0016\u0010]\u001a\u00020\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010^R\u0016\u0010`\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010aR\u0016\u0010c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010aR$\u0010e\u001a\u00020\b2\u0006\u0010d\u001a\u00020\b8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\be\u0010a\u001a\u0004\bf\u0010gR\u001e\u0010i\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u001e\u0010l\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR$\u0010o\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR$\u0010q\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u00188\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u0014\u0010\f\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bu\u0010gR\u0014\u0010w\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bv\u0010gR\u001a\u0010{\u001a\b\u0012\u0004\u0012\u00028\u00000x8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\by\u0010zR\u001a\u0010\u007f\u001a\b\u0012\u0004\u0012\u00028\u00010|8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b}\u0010~R)\u0010\u0082\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0080\u00010x8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010z¨\u0006\u008e\u0001"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "", "n", "Lkotlin/t;", "ensureExtraCapacity", "capacity", "ensureCapacity", "", "allocateValuesArray", "()[Ljava/lang/Object;", "key", "hash", "(Ljava/lang/Object;)I", "compact", "newHashSize", "rehash", "i", "", "putRehash", "findKey", "value", "findValue", "index", "removeKeyAt", "removedHash", "removeHashAt", "", "other", "contentEquals", "", "entry", "putEntry", "", "from", "putAllEntries", "build", "isEmpty", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "remove", "clear", "equals", "hashCode", "", "toString", "checkIsMutable$kotlin_stdlib", "()V", "checkIsMutable", "addKey$kotlin_stdlib", "addKey", "removeKey$kotlin_stdlib", "removeKey", "containsEntry$kotlin_stdlib", "(Ljava/util/Map$Entry;)Z", "containsEntry", "m", "containsAllEntries$kotlin_stdlib", "(Ljava/util/Collection;)Z", "containsAllEntries", "removeEntry$kotlin_stdlib", "removeEntry", "element", "removeValue$kotlin_stdlib", "removeValue", "Lkotlin/collections/builders/MapBuilder$e;", "keysIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$e;", "keysIterator", "Lkotlin/collections/builders/MapBuilder$f;", "valuesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$f;", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$b;", "entriesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$b;", "entriesIterator", "keysArray", "[Ljava/lang/Object;", "valuesArray", "", "presenceArray", "[I", "hashArray", "maxProbeDistance", "I", "length", "hashShift", "<set-?>", "size", "getSize", "()I", "Lkotlin/collections/builders/d;", "keysView", "Lkotlin/collections/builders/d;", "Lkotlin/collections/builders/e;", "valuesView", "Lkotlin/collections/builders/e;", "Lkotlin/collections/builders/c;", "entriesView", "Lkotlin/collections/builders/c;", "isReadOnly", "Z", "isReadOnly$kotlin_stdlib", "()Z", "getCapacity", "getHashSize", "hashSize", "", "getKeys", "()Ljava/util/Set;", "keys", "", "getValues", "()Ljava/util/Collection;", "values", "", "getEntries", "entries", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "initialCapacity", "(I)V", "Companion", "a", "b", "c", "d", "e", "f", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, a_q0 {

    @NotNull
    private static final a Companion = new a(null);

    @Deprecated
    private static final int INITIAL_CAPACITY = 8;

    @Deprecated
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;

    @Deprecated
    private static final int MAGIC = -1640531527;

    @Deprecated
    private static final int TOMBSTONE = -1;

    @Nullable
    private kotlin.collections.builders.c<K, V> entriesView;

    @NotNull
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;

    @NotNull
    private K[] keysArray;

    @Nullable
    private kotlin.collections.builders.d<K> keysView;
    private int length;
    private int maxProbeDistance;

    @NotNull
    private int[] presenceArray;
    private int size;

    @Nullable
    private V[] valuesArray;

    @Nullable
    private kotlin.collections.builders.e<V> valuesView;

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlin/collections/builders/MapBuilder$a;", "", "", "capacity", "c", "hashSize", "d", "INITIAL_CAPACITY", "I", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int capacity) {
            return Integer.highestOneBit(l_s0.a(capacity, 1) * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int hashSize) {
            return Integer.numberOfLeadingZeros(hashSize) + 1;
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0004B\u001b\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006H\u0096\u0002J\u000f\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000f\u001a\u00020\u000e2\n\u0010\r\u001a\u00060\u000bj\u0002`\f¨\u0006\u0014"}, d2 = {"Lkotlin/collections/builders/MapBuilder$b;", "K", "V", "Lkotlin/collections/builders/MapBuilder$d;", "", "", "Lkotlin/collections/builders/MapBuilder$c;", "g", "", "i", "()I", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "Lkotlin/t;", "h", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, a_q0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull MapBuilder<K, V> map) {
            super(map);
            s.e(map, "map");
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public c<K, V> next() {
            if (getIndex() >= ((MapBuilder) c()).length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            e(index + 1);
            f(index);
            c<K, V> cVar = new c<>(c(), getLastIndex());
            d();
            return cVar;
        }

        public final void h(@NotNull StringBuilder sb) {
            s.e(sb, "sb");
            if (getIndex() >= ((MapBuilder) c()).length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            e(index + 1);
            f(index);
            Object obj = ((MapBuilder) c()).keysArray[getLastIndex()];
            if (s.a(obj, c())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = ((MapBuilder) c()).valuesArray;
            s.b(objArr);
            Object obj2 = objArr[getLastIndex()];
            if (s.a(obj2, c())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            d();
        }

        public final int i() {
            if (getIndex() >= ((MapBuilder) c()).length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            e(index + 1);
            f(index);
            Object obj = ((MapBuilder) c()).keysArray[getLastIndex()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = ((MapBuilder) c()).valuesArray;
            s.b(objArr);
            Object obj2 = objArr[getLastIndex()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            d();
            return iHashCode2;
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B#\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00028\u00032\u0006\u0010\u0004\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00028\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001d"}, d2 = {"Lkotlin/collections/builders/MapBuilder$c;", "K", "V", "", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "other", "", "equals", "", "hashCode", "", "toString", "Lkotlin/collections/builders/MapBuilder;", "e", "Lkotlin/collections/builders/MapBuilder;", "map", "f", "I", "index", "getKey", "()Ljava/lang/Object;", "key", "getValue", "value", "<init>", "(Lkotlin/collections/builders/MapBuilder;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public static final class c<K, V> implements Map.Entry<K, V>, a_q0 {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MapBuilder<K, V> map;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int index;

        public c(@NotNull MapBuilder<K, V> map, int i2) {
            s.e(map, "map");
            this.map = map;
            this.index = i2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@Nullable Object other) {
            if (other instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) other;
                if (s.a(entry.getKey(), getKey()) && s.a(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((MapBuilder) this.map).keysArray[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((MapBuilder) this.map).valuesArray;
            s.b(objArr);
            return (V) objArr[this.index];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V newValue) {
            this.map.checkIsMutable$kotlin_stdlib();
            Object[] objArrAllocateValuesArray = this.map.allocateValuesArray();
            int i2 = this.index;
            V v2 = (V) objArrAllocateValuesArray[i2];
            objArrAllocateValuesArray[i2] = newValue;
            return v2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0004R&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u000b\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0011\u0010\u0015¨\u0006\u001c"}, d2 = {"Lkotlin/collections/builders/MapBuilder$d;", "K", "V", "", "Lkotlin/t;", "d", "()V", "", "hasNext", "remove", "Lkotlin/collections/builders/MapBuilder;", "e", "Lkotlin/collections/builders/MapBuilder;", "c", "()Lkotlin/collections/builders/MapBuilder;", "map", "", "f", "I", "a", "()I", "(I)V", "index", "g", "b", "lastIndex", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public static class d<K, V> {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MapBuilder<K, V> map;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int index;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int lastIndex;

        public d(@NotNull MapBuilder<K, V> map) {
            s.e(map, "map");
            this.map = map;
            this.lastIndex = -1;
            d();
        }

        /* renamed from: a, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* renamed from: b, reason: from getter */
        public final int getLastIndex() {
            return this.lastIndex;
        }

        @NotNull
        public final MapBuilder<K, V> c() {
            return this.map;
        }

        public final void d() {
            while (this.index < ((MapBuilder) this.map).length) {
                int[] iArr = ((MapBuilder) this.map).presenceArray;
                int i2 = this.index;
                if (iArr[i2] >= 0) {
                    return;
                } else {
                    this.index = i2 + 1;
                }
            }
        }

        public final void e(int i2) {
            this.index = i2;
        }

        public final void f(int i2) {
            this.lastIndex = i2;
        }

        public final boolean hasNext() {
            return this.index < ((MapBuilder) this.map).length;
        }

        public final void remove() {
            if (!(this.lastIndex != -1)) {
                throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
            }
            this.map.checkIsMutable$kotlin_stdlib();
            this.map.removeKeyAt(this.lastIndex);
            this.lastIndex = -1;
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lkotlin/collections/builders/MapBuilder$e;", "K", "V", "Lkotlin/collections/builders/MapBuilder$d;", "", "next", "()Ljava/lang/Object;", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public static final class e<K, V> extends d<K, V> implements Iterator<K>, a_q0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull MapBuilder<K, V> map) {
            super(map);
            s.e(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (getIndex() >= ((MapBuilder) c()).length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            e(index + 1);
            f(index);
            K k2 = (K) ((MapBuilder) c()).keysArray[getLastIndex()];
            d();
            return k2;
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lkotlin/collections/builders/MapBuilder$f;", "K", "V", "Lkotlin/collections/builders/MapBuilder$d;", "", "next", "()Ljava/lang/Object;", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public static final class f<K, V> extends d<K, V> implements Iterator<V>, a_q0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@NotNull MapBuilder<K, V> map) {
            super(map);
            s.e(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (getIndex() >= ((MapBuilder) c()).length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            e(index + 1);
            f(index);
            Object[] objArr = ((MapBuilder) c()).valuesArray;
            s.b(objArr);
            V v2 = (V) objArr[getLastIndex()];
            d();
            return v2;
        }
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i2, int i3) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i2;
        this.length = i3;
        this.hashShift = Companion.d(getHashSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] allocateValuesArray() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) kotlin.collections.builders.b.d(getCapacity());
        this.valuesArray = vArr2;
        return vArr2;
    }

    private final void compact() {
        int i2;
        V[] vArr = this.valuesArray;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i2 = this.length;
            if (i3 >= i2) {
                break;
            }
            if (this.presenceArray[i3] >= 0) {
                K[] kArr = this.keysArray;
                kArr[i4] = kArr[i3];
                if (vArr != null) {
                    vArr[i4] = vArr[i3];
                }
                i4++;
            }
            i3++;
        }
        kotlin.collections.builders.b.g(this.keysArray, i4, i2);
        if (vArr != null) {
            kotlin.collections.builders.b.g(vArr, i4, this.length);
        }
        this.length = i4;
    }

    private final boolean contentEquals(Map<?, ?> other) {
        return size() == other.size() && containsAllEntries$kotlin_stdlib(other.entrySet());
    }

    private final void ensureCapacity(int i2) {
        if (i2 < 0) {
            throw new OutOfMemoryError();
        }
        if (i2 <= getCapacity()) {
            if ((this.length + i2) - size() > getCapacity()) {
                rehash(getHashSize());
                return;
            }
            return;
        }
        int capacity = (getCapacity() * 3) / 2;
        if (i2 <= capacity) {
            i2 = capacity;
        }
        this.keysArray = (K[]) kotlin.collections.builders.b.e(this.keysArray, i2);
        V[] vArr = this.valuesArray;
        this.valuesArray = vArr != null ? (V[]) kotlin.collections.builders.b.e(vArr, i2) : null;
        int[] iArrCopyOf = Arrays.copyOf(this.presenceArray, i2);
        s.d(iArrCopyOf, "copyOf(this, newSize)");
        this.presenceArray = iArrCopyOf;
        int iC = Companion.c(i2);
        if (iC > getHashSize()) {
            rehash(iC);
        }
    }

    private final void ensureExtraCapacity(int i2) {
        ensureCapacity(this.length + i2);
    }

    private final int findKey(K key) {
        int iHash = hash(key);
        int i2 = this.maxProbeDistance;
        while (true) {
            int i3 = this.hashArray[iHash];
            if (i3 == 0) {
                return -1;
            }
            if (i3 > 0) {
                int i4 = i3 - 1;
                if (s.a(this.keysArray[i4], key)) {
                    return i4;
                }
            }
            i2--;
            if (i2 < 0) {
                return -1;
            }
            iHash = iHash == 0 ? getHashSize() - 1 : iHash - 1;
        }
    }

    private final int findValue(V value) {
        int i2 = this.length;
        while (true) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
            if (this.presenceArray[i2] >= 0) {
                V[] vArr = this.valuesArray;
                s.b(vArr);
                if (s.a(vArr[i2], value)) {
                    return i2;
                }
            }
        }
    }

    private final int getCapacity() {
        return this.keysArray.length;
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K key) {
        return ((key != null ? key.hashCode() : 0) * MAGIC) >>> this.hashShift;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> from) {
        boolean z2 = false;
        if (from.isEmpty()) {
            return false;
        }
        ensureExtraCapacity(from.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = from.iterator();
        while (it.hasNext()) {
            if (putEntry(it.next())) {
                z2 = true;
            }
        }
        return z2;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        V[] vArrAllocateValuesArray = allocateValuesArray();
        if (iAddKey$kotlin_stdlib >= 0) {
            vArrAllocateValuesArray[iAddKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i2 = (-iAddKey$kotlin_stdlib) - 1;
        if (s.a(entry.getValue(), vArrAllocateValuesArray[i2])) {
            return false;
        }
        vArrAllocateValuesArray[i2] = entry.getValue();
        return true;
    }

    private final boolean putRehash(int i2) {
        int iHash = hash(this.keysArray[i2]);
        int i3 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[iHash] == 0) {
                iArr[iHash] = i2 + 1;
                this.presenceArray[i2] = iHash;
                return true;
            }
            i3--;
            if (i3 < 0) {
                return false;
            }
            iHash = iHash == 0 ? getHashSize() - 1 : iHash - 1;
        }
    }

    private final void rehash(int i2) {
        if (this.length > size()) {
            compact();
        }
        int i3 = 0;
        if (i2 != getHashSize()) {
            this.hashArray = new int[i2];
            this.hashShift = Companion.d(i2);
        } else {
            m.f(this.hashArray, 0, 0, getHashSize());
        }
        while (i3 < this.length) {
            int i4 = i3 + 1;
            if (!putRehash(i3)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i3 = i4;
        }
    }

    private final void removeHashAt(int i2) {
        int iC = l_s0.c(this.maxProbeDistance * 2, getHashSize() / 2);
        int i3 = 0;
        int i4 = i2;
        do {
            i2 = i2 == 0 ? getHashSize() - 1 : i2 - 1;
            i3++;
            if (i3 > this.maxProbeDistance) {
                this.hashArray[i4] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i5 = iArr[i2];
            if (i5 == 0) {
                iArr[i4] = 0;
                return;
            }
            if (i5 < 0) {
                iArr[i4] = -1;
            } else {
                int i6 = i5 - 1;
                if (((hash(this.keysArray[i6]) - i2) & (getHashSize() - 1)) >= i3) {
                    this.hashArray[i4] = i5;
                    this.presenceArray[i6] = i4;
                }
                iC--;
            }
            i4 = i2;
            i3 = 0;
            iC--;
        } while (iC >= 0);
        this.hashArray[i4] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeKeyAt(int i2) {
        kotlin.collections.builders.b.f(this.keysArray, i2);
        removeHashAt(this.presenceArray[i2]);
        this.presenceArray[i2] = -1;
        this.size = size() - 1;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final int addKey$kotlin_stdlib(K key) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int iHash = hash(key);
            int iC = l_s0.c(this.maxProbeDistance * 2, getHashSize() / 2);
            int i2 = 0;
            while (true) {
                int i3 = this.hashArray[iHash];
                if (i3 <= 0) {
                    if (this.length < getCapacity()) {
                        int i4 = this.length;
                        int i5 = i4 + 1;
                        this.length = i5;
                        this.keysArray[i4] = key;
                        this.presenceArray[i4] = iHash;
                        this.hashArray[iHash] = i5;
                        this.size = size() + 1;
                        if (i2 > this.maxProbeDistance) {
                            this.maxProbeDistance = i2;
                        }
                        return i4;
                    }
                    ensureExtraCapacity(1);
                } else {
                    if (s.a(this.keysArray[i3 - 1], key)) {
                        return -i3;
                    }
                    i2++;
                    if (i2 > iC) {
                        rehash(getHashSize() * 2);
                        break;
                    }
                    iHash = iHash == 0 ? getHashSize() - 1 : iHash - 1;
                }
            }
        }
    }

    @NotNull
    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        return this;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        g0 it = new f_s0(0, this.length - 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            int[] iArr = this.presenceArray;
            int i2 = iArr[iNextInt];
            if (i2 >= 0) {
                this.hashArray[i2] = 0;
                iArr[iNextInt] = -1;
            }
        }
        kotlin.collections.builders.b.g(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            kotlin.collections.builders.b.g(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(@NotNull Collection<?> m2) {
        s.e(m2, "m");
        for (Object obj : m2) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        s.e(entry, "entry");
        int iFindKey = findKey(entry.getKey());
        if (iFindKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        s.b(vArr);
        return s.a(vArr[iFindKey], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return findKey(key) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return findValue(value) >= 0;
    }

    @NotNull
    public final b<K, V> entriesIterator$kotlin_stdlib() {
        return new b<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object other) {
        return other == this || ((other instanceof Map) && contentEquals((Map) other));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V get(Object key) {
        int iFindKey = findKey(key);
        if (iFindKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        s.b(vArr);
        return vArr[iFindKey];
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        kotlin.collections.builders.c<K, V> cVar = this.entriesView;
        if (cVar != null) {
            return cVar;
        }
        kotlin.collections.builders.c<K, V> cVar2 = new kotlin.collections.builders.c<>(this);
        this.entriesView = cVar2;
        return cVar2;
    }

    @NotNull
    public Set<K> getKeys() {
        kotlin.collections.builders.d<K> dVar = this.keysView;
        if (dVar != null) {
            return dVar;
        }
        kotlin.collections.builders.d<K> dVar2 = new kotlin.collections.builders.d<>(this);
        this.keysView = dVar2;
        return dVar2;
    }

    public int getSize() {
        return this.size;
    }

    @NotNull
    public Collection<V> getValues() {
        kotlin.collections.builders.e<V> eVar = this.valuesView;
        if (eVar != null) {
            return eVar;
        }
        kotlin.collections.builders.e<V> eVar2 = new kotlin.collections.builders.e<>(this);
        this.valuesView = eVar2;
        return eVar2;
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> bVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i2 = 0;
        while (bVarEntriesIterator$kotlin_stdlib.hasNext()) {
            i2 += bVarEntriesIterator$kotlin_stdlib.i();
        }
        return i2;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: isReadOnly$kotlin_stdlib, reason: from getter */
    public final boolean getIsReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @NotNull
    public final e<K, V> keysIterator$kotlin_stdlib() {
        return new e<>(this);
    }

    @Override // java.util.Map
    @Nullable
    public V put(K key, V value) {
        checkIsMutable$kotlin_stdlib();
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(key);
        V[] vArrAllocateValuesArray = allocateValuesArray();
        if (iAddKey$kotlin_stdlib >= 0) {
            vArrAllocateValuesArray[iAddKey$kotlin_stdlib] = value;
            return null;
        }
        int i2 = (-iAddKey$kotlin_stdlib) - 1;
        V v2 = vArrAllocateValuesArray[i2];
        vArrAllocateValuesArray[i2] = value;
        return v2;
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> from) {
        s.e(from, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(from.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V remove(Object key) {
        int iRemoveKey$kotlin_stdlib = removeKey$kotlin_stdlib(key);
        if (iRemoveKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        s.b(vArr);
        V v2 = vArr[iRemoveKey$kotlin_stdlib];
        kotlin.collections.builders.b.f(vArr, iRemoveKey$kotlin_stdlib);
        return v2;
    }

    public final boolean removeEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        s.e(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int iFindKey = findKey(entry.getKey());
        if (iFindKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        s.b(vArr);
        if (!s.a(vArr[iFindKey], entry.getValue())) {
            return false;
        }
        removeKeyAt(iFindKey);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K key) {
        checkIsMutable$kotlin_stdlib();
        int iFindKey = findKey(key);
        if (iFindKey < 0) {
            return -1;
        }
        removeKeyAt(iFindKey);
        return iFindKey;
    }

    public final boolean removeValue$kotlin_stdlib(V element) {
        checkIsMutable$kotlin_stdlib();
        int iFindValue = findValue(element);
        if (iFindValue < 0) {
            return false;
        }
        removeKeyAt(iFindValue);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b<K, V> bVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i2 = 0;
        while (bVarEntriesIterator$kotlin_stdlib.hasNext()) {
            if (i2 > 0) {
                sb.append(", ");
            }
            bVarEntriesIterator$kotlin_stdlib.h(sb);
            i2++;
        }
        sb.append("}");
        String string = sb.toString();
        s.d(string, "sb.toString()");
        return string;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    @NotNull
    public final f<K, V> valuesIterator$kotlin_stdlib() {
        return new f<>(this);
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i2) {
        this(kotlin.collections.builders.b.d(i2), null, new int[i2], new int[Companion.c(i2)], 2, 0);
    }
}
