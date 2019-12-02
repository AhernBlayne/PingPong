package pong;

public class ball  {

    private int xd;
    private int yd ;
    private int bwidth, bheight;
    private int xPos;
    private int yPos;


    public ball(){
            this(3,2,16,16,250,250);
    }


    public ball(int xd,int yd,int bwidth,int bheight,int xPos,int yPos){
        //setting attributes values directly)
        this.xd=xd;
        this.yd=yd;
        this.bwidth=bwidth;
        this.bheight=bheight;
        this.xPos = xPos;
        this.yPos = yPos;

    }
    public ball(int xPos,int yPos, int bwidth,int bheight){
        //setting attributes values directly)
        this.bwidth=bwidth;
        this.bheight=bheight;
        this.xPos = xPos;
        this.yPos = yPos;

    }



    public ball(int xd){
        //setting attributes values indirectly
        setBheight(0);
        setBwidth(0);
        setXd(0);
        setyd(0);
        setxPos(0);
        setyPos(0);
    }

    public ball(int xd,int yd){
        //setting attributes values directly

        setBheight(0);
        setBwidth(0);
        setXd(xd);
        setyd(yd);
        setxPos(0);
        setyPos(0);
    }

    //accessor methods
    public int getXd() {
        return xd;
    }

    public int getyd() {
        return yd;
    }

    public int getBwidth() {
        return bwidth;
    }

    public int getBheight() {
        return bheight;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int xPos) {
       this.xPos = xPos;
    }

    public void setyPos(int yPos) {
       this.yPos = yPos;
    }


    public void setXd(int xd) {
       this.xd = xd;
    }

    public void setyd(int yd) {
       this.yd = yd;
    }

    public void setBwidth(int bwidth) {
        this.bwidth = bwidth;
    }

    public void setBheight(int bheight) {
        this.bheight = bheight;
    }
}
