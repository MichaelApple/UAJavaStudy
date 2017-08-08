package design_patterns.structural;

/**
 * Created by Miha on 05.08.2017.
 */
public class Adapter {
    public static void main(String[] args) {
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();

        VectorGraphicsInterface g2 = new VectorAdapterFromRaster2(new RasterGraphics());
        g1.drawLine();
        g1.drawSquare();
    }
}

interface VectorGraphicsInterface {
    void drawLine();
    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine(){
        System.out.println("Draw a Line");
    }
    void drawRasterSquare(){
        System.out.println("Draw a Square");
    }
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface {
    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface {

    RasterGraphics r;

    public VectorAdapterFromRaster2(RasterGraphics r) {
        this.r = r;
    }

    @Override
    public void drawLine() {
        r.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        r.drawRasterSquare();
    }
}