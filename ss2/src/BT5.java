public class BT5 {
    interface UserActions {
        default void logActivity(String ac) {
            System.out.println("User activity: " + ac);
        }
    }

    interface AdminActions {
        default void logActivity(String ac) {
            System.out.println("Admin activity: " + ac);
        }
    }

    public class SuperAdmin implements UserActions, AdminActions {
        @Override
        public void logActivity(String ac) {
            UserActions.super.logActivity(ac);
            // AdminActions.super.logActivity(ac);
        }
    }

    public static void main(String[] args) {
        BT5 bt5 = new BT5();
        SuperAdmin sa = bt5.new SuperAdmin();
        sa.logActivity("Logged in");
    }
}