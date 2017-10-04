public class BaseFile {

    public int add(int a, int b){
        System.out.println("This is add method");
        System.out.println("This is add method with 2 parameters");
        return a+b;
    }

    public int add(int a, int b, int c){
        System.out.println("This is add method  with 3 parameters");
        return a+b+c;
    }

    public int add(int a, int b, int c, int d){
        System.out.println("This is add method  with 4 parameters");
        return a+b+c+d;
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
