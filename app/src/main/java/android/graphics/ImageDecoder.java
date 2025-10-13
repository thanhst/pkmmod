package android.graphics;

import android.annotation.*;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.os.Build;
import android.util.Size;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Stub replacement for android.graphics.ImageDecoder
 * This version allows the project to compile when the original class is missing or obfuscated.
 *
 * It provides the same public API shape but does not actually decode images.
 */
public final class ImageDecoder implements AutoCloseable {

    // ======================
    // Nested Types
    // ======================

    public static final class ImageInfo {
        private Size size = null;
        private ColorSpace colorSpace = null;

        public ImageInfo(@NonNull Size size, @Nullable ColorSpace colorSpace) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                this.size = size;
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                this.colorSpace = colorSpace;
            }
        }

        @Nullable
        public ColorSpace getColorSpace() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                return colorSpace;
            }
            return null;
        }

        @NonNull
        public Size getSize() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                return size;
            }
            return null;
        }
    }

    public interface OnHeaderDecodedListener {
        void onHeaderDecoded(@NonNull ImageDecoder decoder, @NonNull ImageInfo info, @NonNull Source source);
    }

    public interface OnPartialImageListener {
        boolean onPartialImage(@NonNull Exception e);
    }

    public static final class Source {
        private ByteBuffer buffer = null;

        public Source(@NonNull ByteBuffer buffer) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                this.buffer = buffer;
            }
        }

        public ByteBuffer getBuffer() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                return buffer;
            }
            return null;
        }
    }

    // ======================
    // Fields
    // ======================

    private OnPartialImageListener partialImageListener;
    private int allocator;
    private int memorySizePolicy;
    private ColorSpace targetColorSpace;
    private int targetWidth;
    private int targetHeight;

    // ======================
    // Constructors
    // ======================

    public ImageDecoder() {
    }

    // ======================
    // Static factory methods
    // ======================

    @NonNull
    public static Source createSource(@NonNull ByteBuffer byteBuffer) {
        return new Source(byteBuffer);
    }

    @NonNull
    public static Bitmap decodeBitmap(@NonNull Source source,
                                      @NonNull OnHeaderDecodedListener listener) throws IOException {
        // Fake implementation for build only (replace with real decode logic if needed)
        Size dummySize = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dummySize = new Size(100, 100);
        }
        ColorSpace dummyColor = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dummyColor = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        ImageInfo info = new ImageInfo(dummySize, dummyColor);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            listener.onHeaderDecoded(new ImageDecoder(), info, source);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return Bitmap.createBitmap(dummySize.getWidth(), dummySize.getHeight(), Bitmap.Config.ARGB_8888);
        }
        return null;
    }

    // ======================
    // Instance methods
    // ======================

    public void setAllocator(int allocator) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            this.allocator = allocator;
        }
    }

    public void setMemorySizePolicy(int policy) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            this.memorySizePolicy = policy;
        }
    }

    public void setOnPartialImageListener(@Nullable OnPartialImageListener listener) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            this.partialImageListener = listener;
        }
    }

    public void setTargetColorSpace(ColorSpace colorSpace) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            this.targetColorSpace = colorSpace;
        }
    }

    public void setTargetSize(int width, int height) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            this.targetWidth = width;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            this.targetHeight = height;
        }
    }

    @Override
    public void close() {
        // No resources to close in this stub
    }
}
