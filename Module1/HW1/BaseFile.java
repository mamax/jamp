public class BaseFile {

    public int add(int a, int b){
        System.out.println("This is add method");
        return a+b;
    }

    public int sub(int a, int b){
        return a-b;
    }

    public double div(int a, int b){
        return (double)(a/b);
    }

    public long mult(int a, int b){
        return a*b;
    }
	
	public double sqrt(int a){
        return Math.sqrt(a);
    }

}
