package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SessionEventsState.kt */
@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000f\b\u0001\u0018\u0000 *2\u00020\u0001:\u0001*B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b(\u0010)J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\nJ&\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0014\u0010\u0015\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0011\u0010$\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00148F¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/facebook/appevents/SessionEventsState;", "", "Lcom/facebook/GraphRequest;", "request", "Landroid/content/Context;", "applicationContext", "", "numSkipped", "Lorg/json/JSONArray;", "events", "", "limitEventUsage", "Lkotlin/t;", "populateRequest", "Lcom/facebook/appevents/AppEvent;", "event", "addEvent", "moveToAccumulated", "clearInFlightAndStats", "includeImplicitEvents", "", "accumulatePersistedEvents", "Lcom/facebook/internal/AttributionIdentifiers;", "attributionIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "", "anonymousAppDeviceGUID", "Ljava/lang/String;", "", "accumulatedEvents", "Ljava/util/List;", "inFlightEvents", "numSkippedEventsDueToFullBuffer", "I", "getAccumulatedEventCount", "()I", "accumulatedEventCount", "getEventsToPersist", "()Ljava/util/List;", "eventsToPersist", "<init>", "(Lcom/facebook/internal/AttributionIdentifiers;Ljava/lang/String;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SessionEventsState {

    @NotNull
    private List<AppEvent> accumulatedEvents;

    @NotNull
    private final String anonymousAppDeviceGUID;

    @NotNull
    private final AttributionIdentifiers attributionIdentifiers;

    @NotNull
    private final List<AppEvent> inFlightEvents;
    private int numSkippedEventsDueToFullBuffer;
    private static final String TAG = SessionEventsState.class.getSimpleName();
    private static final int MAX_ACCUMULATED_LOG_EVENTS = 1000;

    public SessionEventsState(@NotNull AttributionIdentifiers attributionIdentifiers, @NotNull String anonymousAppDeviceGUID) {
        kotlin.jvm.internal.s.e(attributionIdentifiers, "attributionIdentifiers");
        kotlin.jvm.internal.s.e(anonymousAppDeviceGUID, "anonymousAppDeviceGUID");
        this.attributionIdentifiers = attributionIdentifiers;
        this.anonymousAppDeviceGUID = anonymousAppDeviceGUID;
        this.accumulatedEvents = new ArrayList();
        this.inFlightEvents = new ArrayList();
    }

    public final synchronized void accumulatePersistedEvents(@NotNull List<AppEvent> events) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            kotlin.jvm.internal.s.e(events, "events");
            this.accumulatedEvents.addAll(events);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final synchronized void addEvent(@NotNull AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            kotlin.jvm.internal.s.e(event, "event");
            if (this.accumulatedEvents.size() + this.inFlightEvents.size() >= MAX_ACCUMULATED_LOG_EVENTS) {
                this.numSkippedEventsDueToFullBuffer++;
            } else {
                this.accumulatedEvents.add(event);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final synchronized void clearInFlightAndStats(boolean z2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if (!z2) {
            this.inFlightEvents.clear();
            this.numSkippedEventsDueToFullBuffer = 0;
            return;
        }
        try {
            this.accumulatedEvents.addAll(this.inFlightEvents);
            this.inFlightEvents.clear();
            this.numSkippedEventsDueToFullBuffer = 0;
            return;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return;
        }
    }

    public final synchronized int getAccumulatedEventCount() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return this.accumulatedEvents.size();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    @NotNull
    public final synchronized List<AppEvent> getEventsToPersist() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            List<AppEvent> list = this.accumulatedEvents;
            this.accumulatedEvents = new ArrayList();
            return list;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final int populateRequest(@NotNull GraphRequest request, @NotNull Context applicationContext, boolean includeImplicitEvents, boolean limitEventUsage) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            kotlin.jvm.internal.s.e(request, "request");
            kotlin.jvm.internal.s.e(applicationContext, "applicationContext");
            synchronized (this) {
                int i2 = this.numSkippedEventsDueToFullBuffer;
                EventDeactivationManager eventDeactivationManager = EventDeactivationManager.INSTANCE;
                EventDeactivationManager.processEvents(this.accumulatedEvents);
                this.inFlightEvents.addAll(this.accumulatedEvents);
                this.accumulatedEvents.clear();
                JSONArray jSONArray = new JSONArray();
                for (AppEvent appEvent : this.inFlightEvents) {
                    if (!appEvent.isChecksumValid()) {
                        Utility utility = Utility.INSTANCE;
                        Utility.logd(TAG, kotlin.jvm.internal.s.m("Event with invalid checksum: ", appEvent));
                    } else if (includeImplicitEvents || !appEvent.isImplicit()) {
                        jSONArray.put(appEvent.getJsonObject());
                    }
                }
                if (jSONArray.length() == 0) {
                    return 0;
                }
                t tVar = t.f3507a;
                populateRequest(request, applicationContext, i2, jSONArray, limitEventUsage);
                return jSONArray.length();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    private final void populateRequest(GraphRequest graphRequest, Context context, int i2, JSONArray jSONArray, boolean z2) {
        JSONObject jSONObject;
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                AppEventsLoggerUtility appEventsLoggerUtility = AppEventsLoggerUtility.INSTANCE;
                jSONObject = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, this.attributionIdentifiers, this.anonymousAppDeviceGUID, z2, context);
                if (this.numSkippedEventsDueToFullBuffer > 0) {
                    jSONObject.put("num_skipped_events", i2);
                }
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
            graphRequest.setGraphObject(jSONObject);
            Bundle parameters = graphRequest.getParameters();
            String string = jSONArray.toString();
            kotlin.jvm.internal.s.d(string, "events.toString()");
            parameters.putString("custom_events", string);
            graphRequest.setTag(string);
            graphRequest.setParameters(parameters);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
