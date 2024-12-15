package Loosecoupling;

public class Phone {
    public Sim Type;

    public void setSim(Sim sime) {
        this.Type = sime;
    }
    public void browse() {
        Type.browse();
    }

    public void call(){
        Type.call();
    }
}
