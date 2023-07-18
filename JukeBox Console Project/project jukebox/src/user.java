import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class user {
    Beats us= new Beats();
    static Connection con = null;
    Statement st = null;
    public int newuser() {



        try {
            con=us.getConnection();
            st = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Scanner au = new Scanner(System.in);
        System.out.println("----------Welcome to the World of  Music-------");
        System.out.println("------------Thank you choosing Beats---------");
        System.out.println("-------Lets get started---------");
        System.out.println("Please enter your name" + " " + "(This will be your username)");
        String username = au.next();
        System.out.println("Please enter a password containing minimum 5 Characters");
        String pass = au.next();
        if (pass.length() < 3) {
            System.out.println(" Re-enter 10 character password");
            pass = au.next();
        }


        int rs = 0;
        try {
            rs = st.executeUpdate("insert into userlogin(username,password)values('" + username + "','" + pass + "')");
            System.out.println("************  your login is successful *************");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
    public void existinguser(){

int an=0;
String username="",password="";
        System.out.println("---------WELCOME BACK-------");
        try {
            con = us.getConnection();
            st = con.createStatement();
            Scanner eu = new Scanner(System.in);

            while (an == 1 || an == 0) {
                System.out.println("please enter your username");
                username = eu.next();
                System.out.println("please enter your password");
                password = eu.next();
                ResultSet rs = st.executeQuery("select * from userlogin where username='"+username+"' and password='"+password+"'");
                 String i="";
                 String v="";

                while (rs.next()) {
                    i = rs.getString(2);
                    v = rs.getString(3);
                }
                    if (username.equals(i)) {

                        if (password.equals(v) ){
                            an = 2;

                        }
                    }
                    else {
                        System.out.println("check your credentials");
                        System.out.println("************************");
                        System.out.println("Enter 1 for Re-try");
                        System.out.println("Enter 2 to quite");
                        an = eu.nextInt();
                        if (an == 2) {
                            System.out.println("****** Thank You *********");
                        }

                    }
                }


        }

        catch(Exception e){
            System.out.println(e);
            existinguser();
        }
    }
    public void searchofsong() {
        try {
            Beats te=new Beats();
            con=us.getConnection();

                st = con.createStatement();

            Scanner ss = new Scanner(System.in);
            System.out.println("1) enter 1 to search by artist name");
            System.out.println("2) enter 2 to search by song name");
            System.out.println("3) enter 3 to search by genre");
            int s = ss.nextInt();
            switch (s) {
                case 1:
                    ResultSet z= st.executeQuery("select * from songlist");
                    while (z.next()) {
                        System.out.println(z.getInt(1) + " " + z.getString(2) + " " + z.getString(3) + " " + z.getString(7));

                    }
                    System.out.println("enter the artist name");
                    String artistname = ss.next();
                    String search = "select * from songlist where artistname='" + artistname + "'";
                    ResultSet p = st.executeQuery(search);
                    while (p.next()) {
                        System.out.println(p.getInt(1) + " " + p.getString(2) + " " + p.getString(3) + " " + p.getString(7));

                    }
                    System.out.println("Enter 1 to Play Music ");
                    System.out.println("Enter 2 to Return to Mainmenu");
                    System.out.println("Enter 3 to exit");
                    int so=ss.nextInt();
                    if(so==1){
                        te.playmusic();
                    }
                    else if(so==2){
                        te.mainmenu();
                    }
                    else if(so==3){
                    System.out.println("*****Thank you*******");}
                    else {
                        System.out.println("incorrect credentials ");
                        te.mainmenu();
                    }
                    break;
                case 2:
                    ResultSet o= st.executeQuery("select * from songlist");
                    while (o.next()) {
                        System.out.println(o.getInt(1) + " " + o.getString(2) + " " + o.getString(3) + " " + o.getString(7));

                    }
                    System.out.println("enter the song name");
                    String songname=ss.next();
                    String sb="select * from songlist where songname='"+songname+"'";
                    ResultSet sn= st.executeQuery(sb);
                    while (sn.next()) {

                        System.out.println(sn.getInt(1) + " " + sn.getString(2) + " " + sn.getString(3) + " " + sn.getString(7));

                    }
                    System.out.println("Enter 1 to Play Music ");
                    System.out.println("Enter 2 to Return to Mainmenu");
                    System.out.println("Enter 3 to exit");
                    int si=ss.nextInt();
                    if(si==1){
                        te.playmusic();
                    }
                    else if(si==2){
                        te.mainmenu();
                    }
                    else if(si==3){
                        System.out.println("*****Thank you*******");}
                    else {
                        System.out.println("incorrect credentials ");
                        te.mainmenu();
                    }
                    break;
                case 3:
                    ResultSet l= st.executeQuery("select * from songlist");
                    while (l.next()) {
                        System.out.println(l.getInt(1) + " " + l.getString(2) + " " + l.getString(3) + " " + l.getString(7));

                    }
                    System.out.println("enter the genre name");
                    String genrename= ss.next();
                    String sg="select * from songlist where genre='"+genrename+"'";
                    ResultSet gs= st.executeQuery(sg);
                    while (gs.next()) {
                        System.out.println(gs.getInt(1) + " " + gs.getString(2) + " " + gs.getString(3) + " " + gs.getString(7));

                    }
                    System.out.println("Enter 1 to Play Music ");
                    System.out.println("Enter 2 to Return to Mainmenu");
                    System.out.println("Enter 3 to exit");
                    int st=ss.nextInt();
                    if(st==1){
                        te.playmusic();
                    }
                    else if(st==2){
                        te.mainmenu();
                    }
                    else if(st==3){
                        System.out.println("*****Thank you*******");}
                    else {
                        System.out.println("incorrect credentials ");
                        te.mainmenu();
                    }
                    break;

            }
        }
        catch (Exception e){
            System.out.println(e);
            searchofsong();
        }
    }
    public void searchofpodcast(){
        try {
            Beats tv=new Beats();
           con= us.getConnection();

            st = con.createStatement();

            Scanner ss = new Scanner(System.in);

            System.out.println("1) enter 1 to search by podcast name");
            System.out.println("2) enter 2 to search by genre");
            int s = ss.nextInt();
            switch (s) {

                case 1:
                    System.out.println("enter the podcast name");
                    String songname=ss.next();
                    String sb="select * from podcastlist where podcastname='"+songname+"'";
                    ResultSet sn= st.executeQuery(sb);
                    while (sn.next()) {
                        System.out.println(sn.getInt(1) + " " + sn.getString(2) + " " + sn.getString(3) + " " + sn.getString(7));

                    }
                    System.out.println("Enter 1 to Play podcast ");
                    System.out.println("Enter 2 to Return to Mainmenu");
                    System.out.println("Enter 3 to exit");
                    int su=ss.nextInt();
                    if(su==1){
                        tv.playpodcast();
                    }
                    else if(su==2){
                        tv.mainmenu();
                    }
                    else if(su==3){
                        System.out.println("*****Thank you*******");}
                    else {
                        System.out.println("incorrect credentials ");
                        tv.mainmenu();
                    }
                    break;
                case 2:
                    System.out.println("enter the genre name");
                    String genrename= ss.next();
                    String sg="select * from podcastlist where genre='"+genrename+"'";
                    ResultSet gs= st.executeQuery(sg);
                    while (gs.next()) {
                        System.out.println(gs.getInt(1) + " " + gs.getString(2) + " " + gs.getString(3) + " " + gs.getString(7));

                    }
                    System.out.println("Enter 1 to playpodcast ");
                    System.out.println("Enter 2 to Return to Mainmenu");
                    System.out.println("Enter 3 to exit");
                    int sp=ss.nextInt();
                    if(sp==1){
                        tv.playpodcast();
                    }
                    else if(sp==2){
                        tv.mainmenu();
                    }
                    else if(sp==3){
                        System.out.println("*****Thank you*******");}
                    else {
                        System.out.println("incorrect credentials ");
                        tv.mainmenu();
                    }
                    break;

            }
        }
        catch (Exception e){
            System.out.println(e);
            searchofpodcast();
        }
    }
}
