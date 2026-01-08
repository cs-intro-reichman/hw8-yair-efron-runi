

/** Represents a social network. The network has users, who follow other uesrs.
 *  Each user is an instance of the User class. */
public class Network {

    // Fields
    private User[] users;  // the users in this network (an array of User objects)
    private int userCount; // actual number of users in this network

    /** Creates a network with a given maximum number of users. */
    public Network(int maxUserCount) {
        this.users = new User[maxUserCount];
        this.userCount = 0;
    }

    /** Creates a network  with some users. The only purpose of this constructor is 
     *  to allow testing the toString and getUser methods, before implementing other methods. */
    public Network(int maxUserCount, boolean gettingStarted) {
        this(maxUserCount);
        users[0] = new User("Foo");
        users[1] = new User("Bar");
        users[2] = new User("Baz");
        userCount = 3;
    }

    public int getUserCount() {
        return this.userCount;
    }

    /** Finds in this network, and returns, the user that has the given name.
     *  If there is no such user, returns null.
     *  Notice that the method receives a String, and returns a User object. */
    public User getUser(String name) {
        //User found=new User("");
        for(int i=0;i<users.length;i++)
            {
                if (users[i]!=null) {
                    if (users[i].getName().equals(name)) {
                        return users[i];   
                    }
                }
            }
        return null;
    }

    /** Adds a new user with the given name to this network.
    *  If ths network is full, does nothing and returns false;
    *  If the given name is already a user in this network, does nothing and returns false;
    *  Otherwise, creates a new user with the given name, adds the user to this network, and returns true. */
    public boolean addUser(String name) {
        //// Replace the following statement with your code
        for(int i=0;i<users.length;i++)//this runs on the users in the network
        {
            if (users[i]!=null) 
            {
                if (users[i].getName().equals(name)) {
                    return false;
                }
            }
        } 
        for(int i=0;i<users.length;i++)//this runs on the users in the network
        {
            if (users[i]==null) 
            {
               
                users[i]=new User(name);   
                return true; 
            
            }
        }
        return false;
    }

    /** Makes the user with name1 follow the user with name2. If successful, returns true.
     *  If any of the two names is not a user in this network,
     *  or if the "follows" addition failed for some reason, returns false. */
    public boolean addFollowee(String name1, String name2) {
        //// Replace the following statement with your code
        boolean one=false;
        boolean two=false;
        for(int i=0;i<users.length;i++)//checks if the one of them is in users
        {
            if (users[i]!=null) 
            {
                if (users[i].getName().equals(name1))
                {
                    one= true; 
                }
                if (users[i].getName().equals(name2)) {
                    two=true;
                }
            }
        }
        if (!one||!two) {
            return false;
        }
        if (one) {
            for(int i=0;i<users.length;i++)//this runs on the users in the network
        {
            if (users[i]!=null) 
            {
                if (users[i].getName().equals(name1))   
                return users[i].addFollowee(name2); 
            }
        }
        }
        return false;
    }
    
    /** For the user with the given name, recommends another user to follow. The recommended user is
     *  the user that has the maximal mutual number of followees as the user with the given name. */
    public String recommendWhoToFollow(String name) {
        User named=null;
        for(int i=0;i<users.length;i++)//this runs on the users in the network
        {
            if (users[i]!=null) 
            {
                if (users[i].getName().equals(name)) 
                {
                    named=users[i];
                }       
            }
        }
        User save=null;
        int mutual=0;
        for(int k=0;k<users.length;k++)//this runs on the users in the network
        {
            if (users[k]!=null&&users[k]!=named) 
            {
                if (named.countMutual(users[k])>mutual) 
                {
                    save=users[k];
                    mutual=named.countMutual(users[k]);
                    
                }
            }
        }
        return save.getName();
    }

    /** Computes and returns the name of the most popular user in this network: 
     *  The user who appears the most in the follow lists of all the users. */
    public String mostPopularUser() {
        //// Replace the following statement with your code
        return null;
    }

    /** Returns the number of times that the given name appears in the follows lists of all
     *  the users in this network. Note: A name can appear 0 or 1 times in each list. */
        //// Replace the following statement with your code
    private int followeeCount(String name) {
    int count = 0;

    for (int i = 0; i < users.length; i++) {
        if (users[i] != null) {

            String[] follows = users[i].getfFollows();
            for (int j = 0; j < follows.length; j++) {
                if (follows[j] != null && !follows[j].isEmpty()
                        && follows[j].equals(name)) {
                    count++;
                    break; 
                }
            }
        }
    }

    return count;
}


    // Returns a textual description of all the users in this network, and who they follow.
    public String toString() {
       String result="";
        for(int i=0;i<users.length;i++)//this runs on the users in the network
        {
            if (users[i]!=null) 
            {
                result=users[i].toString()+"\n";       
            }
        }
       return result;
    }
}
