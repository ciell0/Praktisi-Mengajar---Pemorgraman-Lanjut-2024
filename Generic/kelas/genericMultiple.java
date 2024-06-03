package kelas;
import java.util.*;

public class genericMultiple <T,U> {
    public T data;
    public U data2;

    public genericMultiple (T dataInput, U data2Input){
        this.data = dataInput;
        this.data2 = data2Input;
        setData(dataInput);
        setData2(data2Input);
    }

    public T getData (){
        return this.data;
    }

    public U getData2 (){
        return this.data2;
    }

    public void setData (T dataInput){
        this.data = dataInput;
    }

    public void setData2 (U dataInput2){
        this.data2 = dataInput2;
    }
}
