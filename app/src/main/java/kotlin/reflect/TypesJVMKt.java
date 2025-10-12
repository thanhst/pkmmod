package kotlin.reflect;

import com.facebook.share.internal.ShareConstants;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.text.s;

/* compiled from: TypesJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¨\u0006\u0004"}, d2 = {"Ljava/lang/reflect/Type;", ShareConstants.MEDIA_TYPE, "", "b", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class TypesJVMKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(Type type) {
        String name;
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            kotlin.sequences.d dVarE = SequencesKt__SequencesKt.e(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
            name = ((Class) kotlin.sequences.k.i(dVarE)).getName() + s.o("[]", kotlin.sequences.k.h(dVarE));
        } else {
            name = cls.getName();
        }
        kotlin.jvm.internal.s.d(name, "{\n        if (type.isArr…   } else type.name\n    }");
        return name;
    }
}
