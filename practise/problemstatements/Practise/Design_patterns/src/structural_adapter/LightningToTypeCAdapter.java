package structural_adapter;

public class LightningToTypeCAdapter implements LightningCharger{

    private AndroidPhone android1=new AndroidPhone();
    public void chargeWithLightning(){
        System.out.println("Lightning to Type_C Adapter");
        android1.charge();
    }

    public LightningToTypeCAdapter(AndroidPhone android1){
        this.android1=android1;
    }

}
