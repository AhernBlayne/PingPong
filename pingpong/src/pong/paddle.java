package pong;
/**
 * Represents a paddle for pingpong
 * multiple paddles can be in ping pong.
 * @author Blayne Ahern
 * @version 3.0
 * @since 2019-26-11
 *
 */
public class paddle  {

    /**
     * These are the characteristics of the paddle
     * The paddle has width,height and a position on the x axis and the y axis.
     * paddle also has xd and yd variable which decides the speed of the paddle when it moves on either axis
     */

    private int pxPos;
    private int pyPos ;
    private int pxd;
    private int pyd;
    private int pwidth = 10, pheight = 50;

    /**
     * This is my paddle default constructor
     */


    public paddle(){

    }

    /**
     * paddle constructor which sets attribute values directly.
     */


    public paddle(int pxd,int pyd,int pwidth,int pheight,int pxPos,int pyPos){
        this.pxd=pxd;
        this.pyd=pyd;
        this.pwidth=pwidth;
        this.pheight=pheight;
        this.pxPos = pxPos;
        this.pyPos = pyPos;

    }

    /**
     * A constructor which only takes in xd
     */
    public paddle(int xd){
        //setting attributes values indirectly
        setpheight(0);
        setpwidth(0);
        setpXd(0);
        setpyd(0);
        setpxPos(0);
        setpyPos(0);
    }

    /**
     * A constructor which only takes in xd and yd
     */
    public paddle(int xd,int yd){
        //setting attributes values directly
        setpheight(0);
        setpwidth(0);
        setpXd(xd);
        setpyd(yd);
        setpxPos(0);
        setpyPos(0);
    }
    /**
     * These are my accessor methods for all the attributes of a paddle.
     * I use these in the ping pong class mainly for hit detection.
     *
     */
    public int getpXd() {
        return pxd;
    }

    public int getpyd() {
        return pyd;
    }

    public int getpwidth() {
        return pwidth;
    }

    public int getpheight() {
        return pheight;
    }

    public int getpxPos() {
        return pxPos;
    }

    public int getpyPos() {
        return pyPos;
    }

    public void setpxPos(int pxPos) {
        this.pxPos = pxPos;
    }

    public void setpyPos(int pyPos) {
        this.pyPos = pyPos;
    }

    public void setpXd(int pxd) {
        this.pxd = pxd;
    }

    public void setpyd(int pyd) {
        this.pyd = pyd;
    }

    public void setpwidth(int pwidth) {
        this.pwidth = pwidth;
    }

    public void setpheight(int pheight) {
        this.pheight = pheight;
    }
}
