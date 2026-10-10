public class Test001 {


    // 业务接口
    public interface UserService {
        void addUser();
    }

    public class UserService1 implements UserService{

        @Override
        public void addUser() {
            System.out.println("你好，我是测试类");
        }
    }

    // 目标类：真正的业务逻辑
    public class UserServiceImpl implements UserService {
        @Override
        public void addUser() {
            System.out.println("新增用户到数据库");
        }
    }



    // 代理类：和目标实现同一个接口
    public class UserServiceProxy implements UserService {
        // 持有真正的目标对象
        private final UserService target;
        private final UserService target1;

        public UserServiceProxy(UserService target, UserService target1) {
            this.target = target;
            this.target1 = target1;
        }

        @Override
        public void addUser() {
            // 额外增强：前置日志
            System.out.println("[代理] 方法开始执行，记录日志");
            // 调用真正的目标方法
            target.addUser();
            target1.addUser();
            // 额外增强：后置事务
            System.out.println("[代理] 方法执行完毕，提交事务");
        }
    }



    // 程序入口：运行看结果
    public static void main(String[] args) {
        Test001 test = new Test001();

        // 1. 创建两个真实的实现类对象
        UserService impl = test.new UserServiceImpl();
        UserService testImpl = test.new UserService1();

        // 2. 创建代理：第一个参数传给target，第二个传给target1
        UserService proxy = test.new UserServiceProxy(impl, testImpl);

        // 3. 调用代理的addUser
        proxy.addUser();
    }
}
