public class User {
    public String getUserNameById(int id) {
        return "id yang dipanggil adalah " + id;
    }

    public User getUserById(int id) {
        return new User();
    }
}