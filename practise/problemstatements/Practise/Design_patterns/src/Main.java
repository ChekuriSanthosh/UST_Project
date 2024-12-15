import structural_adapter.AndroidPhone;
import structural_adapter.IPhone;
import structural_adapter.LightningToTypeCAdapter;
import structural_adapter.TypeCToLigtningAdapter;

public class Main {
    public static void main(String[] args) {
        IPhone iPhone14=new IPhone();
        TypeCToLigtningAdapter adapter=new TypeCToLigtningAdapter(iPhone14);
        adapter.chargeWithTypeC();
        System.out.println("_____________________________________");
        AndroidPhone androidPhone=new AndroidPhone();
        LightningToTypeCAdapter adapter1=new LightningToTypeCAdapter(androidPhone);
        adapter1.chargeWithLightning();
    }
}