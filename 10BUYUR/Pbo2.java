public class Pbo2 {
    public static void main(String[] args) {
        User user = new User();
        System.out.println("user.getUserNameById(1) = " + user.getUserNameById(1));
        System.out.println("user.getUserById(2) = " + user.getUserById(1));
        System.out.println(user == new User());
    }
}