import java.util.*;

public class generic <T> {

    private T data;

    public generic (T dataInput){
        this.data = dataInput;
        setData(dataInput);
    }

    public T getData (){
        return data;
    }

    public void setData (T dataInput){
        this.data = dataInput;
    }
}