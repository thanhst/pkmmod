package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.adjust.sdk.Constants;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.collections.v;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ShareInternalUtility.kt */
@Metadata(bv = {}, d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\ba\u0010bJ \u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\"\u0010\u000b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J*\u0010\u000f\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J,\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0007J\u0018\u0010\u001d\u001a\u00020\u00192\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007J$\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J*\u0010#\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010!2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007J\"\u0010)\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010(2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010'\u001a\u00020&H\u0007J\u001c\u0010,\u001a\u0004\u0018\u00010\t2\b\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010'\u001a\u00020&H\u0007J\"\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010(2\b\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010'\u001a\u00020&H\u0007J\u001c\u00102\u001a\u0004\u0018\u00010\u00102\b\u00101\u001a\u0004\u0018\u0001002\u0006\u0010'\u001a\u00020&H\u0007J\u0018\u00106\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u001bH\u0007J\u001c\u00109\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u0001072\u0006\u00105\u001a\u00020\u001bH\u0007J\u001e\u0010<\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\t0;2\u0006\u0010:\u001a\u00020\tH\u0007J\"\u0010A\u001a\u0004\u0018\u00010@2\u0006\u0010=\u001a\u00020&2\u000e\u0010?\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030>H\u0002J&\u0010A\u001a\u0004\u0018\u00010@2\u0006\u0010=\u001a\u00020&2\b\u0010C\u001a\u0004\u0018\u00010B2\b\u0010E\u001a\u0004\u0018\u00010DH\u0002J\u0018\u0010F\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007J\"\u0010G\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0007J,\u0010J\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010H\u001a\u0004\u0018\u00010\r2\b\u0010I\u001a\u0004\u0018\u00010\tH\u0007J\"\u0010J\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010I\u001a\u0004\u0018\u00010\tH\u0007J \u0010J\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010L\u001a\u00020KH\u0007J\u001a\u0010O\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\t2\b\u0010N\u001a\u0004\u0018\u00010\tH\u0002J&\u0010U\u001a\u00020T2\b\u0010Q\u001a\u0004\u0018\u00010P2\b\u0010R\u001a\u0004\u0018\u00010D2\b\u0010\u0004\u001a\u0004\u0018\u00010SH\u0007J&\u0010U\u001a\u00020T2\b\u0010Q\u001a\u0004\u0018\u00010P2\b\u0010W\u001a\u0004\u0018\u00010V2\b\u0010\u0004\u001a\u0004\u0018\u00010SH\u0007J$\u0010U\u001a\u00020T2\b\u0010Q\u001a\u0004\u0018\u00010P2\u0006\u0010X\u001a\u00020B2\b\u0010\u0004\u001a\u0004\u0018\u00010SH\u0007J\u001c\u0010[\u001a\u0004\u0018\u00010\u00102\b\u0010Z\u001a\u0004\u0018\u00010Y2\u0006\u0010'\u001a\u00020&H\u0007J\u001c\u0010\\\u001a\u0004\u0018\u00010\u00102\b\u0010Z\u001a\u0004\u0018\u00010Y2\u0006\u0010'\u001a\u00020&H\u0007J\u0014\u0010]\u001a\u0004\u0018\u00010\t2\b\u0010C\u001a\u0004\u0018\u00010BH\u0007R\u0014\u0010^\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010`\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b`\u0010_¨\u0006c"}, d2 = {"Lcom/facebook/share/internal/ShareInternalUtility;", "", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/share/Sharer$Result;", "callback", "Ljava/lang/Exception;", "exception", "Lkotlin/t;", "invokeCallbackWithException", "", "error", "invokeCallbackWithError", ShareConstants.RESULT_POST_ID, "Lcom/facebook/GraphResponse;", "graphResponse", "invokeCallbackWithResults", "Landroid/os/Bundle;", "result", "getNativeDialogCompletionGesture", "getShareDialogPostId", "", "requestCode", "resultCode", "Landroid/content/Intent;", ShareConstants.WEB_DIALOG_PARAM_DATA, "Lcom/facebook/share/internal/ResultProcessor;", "resultProcessor", "", "handleActivityResult", "getShareResultProcessor", "Lcom/facebook/internal/AppCall;", "getAppCallFromActivityResult", "registerStaticShareCallback", "Lcom/facebook/CallbackManager;", "callbackManager", "registerSharerCallback", "Lcom/facebook/share/model/SharePhotoContent;", "photoContent", "Ljava/util/UUID;", "appCallId", "", "getPhotoUrls", "Lcom/facebook/share/model/ShareVideoContent;", "videoContent", "getVideoUrl", "Lcom/facebook/share/model/ShareMediaContent;", "mediaContent", "getMediaInfos", "Lcom/facebook/share/model/ShareCameraEffectContent;", "cameraEffectContent", "getTextureUrlBundle", "Lorg/json/JSONArray;", "jsonArray", "requireNamespace", "removeNamespacesFromOGJsonArray", "Lorg/json/JSONObject;", "jsonObject", "removeNamespacesFromOGJsonObject", "fullName", "Landroid/util/Pair;", "getFieldNameAndNamespaceFromFullName", "callId", "Lcom/facebook/share/model/ShareMedia;", Constants.MEDIUM, "Lcom/facebook/internal/NativeAppCallAttachmentStore$Attachment;", "getAttachment", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Landroid/graphics/Bitmap;", "bitmap", "invokeOnCancelCallback", "invokeOnSuccessCallback", "response", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "invokeOnErrorCallback", "Lcom/facebook/FacebookException;", "ex", "shareOutcome", "errorMessage", "logShareResult", "Lcom/facebook/AccessToken;", "accessToken", "image", "Lcom/facebook/GraphRequest$Callback;", "Lcom/facebook/GraphRequest;", "newUploadStagingResourceWithImageRequest", "Ljava/io/File;", ShareInternalUtility.STAGING_PARAM, "imageUri", "Lcom/facebook/share/model/ShareStoryContent;", "storyContent", "getStickerUrl", "getBackgroundAssetMediaInfo", "getUriExtension", "MY_STAGING_RESOURCES", "Ljava/lang/String;", "STAGING_PARAM", "<init>", "()V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ShareInternalUtility {

    @NotNull
    public static final ShareInternalUtility INSTANCE = new ShareInternalUtility();

    @NotNull
    public static final String MY_STAGING_RESOURCES = "me/staging_resources";

    @NotNull
    public static final String STAGING_PARAM = "file";

    private ShareInternalUtility() {
    }

    private final AppCall getAppCallFromActivityResult(int requestCode, int resultCode, Intent data) {
        UUID callIdFromIntent = NativeProtocol.getCallIdFromIntent(data);
        if (callIdFromIntent == null) {
            return null;
        }
        return AppCall.INSTANCE.finishPendingCall(callIdFromIntent, requestCode);
    }

    private final NativeAppCallAttachmentStore.Attachment getAttachment(UUID callId, ShareMedia<?, ?> medium) {
        Bitmap bitmap;
        Uri localUrl;
        Uri uri = null;
        Bitmap bitmap2 = null;
        if (medium instanceof SharePhoto) {
            SharePhoto sharePhoto = (SharePhoto) medium;
            bitmap2 = sharePhoto.getBitmap();
            localUrl = sharePhoto.getImageUrl();
        } else {
            if (!(medium instanceof ShareVideo)) {
                bitmap = null;
                return getAttachment(callId, uri, bitmap);
            }
            localUrl = ((ShareVideo) medium).getLocalUrl();
        }
        Bitmap bitmap3 = bitmap2;
        uri = localUrl;
        bitmap = bitmap3;
        return getAttachment(callId, uri, bitmap);
    }

    @JvmStatic
    @Nullable
    public static final Bundle getBackgroundAssetMediaInfo(@Nullable ShareStoryContent storyContent, @NotNull UUID appCallId) throws FacebookException {
        s.e(appCallId, "appCallId");
        Bundle bundle = null;
        if (storyContent != null && storyContent.getBackgroundAsset() != null) {
            ShareMedia<?, ?> backgroundAsset = storyContent.getBackgroundAsset();
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, backgroundAsset);
            if (attachment == null) {
                return null;
            }
            bundle = new Bundle();
            bundle.putString(ShareConstants.MEDIA_TYPE, backgroundAsset.getMediaType().name());
            bundle.putString(ShareConstants.MEDIA_URI, attachment.getAttachmentUrl());
            String uriExtension = getUriExtension(attachment.getOriginalUri());
            if (uriExtension != null) {
                Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
            }
            NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
            NativeAppCallAttachmentStore.addAttachments(t.e(attachment));
        }
        return bundle;
    }

    @JvmStatic
    @NotNull
    public static final Pair<String, String> getFieldNameAndNamespaceFromFullName(@NotNull String fullName) {
        String strSubstring;
        int i2;
        s.e(fullName, "fullName");
        int iF = StringsKt__StringsKt.F(fullName, ':', 0, false, 6, null);
        if (iF == -1 || fullName.length() <= (i2 = iF + 1)) {
            strSubstring = null;
        } else {
            strSubstring = fullName.substring(0, iF);
            s.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            fullName = fullName.substring(i2);
            s.d(fullName, "(this as java.lang.String).substring(startIndex)");
        }
        return new Pair<>(strSubstring, fullName);
    }

    @JvmStatic
    @Nullable
    public static final List<Bundle> getMediaInfos(@Nullable ShareMediaContent mediaContent, @NotNull UUID appCallId) throws FacebookException {
        Bundle bundle;
        s.e(appCallId, "appCallId");
        List<ShareMedia<?, ?>> media = mediaContent == null ? null : mediaContent.getMedia();
        if (media == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ShareMedia<?, ?> shareMedia : media) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, shareMedia);
            if (attachment == null) {
                bundle = null;
            } else {
                arrayList.add(attachment);
                bundle = new Bundle();
                bundle.putString(ShareConstants.MEDIA_TYPE, shareMedia.getMediaType().name());
                bundle.putString(ShareConstants.MEDIA_URI, attachment.getAttachmentUrl());
            }
            if (bundle != null) {
                arrayList2.add(bundle);
            }
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return arrayList2;
    }

    @JvmStatic
    @Nullable
    public static final String getNativeDialogCompletionGesture(@NotNull Bundle result) {
        s.e(result, "result");
        return result.containsKey(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY) ? result.getString(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY) : result.getString(NativeProtocol.EXTRA_DIALOG_COMPLETION_GESTURE_KEY);
    }

    @JvmStatic
    @Nullable
    public static final List<String> getPhotoUrls(@Nullable SharePhotoContent photoContent, @NotNull UUID appCallId) throws FacebookException {
        s.e(appCallId, "appCallId");
        List<SharePhoto> photos = photoContent == null ? null : photoContent.getPhotos();
        if (photos == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = photos.iterator();
        while (it.hasNext()) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, (SharePhoto) it.next());
            if (attachment != null) {
                arrayList.add(attachment);
            }
        }
        ArrayList arrayList2 = new ArrayList(v.o(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((NativeAppCallAttachmentStore.Attachment) it2.next()).getAttachmentUrl());
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return arrayList2;
    }

    @JvmStatic
    @Nullable
    public static final String getShareDialogPostId(@NotNull Bundle result) {
        s.e(result, "result");
        return result.containsKey(ShareConstants.RESULT_POST_ID) ? result.getString(ShareConstants.RESULT_POST_ID) : result.containsKey(ShareConstants.EXTRA_RESULT_POST_ID) ? result.getString(ShareConstants.EXTRA_RESULT_POST_ID) : result.getString(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID);
    }

    @JvmStatic
    @NotNull
    public static final ResultProcessor getShareResultProcessor(@Nullable FacebookCallback<Sharer.Result> callback) {
        return new ResultProcessor(callback) { // from class: com.facebook.share.internal.ShareInternalUtility.getShareResultProcessor.1
            final /* synthetic */ FacebookCallback<Sharer.Result> $callback;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(callback);
                this.$callback = callback;
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public void onCancel(@NotNull AppCall appCall) {
                s.e(appCall, "appCall");
                ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
                ShareInternalUtility.invokeOnCancelCallback(this.$callback);
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public void onError(@NotNull AppCall appCall, @NotNull FacebookException error) {
                s.e(appCall, "appCall");
                s.e(error, "error");
                ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
                ShareInternalUtility.invokeOnErrorCallback(this.$callback, error);
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public void onSuccess(@NotNull AppCall appCall, @Nullable Bundle bundle) {
                s.e(appCall, "appCall");
                if (bundle != null) {
                    String nativeDialogCompletionGesture = ShareInternalUtility.getNativeDialogCompletionGesture(bundle);
                    if (nativeDialogCompletionGesture == null || kotlin.text.s.l("post", nativeDialogCompletionGesture, true)) {
                        ShareInternalUtility.invokeOnSuccessCallback(this.$callback, ShareInternalUtility.getShareDialogPostId(bundle));
                    } else if (kotlin.text.s.l("cancel", nativeDialogCompletionGesture, true)) {
                        ShareInternalUtility.invokeOnCancelCallback(this.$callback);
                    } else {
                        ShareInternalUtility.invokeOnErrorCallback(this.$callback, new FacebookException(NativeProtocol.ERROR_UNKNOWN_ERROR));
                    }
                }
            }
        };
    }

    @JvmStatic
    @Nullable
    public static final Bundle getStickerUrl(@Nullable ShareStoryContent storyContent, @NotNull UUID appCallId) throws FacebookException {
        s.e(appCallId, "appCallId");
        if (storyContent == null || storyContent.getStickerAsset() == null) {
            return null;
        }
        new ArrayList().add(storyContent.getStickerAsset());
        NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, storyContent.getStickerAsset());
        if (attachment == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(ShareConstants.MEDIA_URI, attachment.getAttachmentUrl());
        String uriExtension = getUriExtension(attachment.getOriginalUri());
        if (uriExtension != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
        }
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
        NativeAppCallAttachmentStore.addAttachments(t.e(attachment));
        return bundle;
    }

    @JvmStatic
    @Nullable
    public static final Bundle getTextureUrlBundle(@Nullable ShareCameraEffectContent cameraEffectContent, @NotNull UUID appCallId) throws FacebookException {
        s.e(appCallId, "appCallId");
        CameraEffectTextures textures = cameraEffectContent == null ? null : cameraEffectContent.getTextures();
        if (textures == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        for (String str : textures.keySet()) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, textures.getTextureUri(str), textures.getTextureBitmap(str));
            if (attachment != null) {
                arrayList.add(attachment);
                bundle.putString(str, attachment.getAttachmentUrl());
            }
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return bundle;
    }

    @JvmStatic
    @Nullable
    public static final String getUriExtension(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        String string = uri.toString();
        s.d(string, "uri.toString()");
        int iL = StringsKt__StringsKt.L(string, '.', 0, false, 6, null);
        if (iL == -1) {
            return null;
        }
        String strSubstring = string.substring(iL);
        s.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    @JvmStatic
    @Nullable
    public static final String getVideoUrl(@Nullable ShareVideoContent videoContent, @NotNull UUID appCallId) throws FacebookException {
        ShareVideo video;
        s.e(appCallId, "appCallId");
        Uri localUrl = (videoContent == null || (video = videoContent.getVideo()) == null) ? null : video.getLocalUrl();
        if (localUrl == null) {
            return null;
        }
        NativeAppCallAttachmentStore.Attachment attachmentCreateAttachment = NativeAppCallAttachmentStore.createAttachment(appCallId, localUrl);
        NativeAppCallAttachmentStore.addAttachments(t.e(attachmentCreateAttachment));
        return attachmentCreateAttachment.getAttachmentUrl();
    }

    @JvmStatic
    public static final boolean handleActivityResult(int requestCode, int resultCode, @Nullable Intent data, @Nullable ResultProcessor resultProcessor) {
        AppCall appCallFromActivityResult = INSTANCE.getAppCallFromActivityResult(requestCode, resultCode, data);
        if (appCallFromActivityResult == null) {
            return false;
        }
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
        NativeAppCallAttachmentStore.cleanupAttachmentsForCall(appCallFromActivityResult.getCallId());
        if (resultProcessor == null) {
            return true;
        }
        FacebookException exceptionFromErrorData = data != null ? NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(data)) : null;
        if (exceptionFromErrorData == null) {
            resultProcessor.onSuccess(appCallFromActivityResult, data != null ? NativeProtocol.getSuccessResultsFromIntent(data) : null);
        } else if (exceptionFromErrorData instanceof FacebookOperationCanceledException) {
            resultProcessor.onCancel(appCallFromActivityResult);
        } else {
            resultProcessor.onError(appCallFromActivityResult, exceptionFromErrorData);
        }
        return true;
    }

    @JvmStatic
    public static final void invokeCallbackWithError(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @Nullable String str) {
        invokeOnErrorCallback(facebookCallback, str);
    }

    @JvmStatic
    public static final void invokeCallbackWithException(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @NotNull Exception exception) {
        s.e(exception, "exception");
        if (exception instanceof FacebookException) {
            invokeOnErrorCallback(facebookCallback, (FacebookException) exception);
        } else {
            invokeCallbackWithError(facebookCallback, s.m("Error preparing share content: ", exception.getLocalizedMessage()));
        }
    }

    @JvmStatic
    public static final void invokeCallbackWithResults(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @Nullable String str, @NotNull GraphResponse graphResponse) {
        s.e(graphResponse, "graphResponse");
        FacebookRequestError error = graphResponse.getError();
        if (error == null) {
            invokeOnSuccessCallback(facebookCallback, str);
            return;
        }
        String errorMessage = error.getErrorMessage();
        if (Utility.isNullOrEmpty(errorMessage)) {
            errorMessage = "Unexpected error sharing.";
        }
        invokeOnErrorCallback(facebookCallback, graphResponse, errorMessage);
    }

    @JvmStatic
    public static final void invokeOnCancelCallback(@Nullable FacebookCallback<Sharer.Result> facebookCallback) {
        INSTANCE.logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, null);
        if (facebookCallback == null) {
            return;
        }
        facebookCallback.onCancel();
    }

    @JvmStatic
    public static final void invokeOnErrorCallback(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @Nullable GraphResponse graphResponse, @Nullable String str) {
        INSTANCE.logShareResult("error", str);
        if (facebookCallback == null) {
            return;
        }
        facebookCallback.onError(new FacebookGraphResponseException(graphResponse, str));
    }

    @JvmStatic
    public static final void invokeOnSuccessCallback(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @Nullable String str) {
        INSTANCE.logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED, null);
        if (facebookCallback == null) {
            return;
        }
        facebookCallback.onSuccess(new Sharer.Result(str));
    }

    private final void logShareResult(String str, String str2) {
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_OUTCOME, str);
        if (str2 != null) {
            bundle.putString(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str2);
        }
        internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_SHARE_RESULT, bundle);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newUploadStagingResourceWithImageRequest(@Nullable AccessToken accessToken, @Nullable Bitmap image, @Nullable GraphRequest.Callback callback) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(STAGING_PARAM, image);
        return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, null, 32, null);
    }

    @JvmStatic
    public static final void registerSharerCallback(final int i2, @Nullable CallbackManager callbackManager, @Nullable final FacebookCallback<Sharer.Result> facebookCallback) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl) callbackManager).registerCallback(i2, new CallbackManagerImpl.Callback() { // from class: com.facebook.share.internal.b
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i3, Intent intent) {
                return ShareInternalUtility.m152registerSharerCallback$lambda1(i2, facebookCallback, i3, intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerSharerCallback$lambda-1, reason: not valid java name */
    public static final boolean m152registerSharerCallback$lambda1(int i2, FacebookCallback facebookCallback, int i3, Intent intent) {
        return handleActivityResult(i2, i3, intent, getShareResultProcessor(facebookCallback));
    }

    @JvmStatic
    public static final void registerStaticShareCallback(final int i2) {
        CallbackManagerImpl.INSTANCE.registerStaticCallback(i2, new CallbackManagerImpl.Callback() { // from class: com.facebook.share.internal.a
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i3, Intent intent) {
                return ShareInternalUtility.m153registerStaticShareCallback$lambda0(i2, i3, intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerStaticShareCallback$lambda-0, reason: not valid java name */
    public static final boolean m153registerStaticShareCallback$lambda0(int i2, int i3, Intent intent) {
        return handleActivityResult(i2, i3, intent, getShareResultProcessor(null));
    }

    @JvmStatic
    @NotNull
    public static final JSONArray removeNamespacesFromOGJsonArray(@NotNull JSONArray jsonArray, boolean requireNamespace) throws JSONException {
        s.e(jsonArray, "jsonArray");
        JSONArray jSONArray = new JSONArray();
        int length = jsonArray.length();
        if (length > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                Object objRemoveNamespacesFromOGJsonObject = jsonArray.get(i2);
                if (objRemoveNamespacesFromOGJsonObject instanceof JSONArray) {
                    objRemoveNamespacesFromOGJsonObject = removeNamespacesFromOGJsonArray((JSONArray) objRemoveNamespacesFromOGJsonObject, requireNamespace);
                } else if (objRemoveNamespacesFromOGJsonObject instanceof JSONObject) {
                    objRemoveNamespacesFromOGJsonObject = removeNamespacesFromOGJsonObject((JSONObject) objRemoveNamespacesFromOGJsonObject, requireNamespace);
                }
                jSONArray.put(objRemoveNamespacesFromOGJsonObject);
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return jSONArray;
    }

    @JvmStatic
    @Nullable
    public static final JSONObject removeNamespacesFromOGJsonObject(@Nullable JSONObject jsonObject, boolean requireNamespace) throws JSONException {
        if (jsonObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArrayNames = jsonObject.names();
            if (jSONArrayNames == null) {
                return null;
            }
            int i2 = 0;
            int length = jSONArrayNames.length();
            if (length > 0) {
                while (true) {
                    int i3 = i2 + 1;
                    String key = jSONArrayNames.getString(i2);
                    Object objRemoveNamespacesFromOGJsonArray = jsonObject.get(key);
                    if (objRemoveNamespacesFromOGJsonArray instanceof JSONObject) {
                        objRemoveNamespacesFromOGJsonArray = removeNamespacesFromOGJsonObject((JSONObject) objRemoveNamespacesFromOGJsonArray, true);
                    } else if (objRemoveNamespacesFromOGJsonArray instanceof JSONArray) {
                        objRemoveNamespacesFromOGJsonArray = removeNamespacesFromOGJsonArray((JSONArray) objRemoveNamespacesFromOGJsonArray, true);
                    }
                    s.d(key, "key");
                    Pair<String, String> fieldNameAndNamespaceFromFullName = getFieldNameAndNamespaceFromFullName(key);
                    String str = (String) fieldNameAndNamespaceFromFullName.first;
                    String str2 = (String) fieldNameAndNamespaceFromFullName.second;
                    if (requireNamespace) {
                        if (str != null && s.a(str, DeviceRequestsHelper.SDK_HEADER)) {
                            jSONObject.put(key, objRemoveNamespacesFromOGJsonArray);
                        } else if (str == null || s.a(str, "og")) {
                            jSONObject.put(str2, objRemoveNamespacesFromOGJsonArray);
                        } else {
                            jSONObject2.put(str2, objRemoveNamespacesFromOGJsonArray);
                        }
                    } else if (str == null || !s.a(str, "fb")) {
                        jSONObject.put(str2, objRemoveNamespacesFromOGJsonArray);
                    } else {
                        jSONObject.put(key, objRemoveNamespacesFromOGJsonArray);
                    }
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_DATA, jSONObject2);
            }
            return jSONObject;
        } catch (JSONException unused) {
            throw new FacebookException("Failed to create json object from share content");
        }
    }

    @JvmStatic
    public static final void invokeOnErrorCallback(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @Nullable String str) {
        INSTANCE.logShareResult("error", str);
        if (facebookCallback == null) {
            return;
        }
        facebookCallback.onError(new FacebookException(str));
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newUploadStagingResourceWithImageRequest(@Nullable AccessToken accessToken, @Nullable File file, @Nullable GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, 268435456), "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(STAGING_PARAM, parcelableResourceWithMimeType);
        return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, null, 32, null);
    }

    @JvmStatic
    public static final void invokeOnErrorCallback(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @NotNull FacebookException ex) {
        s.e(ex, "ex");
        INSTANCE.logShareResult("error", ex.getMessage());
        if (facebookCallback == null) {
            return;
        }
        facebookCallback.onError(ex);
    }

    private final NativeAppCallAttachmentStore.Attachment getAttachment(UUID callId, Uri uri, Bitmap bitmap) {
        if (bitmap != null) {
            return NativeAppCallAttachmentStore.createAttachment(callId, bitmap);
        }
        if (uri != null) {
            return NativeAppCallAttachmentStore.createAttachment(callId, uri);
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newUploadStagingResourceWithImageRequest(@Nullable AccessToken accessToken, @NotNull Uri imageUri, @Nullable GraphRequest.Callback callback) throws FileNotFoundException {
        s.e(imageUri, "imageUri");
        String path = imageUri.getPath();
        if (Utility.isFileUri(imageUri) && path != null) {
            return newUploadStagingResourceWithImageRequest(accessToken, new File(path), callback);
        }
        if (Utility.isContentUri(imageUri)) {
            GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(imageUri, "image/png");
            Bundle bundle = new Bundle(1);
            bundle.putParcelable(STAGING_PARAM, parcelableResourceWithMimeType);
            return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, null, 32, null);
        }
        throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
    }
}
