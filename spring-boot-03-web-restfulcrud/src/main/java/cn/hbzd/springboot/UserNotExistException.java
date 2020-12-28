package cn.hbzd.springboot;

/**
 * @description:
 * @author: CodeEmp
 * @time: 2020/12/25 13:36
 */
public class UserNotExistException extends RuntimeException {
    private static final long serialVersionUID = -3762363757873984368L;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }

    @Override
    public String toString() {
        return "用户不存在";
    }
}
