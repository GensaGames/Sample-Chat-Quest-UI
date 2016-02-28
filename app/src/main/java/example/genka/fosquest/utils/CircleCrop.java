package example.genka.fosquest.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

import com.thedeanda.lorem.LoremIpsum;

/**
 * Created by Genka on 27.10.2015.
 */
public class CircleCrop {

    /** Create special ViewHolder for image
     *  to minimize device resource!
     *  TODO: Change function and create special ImageHolder!
     *  */

    public final static int PHOTO_RESIZE = 120;

    public static  Bitmap getRoundedShape(Bitmap scaleBitmapImage) {
        int targetWidth = PHOTO_RESIZE;
        int targetHeight = PHOTO_RESIZE;
        Bitmap targetBitmap = Bitmap.createBitmap(targetWidth,
                targetHeight,Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(targetBitmap);
        Path path = new Path();
        path.addCircle(((float) targetWidth - 1) / 2,
                ((float) targetHeight - 1) / 2,
                (Math.min(((float) targetWidth),
                        ((float) targetHeight)) / 2),
                Path.Direction.CCW);

        canvas.clipPath(path);
        Bitmap sourceBitmap = scaleBitmapImage;
        canvas.drawBitmap(sourceBitmap,
                new Rect(0, 0, sourceBitmap.getWidth(),
                        sourceBitmap.getHeight()),
                new Rect(0, 0, targetWidth, targetHeight), null);
        return targetBitmap;
    }
}
