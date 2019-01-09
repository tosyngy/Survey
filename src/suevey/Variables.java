package suevey;

/**
 *
 * @author OGINNI
 */
public class Variables {

    public static String firstname;
    public static String username;
    public static String password;
    public static String state;
    public static String locGvt;
    public static Double balance;
    private static String phone;
    public static long agentId;
    public static int status;

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param aPhone the phone to set
     */
    public void setPhone(String aPhone) {
        phone = aPhone;
    }

    /**
     * @return the phone
     */
    DbConnect dbcon = new DbConnect();

    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the id
     */
    public long getAgentId() {
        getStatus();
        return agentId;
    }

    /**
     * @param id the id to set
     */
    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    /**
     * @return the balance
     */
    public Double getBalance() {
        //  getStatus();
        try {
            dbcon.rs = dbcon.st.executeQuery("select balance from agents where id='" + agentId + "'");
            if (dbcon.rs.next()) {
                setBalance(dbcon.rs.getDouble("balance"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the localGovt
     */
    public String getLocGvt() {
        return locGvt;
    }

    /**
     * @param localGovt the localGovt to set
     */
    public void setLocGvt(String locGvt) {
        this.locGvt = locGvt;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
