import org.omg.CORBA.SystemException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionExample {
    public void method() throws IOException {

    }
}

class ExceptionSubClass extends ExceptionExample{
    @Override
    public void method() throws FileNotFoundException, SystemException, IOException {

    }
}
