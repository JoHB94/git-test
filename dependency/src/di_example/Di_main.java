package di_example;

class A {
    //public B b = new B(); 기존
    public X x;
    //b.method();

    public void setX(X x){
        this.x = x;
    }
}

class B implements X{
    @Override
    public void method() {

    }
    //memoryDB --> repository 가정
}

class C implements X{
    @Override
    public void method() {

    }
    // mySQL --> repository 가정
}

interface X{
    public void method();
}


public class Di_main {
    public static void main(String[] args) {
        A a = new A();
        X x;
        @Autowired
         a.setX(x);

    }
}
