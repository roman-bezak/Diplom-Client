package client.platform;

import java.io.*;

public class SettingsConfig implements Serializable{

    public String server_address = null;
    public int port = 0;

    public void saveSettingsConfig(){

        try {
            FileOutputStream fileOut =
                    new FileOutputStream(Constants.SETTINGS_CONFIG_PATH);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }

    }
    public static SettingsConfig loadSettingsConfig(){

        SettingsConfig config = null;

        try {
            FileInputStream fileIn = new FileInputStream(Constants.SETTINGS_CONFIG_PATH);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            config = (SettingsConfig) in.readObject();
            in.close();
            fileIn.close();
            return config;
        }catch(IOException i) {
            i.printStackTrace();
        }catch(ClassNotFoundException c) {
            c.printStackTrace();
        }

        return config;
    }

    public void updateSettingsConfig(String _address_server, int _port){
        server_address = _address_server;
        port = _port;
        this.saveSettingsConfig();
    }
}
