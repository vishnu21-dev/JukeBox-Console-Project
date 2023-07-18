import javax.sound.sampled.*;
import java.util.*;
import java.io.*;
public class musicplayer {
    long time;
    public void musicplay(String file) {
        File musicfile=new File(file);
        int str=-1;
        Beats b=new Beats();
        Scanner sc=new Scanner(System.in);

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(musicfile);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            while (str != 0) {
                System.out.println("Enter   1.play   2.pause   3.reset   4.resume    0.quit ");
                str = sc.nextInt();
                switch (str) {
                    case 1: {
                        clip.start();
                        break;
                    }
                    case 2: {
                        clip.stop();
                        time = clip.getMicrosecondPosition();
                        System.out.println(time);
                        break;
                    }
                    case 3: {
                        clip.setMicrosecondPosition(0);
                        break;
                    }
                    case 0: {
                        clip.close();
                        System.out.println("----Enter 1 to play next song--");
                        System.out.println("----Enter 2 for main menu------");
                        System.out.println("----Enter 3 to Exit---------- ");
                        int c=sc.nextInt();
                        if(c==1){
                            b.playmusic();
                        }
                        else if(c==2){
                            b.mainmenu();
                        }
                        else if(c==3){
                            System.out.println("*******Thank You**********");
                        }
                        else {
                            System.out.println("Incorrect response");
                            b.mainmenu();
                        }
                        break;
                    }
                    case 4: {
                        clip.setMicrosecondPosition(time);
                        clip.start();
                        break;

                    }


                }
            }
        } catch (Exception e) {
            System.out.println(e);
            b.playmusic();
        }
    }


}

// AudioInputStream class and clip interface is used
//AudioInputStream class can convert only wav file
//clip interface is used to read data from converted stream class