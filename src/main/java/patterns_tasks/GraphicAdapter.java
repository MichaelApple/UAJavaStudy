package patterns_tasks;

/**
 * Created by Miha on 10.08.2017.
 */
public class GraphicAdapter {
    public static void main(String[] args) {
        DVI dvi = new VideoAdapter(new SVGA());
        dvi.showDVI();
    }
}

class SVGA {
    void superVideoGraphics(){
        System.out.println("Shows Super Video Graphics");
    }
}
interface DVI {
    void showDVI();
}

class VideoAdapter implements DVI{
    SVGA svga;

    public VideoAdapter(SVGA svga) {
        this.svga = svga;
    }

    @Override
    public void showDVI() {
        svga.superVideoGraphics();
    }
}

