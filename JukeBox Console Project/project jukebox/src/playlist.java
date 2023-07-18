import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class playlist {
    static Connection con = null;
    Statement st = null;
    Beats pl=new Beats();


    public void createplaylist() {
        con=pl.getConnection();
        try {
            st = con.createStatement();
            Scanner pl = new Scanner(System.in);
            System.out.println("enter the playlist name");
            String playlistname = pl.next();
            System.out.println("enter the song name to be added");
            String songname=pl.next();
            String create = "insert into playlist(playlistname,songname)" + "values('"+playlistname+"','"+songname+ "')";
           int sm= st.executeUpdate(create);
            ResultSet so=st.executeQuery("select * from playlist where playlistname= '"+playlistname+"'");

            while(so.next()){
                System.out.println(so.getInt(1) + " " + so.getString(3) + " " + so.getString(4) + " " + so.getString(5));

            }

        } catch (Exception e) {
            System.out.println(e);
            createplaylist();
        }
    }

    public void existingplaylist() {
Beats vt=new Beats();
        con=pl.getConnection();
        try {
            Scanner ep = new Scanner(System.in);
            st = con.createStatement();
int va=0;
            System.out.println("enter the playlist name");
            String playlistname = ep.next();
            String songs = "select * from playlist where playlistname='"+playlistname+"'";
            ResultSet s = st.executeQuery(songs);
            System.out.println("enter 1 to add song/podcast to playlist ");
            System.out.println("enter 2 to add view the playlist ");
            int add=ep.nextInt();
            if(add==1) {
                System.out.println("enter 1 to add song ");
                System.out.println("enter 2 to add podcast");
                int v=ep.nextInt();
                if(v==1) {
                    System.out.println("enter the song name to be added");
                    String songname = ep.next();
                    ResultSet vi=st.executeQuery("select songid from songlist where songname='"+songname+"'");
                    while (vi.next()) {
                       va=vi.getInt(1);

                    }
                    int sm = st.executeUpdate("insert into playlist(playlistname,songid,songname) values('"+playlistname+"',"+ va + ",'"+songname+"')");
                    System.out.println("Enter 1 to play song ");
                    System.out.println("Enter 2 to Return to Mainmenu");
                    System.out.println("Enter 3 to exit");
                    int sp=ep.nextInt();
                    if(sp==1){
                        vt.playmusic();
                    }
                    else if(sp==2){
                        vt.mainmenu();
                    }
                    else if(sp==3){
                        System.out.println("*****Thank you*******");}
                    else {
                        System.out.println("incorrect credentials ");
                        vt.mainmenu();
                    }
                }
                if(v==2){
                    System.out.println("enter the podcast id");
                    String pod= ep.next();

                    int sn= st.executeUpdate("insert into playlist(playlistname,podcastid) values(" +playlistname+","+pod+")");
                    System.out.println("Enter 1 to play song ");
                    System.out.println("Enter 2 to Return to Mainmenu");
                    System.out.println("Enter 3 to exit");
                    int sp=ep.nextInt();
                    if(sp==1){
                        vt.playmusic();
                    }
                    else if(sp==2){
                        vt.mainmenu();
                    }
                    else if(sp==3){
                        System.out.println("*****Thank you*******");}
                    else {
                        System.out.println("incorrect credentials ");
                        vt.mainmenu();
                    }
                }
            }
             else if(add==2){
                while (s.next()) {
                    System.out.println(s.getInt(1) + " " + s.getString(3) + " " + s.getString(4) + " " + s.getString(5));

                }
                System.out.println("Enter 1 to play song ");
                System.out.println("Enter 2 to Return to Mainmenu");
                System.out.println("Enter 3 to exit");
                int sp=ep.nextInt();
                if(sp==1){
                    vt.playmusic();
                }
                else if(sp==2){
                    vt.mainmenu();
                }
                else if(sp==3){
                    System.out.println("*****Thank you*******");}
                else {
                    System.out.println("incorrect credentials ");
                    vt.mainmenu();}
             }
             else {
                 System.out.println("check your credentials");
                 vt.mainmenu();
             }
        } catch (Exception e) {
            System.out.println(e);
            existingplaylist();
        }
    }



    }
