import java.sql.*;
import java.util.Scanner;

public class Beats {
    static Connection con = null;
    Statement st = null;


    public void start() {

        System.out.println("---------Welcome  to  the  World  of  Music------");
        System.out.println("----------         ---------");
        System.out.println("----------  BEATS   ---------");
        System.out.println("----------         ---------");


    }

    public static Connection getConnection() {
        try { //1.loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //establishing the connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Chithra04.@");


        } catch (Exception ex) {
            System.out.println(ex);
        }


        return con;
    }


    public void displaysongs() {
        con=getConnection();
        Beats nu=new Beats();
        Scanner op=new Scanner(System.in);
        try {
            st = con.createStatement();
            System.out.println("-------- SONGS LIST-------------");
            String songs = "select * from songlist";
            ResultSet s = st.executeQuery(songs);
            while (s.next()) {
                System.out.println(" " + s.getInt(1) + "   " + s.getString(2) + "       " + s.getString(3) + "   " + s.getString(7));
                System.out.println("------------------------------------------------------");
            }
            System.out.println("Enter 1 to Play song ");
            System.out.println("Enter 2 to Return to Mainmenu");
            System.out.println("Enter 3 to exit");
            int su=op.nextInt();
            if(su==1){
                nu.playmusic();
            }
            else if(su==2){
                nu.mainmenu();
            }
            else if(su==3){
                System.out.println("*****Thank you*******");}
            else {
                System.out.println("incorrect credentials ");
                nu.mainmenu();
            }

        } catch (Exception e) {
            System.out.println(e);
            displaysongs();
        }
    }

    public void displaypodcast() {
        con=getConnection();
Scanner vj=new Scanner(System.in);
Beats jv=new Beats();
        try {
            st = con.createStatement();

            System.out.println("-------- PODCAST LIST-------------");

            String podcast = "select * from podcastlist";
            ResultSet p = st.executeQuery(podcast);
            while (p.next()) {
                System.out.println("  " + p.getString(1) + "   " + p.getString(2) + "   " + p.getString(3) + "   " + p.getString(5));
                System.out.println("----------------------------------------------------------------------------------------------------");
            }
            System.out.println("Enter 1 to Play podcast ");
            System.out.println("Enter 2 to Return to Mainmenu");
            System.out.println("Enter 3 to exit");
            int su=vj.nextInt();
            if(su==1){
                System.out.println(su);
                playpodcast();
            }
            else if(su==2){
                jv.mainmenu();
            }
            else if(su==3){
                System.out.println("*****Thank you*******");}
            else {
                System.out.println("incorrect credentials ");
                jv.mainmenu();
            }
        } catch (Exception e) {
            System.out.println(e);
            displaypodcast();
        }

    }

    public void playmusic() {
        try {    Beats ms=new Beats();

            musicplayer mp = new musicplayer();

            Scanner pm = new Scanner(System.in);
            System.out.println("Enter the songid from the list showed to be played ");
            int name = pm.nextInt();

            getConnection();

            st = con.createStatement();

            String song = "select songpath from songlist where songid='" + name + "'";

            ResultSet v = st.executeQuery(song);
            while (v.next()) {
                mp.musicplay(v.getString(1));
            }


        } catch (SQLException e) {
            System.out.println(e);
            playmusic();
        }

    }

    public void playpodcast() {

        try {
            Beats mv=new Beats();

            Scanner pp = new Scanner(System.in);

            System.out.println(" Enter the Podcast id to be played ");
            int name = pp.nextInt();
            getConnection();
            st = con.createStatement();
            String podcast = "select * from podcastlist where podcastid=" + name + "";
            ResultSet rs = st.executeQuery(podcast);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + rs.getString(6));
            }
            System.out.println("To play the podcast please click on the url");
            System.out.println("Enter 1 for main menu ");
            System.out.println("Enter 2 to exit");
            int jv=pp.nextInt();
            if(jv==1){
                mv.mainmenu();
            }
            else if(jv==2){
                System.out.println("********  Thank you  *****");
            }
            else {
                System.out.println("incorrect option");
                mv.mainmenu();
            }
        } catch (Exception e) {
            System.out.println(e);
            playpodcast();
        }
    }
    public void mainmenu(){
        Beats mv=new Beats();
        user us=new user();
        Scanner mm=new Scanner(System.in);
        playlist p=new playlist();
        musicplayer mp = new musicplayer();
        System.out.println("--------------------------------------");
        System.out.println("---- Enter 1 View Songs/Podcast List--");
        System.out.println("--------------------------------------");
        System.out.println("---- Enter 2 to Search Songs/Podcast--");
        System.out.println("--------------------------------------");
        System.out.println("-----Enter 3 to play songs----------- ");
        System.out.println("--------------------------------------");
        System.out.println("-----Enter 4 to play podcast----------");
        System.out.println("--------------------------------------");
        System.out.println("-----Enter 5 to view playlist---------");
        System.out.println("--------------------------------------");
        System.out.println("-----Enter 6 to create playlist-------");
        System.out.println("--------------------------------------");
        System.out.println("----------Enter 7 to exit-------------");

       try {
           int search = mm.nextInt();
           if (search == 1) {
               System.out.println("Enter 1 to view songs ");
               System.out.println("Enter 2 to view podcast");
               int z = mm.nextInt();
               if (z == 1) {
                   mv.displaysongs();
               } else if (z == 2) {
                   mv.displaypodcast();
               } else {
                   System.out.println("check your credentials");
               }
           } else if (search == 2) {
               System.out.println("Enter 1 to Search Songs ");

               int v = mm.nextInt();
               if (v == 1) {
                   us.searchofsong();
               }
                else {
                   System.out.println("Check your Credentials ");
                   mv.mainmenu();
               }
           } else if (search == 3) {
               mv.playmusic();
           } else if (search == 4) {
               mv.playpodcast();
           } else if (search == 5) {
               p.existingplaylist();
           } else if (search == 6) {
               p.createplaylist();
           } else if (search == 7) {
               System.out.println("-----Thank you------");
           }
       }
       catch(Exception e){
           System.out.println(e);
           mainmenu();
       }

    }


        public static void main (String [] args)
        { Beats m=new Beats();
            Scanner mb = new Scanner(System.in);
            user u = new user();

            m.start();
            System.out.println("----- enter 1 for new  user  ---- ");
            System.out.println("----- enter 2 for existing user  ---- ");
            int n1 = mb.nextInt();
            if (n1 == 1) {
                u.newuser();
            } else if (n1 == 2) {
                u.existinguser();
            }
            System.out.println("*********************************");
            System.out.println("-------Your Login Successful-------");
            System.out.println("***********************************");

            m.mainmenu();

        }


    }






