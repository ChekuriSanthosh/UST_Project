package structural_adapter;

public class TypeCToLigtningAdapter implements TypeCCharger{
    private IPhone iPhone;
    public void chargeWithTypeC(){
        System.out.println("Type-C to Lightning Adapter");
        iPhone.charge();

    }

    public TypeCToLigtningAdapter(IPhone iphone){
        this.iPhone=iphone;

    }
}
