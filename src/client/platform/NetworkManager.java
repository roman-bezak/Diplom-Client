package client.platform;


import java.io.Serializable;

public class NetworkManager extends Thread implements Serializable {

    public void run() {

        while(true){

            System.out.println("Q");

            try {
                Thread.sleep(Constants.UPDATE_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}
