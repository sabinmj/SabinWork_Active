package com.example.sabin.sabinwork_active;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class Instagramclone extends AppCompatActivity {

    private static final String TAG = Instagramclone.class.getSimpleName();
    private ImageView ivResult;
    private Bitmap bp;


    public void getImage(View view){

        switch (view.getId()){
            case R.id.btnbrowsefromgallery:
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
                break;


        }
        ivResult.buildDrawingCache();
        this.bp = ivResult.getDrawingCache();
    }
    public void getImagefromgallery(View view){


        switch (view.getId()){
            case R.id.btngallery:
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
                break;


        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == RESULT_OK){
            Log.i(TAG,"inside if");
           Bitmap bp22 = (Bitmap) data.getExtras().get("data");
           ivResult.setImageBitmap(bp22);

        }
        else if (requestCode == 1 && resultCode == RESULT_OK){
            Uri selectedImage = data.getData();
            InputStream imageStream = null;
            try {
                imageStream = getContentResolver().openInputStream(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
            this.ivResult.setImageBitmap(yourSelectedImage);


        }
    }

    public void applyFilter(View view){

        ivResult.buildDrawingCache();
         bp = ivResult.getDrawingCache();



        switch (view.getId()){
            case R.id.btnoriginal:
                Bitmap original = toOriginal(bp);
                ivResult.setImageBitmap(original);
                break;
            case R.id.btngrayscale:
                Bitmap grayBitmap = toGrayScale(bp);
                ivResult.setImageBitmap(grayBitmap);
                break;
            case R.id.btncontrast:
                Bitmap bw=toBW(bp);
                ivResult.setImageBitmap(bw);
                break;
            case R.id.btnsat:
                Bitmap tosat=toSat(bp);
                ivResult.setImageBitmap(tosat);
                break;
        }
    }
    public Bitmap toOriginal(Bitmap bitmapOriginal) {

        int width, height;
        height = bitmapOriginal.getHeight();
        width = bitmapOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(1);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bitmapOriginal, 0, 0, paint);

        return bmpGrayscale;

    }
    public Bitmap toGrayScale(Bitmap bitmapOriginal) {

        int width, height;
        height = bitmapOriginal.getHeight();
        width = bitmapOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrix matB=new ColorMatrix();
        matB.setScale(1f, .95f, .82f, 1.0f);
        cm.setConcat(cm,matB);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bitmapOriginal, 0, 0, paint);

        return bmpGrayscale;
    }
    public Bitmap toBW(Bitmap bitmapOriginal) {
        int width, height;
        height = bitmapOriginal.getHeight();
        width = bitmapOriginal.getWidth();
        Bitmap bmpMonochrome = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bmpMonochrome);
        ColorMatrix ma = new ColorMatrix();
        ma.setSaturation(2);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(ma));
        canvas.drawBitmap(bitmapOriginal,0,0,paint);
        return bmpMonochrome;
    }
    public Bitmap toSat(Bitmap bitmapOriginal) {
        int width, height;
        height = bitmapOriginal.getHeight();
        width = bitmapOriginal.getWidth();
        Bitmap bmpMonochrome = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bmpMonochrome);
        ColorMatrix ma = new ColorMatrix();
        ma.setSaturation(2);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(ma));
        canvas.drawBitmap(bitmapOriginal,0,0,paint);
        return bmpMonochrome;
    }
    public Bitmap toSephia(Bitmap bmpOriginal) {

        float[] sepMat = {
                0.3930000066757202f,
                0.7689999938011169f,
                0.1889999955892563f,
                0,
                0,
                0.3490000069141388f,
                0.6859999895095825f,
                0.1679999977350235f,
                0,
                0,
                0.2720000147819519f,
                0.5339999794960022f,
                0.1309999972581863f,
                0,
                0,
                0,
                0,
                0,
                1,
                0,
                0,
                0,
                0,
                0,
                1,0,0,0,0,1,1,1,1};

        ColorMatrix sepiaMatrix = new ColorMatrix();
        sepiaMatrix.set(sepMat);

        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(sepiaMatrix);
        Bitmap rBitmap = bmpOriginal.copy(Bitmap.Config.ARGB_8888, true);

        Paint paint = new Paint();
        paint.setColorFilter(colorFilter);

        Canvas myCanvas = new Canvas(rBitmap);
        myCanvas.drawBitmap(rBitmap, 0, 0, paint);
        return rBitmap;





        /**
         ColorMatrix colorMatrix_Sepia = new ColorMatrix();
         colorMatrix_Sepia.setSaturation(0);

         ColorMatrix colorScale = new ColorMatrix();
         colorScale.setScale(1, 1, 0.8f, 1);

         colorMatrix_Sepia.postConcat(colorScale);

         ColorFilter ColorFilter_Sepia = new ColorMatrixColorFilter(
         colorMatrix_Sepia);

         Bitmap bitmap = Bitmap.createBitmap(bmpOriginal.getWidth(), bmpOriginal.getHeight(),
         Bitmap.Config.ARGB_8888);
         Canvas canvas = new Canvas(bitmap);

         Paint paint = new Paint();

         paint.setColorFilter(ColorFilter_Sepia);
         canvas.drawBitmap(bmpOriginal, 0, 0, paint);

         return bitmap;
         */
    }

    public Bitmap toCustom(Bitmap bmpOriginal)
    {
        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(2);
        cm.setScale(1f,1f,2,5);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;
    }
    public Bitmap toCustom1(Bitmap bmpOriginal)
    {
        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(2);
        cm.setScale(3f,2f,4f,4f);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;
    }
    public Bitmap toCustom2(Bitmap bmpOriginal)
    {
        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrix cm1=new ColorMatrix(cm);
        cm1.setScale(1,2f,1f,3);
        cm1.setConcat(cm,cm1);

        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm1);
        paint.setColorFilter(f);
        c.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;
    }
    public Bitmap toCustom3(Bitmap bmpOriginal)
    {
        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(1);
        ColorMatrix cm1=new ColorMatrix(cm);
        cm1.setScale(1,0.9f,0.9f,5);
        cm1.setConcat(cm,cm1);

        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm1);
        paint.setColorFilter(f);
        c.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;
    }
   /* private Bitmap toGrayScale(Bitmap bitmapOriginal) {

        int width, height;
        height = bitmapOriginal.getHeight();
        width = bitmapOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bitmapOriginal, 0, 0, paint);
        return bmpGrayscale;

    }
    public  Bitmap applyContrastEffect(Bitmap src, double value) {
        // image size
        int width = src.getWidth();
        int height = src.getHeight();
        // create output bitmap
        Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
        // color information
        int A, R, G, B;
        int pixel;
        // get contrast value
        double contrast = Math.pow((100 + value) / 100, 2);

        // scan through all pixels
        for(int x = 0; x < width; ++x) {
            for(int y = 0; y < height; ++y) {
                // get pixel color
                pixel = src.getPixel(x, y);
                A = Color.alpha(pixel);
                // apply filter contrast for every channel R, G, B
                R = Color.red(pixel);
                R = (int)(((((R / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                if(R < 0) { R = 0; }
                else if(R > 255) { R = 255; }

                G = Color.red(pixel);
                G = (int)(((((G / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                if(G < 0) { G = 0; }
                else if(G > 255) { G = 255; }

                B = Color.red(pixel);
                B = (int)(((((B / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                if(B < 0) { B = 0; }
                else if(B > 255) { B = 255; }

                // set new pixel color to output bitmap
                bmOut.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }

        // return final image
        return bmOut; */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagramclone);
        ivResult = (ImageView) findViewById(R.id.ivResult);

        Intent intent = getIntent();

    }




   @Override

  protected void onStart() {
        super.onStart();


/*
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH){
            try{
                Intent imageRecievedIntent = getIntent();

                String intentAction = imageRecievedIntent.getAction();
                String intentType = imageRecievedIntent.getType();
                if (Intent.ACTION_SEND.equals(intentAction) && intentType != null) {
                    Uri contentUri = imageRecievedIntent.getParcelableExtra(Intent.EXTRA_STREAM);
                    ivResult.setImageURI(contentUri);
                }
            }catch (Exception e){
                Log.e("vvvvvvv", e.toString());
                e.printStackTrace();
            }
        } else {
            Intent imageRecievedIntent = getIntent();
            Uri uri = (Uri) imageRecievedIntent.getExtras().get("data");
        }*/
    }
}

