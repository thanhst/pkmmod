package com.facebook.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/BundleJSONConverter;", "", "()V", "SETTERS", "", "Ljava/lang/Class;", "Lcom/facebook/internal/BundleJSONConverter$Setter;", "convertToBundle", "Landroid/os/Bundle;", "jsonObject", "Lorg/json/JSONObject;", "convertToJSON", "bundle", "Setter", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class BundleJSONConverter {

    @NotNull
    public static final BundleJSONConverter INSTANCE = new BundleJSONConverter();

    @NotNull
    private static final Map<Class<?>, Setter> SETTERS;

    /* compiled from: BundleJSONConverter.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001H&J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001H&¨\u0006\f"}, d2 = {"Lcom/facebook/internal/BundleJSONConverter$Setter;", "", "Landroid/os/Bundle;", "bundle", "", "key", "value", "Lkotlin/t;", "setOnBundle", "Lorg/json/JSONObject;", "json", "setOnJSON", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface Setter {
        void setOnBundle(@NotNull Bundle bundle, @NotNull String str, @NotNull Object obj) throws JSONException;

        void setOnJSON(@NotNull JSONObject jSONObject, @NotNull String str, @NotNull Object obj) throws JSONException;
    }

    static {
        HashMap map = new HashMap();
        SETTERS = map;
        map.put(Boolean.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.1
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@NotNull Bundle bundle, @NotNull String key, @NotNull Object value) throws JSONException {
                kotlin.jvm.internal.s.e(bundle, "bundle");
                kotlin.jvm.internal.s.e(key, "key");
                kotlin.jvm.internal.s.e(value, "value");
                bundle.putBoolean(key, ((Boolean) value).booleanValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@NotNull JSONObject json, @NotNull String key, @NotNull Object value) throws JSONException {
                kotlin.jvm.internal.s.e(json, "json");
                kotlin.jvm.internal.s.e(key, "key");
                kotlin.jvm.internal.s.e(value, "value");
                json.put(key, value);
            }
        });
        map.put(Integer.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.2
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@NotNull Bundle bundle, @NotNull String key, @NotNull Object value) throws JSONException {
                kotlin.jvm.internal.s.e(bundle, "bundle");
                kotlin.jvm.internal.s.e(key, "key");
                kotlin.jvm.internal.s.e(value, "value");
                bundle.putInt(key, ((Integer) value).intValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@NotNull JSONObject json, @NotNull String key, @NotNull Object value) throws JSONException {
                kotlin.jvm.internal.s.e(json, "json");
                kotlin.jvm.internal.s.e(key, "key");
                kotlin.jvm.internal.s.e(value, "value");
                json.put(key, value);
            }
        });
        map.put(Long.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.3
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@NotNull Bundle bundle, @NotNull String key, @NotNull Object value) throws JSONException {
                kotlin.jvm.internal.s.e(bundle, "bundle");
                kotlin.jvm.internal.s.e(key, "key");
                kotlin.jvm.internal.s.e(value, "value");
                bundle.putLong(key, ((Long) value).longValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@NotNull JSONObject json, @NotNull String key, @NotNull Object value) throws JSONException {
                kotlin.jvm.internal.s.e(json, "json");
                kotlin.jvm.internal.s.e(key, "key");
                kotlin.jvm.internal.s.e(value, "value");
                json.put(key, value);
            }
        });
        map.put(Double.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.4
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@NotNull Bundle bundle, @NotNull String key, @NotNull Object value) throws JSONException {
                kotlin.jvm.internal.s.e(bundle, "bundle");
                kotlin.jvm.internal.s.e(key, "key");
                kotlin.jvm.internal.s.e(value, "value");
                bundle.putDouble(key, ((Double) value).doubleValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@NotNull JSONObject json, @NotNull String key, @NotNull Object value) throws JSONException {
                kotlin.jvm.internal.s.e(json, "json");
                kotlin.jvm.internal.s.e(key, "key");
                kotlin.jvm.internal.s.e(value, "value");
                json.put(key, value);
            }
        });
        map.put(String.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.5
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@NotNull Bundle bundle, @NotNull String key, @NotNull Object value) throws JSONException {
                kotlin.jvm.internal.s.e(bundle, "bundle");
                kotlin.jvm.internal.s.e(key, "key");
                kotlin.jvm.internal.s.e(value, "value");
                bundle.putString(key, (String) value);
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@NotNull JSONObject json, @NotNull String key, @NotNull Object value) throws JSONException {
                kotlin.jvm.internal.s.e(json, "json");
                kotlin.jvm.internal.s.e(key, "key");
                kotlin.jvm.internal.s.e(value, "value");
                json.put(key, value);
            }
        });
        map.put(String[].class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.6
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@NotNull Bundle bundle, @NotNull String key, @NotNull Object value) throws JSONException {
                kotlin.jvm.internal.s.e(bundle, "bundle");
                kotlin.jvm.internal.s.e(key, "key");
                kotlin.jvm.internal.s.e(value, "value");
                throw new IllegalArgumentException("Unexpected type from JSON");
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@NotNull JSONObject json, @NotNull String key, @NotNull Object value) throws JSONException {
                kotlin.jvm.internal.s.e(json, "json");
                kotlin.jvm.internal.s.e(key, "key");
                kotlin.jvm.internal.s.e(value, "value");
                JSONArray jSONArray = new JSONArray();
                String[] strArr = (String[]) value;
                int length = strArr.length;
                int i2 = 0;
                while (i2 < length) {
                    String str = strArr[i2];
                    i2++;
                    jSONArray.put(str);
                }
                json.put(key, jSONArray);
            }
        });
        map.put(JSONArray.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.7
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@NotNull Bundle bundle, @NotNull String key, @NotNull Object value) throws JSONException {
                kotlin.jvm.internal.s.e(bundle, "bundle");
                kotlin.jvm.internal.s.e(key, "key");
                kotlin.jvm.internal.s.e(value, "value");
                JSONArray jSONArray = (JSONArray) value;
                ArrayList arrayList = new ArrayList();
                if (jSONArray.length() == 0) {
                    bundle.putStringArrayList(key, arrayList);
                    return;
                }
                int i2 = 0;
                int length = jSONArray.length();
                if (length > 0) {
                    while (true) {
                        int i3 = i2 + 1;
                        Object obj = jSONArray.get(i2);
                        if (!(obj instanceof String)) {
                            throw new IllegalArgumentException(kotlin.jvm.internal.s.m("Unexpected type in an array: ", obj.getClass()));
                        }
                        arrayList.add(obj);
                        if (i3 >= length) {
                            break;
                        } else {
                            i2 = i3;
                        }
                    }
                }
                bundle.putStringArrayList(key, arrayList);
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@NotNull JSONObject json, @NotNull String key, @NotNull Object value) throws JSONException {
                kotlin.jvm.internal.s.e(json, "json");
                kotlin.jvm.internal.s.e(key, "key");
                kotlin.jvm.internal.s.e(value, "value");
                throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
            }
        });
    }

    private BundleJSONConverter() {
    }

    @JvmStatic
    @NotNull
    public static final Bundle convertToBundle(@NotNull JSONObject jsonObject) throws JSONException {
        kotlin.jvm.internal.s.e(jsonObject, "jsonObject");
        Bundle bundle = new Bundle();
        Iterator<String> itKeys = jsonObject.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            Object value = jsonObject.get(key);
            if (value != JSONObject.NULL) {
                if (value instanceof JSONObject) {
                    bundle.putBundle(key, convertToBundle((JSONObject) value));
                } else {
                    Setter setter = SETTERS.get(value.getClass());
                    if (setter == null) {
                        throw new IllegalArgumentException(kotlin.jvm.internal.s.m("Unsupported type: ", value.getClass()));
                    }
                    kotlin.jvm.internal.s.d(key, "key");
                    kotlin.jvm.internal.s.d(value, "value");
                    setter.setOnBundle(bundle, key, value);
                }
            }
        }
        return bundle;
    }

    @JvmStatic
    @NotNull
    public static final JSONObject convertToJSON(@NotNull Bundle bundle) throws JSONException {
        kotlin.jvm.internal.s.e(bundle, "bundle");
        JSONObject jSONObject = new JSONObject();
        for (String key : bundle.keySet()) {
            Object obj = bundle.get(key);
            if (obj != null) {
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = ((List) obj).iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    jSONObject.put(key, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(key, convertToJSON((Bundle) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter == null) {
                        throw new IllegalArgumentException(kotlin.jvm.internal.s.m("Unsupported type: ", obj.getClass()));
                    }
                    kotlin.jvm.internal.s.d(key, "key");
                    setter.setOnJSON(jSONObject, key, obj);
                }
            }
        }
        return jSONObject;
    }
}
