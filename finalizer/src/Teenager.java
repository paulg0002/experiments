public class Teenager {
    public static void main(String[] args) {
        try {
            Room r = new Room(99);
            r.close();
            //Adding a line System.gc() only helps in certain condition
            System.out.println("Peace Out");
        }
        catch(Exception e){

            }
    }
}