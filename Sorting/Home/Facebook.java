import java.util.Scanner;

public class Facebook {

    class User {
        String name;
        int id;
        User next;
        Friend friendHead;

        User(String name, int id) {
            this.name = name;
            this.id = id;
            this.next = null;
            this.friendHead = null;
        }
    }

    class Friend {
        User user;
        Friend next;

        Friend(User user) {
            this.user = user;
            this.next = null;
        }
    }

    private User head = null;

    public void addUser(String name, int id) {
        User newUser = new User(name, id);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newUser;
        }
    }

    private User findUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equals(name))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriendship(String name1, String name2) {
        User u1 = findUserByName(name1);
        User u2 = findUserByName(name2);
        if (u1 == null || u2 == null || u1 == u2)
            return;
        if (!isFriend(u1, u2)) {
            Friend f1 = new Friend(u2);
            f1.next = u1.friendHead;
            u1.friendHead = f1;
            Friend f2 = new Friend(u1);
            f2.next = u2.friendHead;
            u2.friendHead = f2;
        }
    }

    private boolean isFriend(User u1, User u2) {
        Friend temp = u1.friendHead;
        while (temp != null) {
            if (temp.user == u2)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public void searchAndDisplayAllFriendsForGivenUser(String name) {
        User u = findUserByName(name);
        if (u == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of " + u.name + ":");
        Friend temp = u.friendHead;
        if (temp == null) {
            System.out.println("  No friends found.");
        }
        while (temp != null) {
            System.out.println("  -> " + temp.user.name + " (ID: " + temp.user.id + ")");
            temp = temp.next;
        }
    }

    public void checkFriendshipUserStatus(String name1, String name2) {
        User u1 = findUserByName(name1);
        User u2 = findUserByName(name2);
        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        if (isFriend(u1, u2)) {
            System.out.println(u1.name + " and " + u2.name + " are friends.");
        } else {
            System.out.println(u1.name + " and " + u2.name + " are not friends.");
        }
    }

    public static void main(String[] args) {
        Facebook fb = new Facebook();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add User");
            System.out.println("2. Add Friendship");
            System.out.println("3. Search and Display All Friends for Given User");
            System.out.println("4. Check Friendship User Status");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    fb.addUser(name, id);
                    System.out.println("User added.");
                    break;
                case 2:
                    System.out.print("Enter first user name: ");
                    String name1 = sc.next();
                    System.out.print("Enter second user name: ");
                    String name2 = sc.next();
                    fb.addFriendship(name1, name2);
                    System.out.println("Friendship added.");
                    break;
                case 3:
                    System.out.print("Enter user name: ");
                    String fname = sc.next();
                    fb.searchAndDisplayAllFriendsForGivenUser(fname);
                    break;
                case 4:
                    System.out.print("Enter first user name: ");
                    String cname1 = sc.next();
                    System.out.print("Enter second user name: ");
                    String cname2 = sc.next();
                    fb.checkFriendshipUserStatus(cname1, cname2);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
